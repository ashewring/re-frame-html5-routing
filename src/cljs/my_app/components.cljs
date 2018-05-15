(ns my-app.components
  (:require [re-frame.core :as re-frame]
            [my-app.routes :as routes]
            [my-app.subs :as subs]
            [my-app.meta-tags :as meta-tags]
            [my-app.page-metadata :as pages]
            [goog.i18n.DateTimeFormat :as dtf]
            [clojure.string :as s]
            ))

(defn- image
  [name]
  (str "/assets/images/" name))

(defn- current-year [] (.format (goog.i18n.DateTimeFormat. "yyyy") (js/Date.)))

(defn- copyright [] (str "Copyright " (current-year) " by S23M Limited"))

(defn meta-tags
  [title description]
  (js/console.log "meta-tags")
  [meta-tags/meta-tags {:title title :description description} {:id "copyright" :name "copyright" :content (copyright)}])

(defn- small-button
  [id]
  [:a.smallbutton
   {:href
     (routes/url-for id)}
     (pages/short-title id)])

(defn- buttons
  []
  (js/console.log "buttons")
  [:div.buttonholder
   [:span.buttons ;; TODO: proper event handling based on current page
    [:a.smallbutton.disabled
     ;;{:on-click "return false", :href "#"}
     "Home"]
    (small-button :about)
    [:a#news-button.smallbutton.news
      {:href (routes/url-for :news)}
      (pages/short-title :news)]
    (small-button :contact-us)]])

(defn header
  [heading]
  (js/console.log "header")
  [:div.header
   [:div.headerleft
    [:a
     {:href (routes/url-for :life)}
     [:img.s23m-logo
      {:title (pages/page-header :life),
       :alt (pages/page-header :life),
       :src (image "s23m-logo.png")}]]]
   [:div.headerright [:h1 heading]]
   (buttons)])

(defn main-headline
  []
  (js/console.log "main-headline")
  [:div.headline-container
    [:h2.headline
      "S23M makes sense of the world's information"
      [:br]
      "from your unique point of view"]])

(defn- line-of-business-button
  [id image-name]
  [:div
   [:a.line-of-business
    {:href (routes/url-for id)}
    [:img.rounded {:src (image image-name)}]
    [:h3 (pages/short-title id)]]
   [:p (pages/long-title id)]])

(defn lines-of-business
  []
  (js/console.log "lines-of-business")
  [:div.section
    [:ul.responsive-list
      [:li.innovation-new-product-development
        (line-of-business-button :innovation-new-product-development "value-cycle-design.jpg")]
      [:li.operational-excellence
        (line-of-business-button :operational-excellence "collaboration-whiteboard.jpg")]
      [:li.enterprise-saas
        (line-of-business-button :enterprise-saas "saas.jpg")]]])

(defn- name-to-filename
  [name]
  (s/replace (s/lower-case name) #" " "-"))

(defn- industries-image
  [name]
  (js/console.log (str "industries-image: " (image "industries/") (name-to-filename name) ".jpg"))
  [:img.rounded
    {:src (str (image "industries/") (name-to-filename name) ".jpg")}])

(defn- industry
  [name href]
  [:a.industry
    (if (s/starts-with? href "http")
      {:href href :target "_blank"}
      {:href href})
    (industries-image name)
    [:div.link-footer name]])

(defn- absolute? [url] (s/starts-with? url "http"))

(defn- industry-button
  [id]
  (let [href (routes/url-for id)
        name (pages/short-title id)]
    [:a.industry
      (if (absolute? href)
        {:key id :href href :target "_blank"}
        {:key id :href href})
      (industries-image name)
      (js/console.log (str "industry-button - href: '" href "', name: '" name "'"))
      [:div.link-footer name]]))

(def ^:private industry-list
  [:agriculture
   :healthcare
   :construction
   :logistics
   :industrial-automation
   :professional-services
   :government
   :ciic])

;; TODO: make this a def (static content)
(defn industries
  []
  (js/console.log "industries")
  [:div.section
    [:div.headline-container
      [:h2.headline "Industries"]]
    [:div.flowing-list-wrapper
      (for [id industry-list]
        (industry-button id))]])

(defn call-to-action
  [text]
  [:div.call-to-action-wrapper
    [:a.call-to-action-button
      {:href (routes/url-for :contact-us)}
      text]])

(defn footer
  [left centre right]
  [:span
    [:div.footer-separator]
    [:div.colmask.footer
     [:div.colmid
      [:div.colright
       [:div.col1wrap
        [:div.col1pad
         [:div.col1
          [:table.links
            [:tbody
              [:tr
                [:td.left (small-button left)]
                [:td.center (small-button centre)]
                [:td.right (small-button right)]]]]
              ]]]
       [:div.col2.sidebar-left
        [:span.left
         [:a
          {:title "Scroll to the top of this page", :href "#"}
          "Top ↑"]]
          ]
       [:div.col3.sidebar-right
        [:span.right (str "© 2002 - " (current-year) " ") [:span.s23m "S23M"]]
        ]]]]])

(defn disclaimer
  []
  [:div.disclaimer [:a {:href (routes/url-for :disclaimer)} (pages/short-title :disclaimer)]])
