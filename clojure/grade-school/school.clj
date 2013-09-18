(ns school)

(defn add [db name grade]
  (update-in db [grade] (fnil #(conj % name) [])))

(defn grade [db grade]
  (get db grade []))

(defn sorted [db]
  (into {} (for [[grade students] db]
             [grade (sort compare students)])))
