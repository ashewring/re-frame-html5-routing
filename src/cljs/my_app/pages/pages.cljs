(ns my-app.pages
  (:require [clojure.string :as s]))

(def ^:private page-metadata {
  :home {
    :header "Business Performance Optimisation"
    :description "S23M makes sense of the world's information from your unique point of view. We offer business performance optimisation services."
    :button-title "Home"
  }
  :about {
    :header "About"
    :description "S23M is built around a powerful methodology for gaining a deep understanding of your business and its future potential."
    :button-title "About"
  }
  :life {
    :header "Collaboration for Life"
    :description "S23M provides customers with unique expertise in managing complex organisations and systems, and in designing adaptive and resilient systems."
    :button-title "Collaboration"
  }
  :not-found {
    :header "Page not found"
    :description "Page not found"
  }
})

(defn- lookup-page-metadata
  [id k]
  (k (id page-metadata)))

(defn page-header
  [id]
  (lookup-page-metadata id :header))

(defn page-description
  [id]
  (lookup-page-metadata id :description))

(defn button-title
  [id]
  (lookup-page-metadata id :button-title))
