(ns won.core
  (:require
   [clojure.data.json :as json]))

(def data (slurp "./resources/testi.json"))
(def data-with-keys (json/read-str data :key-fn keyword))

(defn calculate-vaccines [vaccine-patches]
  (let [manufactorer (:vaccine (first vaccine-patches))]
    (reduce (fn [acc cur]
              ;; (println 
              ;;  {:vaccine manufactorer
              ;;   :batch_date (:batch_date cur)
              ;;   :remaining (+ (:quantity cur) (:quantity-remaining acc))})
              (assoc acc :quantity-remaining (+ (:quantity cur) (:quantity-remaining acc))))
            {:vaccine manufactorer :quantity-remaining 0}
            vaccine-patches)))

(defn map-by-vaccines [data-with-negated-vals]
  (map second (group-by :vaccine data-with-negated-vals)))

(defn negate-out-quantities [data]
  (->> data
       (map
        #(if (= (:direction %) "OUT") (assoc % :quantity (- (:quantity %))) %))
       (map #(dissoc % :direction))))

(defn quantities [data-with-keys]
  (->> data-with-keys
       (negate-out-quantities)
       (map-by-vaccines)
       (map #(calculate-vaccines %))))

(quantities data-with-keys)
