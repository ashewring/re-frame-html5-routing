(ns my-app.test-runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [my-app.routes-test]))

(doo-tests 'my-app.routes-test)
