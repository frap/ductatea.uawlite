(ns atea.uawlite.handler.index-test
  (:require [atea.uawlite.handler.index]
            [clojure.test :refer [deftest testing is]]
            [ring.mock.request :as mock]
            [integrant.core :as ig]))

(deftest check-index-handler
  (testing "Ensure that the index handler returns two links for add and list films"
    (let [handler (ig/init-key :atea.uawlite.handler/index {})
          response (handler (mock/request :get "/"))]
      (is (= :ataraxy.response/ok (first response)))
      (is (= "href=\"/list-queues\""
            (re-find #"href=\"/list-queues\"" (second response))))
      (is (= "href=\"/list-stats\""
            (re-find #"href=\"/list-stats\"" (second response)))))))
