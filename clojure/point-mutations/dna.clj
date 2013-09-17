(ns dna)

(defn hamming-distance [d1 d2]
  (count (filter identity (map not= d1 d2))))
