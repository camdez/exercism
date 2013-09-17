(ns dna
  (:require [clojure.set :as set]))

(def dna-nucleotides #{\A \C \G \T})
(def rna-nucleotides #{\A \C \G \U})
(def valid-nucleotides (set/union dna-nucleotides rna-nucleotides))

(defn nucleotide-counts [dna-str]
  (reduce (fn [counts nuc]
            (update-in counts [nuc] inc))
          (zipmap dna/dna-nucleotides (repeat 0))
          dna-str))

(defn count [nuc dna-str]
  (if (valid-nucleotides nuc)
    (get (nucleotide-counts dna-str) nuc 0)
    (throw (Exception. "invalid nucleotide"))))
