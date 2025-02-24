# Inventario App

## Instrucciones para ejecutar en modo desarrollo

### API

Recomiendo abrir la carpeta `app/`, la cual tiene el código de la REST API hecha con Spring, en un editor de código como IntelliJ IDEA y ejecutar el archivo main `app/src/main/java/com/inventario/tia/app/AppApplication.java` desde ahí.

Para ejecutarlo desde la línea de comandos deben instalar Java y Maven y seguir los pasos de la siguiete [guía](https://docs.spring.io/spring-boot/maven-plugin/run.html)

### Web

El frontend es más sencillo, navegar a la carpeta `web/`, instalar las dependencias con:

```bash
npm i
```

Una vez instaladas ejecutar:

```bash
npm run dev
```
