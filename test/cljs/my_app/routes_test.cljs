(ns my-app.routes-test
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]
            [my-app.routes :as r]))

(deftest test-parse-url
  (is (= (r/parse-url "/") {:handler :home})))
