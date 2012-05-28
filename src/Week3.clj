(ns Week3)

; Vraag 1
; a
; (= (list :aap :noot :mies) '(:aap :noot :mies))
; (= '(1 2 3 4) (flatten '(1 2 (3 4))))
; (= '(1 2 3 4) (conj '(3 4) 2 1))

; b
; (#(reverse %) '(1 2 3 4))


; Vraag 2
; a
; (= '(1 2 3 4) (conj [1 2] 3 4))
; (= '(1 2 3 4) (into () [4 3 2 1]))

; Vraag 3
; (zipmap [:first :second :third] [1 2 3])
; (interleave [:first :second :third] [1 2 3])
; (hash-map :first 1 :second 2 :third 3)
;
; (def tentamencijfers [{:naam "Piet" :cijfer 7} {:naam "Klaas" :cijfer 3}])
; (assoc-in tentamencijfers [1 :cijfer] 10)
; (get-in (assoc-in tentamencijfers [1 :cijfer] 10) [1 :cijfer])
; (fn [x y]
;   (and 
;     (contains? y x)
;     (nil? (y x))
;   )
; )

; Vraag 4
; (remove #{:a :d} #{:a :b :c :d})
; (set [1 1 2 3])
; omdat een set bestaat uit unique waarden
; (into #{1 2 3 4} #{5 6 7 8})

; Vraag 5
; (into [5] [4 3 2 1])
; (apply str ["een" "twee" "drie"])
;
; (defn my-but-last [x]
;   (x (- (count x) 2))
; )

; Vraag 6
; (defn repeat-fifteen [x]
;   (repeat 15 x)
; )
; (use '[clojure.xml :only (parse)])
; (def xml-doc (parse (java.io.File. "src/tentamen.xml")))
; (loop [count (- (count (:content xml-doc)) 1) result []]
;   (if (< count 0)
;     result
;      (recur (dec count) (conj result 
;        (hash-map 
;          (get (:content (first (:content (get (:content xml-doc) count)))) 0)
;          (get (:content (second (:content (get (:content xml-doc) count)))) 0)
;        )                                                           
;     ))
;   )
; )



