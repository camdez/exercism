(ns beer
  (:require [clojure.pprint :refer [cl-format]]))

(defn verse [beer-count]
  (cl-format nil "~[No more~:;~:*~D~] bottle~:P of beer on the wall, ~:*~[no more~:;~:*~D~] bottle~:P of beer.~%~:*~[Go to the store and buy some more~:;Take ~:*~[~;it~:;one~] down and pass it around~], ~[no more~:;~:*~D~] bottle~:P of beer on the wall.~%"
             beer-count
             (if (zero? beer-count) 99 (dec beer-count))))

(defn sing
  ([start] (sing start 0))
  ([start stop]
     (apply str (interleave (map verse (range start (dec stop) -1))
                            (repeat "\n")))))
