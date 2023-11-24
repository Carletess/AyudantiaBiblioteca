# Sistema de modelo.Biblioteca

Este proyecto contiene las clases Java para un sistema de biblioteca. Aquí se describen las clases principales, incluyendo `modelo.Biblioteca`, `modelo.Prestamo`, `modelo.Bibliotecario`, `modelo.Libro`, y `modelo.Usuario`, junto con el método `generarPrestamo`.

## Clase `modelo.Biblioteca`

La clase `modelo.Biblioteca` representa una biblioteca y contiene métodos y atributos relacionados con la gestión de libros y préstamos. Algunas de las características clave de esta clase incluyen:

- Atributos como `nombre`, `direccion`, `bibliotecario`, `libro`, y `usuarios`.
- Métodos para agregar libros, buscar libros por autor y más.

## Clase `modelo.Prestamo`

La clase `modelo.Prestamo` se utiliza para representar los préstamos de libros en el sistema de biblioteca. Algunos de los aspectos importantes de esta clase son:

- Atributos como `fechaInicio`, `fechaTermino`, `libro`, `usuario`, y `bibliotecario`.
- Métodos para obtener y establecer estos atributos.

## Clase `modelo.Bibliotecario`

La clase `modelo.Bibliotecario` representa a un bibliotecario y contiene atributos como `nombre`, `rut`, `direccion`, e `id`. Algunos de los aspectos importantes de esta clase son:

- Métodos para obtener y establecer estos atributos.

## Clase `modelo.Libro`

La clase `modelo.Libro` representa un libro en la biblioteca y contiene atributos como `nombre`, `isbn`, `autor`, y `editorial`. Algunos de los aspectos importantes de esta clase son:

- Métodos para obtener y establecer estos atributos.

## Clase `modelo.Usuario`

La clase `modelo.Usuario` representa a un usuario de la biblioteca y contiene atributos como `nombre`, `rut`, y `numeroTelefonico`. Algunos de los aspectos importantes de esta clase son:

- Métodos para obtener y establecer estos atributos.

## Método `generarPrestamo`

En la clase `modelo.Biblioteca`, se ha implementado el método `generarPrestamo` que permite crear un objeto `modelo.Prestamo` con los atributos de un préstamo y retornarlo.

Ejemplo de uso:

```java
modelo.Biblioteca biblioteca = new modelo.Biblioteca("modelo.Biblioteca Central", "Calle Principal");

// Parámetros para el préstamo
modelo.Bibliotecario bibliotecario = new modelo.Bibliotecario("Juan", "123456789", "Calle modelo.Biblioteca", 1);
modelo.Usuario usuario = new modelo.Usuario("Maria", "987654321", "1234567890");
Date fechaInicio = new Date();
Date fechaTermino = new Date();
modelo.Libro libro = new modelo.Libro("La Odisea", "Homero", "Editorial XYZ", "1234567890");

// Generar un préstamo
modelo.Prestamo prestamo = biblioteca.generarPrestamo(bibliotecario, usuario, fechaInicio, fechaTermino, libro);
