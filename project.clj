(defproject lein-kibit "0.1.3"
  :description "kibit lein plugin"
  :url "https://github.com/jonase/lein-kibit"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[jonase/kibit "0.1.3"]
                 [org.clojure/tools.namespace "0.2.11"]]
  :deploy-repositories [["releases" :clojars]]
  :eval-in-leiningen true)
