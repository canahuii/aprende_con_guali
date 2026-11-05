# Tutorial 6
![toma de decisiones](decisiones.png)
# Toma de Decisiones con Condicionales (if / else)

En la vida real tomamos decisiones constantemente: *"Si está lloviendo, llevo sombrilla; si no, voy sin ella"*. En programación, las **estructuras condicionales** permiten que tu código tome diferentes caminos según se cumpla o no una condición.

---

## 1. Reglas y Conceptos Clave

Para controlar el flujo de ejecución en Java utilizamos la estructura `if` (si) y `else` (si no):

* **La instrucción `if`:** Evalúa una condición entre paréntesis `()`. Si la condición resulta verdadera (`true`), ejecuta el bloque de código entre sus llaves `{}`.
* **La instrucción `else`:** Es opcional y se ejecuta únicamente cuando la condición del `if` resulta falsa (`false`).
* **Operadores Relacionales (Comparaciones):**
  * `>` (Mayor que) y `<` (Menor que)
  * `>=` (Mayor o igual) y `<=` (Menor o igual)
  * `==` (Igual a) y `!=` (Diferente de)

---

## 2. Instrucciones para la Práctica

A continuación escribirás un programa que evalúa la calificación de un estudiante y decide automáticamente si ha aprobado o reprobado la materia.

1. Dirígete al **Editor de Código** a la derecha.
2. Escribe **manualmente** el siguiente código Java completo:

```java
public class Main {
    public static void main(String[] args) {
        int nota = 75;
        int notaMinimaAprobatoria = 60;

        System.out.println("Evaluando nota del estudiante: " + nota);

        // Estructura condicional
        if (nota >= notaMinimaAprobatoria) {
            System.out.println("Resultado: ¡Felicidades! Has aprobado la materia.");
        } else {
            System.out.println("Resultado: Lo sentimos, necesitas repasar más.");
        }

        System.out.println("Proceso de evaluación finalizado.");
    }
}