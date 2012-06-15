(defproject sketchpad "0.0.1-SNAPSHOT"
  :description "A light weight IDE for programming with Overtone and Clojure"
  :main sketchpad.core
  :dependencies [[org.clojure/clojure "1.3.0"]
        	       [overtone "0.6.0"]
        		  [franks42/seesaw "1.4.2-SNAPSHOT"]
        		  [clooj "0.3.4.2-SNAPSHOT"]
                 [rounded-border "0.0.1-SNAPSHOT"]
                 [org.fife.ui/rsyntaxtextarea "2.0.3"]
                 [net.sf.squirrel-sql.thirdparty-non-maven/com-fifesoft-autocomplete "1.0.0"]
                 [language-builder "1.0.0-SNAPSHOT"]]
  :jvm-opts ~(if (= (System/getProperty "os.name") "Mac OS X") ["-Xdock:name=Sketchpad"] []))
