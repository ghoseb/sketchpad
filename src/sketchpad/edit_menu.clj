(ns sketchpad.edit-menu
	(:use [sketchpad editor-kit] 
		  [clooj utils dev-tools]
		  [seesaw.core])

	(:import (org.fife.ui.rtextarea RTextAreaEditorKit)))

(defn yank-action
	[text-editor])

(defn menu-item-with-accelerator
	[text accelerator]
	(let [item (menu-item :text text
								:listen [:action #(delete-rest-of-line-action)])]
		(.setAccelerator item (get-keystroke accelerator))
		item))

(defn edit-text-menu
	[rta]
	(let [item (menu-item :text "Delete To End"
						  :listen [:action (fn [_] (delete-rest-of-line-action rta))])]
	(.setAccelerator item (get-keystroke "ctrl K"))
	(menu :text "Text"
          :items [item])))