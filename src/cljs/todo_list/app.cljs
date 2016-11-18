(ns todo-list.app
  (:require [reagent.core :as r]
            [todo-list.model :as m]))

(def state
  (r/atom
   {:task
    [(m/task "Review presentation slides")
     (m/task "Check if current slideware does not exceed presentation timebox")]}))

(defn task
  "Renders a TODO item"
  []
  [:div.row.todo
   [:div.large-12.columns
    [:p [:strong "Task mockup "]
     "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."]
    [:ul.inline-list
     [:li [:a {:href "javascript:void(0);"} "Mark as done"]]]]])

(defn root-component
  "Container all components"
  []
  [task])

(defn init
  "Entry point"
  []
  (r/render-component [root-component] (.getElementById js/document "container")))
