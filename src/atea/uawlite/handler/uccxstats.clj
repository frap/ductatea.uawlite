(ns atea.uawlite.handler.uccxstats
 (:require  [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [atea.uawlite.boundary.uccx :as boundary.uccx]
            [atea.uawlite.views.uccxstats :as views.uccxstats]
            [integrant.core :as ig]))


(defmethod ig/init-key :atea.uawlite.handler.uccxstats/list [_ {:keys [db]}]
  (fn [_]
    (let [rtstats-list (boundary.uccx/fetch-rtstats db)]
      (if (seq rtstats-list)
       [::response/ok (views.uccxstats/list-rtstats-view rtstats-list {})]
       [::response/ok (views.uccxstats/list-rtstats-view [] {:messages ["No UCCX RTStats found."]})]
       ))))
