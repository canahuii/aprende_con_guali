# Tutorial 2

![imagen hola mundo](hola_mundo.png)

# Tu primer entorno de trabajo y el "Hola Mundo"

¡Es hora de escribir tu primera línea de código! En esta lección aprenderás a ubicarte dentro de la aplicación y ejecutarás el programa más famoso del mundo de la programación: el **"Hola Mundo"**.

---

## 1. Conociendo el entorno de trabajo

No necesitas instalar ni usar herramientas externas. Toda la práctica la realizarás directamente dentro de esta aplicación. 

La pantalla principal está dividida en las siguientes áreas principales:

1. **Panel de Lección Activa (Centro-Izquierda):** Muestra las instrucciones y la explicación de la lección actual.
2. **Editor de Código (Centro-Derecha):** El área de texto editable donde escribirás tu código Java manualmente.
3. **Botones de Acción:** Ubicados debajo del editor:
   * **Compilar:** Revisa que tu código esté bien escrito.
   * **Ejecutar:** Pone en marcha tu programa (solo se habilita si la compilación fue exitosa).
4. **Panel de Consola (Inferior):** Muestra los mensajes del sistema, los resultados de la ejecución o los errores detectados.

---

## 2. Escribiendo tu primer programa

En Java, para mostrar un mensaje en pantalla, utilizamos la instrucción `System.out.println()`.

### Pasos a seguir:

1. Dirígete al **Editor de Código** a la derecha.
2. Escribe **manualmente** el siguiente código (recuerda que copiar manualmente te ayuda a memorizar la sintaxis y evitar errores):

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola, Mundo!");
    }
}