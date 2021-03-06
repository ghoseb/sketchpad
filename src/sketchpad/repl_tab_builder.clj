(ns sketchpad.repl-tab-builder
	(:import (java.awt.event KeyEvent)
					(java.io File StringReader BufferedWriter OutputStreamWriter FileOutputStream)
					(javax.swing JButton JOptionPane JWindow ImageIcon)
					(javax.swing.event DocumentListener))
	(:use [sketchpad styles project-manager buffer-edit option-windows repl utils tab-manager repl-component repl-button-tab prefs]
				[clojure pprint]
				[seesaw meta core border color])
	(:require [clojure.string :as str])
	)

(defn add-repl-mouse-handlers [app-atom panel rsta btn repl-component tab-color]
	(listen btn 
		:mouse-entered (fn [e] (swap! tab-color (fn [_] mouse-over-color)))
		:mouse-exited (fn [e] (swap! tab-color (fn [_] base-color)))
		:mouse-clicked (fn [e] (let [idx (.indexOfComponent panel repl-component)
												  yes-no-option (close-repl-dialogue)]
											(if (= yes-no-option 0)
												(do 
													(remove-repl-tab! panel idx)
													(remove-repl-from-project! app-atom rsta (get-meta rsta :project-path))))))))
 (defn new-repl-tab! 
 	([app-atom]
 	(let [app @app-atom
 				cur-project-path (get-current-project app-atom)
 				project-map (app :project-map)
 				tabbed-panel (app :repl-tabbed-panel)
		 		repl-component (make-repl-component app)
		 		rsta (select repl-component [:#editor])
		 		tab-title (str "REPL# " (+ (tab-count tabbed-panel) 1))
		 		cur-buffer (current-text-area (app :editor-tabbed-panel))
		 		cur-proj (get-meta cur-buffer :project)]
 		(add-tab! tabbed-panel tab-title repl-component)
 		(add-repl-to-project! app-atom rsta)
 		(let [project (@project-map cur-project-path)
 					index-of-new-tab (index-of tabbed-panel tab-title)
 					project-color (get-project-theme-color (:id project))
 					tab (repl-button-tab app tabbed-panel index-of-new-tab project-color)
 					close-button (select tab [:#close-button])
 					tab-label (first (select tab [:.tab-label]))
 					tab-color (atom base-color)]
 					(put-meta! rsta :tab tab)
 			(add-repl-mouse-handlers app-atom tabbed-panel rsta close-button repl-component tab-color)
 			(.setTabComponentAt tabbed-panel index-of-new-tab tab)
 			(show-tab! tabbed-panel index-of-new-tab)))))
