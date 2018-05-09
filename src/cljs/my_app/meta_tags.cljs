(ns my-app.meta-tags
  (:require [reagent.core :as r]
            [cljsjs.react-meta-tags]
            [re-frame.core :refer [subscribe]]))

(def ^:private react-meta-tags (r/adapt-react-class (aget js/MetaTags "default")))

;; See https://github.com/district0x/district-ui-component-meta-tags
(defn meta-tags [{:keys [title description]} & tags]
  [react-meta-tags
   [:title {:id "title"} title]
   [:meta {:id "description" :name "description" :content description}]
   (for [{:keys [id name content]} tags]
     ^{:key id} [:meta {:id id :name name :content content}])])
