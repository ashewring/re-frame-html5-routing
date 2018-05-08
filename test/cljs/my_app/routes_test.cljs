(ns my-app.routes-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [my-app.routes :as r]))

(defn- h
  [handler]
  {:handler handler})

(defn- check-parse-url
  [pattern handler]
  (is (= (r/parse-url pattern) (h handler))))

(deftest test-parse-url
  (check-parse-url "/" :home)
  (check-parse-url "/about" :about)
  (check-parse-url "/about/" :about)
  (check-parse-url "/about/index.html" :about))

(defn- check-parse-url-with-query-params
  [pattern handler query-params]
  (is (= (r/parse-url-with-query-params pattern) {:handler handler, :query-params query-params})))

(deftest test-parse-url-with-query-params
  (check-parse-url-with-query-params "/about?foo=bar" :about {:foo "bar"}))
