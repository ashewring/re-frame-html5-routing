(ns my-app.components
  (:require [re-frame.core :as re-frame]
            [my-app.routes :as routes]
            [my-app.subs :as subs]
            [my-app.meta-tags :as meta-tags]
            [goog.i18n.DateTimeFormat :as dtf]
            [clojure.string :as s]
            ))

(defn- current-year [] (.format (goog.i18n.DateTimeFormat. "yyyy") (js/Date.)))

(defn- copyright [] (str "Copyright " (current-year) " by S23M Limited"))

(defn meta-tags
  [title description]
  (js/console.log "meta-tags")
  [meta-tags/meta-tags {:title title :description description} {:id "copyright" :name "copyright" :content (copyright)}])

(defn- buttons
  []
  (js/console.log "buttons")
  [:div.buttonholder
   [:span.buttons ;; TODO: proper event handling based on current page
    [:a.smallbutton.disabled
     ;;{:on-click "return false", :href "#"}
     "Home"]
    [:a.smallbutton {:href "about/index.html"} "About"]
    [:a#news-button.smallbutton.news
     {:href "news/index.html"}
     "News"]
    [:a.smallbutton {:href "contactus/index.html"} "Contact"]]])

(defn header
  [heading]
  (js/console.log "header")
  [:div.header
   [:div.headerleft
    [:a
     {:href "life/index.html"}
     [:img.s23m-logo
      {:title "Collaboration for Life",
       :alt "Collaboration for Life",
       :src "assets/images/s23m-logo.png"}]]]
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

(defn lines-of-business
  []
  (js/console.log "lines-of-business")
  [:div.section
   [:ul.responsive-list
    [:li.innovation-new-product-development
     [:div
      [:a.line-of-business
       {:href "innovation-new-product-development.html"}
       [:img.rounded {:src "assets/images/value-cycle-design.jpg"}]
       [:h3 "Innovation & New Product Development"]]
      [:p
       "Helping you to innovate and make significantly better decisions"]]]
    [:li.operational-excellence
     [:div
      [:a.line-of-business
       {:href "operational-excellence.html"}
       [:img.rounded
        {:src "assets/images/collaboration-whiteboard.jpg"}]
       [:h3 "Operational Excellence"]]
     [:p
      "Producing transformative improvements by reducing complexity and catalysing cultural transformation"]]]
    [:li.enterprise-saas
     [:div
      [:a.line-of-business
       {:href "enterprise-saas.html"}
       [:img.rounded {:src "assets/images/saas.jpg"}]
       [:h3 "Enterprise Software as a Service"]]
      [:p
       "Enabling people and software systems to interact in the simplest possible way"]]]]])

(defn- name-to-filename
  [name]
  (s/replace (s/lower-case name) #" " "-"))

(defn- industry
  [name href]
  [:a.industry
    (if (s/starts-with? name "http")
      {:href href, :target "_blank"}
      {:href href})
    [:img.rounded
      {:src (str "assets/images/industries/" (name-to-filename name) ".jpg")}]
    [:div.link-footer name]])

(defn industries
  []
  (js/console.log "industries")
  [:div.section
    [:div.headline-container
      [:h2.headline "Industries"]]
    [:div.flowing-list-wrapper
      (industry "Agriculture" "agriculture/index.html")
      (industry "Healthcare" "healthcare/index.html")
      (industry "Construction" "construction/index.html")
      (industry "Logistics" "logistics/index.html")
      (industry "Industrial Automation" "insight/data-science-case.html#case-study")
      (industry "Professional Services" "performance/governance-case.html#case-study")
      (industry "Government" "government/index.html")
      (industry "Interdisciplinary" "https://ciic.s23m.com/about")]])

(defn call-to-action
  [text]
  [:div.call-to-action-wrapper
    [:a.call-to-action-button
      {:href "contactus/index.html"}
      text]])

(defn footer
  []
  [:span
    [:div.footer-separator]
    [:div.colmask.footer
     [:div.colmid
      [:div.colright
       [:div.col1wrap
        [:div.col1pad
         [:div.col1
          [:table.links
           [:tr
            [:td.left
             [:a.smallbutton
              {:href "case-studies/index.html"}
              "Case Studies"]]
            [:td.center
             [:a.smallbutton
              {:href "life/index.html"}
              "Collaboration"]]
            [:td.right
             [:a.smallbutton
              {:href "methodology/index.html"}
              "Methodology"]]]]
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
  [:div.disclaimer [:a {:href "disclaimer.html"} "Disclaimer"]])
