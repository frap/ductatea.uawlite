(ns atea.uawlite.views.index
  (:require [atea.uawlite.views.template :refer [page]]))

(defn list-stats []
  (page
    [:div.container.jumbotron.bg-white.text-center
     [:row
      [:p
       [:a.btn.btn-primary {:href "/list-queues"} "List Queues"]]]
     [:row
      [:p
       [:a.btn.btn-primary {:href "/list-stats"} "List RealTimeStats"]]]]))
