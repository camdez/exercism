(ns phone
  (:require [clojure.string :as str]))

(def invalid-response "0000000000")

(defn- clean-number [s]
  "Returns a phone number in canonical 10-digit format or nil if the
format is invalid."
  (let [digits  (str/replace s #"\D" "")
        matches (re-matches #"1?(\d{10})" digits)]
    (when matches
      (second matches))))

(defn number [s]
  (or (clean-number s) invalid-response))

(defn area-code [s]
  (subs s 0 3))

(defn pretty-print [s]
  (let [clean (clean-number s)]
    (apply str "(" (area-code clean) ") " (subs clean 3 6) "-" (subs clean 6))))
