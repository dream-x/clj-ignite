(defproject clj-ignite "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main clj-ignite.core
  :dependencies [[org.clojure/clojure "1.8.0"]
                  [javax.cache/cache-api "1.0.0"]
                  [org.apache.ignite/ignite-core "1.8.0"]
                  [org.apache.ignite/ignite-log4j "1.8.0"]
                  [org.apache.ignite/ignite-indexing "1.8.0"]
                  [org.apache.ignite/ignite-spring "1.8.0"]])
