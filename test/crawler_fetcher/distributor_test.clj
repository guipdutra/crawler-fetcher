(ns crawler-fetcher.distributor_test
  (:use midje.sweet)
  (:use crawler-fetcher.distributor))


(facts "about 'split-repos'"
       (fact "it splits the repositories array based on number of servers"
             (split-repos [{:name "rails" :login "rails"}
                           {:name "linux" :login "linux"}
                           {:name "jquery" :login "jquery"}]) => [[{:name "rails" :login "rails"}] [{:name "linux" :login "linux"}] [{:name "jquery" :login "jquery"}]]))


(facts "about 'distribute'"
       (fact "it distribute the repositories for the servers"
             (distribute [{:name "rails" :login "rails"}
                          {:name "linux" :login "linux"}
                          {:name "jquery" :login "jquery"}]) => '(nil nil nil)
             (provided
               (clj-http.client/post anything {:body "[{\"name\":\"rails\",\"login\":\"rails\"}]" :content-type :json :accept :json}) => nil
               (clj-http.client/post anything {:body "[{\"name\":\"linux\",\"login\":\"linux\"}]" :content-type :json :accept :json}) => nil
               (clj-http.client/post anything {:body "[{\"name\":\"jquery\",\"login\":\"jquery\"}]" :content-type :json :accept :json}) => nil)))
