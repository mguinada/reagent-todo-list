(ns todo-list.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.stylesheet :refer [rule]]))

(defstyles todo
  (let [div (rule :div.todo) p (rule :div.todo :p)]
    (div {:margin-bottom "5px"})
    (p {:font-size "32px" :margin-bottom "2px"})))

(defstyles todo-list
  (let [task-list (rule :ul.todo-list)]
    (task-list {:list-style :none})))

(defstyles screen
  (let [body (rule :body)]
    (body
     {:font-family "Helvetica Neue" :font-size "16px" :line-height 1.5}
     todo
     todo-list)))
