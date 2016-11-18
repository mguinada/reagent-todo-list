(ns todo-list.app
  (:require [reagent.core :as r]
            [todo-list.model :as m]))

(def state
  (r/atom
   {:tasks
    [(m/task "Review presentation slides")
     (m/task "Check if current slideware does not exceed presentation timebox")]}))

(defn task
  "Renders a TODO item"
  [task]
  [:div.row.todo
   [:div.large-12.columns
    [:p (:description task)]
    [:ul.inline-list
     [:li [:a {:href "javascript:void(0);"} "Mark as done"]]
     [:li [:a {:href "javascript:void(0);"} "Delete"]]]]])

(defn root
  "Root component"
  []
  [:div
   [:ul.todo-list
    (for [t (:tasks @state)]
      [:li
       [task t]])]])

(defn init
  "Entry point"
  []
  (r/render-component [root] (.getElementById js/document "container")))
