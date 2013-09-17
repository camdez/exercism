(ns dna)

(defn hamming-distance [d1 d2]
  (reduce (fn [diff-count t]
            (if t (inc diff-count) diff-count))
          0
          (map not= d1 d2)))
