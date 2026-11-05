# Tutorial 8
![reutilizacion de codigo](reutilizacion.png)
# Reutilización de Código con Funciones y Métodos

A medida que tus programas crecen, escribir todo el código dentro del método `main` se vuelve difícil de leer y mantener. Los **métodos** (o funciones) son bloques de código independientes diseñados para realizar una tarea específica que puedes invocar cuantas veces necesites.

---

## 1. Reglas y Conceptos Clave

Un método en Java permite modularizar y reutilizar lógica. Se compone de las siguientes partes principales:

* **Tipo de retorno:** Indica qué tipo de dato devolverá el método al finalizar (por ejemplo `int`, `String`, `double`). Si el método no devuelve ningún valor, se utiliza la palabra clave `void`.
* **Nombre del método:** Se escribe en convención *camelCase* (ejemplo: `calcularSuma`, `obtenerSalud`).
* **Parámetros:** Son los valores de entrada que recibe el método entre sus paréntesis `()` para procesar la información.
* **La instrucción `return`:** Devuelve el resultado del procesamiento al lugar donde se llamó el método.

---

## 2. Instrucciones para la Práctica

A continuación escribirás un programa que define un método para calcular el área de un rectángulo y otro para determinar si un número es par o impar.

1. Dirígete al **Editor de Código** a la derecha.
2. Escribe **manualmente** el siguiente código Java completo:

```java
public class Main {

    // Método que recibe dos números y devuelve un área (int)
    public static int calcularArea(int base, int altura) {
        return base * altura;
    }

    // Método que verifica si un número es par (boolean)
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println("--- Probando Métodos en Java ---");

        // Llamada al método calcularArea
        int area = calcularArea(5, 4);
        System.out.println("El área del rectángulo es: " + area);

        // Llamada al método esPar
        int numeroEvaluar = 8;
        boolean resultadoPar = esPar(numeroEvaluar);
        System.out.println("¿El número " + numeroEvaluar + " es par?: " + resultadoPar);

        System.out.println("¡Métodos ejecutados correctamente!");
    }
}