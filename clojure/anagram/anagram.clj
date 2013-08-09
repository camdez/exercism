(ns anagram)

(defn anagrams-for [word possible-anagrams]
  (let [sorted-word (sort word)]
    (filter
     #(= sorted-word (sort %))
     possible-anagrams)))
