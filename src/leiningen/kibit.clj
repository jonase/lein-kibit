(ns leiningen.kibit
  (:require [leiningen.core.eval :refer [eval-in-project]]))

(defn ^:no-project-needed kibit
  [project & args]
  (let [kibit-project '{:dependencies [[jonase/kibit "0.0.9-SNAPSHOT"]]}
        paths (or (:source-paths project) [(:source-path project)])
        src `(kibit.driver/run '~paths ~@args)
        req '(require 'kibit.driver)]
    (eval-in-project kibit-project src req)))
