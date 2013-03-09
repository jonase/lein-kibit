(ns leiningen.kibit
  (:require [leiningen.core.eval :refer [eval-in-project]]))

(defn ^:no-project-needed kibit
  "I don't do a lot."
  [project & args]
  (let [kibit-project '{:dependencies [[jonase/kibit "0.0.8"]]}
        src `(kibit.driver/run '~project ~@args)
        req '(require 'kibit.driver)]
    (eval-in-project kibit-project src req)))
