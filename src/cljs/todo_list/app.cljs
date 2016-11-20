(ns todo-list.app
  (:require [reagent.core :as r]
            [todo-list.model :as m]))

(def state
  (r/atom
   {:tasks
    [(m/task "Review presentation slides")
     (m/task "Check if current slideware does not exceed presentation timebox")]}))

(defn add-task
  [task]
  (swap! state update-in [:tasks] conj task))

(defn task
  "Renders a TODO item"
  [task]
  [:div.row.todo
   [:div.large-12.columns
    [:p {:class (if (m/done? task) "done" "undone")} (:description task)]
    [:ul.inline-list
     [:li
      [:a (str "Mark as " (if (m/done? task) "undone" "done"))]]]]])

(defn task-input
  "Input new tasks"
  []
  (let [value (r/atom "")]
    (fn []
      [:div.task-input
       [:input
        {:value @value
         :type "text"
         :placeholder "Enter a new task"
         :on-change (fn [e] (reset! value (aget e "target" "value")))
         :on-key-down (fn [e] (when (= (aget e "keyCode") 13)
                                (add-task (m/task @value))
                                (reset! value "")))}]])))

(defn root
  "Root component"
  []
  [:div
   [task-input]
   [:ul.todo-list
    (for [t (:tasks @state)]
      ^{:key t} [:li [task t]])]])

(defn init
  "Entry point"
  []
  (r/render-component [root] (.getElementById js/document "container")))
