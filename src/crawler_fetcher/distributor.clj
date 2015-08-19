(ns crawler-fetcher.distributor
  (require [clj-http.client :as client]))

(def servers
  ["100.100.100.1"
   "100.100.100.2"
   "100.100.100.3"])

(def default-params { :content-type :json :accept :json })

(def repo-number-by-server
  (fn [repositories-count]
    (Math/round (double (/ repositories-count (count servers))))))

(def create-body-request
  (fn [repositories-json] {:body (client/json-encode repositories-json) }))

(defn split-repos [repositories]
  (partition (repo-number-by-server (count repositories)) repositories))

(defn assign-a-server-for-repositories [repositories]
  (apply hash-map (interleave servers (split-repos repositories))))

(defn distribute [repositories]
  (for [server-with-repos (assign-a-server-for-repositories repositories)]
    (let [server-address (key server-with-repos)
          repositories   (val server-with-repos)]
      (client/post server-address (merge (create-body-request repositories) default-params)))))
