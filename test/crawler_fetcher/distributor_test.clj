(ns crawler-fetcher.distributor_test
  (:use midje.sweet)
  (:use crawler-fetcher.distributor))


(facts "about 'split-repos'"
       (fact "it splits the repositories array based on number of servers"
             (split-repos [{:name "rails" :login "rails"}
                           {:name "linux" :login "linux"}
                           {:name "jquery" :login "jquery"}]) => [[{:name "rails" :login "rails"}] [{:name "linux" :login "linux"}] [{:name "jquery" :login "jquery"}]]))


(comment (facts "about 'distribute'"
       (fact "it distribute the repositories for the servers"
             (distribute [{:name "rails" :login "rails"}
                          {:name "linux" :login "linux"}
                          {:name "jquery" :login "jquery"}]) => nil
             (provided
               (clj-http.client/post "100.100.100.1" {:body "{\"name\":\"rails\",\"login\":\"rails\"}" :content-type :json :accept :json}) => nil
               (clj-http.client/post "100.100.100.2" {:body "{\"name\":\"linux\",\"login\":\"linux\"}" :content-type :json :accept :json}) => nil
               (clj-http.client/post "100.100.100.3" {:body "{\"name\":\"jquery\",\"login\":\"jquery\"}" :content-type :json :accept :json}) => nil))))
