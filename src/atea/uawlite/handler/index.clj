(ns atea.uawlite.handler.index
 (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [atea.uawlite.views.index :as views.index]
            [integrant.core :as ig]))


(defmethod ig/init-key :atea.uawlite.handler/index [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok (views.index/list-stats)]))
