(ns phrase
  (:require [clojure.string :as str]))

(defn- count-occurrences [coll]
  (reduce
   (fn [counts x]
     (update-in counts [x] (fnil inc 0)))
   {}
   coll))

(defn word-count [s]
  (->> (str/split (str/lower-case s) #"\W")
       (remove str/blank?)
       (count-occurrences)))
