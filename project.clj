; (load-file "config/default.clj")
; (load-file "config/user.clj")
; (println (:clojure-version sketchpad-prefs))

(defproject sketchpad "0.0.1-SNAPSHOT"
  :description "A light weight IDE for programming with Overtone and Clojure"
;  :main sketchpad.core
  :dependencies [[org.clojure/clojure "1.4.0"]
                 ;[org.clojure/clojure-contrib "1.2.0"]
        		     [franks42/seesaw "1.4.2-SNAPSHOT"]
                 [clooj "0.3.4.2-SNAPSHOT"]
                 [rounded-border "0.0.1-SNAPSHOT"]
                 [rsyntax-clojars "0.1.0-SNAPSHOT"]
                 [language-builder "1.0.0-SNAPSHOT"]
                 [auto-complete "0.1.0-SNAPSHOT"]
                 [timbre "0.5.1-SNAPSHOT"]
                 [leiningen-core "2.0.0-SNAPSHOT"]
                 [org.clojure/tools.nrepl "0.2.0-beta8"]
                 ;[com.cemerick/pomegranate "0.0.13"]
                 ;[org.clojars.stevelindsay/tools.nrepl "0.2.0-b2"]
                 ]
  :jvm-opts ~(if (= (System/getProperty "os.name") "Mac OS X") ["-Xdock:name=Sketchpad"] []))
