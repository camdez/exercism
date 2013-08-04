(ns dna
  (:require clojure.string))

(def thymine \T)
(def uracil  \U)

(defn to-rna [dna-str]
  (clojure.string/replace dna-str thymine uracil))