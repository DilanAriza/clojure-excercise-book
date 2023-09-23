(ns chapter5.exercises.3)

; ===        ===
; === ASSOC-IN ===
; ===        ===
(def example-map {:a1 {:a2 {:a3 "level a3 v1"} } :b1 {:b2 {:b3 "level b3 v1"} } } )


; assoc-in se utiliza para para asociar un valor, a una clave dentro de una ruta de una estructura de datos anidada (un objeto por ejemplo)
; los parametros son los siguientes: assoc-in estructura-de-datos ruta-de-clave valor-a-asignar
; en este caso, modificaremos la estructura de datos example-map
(def modified-example-map-a (assoc-in example-map [:a1 :a2 :a3] "level a3 v2"))
; en este caso la salida es la siguiente
; => {:a1 {:a2 {:a3 "level a3 v2"}}, :b1 {:b2 {:b3 "level b3 v1"}}}
; demostrando que se configuro o se anido el nuevo valor al indice pasado

; ahora vamos a cambiar el valor de b3, en este caso hace parte de b2 y a su vez de b1, cada b, representa un nivel o path en referencia a el example-map
(def modified-example-map-b (assoc-in example-map [:b1 :b2 :b3] "level b3 v2"))
; en este caso la salida es la siguiente
; => {:a1 {:a2 {:a3 "level a3 v1"}}, :b1 {:b2 {:b3 "level b3 v2"}}}
; demostrando que se configuro o se anido el nuevo valor al indice pasado
