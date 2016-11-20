(ns todo-list.styles
  (:require [garden.def :refer [defrule defstyles]]
            [garden.stylesheet :refer [rule]]))

(def grey "#d1d3d6")

(defstyles todo-list
  [:ul.todo-list {:list-style :none}])

(defstyles task-input
  [:div.task-input
   [:input
    {:height "50px"
     :font-size "20px"
     :border-radius "10px"}]])

(defstyles todo-box
  [:div.todo
   {:font-size "32px"
    :margin-bottom "15px"
    :margin-right "0px"
    :border-radius "15px"
    :border (str "1px solid " grey)}
   [:ul.inline-list
    {:margin-bottom "7px"}]
   [:a
    {:font-size "12px"
     :color grey
     :padding "2px 4px 2px 4px"}
    [:&:hover
     {:background-color :black
      :color grey
      :border-radius "5px"}]]
   [:p
    {:margin "5px 0 2px 0"
     :font-size "32px"}]])

(def font {:font-family "Helvetica Neue" :font-size "16px" :line-height 1.5})

(defstyles screen
  (let [container (rule :div#container)]
    (container
     font
     task-input
     todo-list
     todo-box)))
