# Sistema de Biblioteca

Este proyecto contiene las clases Java para un sistema de biblioteca. Aquí se describen las clases principales, incluyendo `Biblioteca`, `Prestamo`, `Bibliotecario`, `Libro`, y `Usuario`, junto con el método `generarPrestamo`.

## Clase `Biblioteca`

La clase `Biblioteca` representa una biblioteca y contiene métodos y atributos relacionados con la gestión de libros y préstamos. Algunas de las características clave de esta clase incluyen:

- Atributos como `nombre`, `direccion`, `bibliotecario`, `libro`, y `usuarios`.
- Métodos para agregar libros, buscar libros por autor y más.

## Clase `Prestamo`

La clase `Prestamo` se utiliza para representar los préstamos de libros en el sistema de biblioteca. Algunos de los aspectos importantes de esta clase son:

- Atributos como `fechaInicio`, `fechaTermino`, `libro`, `usuario`, y `bibliotecario`.
- Métodos para obtener y establecer estos atributos.

## Clase `Bibliotecario`

La clase `Bibliotecario` representa a un bibliotecario y contiene atributos como `nombre`, `rut`, `direccion`, e `id`. Algunos de los aspectos importantes de esta clase son:

- Métodos para obtener y establecer estos atributos.

## Clase `Libro`

La clase `Libro` representa un libro en la biblioteca y contiene atributos como `nombre`, `isbn`, `autor`, y `editorial`. Algunos de los aspectos importantes de esta clase son:

- Métodos para obtener y establecer estos atributos.

## Clase `Usuario`

La clase `Usuario` representa a un usuario de la biblioteca y contiene atributos como `nombre`, `rut`, y `numeroTelefonico`. Algunos de los aspectos importantes de esta clase son:

- Métodos para obtener y establecer estos atributos.

## Método `generarPrestamo`

En la clase `Biblioteca`, se ha implementado el método `generarPrestamo` que permite crear un objeto `Prestamo` con los atributos de un préstamo y retornarlo.

Ejemplo de uso:

```java
Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle Principal");

// Parámetros para el préstamo
Bibliotecario bibliotecario = new Bibliotecario("Juan", "123456789", "Calle Biblioteca", 1);
Usuario usuario = new Usuario("Maria", "987654321", "1234567890");
Date fechaInicio = new Date();
Date fechaTermino = new Date();
Libro libro = new Libro("La Odisea", "Homero", "Editorial XYZ", "1234567890");

// Generar un préstamo
Prestamo prestamo = biblioteca.generarPrestamo(bibliotecario, usuario, fechaInicio, fechaTermino, libro);
