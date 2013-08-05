(ns phrase
  (:require [clojure.string :as str]))

(defn- count-occurrences [coll]
  (reduce
   (fn [counts x]
     (assoc counts x (inc (get counts x 0))))
   {}
   coll))

(defn word-count [s]
  (->> (str/split (str/lower-case s) #"\W")
       (remove str/blank?)
       (count-occurrences)))
