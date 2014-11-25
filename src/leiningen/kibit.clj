(ns leiningen.kibit
  (:require [leiningen.core.eval :refer [eval-in-project]]))

(defn ^:no-project-needed kibit
  [project & args]
  (let [kibit-project '{:dependencies [[jonase/kibit "0.0.9-SNAPSHOT"]]}
        paths (seq (disj (set (concat
                                (:source-paths project)
                                [(:source-path project)]
                                (mapcat :source-paths (get-in project [:cljsbuild :builds]))
                                (mapcat :source-paths (get-in project [:cljx :builds]))))
                         nil))
        src `(kibit.driver/external-run '~paths ~@args)
        req '(require 'kibit.driver)]
    (try (eval-in-project kibit-project src req)
         (catch Exception e
           (throw (ex-info "" {:exit-code 1}))))))
