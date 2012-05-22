(ns Week4)

; Vraag 3
; Aanpak
; (for [i (range 10 15)] [i (* i 2) (* i 3)])
;
; De macro:
;(defmacro my-for [name start end & exprs]
;  `(for [~name (range ~start ~end)]
;     [~@exprs]))