(ns chapter5.exercises.4)

; ===        ===
; === UPDATE-IN ===
; ===        ===


; update in se utiliza como una funcion que en ves de agregar un valor nuevo o
; -> reemplazar uno existente en una estructura de datos anidada o mapa de datos,
; -> este actualiza una clave existente, modificandolo mediante una funcion, esta se
; -> podria utilizar por ejemplo para sumar items, valores o elementos al valor de la
; -> clave a actualizar

(def example-map {:a1 {:a2 {:a3 10 } } :b1 {:b2 {:b3 20} } } )


; ahora ejecutamos update-in para actualizar el valor de a3 dentro de a2 y al a vez dentro de a1
(def update-in-example-map-a (update-in example-map [:a1 :a2 :a3] * 10))

; ahora realizamos la modificacacion pero de b3, esto sumandole 15 al valor de la clave b3


(def update-in-example-map-b (update-in example-map [:b1 :b2 :b3] + 15))

; en el punto 5, segun lo que comprendo es integrar la funcion en si, pero no se especifica en donde, entonces tome en cuenta eso para integrarlo en este ejercicio basandome en el cuerpo del map compartido entre el 3 y el 4 ejercicio

