(ns my-app.pages
  (:require [clojure.string :as s]))

(def ^:private page-metadata {
  :home {
    :button-title "Home"
    :header "Business Performance Optimisation"
    :description "S23M makes sense of the world's information from your unique point of view. We offer business performance optimisation services."
  }
  :about {
    :button-title "About"
    :header "About"
    :description "S23M is built around a powerful methodology for gaining a deep understanding of your business and its future potential."
  }
  :contact-us {
    :button-title "Contact"
    :header "Contact Us"
    :description "Contact us to discuss your specific needs. S23M offers business performance optimisation services across several industries."
  }
  :case-studies {
    :button-title "Case Studies"
    :header "Case Studies"
    :description "A list of S23M case studies by geographical region."
  }
  :life {
    :button-title "Collaboration"
    :header "Collaboration for Life"
    :description "S23M provides customers with unique expertise in managing complex organisations and systems, and in designing adaptive and resilient systems."
  }
  :methodology {
    :button-title "Methodology"
    :header "MODA&thinsp;+&thinsp;MODE methodology"
    :description "MODA + MODE (Model Oriented Domain Analysis and Engineering) provide advanced techniques for modular and redundant system design."
  }
  :not-found {
    :header "Page not found"
    :description "Page not found"
  }
})

(defn- lookup-page-metadata
  [id k]
  (k (id page-metadata)))

(defn button-title
  [id]
  (lookup-page-metadata id :button-title))

(defn page-header
  [id]
  (lookup-page-metadata id :header))

(defn page-description
  [id]
  (lookup-page-metadata id :description))