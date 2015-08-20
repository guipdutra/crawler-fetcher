(ns crawler-fetcher.core
  (:require [crawler-fetcher.github-api-wrapper :refer [get-all-repositories]]
            [crawler-fetcher.distributor :refer [distribute]]))


(def extract-username-and-repo-name
  (fn [repo] (hash-map :name (:name repo) :login (:login (:owner repo)))))

(defn -main []
  (dorun
    (distribute (map extract-username-and-repo-name (get-all-repositories)))))
