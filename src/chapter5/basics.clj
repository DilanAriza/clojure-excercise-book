(ns chapter5.basics)

; ===        ===
; === REDUCE ===
; ===        ===
(defn reduce-exercise-str [str-list]
  (reduce str str-list))

(defn reduce-sum-numbers [number-list]
  (reduce + number-list))

(defn reduce-minus-numbers [n1 n2 n3]
  (reduce - [n1 n2 n3]))

(defn reduce-multiply-numbers [number-list]
  (reduce * number-list))

(defn reduce-split-numbers [number-list]
  (reduce / number-list))

; validar numeros primos
(defn reduce-pair-numbers [number-list]
  (reduce #(if (even? %2)
             ;conj, agrega un elemento a una coleccion, aqui lo agrega a la colecion 1%
             ;%2 es el elemento a revisar, si paso el if, se agrega al acomulador, en este caso %1
             (conj %1 %2)
             ;En el caso contrario, si no se cumple, solo se devuelve el acomulador sin realizar inguna operacion
             ; [] es el valor inicial del acomulador
             ; number-list es la lista de numeros a procesar
             %1) [] number-list))

; ===        ===
; === APPLY  ===
; ===        ===
(defn apply-string-concat [str-list]
  (apply str str-list))

(defn apply-max-numbers [number-list]
  (apply max number-list))
; apply lo que hace es pasarle a una funcion una lista de elementos de manera unitaria, lo que le permite que si tenemos una lista que recibe valores de manera individual, podamos con apply asignarle un vector, o arreglo de elementos, y apply los pasara de manera separada e indidual a la funcion
