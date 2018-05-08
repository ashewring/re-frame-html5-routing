(ns my-app.test-runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [my-app.routes-test]
              [my-app.routes]))

(doo-tests 'my-app.routes-test)
