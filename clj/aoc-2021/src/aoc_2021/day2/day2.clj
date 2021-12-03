(ns aoc-2021.day2.day2
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str])
  (:require [clojure.edn :as edn]))
(:require [io/reader])


(def str-number-vec (let [day2-str (str/split (slurp "resources/day2.txt") #"\r\n")
                          vec-str-number #(vector (first %) (edn/read-string (second %)))
                          split-on-space #(str/split % #" ")]
                      (->> day2-str
                           (map split-on-space)
                           (map vec-str-number))))

(defn task-1 [] (let [end-map-task-1 (let [merge-map (fn [data-map y]
                                                   (let [[key val] y]
                                                     (assoc data-map key (+ (data-map key) val))))]
                                   (reduce merge-map {"forward" 0 "down" 0 "up" 0} str-number-vec))
                  x (end-map-task-1 "forward")
                  y (- (end-map-task-1 "down") (end-map-task-1 "up"))]
  (println (format "The x, y coordinates are: (%d, %d)" x y))
  (println (format "And theire mulitplycation is: %d" (* x y)))))

(defn task-2-func [data-map y]  (let [[key val] y
                                 down #(assoc %1 :aim (+ (data-map :aim) %2))
                                 up #(assoc %1 :aim (- (data-map :aim) %2))
                                 foreward (fn [data-map val] 
                                            (let [map-new-h (assoc data-map :horizontal (+ (data-map :horizontal) val))]
                                              (assoc map-new-h :depth (+ (map-new-h :depth) (* (map-new-h :aim) val)))))
                                 ]
                                (if (= key "down")
                                  (down data-map val)
                                  (if (= key "up") 
                                    (up data-map val) 
                                    (foreward data-map val)))))


(defn task-2 [] (let [end-map-task-2 (reduce task-2-func {:aim 0 :depth 0 :horizontal 0} str-number-vec)
                  aim (end-map-task-2 :aim) 
                  depth (end-map-task-2 :depth)
                  horizontal (end-map-task-2 :horizontal)]
              (println 
               (format "The x, y coordinates are: (%d, %d). With an aim of %d." 
                       depth horizontal aim))
              (println (format "And theire mulitplycation is: %d" (* horizontal depth)))))

(comment
  (task-1)
  (task-2))




