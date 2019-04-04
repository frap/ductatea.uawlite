(ns atea.uawlite.boundary.uccx
  (:require [hugsql.core :as hugsql]
            [duct.database.sql])
  (:import java.sql.SQLException)
  )

;; wires up def-db-fns macro so that when we call it later
;; it will parse the uccx.sql file and create the fns for us
;; the  uccxstats.sql namespace
;; The path is relative to the classpath (not proj dir!),
;; so "src" is not included in the path.
;; The same would apply if the sql was under "resources/..."
;; Also, notice the under_scored path compliant with
;; Clojure file paths for hyphenated namespaces
(hugsql/def-db-fns "atea/uawlite/rtstats.sql")

(defprotocol RtStats
  (fetch-rtstats  [db])
  (fetch-csqs     [db]))


(extend-protocol RtStats
  duct.database.sql.Boundary
  (fetch-rtstats [{db :spec}]
    (sql-get-rtstats db))
  (fetch-csqs [{db :spec}]
    (sql-get-csqs db)))
