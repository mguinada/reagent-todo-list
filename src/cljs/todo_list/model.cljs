(ns todo-list.model
  (:require [clojure.string :as string :refer [capitalize]]))

(defn task
  "Task constructor"
  [description]
  {:description (capitalize description) :created-at (.getTime (js/Date.)) :done false})

(defn done
  "Mark task as done"
  [task]
  (assoc task :done true))

(defn done?
  "Is the task done?"
  [task]
  (:done task))
