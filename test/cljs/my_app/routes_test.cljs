(ns my-app.routes-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [my-app.routes :as r]))

(defn- h [handler]
  {:handler handler})

(defn- check [pattern handler]
  (is (= (r/parse-url pattern) (h handler))))

(deftest test-parse-url
  (check "/" :home)
  (check "/about" :about)
  (check "/about/" :about)
  (check "/about/index.html" :about))
