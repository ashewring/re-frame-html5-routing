(ns my-app.layouts
  (:require [re-frame.core :as re-frame]
            [my-app.routes :as routes]
            [my-app.subs :as subs]
            [my-app.meta-tags :as meta-tags]
            ))

(defn full-width-layout
  [title description]

  [:div#container
    [meta-tags/meta-tags {:title title :description description}]
    [:div.header
     [:div.headerleft
      [:a
       {:href "life/index.html"}
       [:img.s23m-logo
        {:title "Collaboration for Life",
         :alt "Collaboration for Life",
         :src "assets/images/s23m-logo.png"}]]]
     [:div.headerright [:h1 "Business Performance Optimisation"]]
     ]])

(comment

  [:html
  {:xml:lang "en-GB"}
  [:head
   [:meta
    {:content "text/html; charset=UTF-8", :http-equiv "Content-Type"}]
   [:title "S23M - Business Performance Optimisation"]
   [:meta
    {:content
     "S23M makes sense of the world's information from your unique point of view. We offer business performance optimisation services.",
     :name "description"}]
   [:meta
    {:content "Copyright 2015 by S23M Limited", :name "copyright"}]
   "<!-- See http://stackoverflow.com/a/16577316 -->"
   [:meta
    {:content "width=device-width, initial-scale=1", :name "viewport"}]
   "<!-- For Google webmaster tools. Do not remove -->"
   [:meta
    {:content "hTfgk0LGf-7tLqgwgEfxQWakWj5AQ-u0ZvD8-uN-j2k",
     :name "google-site-verification"}]
   [:link
    {:type "image/x-icon",
     :href "favicon.ico?v=3",
     :rel "shortcut icon"}]
   [:link
    {:media "screen",
     :href "assets/css/screen.css",
     :type "text/css",
     :rel "stylesheet"}]
   "<!--[if lte IE 9]>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"assets/css/PIE.css\" media=\"screen\"/>\n\t<![endif]-->"
   [:script
    "\n\t  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n\t  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n\t  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n\t  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n\n\t  ga('create', 'UA-68387238-1', 'auto');\n\t  ga('send', 'pageview');\n\t"]]
  [:body
   [:div#container
    [:div.header
     [:div.headerleft
      [:a
       {:href "life/index.html"}
       [:img.s23m-logo
        {:title "Collaboration for Life",
         :alt "Collaboration for Life",
         :src "assets/images/s23m-logo.png"}]]]
     [:div.headerright [:h1 "Business Performance Optimisation"]]
     [:div.buttonholder
      [:span.buttons
       [:a.smallbutton.disabled
        {:onclick "return false", :href "#"}
        "Home"]
       [:a.smallbutton {:href "about/index.html"} "About"]
       [:a#news-button.smallbutton.news
        {:href "news/index.html"}
        "News"]
       [:a.smallbutton {:href "contactus/index.html"} "Contact"]]]]
    [:div.headline-container
     [:h2.headline
      "S23M makes sense of the world's information"
      [:br]
      "from your unique point of view"]]
    [:div.section
     [:ul.responsive-list
      [:li.innovation-new-product-development
       [:div
        [:a.line-of-business
         {:href "innovation-new-product-development.html"}
         [:img.rounded {:src "assets/images/value-cycle-design.jpg"}]]
        [:h3 "Innovation & New Product Development"]
        [:p
         "Helping you to innovate and make significantly better decisions"]]]
      [:li.operational-excellence
       [:div
        [:a.line-of-business
         {:href "operational-excellence.html"}
         [:img.rounded
          {:src "assets/images/collaboration-whiteboard.jpg"}]]
        [:h3 "Operational Excellence"]]
       [:p
        "Producing transformative improvements by reducing complexity and catalysing cultural transformation"]
       [:p]]
      [:li.enterprise-saas
       [:div
        [:a.line-of-business
         {:href "enterprise-saas.html"}
         [:img.rounded {:src "assets/images/saas.jpg"}]]
        [:h3 "Enterprise Software as a Service"]
        [:p
         "Enabling people and software systems to interact in the simplest possible way"]]]]]
    [:div.section
     [:div.headline-container [:h2.headline "Industries"]]
     [:div.flowing-list-wrapper
      [:a.industry
       {:href "agriculture/index.html"}
       [:img.rounded
        {:src "assets/images/industries/agriculture.jpg"}]]
      [:div.link-footer "Agriculture"]
      [:a.industry
       {:href "healthcare/index.html"}
       [:img.rounded {:src "assets/images/industries/healthcare.jpg"}]]
      [:div.link-footer "Healthcare"]
      [:a.industry
       {:href "construction/index.html"}
       [:img.rounded
        {:src "assets/images/industries/construction.jpg"}]]
      [:div.link-footer "Construction"]
      [:a.industry
       {:href "logistics/index.html"}
       [:img.rounded {:src "assets/images/industries/logistics.jpg"}]]
      [:div.link-footer "Logistics"]
      [:a.industry
       {:href "insight/data-science-case.html#case-study"}
       [:img.rounded
        {:src "assets/images/industries/industrial-automation.jpg"}]]
      [:div.link-footer "Industrial Automation"]
      [:a.industry
       {:href "performance/governance-case.html#case-study"}
       [:img.rounded
        {:src "assets/images/industries/professional-services.jpg"}]]
      [:div.link-footer "Professional Services"]
      [:a.industry
       {:href "government/index.html"}
       [:img.rounded {:src "assets/images/industries/government.jpg"}]]
      [:div.link-footer "Government"]
      [:a.industry
       {:target "_blank", :href "https://ciic.s23m.com/about"}
       [:img.rounded
        {:src
         "assets/images/industries/interdisciplinary-collaboration.jpg"}]]
      [:div.link-footer "Interdisciplinary"]]]
    [:div.call-to-action-wrapper
     [:a.call-to-action-button
      {:href "contactus/index.html"}
      "Contact us about your business challenges"]]
    [:div.footer-separator]
    [:div.colmask.footer
     [:div.colmid
      [:div.colright
       [:div.col1wrap
        [:div.col1pad
         [:div.col1
          "<!-- Column 1 start -->"
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
          "<!-- Column 1 end -->"]]]
       [:div.col2.sidebar-left
        "<!-- Column 2 start -->"
        [:span.left
         [:a
          {:title "Scroll to the top of this page", :href "#"}
          "Top ↑"]]
        "<!-- Column 2 end -->"]
       [:div.col3.sidebar-right
        "<!-- Column 3 start -->"
        [:span.right "© 2002 - 2018 " [:span.s23m "S23M"]]
        "<!-- Column 3 end -->"]]]]]
   [:div.disclaimer [:a {:href "disclaimer.html"} "Disclaimer"]]
   "<!-- Pre-loading content -->"
   [:img
    {:style "display: none",
     :src "assets/images/icon-external-link-hover.png"}]
   [:script {:src "assets/js/LAB.min.js"}]
   [:script
    "\n\t\t$LAB\n\t\t .script(\"assets/js/jquery-1.11.3.min.js\").wait()\n\t\t .script(\"assets/js/main.js\")\n\t\t .script(\"assets/js/vendor/smooth-scroll-11.0.2.min.js\").wait()\n\t\t .script(\"assets/js/smooth-scrolling.js\");\n\t"]]]


  )
