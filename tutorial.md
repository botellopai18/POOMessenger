# Notas
## Estructura
POOMessenger/
....src/
........ejemplos/
............interfaces/
....bin/
........ejemplos/
............interfaces/
....resources/
.......imagenes,etc

- src: contiene archivos.java dentro de paquetes
- bin: contiene archivos.class para ejecutarse
- resources: guardar archivos como imagenes, videos, etc.

## ¿Como compilar y ejecutar?
### Para compilar:
(Tienes que estar en la carpeta inicial osea POOMessenger)
--> javac -d bin src/paquete/nombreArchivo.java

### Para ejecutar:
(Tienes que estar en la carpeta inicial osea POOMessenger)
java -cp bin paquete.nombreClase

--Por ejemplo:
javac -d bin src/ejemplos/interfaces/panel-con-scroll.java
java -cp bin ejemplos.interfaces.PanelConScroll

