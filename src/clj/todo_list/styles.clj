(ns todo-list.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.stylesheet :refer [rule]]))

;;TODO: Move the todo-list.app

(defstyles todo-list
  [:ul.todo-list {:list-style :none}])

(defstyles todo-box
  [:div.todo
   {:font-size "32px"
    :margin-bottom "15px"
    :margin-right "0px"
    :border-radius "15px"
    :border "1px solid #d1d3d6"}
   [:ul.inline-list
    {:margin-bottom "7px"}]
   [:a
    {:font-size "12px"
     :color "#d1d3d6"
     :padding "2px 4px 2px 4px"}
    [:&:hover
     {:background-color :black
      :color "#d1d3d6"
      :border-radius "5px"}]]
   [:p
    {:margin "5px 0 2px 0"
     :font-size "32px"}]])

(def font {:font-family "Helvetica Neue" :font-size "16px" :line-height 1.5})

(defstyles screen
  (let [container (rule :div#container)]
    (container
     font
     todo-list
     todo-box)))
