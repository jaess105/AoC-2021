(ns aoc-2021.day1.day1
 (:require [clojure.java.io :as io])
 (:require [clojure.string :as str])
 (:require [clojure.edn :only [read-string]]))
(:require [io/reader])
(use '[aoc-2021.utility.input :only [input-split-on-linebreak]])


(def path "resources/day1.txt")
(def input (map read-string (input-split-on-linebreak path)))



(defn aufgabe-1 [in] (let [liste (for [x in
                                       y (rest in)]
                                   (if (< x y) 1 0))]
                                   ;;(print liste)
                                   (reduce + liste) 
                         )) 
(comment
  (aufgabe-1 input)
  )
