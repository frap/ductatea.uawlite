-- :name sql-get-rtstats :? :*
-- :doc select all from the Realtime ICD Statisitics table
SELECT *
FROM RtICDStatistics

-- :name sql-get-loggedinagents :? :*
-- :doc select all loggedinagents from realTime ICD Statisitics tbale
SELECT loggedinagents AS agents
FROM RtICDStatistics

-- :name sql-get-csqs :? :*
-- :doc select active CSQ from contactservicequeue table
select CSQNAME from contactservicequeue where active = 'T' and queuetype = 0

-- :name sql-get-csqstats :? :*
-- :doc select all Real time CSQ data from RealTime CSQ Summary table
select *,(callshandled + callsdequeued) as callsHanDeq,(callsabandoned - callsdequeued) as callsAbDeq
FROM RtCSQsSummary
