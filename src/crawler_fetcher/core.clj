(ns crawler-fetcher.core
  (:require [crawler-fetcher.github-api-wrapper :refer [get-all-repositories]]
            [crawler-fetcher.distributor :refer [distribute]]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.util.response :refer [response]])
  (:use ring.adapter.jetty))

(def extract-username-and-repo-name
  (fn [repo] (hash-map :name (:name repo) :owner {:login (:login (:owner repo))})))

(defn handler [request]
  (println (:body request))
  (response "Ok"))

(def app
  (wrap-json-body handler {:keywords? true :bigdecimals? true}))

(defn -main []
  (future (dorun
            (distribute (map extract-username-and-repo-name (get-all-repositories)))))
  (run-jetty app {:port 3001}))
