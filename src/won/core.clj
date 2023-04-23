(ns won.core
  (:require
   [clojure.data.json :as json]))

(def data (slurp "./resources/testi.json"))

(def data-with-key (json/read-str data :key-fn keyword))
(def quantities-negated (map #(if (= (:direction %) "OUT") (assoc % :quantity (- (:quantity %))) %) data-with-key))

(def data-no-direction (map #(dissoc % :direction) quantities-negated))

(def grouped-by-vaccines (group-by :vaccine data-no-direction))

(def mapped-by-vaccines (map second grouped-by-vaccines))

(defn vaccine-calculated [daily-batch]
  (let [vacc (:vaccine (first daily-batch))]
    (reduce (fn [acc cur]
              (assoc acc :quantity (+ (:quantity cur) (:quantity acc))))
            {:vaccine vacc :quantity-remaining 0}
            daily-batch)))

(def quantity-by-vaccine
  (map #(vaccine-calculated %) mapped-by-vaccines))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (quantity-by-vaccine))
