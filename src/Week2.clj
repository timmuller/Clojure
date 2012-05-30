(ns Week2)

; Vraag 1
; (apply max [1 2 3 4 5])

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
; (loop [i 0]
;   (if (= i 10)
;     nil
;     (do (println i) (recur (+ i 1)))
;   ) 
; )

; Vraag 5
;(defn not-zero? [x]
;  (= false (. clojure.lang.Numbers (isZero x)))
;)

; Vraag 6
; Partial representeerd een of meerdere variable die gebruikt kunnen worden in functies. annonieme variable?
;
; (= '(3 4 5) (map (partial + 2)  [1 2 3]))
; 
; (= "first second third" (let [a " second" b  " third"] ((partial str "first") a b)))
;
; Comp kan meerdere functies binnenkrijgen en probeer hier een uitkomst van te maken.
;
; [x 8 y 3]

; Vraag 7
; Complement verdraait bijvoorbeeld true naar false en andersom
;
; (def not-ends-with? (complement ends-with?))

; Vraag 8
; (defn divisible-by-three? [x]
;   (zero? (rem x 3))        
; )

; Vraag 9
; (defn max-except-first [x] 
;   (if (> (count x) 1)
;     (apply max (take-last (- (count x) 1) x))
;     "kleiner"
;   )
; )

; Vraag 10
;
; (defn average [x y] 
;   (/ (+ x y) 2)
; )
;
; (defn improve [guess x]
;   (average guess (/ x guess))  
; )
;
; (defn good-enough? [guess x]
;   (< (- (* guess guess) x) 0.001)
; )
;
; (defn sqrt-iterator [guess x]
;   (if (good-enough? guess x)
;     guess
;     (sqrt-iterator (improve guess x) x)
;   )  
; )
;
; (defn sqrt [x]
;   (sqrt-iterator 1.0 x)
; )
;
; (defn abs [x] 
;   (if (< x 0) (- x) x))
