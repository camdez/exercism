(ns phrase
  (:require [clojure.string :as str]))

(defn word-count [s]
  (->> (str/split (str/lower-case s) #"\W")
       (remove str/blank?)
       (frequencies)))
