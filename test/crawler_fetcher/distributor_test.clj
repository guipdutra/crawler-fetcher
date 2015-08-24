(ns crawler-fetcher.distributor_test
  (:use midje.sweet)
  (:use crawler-fetcher.distributor))


(facts "about 'split-repos'"
       (fact "it splits the repositories array based on number of servers"
             (split-repos [{:name "rails" :login "rails"}
                           {:name "linux" :login "linux"}
                           {:name "jquery" :login "jquery"}]) => [[{:name "rails" :login "rails"}] [{:name "linux" :login "linux"}] [{:name "jquery" :login "jquery"}]]))
