(ns bob
  (:use [clojure.string :only [blank?]]))

(defn- shouting? [s]
  (not (re-seq #"[a-z]" s)))

(defn- question? [s]
  (= (last s) \?))

(defn response-for [s]
  (cond
    (blank?    s) "Fine, be that way."
    (shouting? s) "Woah, chill out!"
    (question? s) "Sure."
    :else         "Whatever."))
