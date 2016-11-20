(set-env!
 :source-paths    #{"sass" "src/cljs" "src/clj"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs          "1.7.228-1"  :scope "test"]
                 [adzerk/boot-cljs-repl     "0.3.0"      :scope "test"]
                 [adzerk/boot-reload        "0.4.8"      :scope "test"]
                 [pandeiro/boot-http        "0.7.2"      :scope "test"]
                 [com.cemerick/piggieback   "0.2.1"      :scope "test"]
                 [org.clojure/tools.nrepl   "0.2.12"     :scope "test"]
                 [weasel                    "0.7.0"      :scope "test"]
                 [org.clojure/clojurescript "1.7.228"]
                 [reagent "0.6.0"]
                 [org.martinklepsch/boot-garden "1.2.5-3" :scope "test"]
                 [deraen/boot-sass  "0.2.1" :scope "test"]
                 [org.slf4j/slf4j-nop  "1.7.13" :scope "test"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]]
 '[org.martinklepsch.boot-garden :refer [garden]]
 '[deraen.boot-sass    :refer [sass]])

(deftask build []
  (comp (cljs)
        (garden :styles-var 'todo-list.styles/screen :output-to "css/garden.css")
        (sass)))

(deftask run []
  (comp (serve)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production []
  (task-options! cljs {:optimizations :advanced}
                 garden {:pretty-print false}
                 sass   {:output-style :compressed}
                 identity))

(deftask development []
  (task-options! cljs {:optimizations :none :source-map true}
                 reload {:on-jsload 'todo-list.app/init})
  identity)

(deftask dev
  "Simple alias to run application in development mode"
  []
  (comp (development)
        (run)))
