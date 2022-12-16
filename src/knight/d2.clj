(ns knight.d2
  (:require [clojure.string :as str]))

(def config {"A" :rock
             "B" :paper
             "C" :scissors
             "X" :rock
             "Y" :paper
             "Z" :scissors})

(def points {:rock 1
             :paper 2
             :scissors 3})

(defn calculate-game-score [strategy]
  (def temp (clojure.string/split strategy #" "))

  (def opp-st (-> (first temp) (config)))
  (def your-st (-> (last temp) (config)))

  (cond
    (= opp-st your-st) 3
    (and (= opp-st :rock) (= your-st :scissors)) 0
    (and (= opp-st :paper) (= your-st :rock)) 0
    (and (= opp-st :scissors) (= your-st :paper)) 0
    :else 6))

(defn strategy-point [strategy]
  (-> (clojure.string/split strategy #" ")
      (last)
      (config)
      (points)))

(defn total-points [strategy]
  (+ (calculate-game-score strategy) (strategy-point strategy)))

(defn problem-1 []
  (def normalized-input
    (-> "input.txt"
        (slurp)
        (clojure.string/split-lines)))
  (reduce + (map total-points normalized-input)))

(problem-1)
