(ns crawler-fetcher.distributor)

(def servers
  ["100.100.100.1"
   "100.100.100.2"
   "100.100.100.3"])

(def repo-number-by-server
  (fn [repositories-count]
    (Math/round (double (/ repositories-count (count servers))))))

(defn split-repos [repositories]
  (partition (repo-number-by-server (count repositories)) repositories))

(defn distribute [repositories]
  nil)


