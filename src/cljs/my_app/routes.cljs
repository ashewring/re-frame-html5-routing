;; authored by J. PABLO FERNÁNDEZ - https://pupeno.com/2015/08/26/no-hashes-bidirectional-routing-in-re-frame-with-bidi-and-pushy/

(ns my-app.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as re-frame]
            [my-app.events :as events]
            [clojure.string :as s]
            [cemerick.url :as c]))

(def routes ["/" {""                                          :home
                  "disclaimer.html"                           :disclaimer
                  "innovation-new-product-development.html"   :innovation-new-product-development
                  "operational-excellence.html"               :operational-excellence
                  "enterprise-saas.html"                      :enterprise-saas
                  "about"             :about
                  "contactus"         :contact-us
                  "life"              :life
                  "case-studies"      :case-studies
                  "methodology"       :methodology
                  "news"              :news
                  "agriculture"       :agriculture
                  "healthcare"        :healthcare
                  "construction"      :construction
                  "logistics"         :logistics
                  "government"        :government
                  "insight/" {
                    "data-science-case.html" :industrial-automation
                  }
                  "performance/" {
                    "governance-case.html" :professional-services
                  }
                  ;; true            :not-found
             }
             ])

(def ^:private external-urls
  {:ciic "https://ciic.s23m.com/about"})

(defn- remove-last-n
  [str n]
  (subs str 0 (- (count str) n)))

(defn- simplify
  [url]
  ;; if url ends with / or with /index.html, drop the suffix
  (cond
    (and (s/ends-with? url "/") (> (count url) 1)) (remove-last-n url 1)
    (s/ends-with? url "/index.html") (remove-last-n url 11)
    :else url))

(defn parse-url
  [url]
  (let [simplified (simplify url)]
    (js/console.log simplified)
    (bidi/match-route routes simplified)))

;; based on https://github.com/juxt/bidi/issues/51#issuecomment-344101759
(defn parse-url-with-query-params
  [url & {:as options}]
  (let [query-params (->> (:query (c/url url))
                          (map (fn [[k v]] [(keyword k) v]))
                          (into {}))
        simplified   (simplify url)]
    (-> (bidi/match-route* routes simplified options)
        (assoc :query-params query-params))))

(defn- dispatch-route
  [matched-route]
  (js/console.log (str "dispatch-route: " matched-route))
  (let [panel-name (keyword (name (:handler matched-route)))]
    (js/console.log (str "panel-name: " panel-name))
    (re-frame/dispatch [::events/set-active-panel panel-name])))

(defn app-routes
  []
  (js/console.log "app-routes")
  (pushy/start! (pushy/pushy dispatch-route parse-url)))

(defn url-for
  [id]
  (if (contains? external-urls id)
    (id external-urls)
    (bidi/path-for routes id)
  ))
