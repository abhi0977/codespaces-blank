#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns knight.aoc.d1
  (:require [clojure.string :as str]))

(defn calculate-total-calories [str]
  (->>
   str
   (str/split-lines)
   (map #(Integer/parseInt %))
   (apply +)))

(def calories
  (->
   "input.txt"
   (slurp)
   (str/split #"\n\n")))

(defn problem-1 []
  (->>
   calories
   (map calculate-total-calories)
   (reduce max)))

(defn problem-2 []
  (->>
   calories
   (map calculate-total-calories)
   (sort)
   (take-last 3)
   (apply +)))

(problem-1)
(problem-2)
