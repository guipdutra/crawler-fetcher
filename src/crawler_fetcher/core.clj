(ns crawler-fetcher.core
  (:require [crawler-fetcher.github-api-wrapper :refer [get-all-repositories]]))

(defn -main []
  (dorun
    (map (fn [repo] (println (:name repo))) (get-all-repositories))))
