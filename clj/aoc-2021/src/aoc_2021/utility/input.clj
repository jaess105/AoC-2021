(ns aoc-2021.utility.input
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str]))
  (:require [io/reader])


(defn input-split-on-linebreak [path] (str/split (slurp path) #"\r\n"))

