# Tutorial 5
![error en tiempo de ejecucion](tiempo_ejecucion.png)
# Errores en Tiempo de Ejecución (Runtime Errors)

En las lecciones anteriores aprendiste a corregir **errores de compilación** (reglas de sintaxis que el compilador detecta antes de iniciar). Sin embargo, existe otro tipo de error muy común en programación: los **errores en tiempo de ejecución** o *Runtime Errors*.

Ocurren cuando la sintaxis de tu código es totalmente correcta y el programa logra compilar sin inconvenientes, pero al momento de **Ejecutar**, la computadora intenta realizar una operación matemáticamente o lógicamente imposible, interrumpiendo abruptamente el programa.

---

## 1. Reglas y Conceptos Clave

Para comprender y evitar los errores en tiempo de ejecución, ten en cuenta estas reglas fundamentales:

* **Regla de Operaciones Matemáticas Imposibles:** Las matemáticas básicas establecen que no se puede dividir entre cero. En Java, intentar dividir un número entero entre cero (`x / 0`) provocará inmediatamente una excepción del tipo `ArithmeticException` que detendrá la ejecución.
* **Diferencia Fundamental entre Errores:**
  * **Error de Compilación:** El programa **no llega a ejecutarse** porque el compilador no entiende la sintaxis del código.
  * **Error de Ejecución:** El programa **sí empieza a ejecutarse**, pero se interrumpe a mitad del proceso por una instrucción no válida.

---

## 2. Instrucciones para la Práctica

Para cumplir el objetivo pedagógico de esta lección, debes lograr que el programa compile con **0 errores** y, posteriormente, **producir un error al ejecutarlo**.

### Pasos a seguir:

1. Dirígete al **Editor de Código** a la derecha.
2. Escribe **manualmente** el siguiente código completo:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando la operación matemática...");

        int dividendo = 20;
        int divisor = 0;

        // Operación no válida: división entre cero
        int resultado = dividendo / divisor;

        System.out.println("El resultado es: " + resultado);
    }
}