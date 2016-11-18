(ns todo-list.model)

(defn task
  "Task constructor"
  [description]
  {:description description :created-at (.getTime (js/Date.)) :done false})

(defn done
  "Mark task as done"
  [task]
  (assoc task :done true))
