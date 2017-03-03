(ns clj-ignite.core
  (:use clojure.test)
  (:import (org.apache.ignite Ignition
                              Ignite
                              IgniteCluster)
            (org.apache.ignite.cluster ClusterGroup)
            (org.apache.ignite.lang IgniteRunnable)
            (org.apache.ignite.configuration CacheConfiguration)
            (org.apache.ignite.cache CachePeekMode)))

(defn say-hello
  [ignite grp]
  (.broadcast (.compute ignite grp) 
                  (reify IgniteRunnable
                    (run 
                      [this] 
                      (println (str "Hello node - " (.id (.localNode (.cluster (.ignite grp))))))))))

(defn start
  "Start Ignite compute task node."
  [conf]
  (with-open [ignite (Ignition/start conf)]
    (println "Compute example started.")
    (say-hello ignite (.cluster ignite))))
    ; (say-hello ignite (.forRemotes (.cluster ignite)))))
    ; (say-hello ignite (.forRandom (.forRemotes (.cluster ignite))))))

(defn start-server
  "For only start node."
  [conf]
  (Ignition/start conf))

(defn test-cache
  "Test cache operations."
  [conf]
  (with-open [ignite (Ignition/start conf)]
    (println "Cache example started.")
    (let [cache (.getOrCreateCache ignite (new CacheConfiguration))
          k 1
          v "2"]
      (.put cache k v)
      (is (.get cache k) v))))

(defn -main
  [& args]
  ; (start "example-ignite.xml"))
  (test-cache "example-ignite.xml"))
  ; (start-server "example-ignite.xml"))