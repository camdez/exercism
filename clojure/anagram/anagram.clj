(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for [word possible-anagrams]
  (let [normalize #(sort (str/lower-case %))
        normalized-word (normalize word)]
    (filter
     #(= normalized-word (normalize %))
     possible-anagrams)))
