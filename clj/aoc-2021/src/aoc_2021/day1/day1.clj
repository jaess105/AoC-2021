(ns aoc-2021.day1.day1
 (:require [clojure.edn :only [read-string]]))
(use '[aoc-2021.utility.input :only [input-split-on-linebreak]])


(def path "resources/day1.txt")
(def input (map read-string (input-split-on-linebreak path)))


(def one-if-greater  #(if (< %1 %2) 1 0))
(defn aufgabe-1-fun [in] (reduce + (map one-if-greater in (rest in))))
(def aufgabe-1 (aufgabe-1-fun input))
(comment
  aufgabe-1  
  )
(defn aufgabe-2-fun [in] (->> (map #(+ %1 %2 %3) in (rest in) (nthrest 2 in))
                              (map one-if-greater)
                              (reduce +)))
