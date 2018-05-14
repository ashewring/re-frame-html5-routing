(ns my-app.pages
  (:require [clojure.string :as s]))

(def ^:private page-metadata {
  :home {
    :short-title "Home"
    :header "Business Performance Optimisation"
    :description "S23M makes sense of the world's information from your unique point of view. We offer business performance optimisation services."
  }
  :about {
    :short-title "About"
    :header "About"
    :description "S23M is built around a powerful methodology for gaining a deep understanding of your business and its future potential."
  }
  :contact-us {
    :short-title "Contact"
    :header "Contact Us"
    :description "Contact us to discuss your specific needs. S23M offers business performance optimisation services across several industries."
  }
  :case-studies {
    :short-title "Case Studies"
    :header "Case Studies"
    :description "A list of S23M case studies by geographical region."
  }
  :life {
    :short-title "Collaboration"
    :header "Collaboration for Life"
    :description "S23M provides customers with unique expertise in managing complex organisations and systems, and in designing adaptive and resilient systems."
  }
  :methodology {
    :short-title "Methodology"
    :header "MODA&thinsp;+&thinsp;MODE methodology"
    :description "MODA + MODE (Model Oriented Domain Analysis and Engineering) provide advanced techniques for modular and redundant system design."
  }
  :news {
    :short-title "News"
    :header "News"
    :description "TODO"
  }
  :ciic {
    :short-title "Interdisciplinary"
  }
  :agriculture {
    :short-title "Agriculture"
  }
  :healthcare {
    :short-title "Healthcare"
  }
  :construction {
    :short-title "Construction"
  }
  :logistics {
    :short-title "Logistics"
  }
  :industrial-automation {
    :short-title "Industrial Automation"
  }
  :professional-services {
    :short-title "Professional Services"
  }
  :government {
    :short-title "Government"
  }
  :disclaimer {
    :short-title "Disclaimer"
  }
  :innovation-new-product-development {
    :short-title "Innovation & New Product Development"
    :long-title "Helping you to innovate and make significantly better decisions"
  }
  :operational-excellence {
    :short-title "Operational Excellence"
    :long-title "Producing transformative improvements by reducing complexity and catalysing cultural transformation"
  }
  :enterprise-saas {
    :short-title "Enterprise Software as a Service"
    :long-title "Enabling people and software systems to interact in the simplest possible way"
  }
  :not-found {
    :header "Page not found"
    :description "Page not found"
  }
})

(defn- lookup-page-metadata [id k] (k (id page-metadata)))

(defn short-title [id] (lookup-page-metadata id :short-title))

(defn long-title [id] (lookup-page-metadata id :long-title))

(defn page-header [id] (lookup-page-metadata id :header))

(defn page-description [id] (lookup-page-metadata id :description))
