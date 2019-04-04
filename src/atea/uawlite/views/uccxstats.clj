(ns atea.uawlite.views.uccxstats
  (:require [atea.uawlite.views.template :refer [page labeled-radio]]
            [hiccup.form :refer [form-to label text-field text-area submit-button]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]
            ))

(defn- rtstats-attributes-view
  [queue callshandled callsabandoned]
  [:div
   [:div.row
    [:div.col-2 "Queue:"]
    [:div.col-10 queue]]
   (when callshandled
     [:div.row
      [:div.col-2 "Calls Hndled:"]
       [:div.col-10 callshandled]])
   (when callsabandoned
     [:div.row
      [:div.col-2 "Calls Abdned:"]
      [:div.col-10 callsabandoned]])])

(defn rtstats-view
  [{:keys [queue callshandled callsabandoned]} {:keys [errors messages]}]
  (page
   [:div.container.jumbotron.bg-light
    [:div.row
     [:h2 "RtStats"]]
    (rtstats-attributes-view queue callshandled callsabandoned)
    (when errors
      (for [error (doall errors)]
       [:div.row.alert.alert-danger
        [:div.col error]]))
    (when messages
      (for [message (doall messages)]
       [:div.row.alert.alert-success
        [:div.col message]]))]))


(defn list-rtstats-view
  [rtstats {:keys [messages]}]
  (page
   [:div.container.jumbotron.bg-light
    [:div.row [:h2 "Realtime Stats"]]
    (for [{:keys [queue callshandled callsabandoned]} (doall rtstats)]
      [:div
       (rtstats-attributes-view queue callshandled callsabandoned)
       [:hr]])
    (when messages
      (for [message (doall messages)]
       [:div.row.alert.alert-success
        [:div.col message]]))]))
