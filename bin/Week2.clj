(ns Week2)

; Vraag 1
; TODO, Onduidelijk hoe de array uit elkaar getrokken moet worden. Max return de gehele array

; Vraag 2
; 12 voor alle 3 de functies
;
; ((fn [x] (int (* x x))) 5)
;
; (filter #(< % 5) [1 6 5 2 3])

; Vraag 3
; (defn myfunction
;   ([x y] (* x y))
;   ([x y & others] (+ x y (reduce + others)))
; )

; Vraag 4
; ((fn [x] (nth x (- (count x) 1))) [2 3 4])
;
; ((fn [& x]
;   (if (> (count x) 1)
;     (filter (fn [x] (= (type x) "java.lang.String") x) x)
;     (type (nth x 0))
;   )
; ) "banaan" "appel")
;
; Via loop is met niet gelukt. Ben zover gekomen =
; (loop [counter 10 iterator 0]
;   (if (< counter iterator)
;     (println "end")
;     (recur (- counter 1)(+ iterator 1))
;   )
; )
; Probleem : Krijg maar 1 uitput. Er wordt niet iets uitgeprint als er overheen geloopt wordt. Maar pas als de gehele loop afgelopen is.
; Wat wel kan is het volgende:
; (dotimes [i 10] (println i))

; Vraag 5
;(defn not-zero? [x]
;  (= false (. clojure.lang.Numbers (isZero x)))
;)

