(ns Week4)

week 1 opdr 9
week 3 6c en d
week 4 3b


;; AANTEKENINGEN
; Vraag 3
; Aanpak
; (for [i (range 10 15)] [i (* i 2) (* i 3)])
;
; De macro:
;(defmacro my-for [name start end & exprs]
;  `(for [~name (range ~start ~end)]
;     [~@exprs]))

;; EINDE AANTEKENINGEN

; 1.a
(defn sumTo
	([n] 
   (if (= n 0) 0
     (sumTo n n)))
	([n iter]
   (if (= iter 0) n
     (recur (+ n (dec iter)) (dec iter)))))
(println (sumTo 3)) ;;=> 6

; 1.b
(defn times-called
  ([calc-fnc start-val limit]
    (times-called calc-fnc start-val limit 0))
  ([calc-fnc val limit called]
    (if (>= val limit) (dec called)
      (recur calc-fnc (calc-fnc val) limit (inc called)))))
(println (times-called (fn [x] (+ x x)) 2 1000)) ;;=> 8
(println (times-called (fn [x] (* x x)) 2 1000)) ;;=> 3
(println (times-called (fn [x] (Math/pow x x)) 2 1000)) ;;=> 2

; 2.a
(def books-atom (atom []))

(defn get-book [title]
  (loop [idx 1, book (nth @books-atom 0 "idx-not-found")]
    (if (= book "idx-not-found") "book-not-found"
	    (if (= title (:title book)) book
	      (recur (inc idx) (nth @books-atom idx "idx-not-found"))))))

(defn insert-book [title author publisher]
  (if (= "book-not-found" (get-book title))
    (swap! books-atom conj {:title title, :author author, :publisher publisher})
    "book-exists"))

(defn delete-book [title]
  (loop [idx 1, book (nth @books-atom 0 "idx-not-found"), books-vec []]
    (if (= book "idx-not-found")
      (reset! books-atom books-vec)
      (if (= title (:title book))
        (recur (inc idx) (nth @books-atom idx "idx-not-found") books-vec)
        (recur (inc idx) (nth @books-atom idx "idx-not-found") (conj books-vec book))))))

(defn update-book [current-title author publisher]
  (loop [idx 1, book (nth @books-atom 0 "idx-not-found"), books-vec []]
    (if (= book "idx-not-found")
      (reset! books-atom books-vec)
      (if (= current-title (:title book))
        (recur (inc idx) (nth @books-atom idx "idx-not-found") (conj books-vec (assoc book :author author :published publisher)))
        (recur (inc idx) (nth @books-atom idx "idx-not-found") (conj books-vec book))))))

(println @books-atom)
(println (get-book "Jan Jans en de kinderen"))
(println (insert-book "Jan Jans en de kinderen" "Jan Steen" "Uitgevertje B.V."))
(println (get-book "Jan Jans en de kinderen"))
(println (insert-book "Jan Jans en de kids" "Jan Steen" "Uitgevertje B.V."))
(println (insert-book "Jan Jans en de kinderen" "Jan Steen" "Uitgevertje B.V."))
(println (delete-book "Jan Jans en de kinderen"))
(println (update-book "Jan Jans en de kids" "Jan Been" "Uitgevurrr B.V."))

; 2.b
(def time-elapsed (atom {:started false, :time (. System (nanoTime))}))

(defn start! []
  (if (:started @time-elapsed)
    "Stopwatch already started"
    (do
      (swap! time-elapsed assoc :started true :time (. System (nanoTime)))
      "Stopwatch started")))

(defn stop! []
  (if (:started @time-elapsed)
    (let [elapsed (/ (double (- (. System (nanoTime)) (:time @time-elapsed))) 1000000000.0)]
      (do
	      (swap! time-elapsed assoc :started false)
	      (str elapsed " seconds passed since start")))
    "Start stopwatch first"))

(println (start!)) ;;=> "Stopwatch started"
(println (start!)) ;;=> "Stopwatch already started"
(println (stop!)) ;;=> "3.618 seconds passed since start"
(println (stop!)) ;;=> "Start stopwatch first"
(println (start!)) ;;=> "Stopwatch started"
(println (stop!)) ;;=> "105.838 seconds passed since start"

; 3.a,b
;(defmacro my-for [[i end] & code]
;  '(let [finish# ~end]
;     (loop [~i 0]
;      (when (< ~i finish#)
;         ~@code
;        (recur (inc ~i))))))


;(defmacro my-for [name start end & exprs]
;  '(for [~name (range ~start ~end)]
;     [~@exprs]))
;(defmacro my-for [name start end & exprs]
;  `(for [name (range ~start ~end)] 
;    [~exprs]))
;(defmacro my-for [name begin end & funcs]
;  (if (>= begin end)
;    '(for [name (range ~begin ~end)]
;       ([~(first ~funcs)])))
;    
;    (loop [iterator begin, limit end, returnlist '()]
;      (if (>= end begin)
;        (recur (dec iterator) end returnlist)
;        returnlist)))
;(my-for i 10 15 i (* i 2) (* i 3))
;(my-for c 97 123 (char c))
;(apply str (apply concat (my-for c 97 123 (char c))))