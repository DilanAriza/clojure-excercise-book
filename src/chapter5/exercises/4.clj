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

(def example-map-2 {:a1 {:a2 {:a3 "Hola, espero se encuentren bien, en este hermoso" } } :b1 {:b2 {:b3 20} } } )

(def update-in-example-map-a-2 (update-in example-map-2 [:a1 :a2 :a3] #(str "buenos dias " % " mundo")))

(def update-in-example-map-a-3 (assoc-in example-map-2 [:a1 :a2 :a3] "buenos dias, VALOR ACTUALIZADO"))

; ahora ejecutamos update-in para actualizar el valor de a3 dentro de a2 y al a vez dentro de a1
(def update-in-example-map-a (update-in example-map [:a1 :a2 :a3] * 10))

; ahora realizamos la modificacacion pero de b3, esto sumandole 15 al valor de la clave b3


(def update-in-example-map-b (update-in example-map [:b1 :b2 :b3] + 15))

; en el punto 5, segun lo que comprendo es integrar la funcion en si, pero no se especifica en donde, entonces tome en cuenta eso para integrarlo en este ejercicio basandome en el cuerpo del map compartido entre el 3 y el 4 ejercicio


; se utiliza la recursividad para acceder a todas las keys suministradas y recorrerlas una a una,
; para de esta forma poder saber si estamos en el elemento exacto o en el elemento contenedor,
; asi podemos

; se utiliza la validacion de if, para saber si estamos accediendo al ultimo indice de la estructura
; si se encuentran mas keys, osea other-keys, entonces llama recursivamente a la misma funcion,
; esta vez pasandole la key del elemento hijo, luego cuando se descubre que no existe otro elemento hijo
; se ejecuta el assoc final asignaldole al ultimo elemento hijo el valor nuevo

(def test-object {:a1 {:a2 {:a3 "v1" } } :b1 {:b2 {:b3 "v1"} } } )
(defn assoc-in-int
  ([structure [key & other-keys] value]
   (if other-keys
     (assoc structure key (assoc-in-int (get structure key (hash-map)) other-keys value))
     (assoc structure key value))))

; este defn funciona de una forma parecida al de arriba, solo que esta vez permite ingresarle
; en vez de un solo elemento unico, una funcion y sus argumentos
; cuando se le pasa la funcion, permite que al final de proceso no solo sobreescriba el valor,
; sino que permite tomarlo en cuenta y modificarlo, actualizandolo pero tomando en cuenta su valor previo
; como en el ejemplo de la parte de arriba, utilizando el hola

(defn update-in-inter-f
  ([structure [key & other-keys] func & params]
   (if other-keys
     (assoc structure key (update-in-inter-f (get structure key (hash-map)) other-keys func params))
     (assoc structure key (apply func (get structure key (hash-map)) params)))))

;(def testValueObject-Update (update-in-inter-f test-object [:a1 :a2 :a3] #(str % "v2")))
;(def testValueObject-UpdateIn (update-in test-object [:a1 :a2 :a3] (str "v2")))
(def testValueObject-Assoc (assoc-in-int test-object [:c1 :a2 :a3] "test"))