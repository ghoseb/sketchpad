(ns overtone-sketchpad.documentation
  (:use 
        [upshot.core]
        [upshot.animation]
        [upshot.paint]) 
  (:import javax.swing.event.HyperlinkEvent
           javax.swing.event.HyperlinkEvent$EventType))



; (defn make-scene []
;   (scene
;     :root (border-pane
;             :top (h-box
;                    :children [(button :id :play :text "Play")
;                               (button :id :stop :text "Stop")])
;             :center (circle :id :ball :radius 50
;                             :fill :white))
;     :width 600.0 :height 400.0
;     :fill :black))

(defn make-scene []
  (scene 
    :root (border-pane
            :center (web-view
                      :url "http://localhost:8080/docs/ugens-list"))
    :width 700
    :height 300))

(defn add-behaviors [root]
  (let [ball (select root [:#ball])
        play (select root [:#play])
        stop (select root [:#stop])
        tl   (timeline
               (key-frame
                 (key-value (property ball :translate-x) 0)
                 (key-value (property ball :translate-y) 0)
                 (key-value (property ball :fill) (to-paint :red))
                 :time 0.0)
               (key-frame
                 (key-value (property ball :translate-x) 200)
                 (key-value (property ball :translate-y) 200)
                 (key-value (property ball :fill) (to-paint :blue))
                 :time 1.0)
               :auto-reverse? true
               :cycle-count  5)]
    (config! play :on-action (fn [e] (play! tl)))
    (config! stop :on-action (fn [e] (stop! tl))))
  root)

(defn make-stage []
  (add-behaviors 
    (stage 
      :scene (make-scene))))

(defn run []
  (run-now
    (-> (stage :scene (make-scene))
      .show)))
; (defn make-editor-pane
;   []
;   (editor-pane
;     :id :doc-editor
;     :content-type "text/html"
;     :editable? false
;     :page "http://127.0.0.1:8080"))

; (defn add-behaviors
;   [root]
;   (let [editor (select root [:#editor])]
;     (listen editor :hyperlink
;       (fn [e]
;         (when (= HyperlinkEvent$EventType/ACTIVATED (.getEventType e))
;           (alert e (str "Clicked: " (.getDescription e)))))))
;   root)

(defn doc-browser []
  (run))
