(ns sketchpad.user
	(:use [sketchpad buffer-edit]
       clojure.string)
	(:require [sketchpad.tab-manager :as tab]
			  [sketchpad.rsyntaxtextarea :as rsta]
			  [sketchpad.core :as core]))

(def app @core/current-app)

(defn help
([]
	(println)
	(println "Sketchapd Help")
	(println)
	(println "useful commands:")
	(println)
	(println  "\t :file")
	(println  "\t :project"))
([kw]
	(println)
	(println "Sketchapd Help")
	(println)
	(cond
		(= kw :file)
			(println "file helper functions:")
			(println)
			(println "\t :open/:o")
			(println "\t :close/:c")
		(= kw :project)
			(println "project helper functions:")
			(println)
			(println "\t :open/:o")
			(println "\t :close/:c")
	)))

;; clojure tools

(defn preflect [obj]
	(clojure.pprint/pprint (clojure.reflect/reflect obj)))


;; sketchpad tools

(def component-look-up-table
	{
	:current (tab/current-text-area (:editor-tabbed-panel app))
	:repl (:editor-repl app)

	})

(defn current-rsta []
	(:current component-look-up-table))

(defn make-icon []

)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Buffer functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; get list of buffers, name or number of current buffer, open new buffer, close buffer

; Return the filename without the full path, or something like *scratch* if the file
; hasn't been saved anywhere yet.

(defn buffer-list
  [])

(defn current-buffer
  "Return a buffer 'object' for the current buffer, which can be used to manipulate the buffer with
  other functions."
  [])

(defn switch-to-buffer
  "Bring a new buffer to the foreground."
  [buf] )

(defn buffer-name
  "Get the name of a buffer."
  ([] (buffer-name (current-buffer)))
  ([buf] ))

(defn buffer-file-name
  "Get the full-path filename of the buffer."
  ([] (buffer-file-name (current-buffer)))
  ([buf] ))

(defn buffer-size
  "Returns the number of chars in a buffer."
  ([] (buffer-size (current-buffer)))
  ([buf] ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Cursor and mark position
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn cursor-point
  "Return the current position of the cursor as a character count."
  [])

(defn cursor-pos
  "Returns the position of the cursor [<column> <line>]."
  []
  )

(defn set-cursor-pos!
  "Set the position of the cursor."
  [col line]
  )

(defn current-col
  "Return the column number of the cursor in the current buffer."
  []
  (first (cursor-pos)))

(defn current-line
  "Return the line number of the cursor in the current buffer."
  []
  (second (cursor-pos)))

(defn goto-pattern
  [])

(defn goto-next-char
  [])

(defn goto-prev-char
  [])

(defn goto-next-word
  [])

(defn goto-prev-word
  [])

(defn goto-next-line
  [])

(defn goto-prev-line
  [])

(defn goto-next-paragraph
  [])

(defn goto-prev-paragraph
  [])


(defn push-mark
  "Push the current position onto the mark stack."
  [])

(defn pop-mark
  "Pop the last position off the mark stack and cursor to it."
  [])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Manipulate buffer text
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn buffer-insert-string
  "Insert a string into the given buffer."
  [buf col line txt]
  )

; These two fns below can use buffer-insert-string...

(defn buffer-append
  "Append text to the specified uffer."
  [buf txt]
  )

(defn prepend-append
  "Prepend text to the specified uffer."
  [buf txt]
  )

(defn get-line
  "Get a line of text from the current buffer."
  ([] (get-line (current-line)))
  ([line]
   ))

(defn set-line!
  "Set the current line of text."
  ([txt] (set-line! (current-line) txt))
  ([line txt]
   ))

(defn indent-line!
  ([])
  ([line]))

(defn next-non-blank-line
  "Move cursor to the next non-blank line."
  [])

(defn prev-non-blank-line
  "Move cursor to the previous non-blank line."
  [])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Search and replace
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn search
  "Find a regexp pattern in the current buffer."
  [regexp]
  )

(defn search-and-replace
  [])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; File and directory operations
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; Can probably just import some file util namespace from clojure.file that will provide the necessary functions (like checking if a path is a file or directory, getting and setting permissions, mkdir, move, rename, delete, etc...


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Repl functions (so scripts can manipulate the repl)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn get-repl-line
  "Returns the text on the current line of the repl."
  [])

(defn get-repl-col
  "Returns the current column number of the repl cursor."
  [])

(defn set-repl-line
  "Set the text on the current repl line."
  [txt])

;; Interactive
; I'm not sure the best way to do it, but it will probably be necessary for some commands and scripts
; to ask the user for input.  Maybe it should bring the editor-repl to the foreground,
; and then modify the prompt to ask for user input?


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Popup window
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; Create popup at current cursor location (or given location)
; set, add, remove contents of popup
; move, delete popup



