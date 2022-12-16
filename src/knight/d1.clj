#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns knight.aoc.d1
  (:require [clojure.string :as str]))

(defn calculate-total-calories [str]
  (->>
   str
   (str/split-lines)
   (map #(Integer/parseInt %))
   (apply +)))

(defn problem-1 []
  (def calories
    (->
     "input.txt"
     (slurp)
     (str/split #"\n\n")))

  (->>
   calories
   (map calculate-total-calories)
   (reduce max)))

(problem-1)