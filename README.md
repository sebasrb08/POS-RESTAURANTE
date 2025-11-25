# POS Restaurante – Proyecto Final POO

Sistema de punto de venta (POS) para la gestión de un restaurante, desarrollado como **Proyecto final de la asignatura Fundamentos de Programación Orientada a Objetos (3er semestre)**.

La aplicación permite administrar **mesas, platos, pedidos y usuarios** mediante una interfaz de escritorio construida en Java Swing, siguiendo el patrón **MVC**.

---

## 📚 Contexto Académico

- **Asignatura:** Fundamentos de Programación Orientada a Objetos  
- **Programa:** Tecnología / Ingeniería en Sistemas  
- **Semestre:** 3  
- **Tipo de trabajo:** Proyecto final  
- **Enfoque principal:** Aplicar los conceptos de POO (clases, objetos, herencia, encapsulamiento, controladores, separación de capas, etc.) en una aplicación real.

---

## ✨ Características principales

- Gestión de **Platos**
  - Crear, listar, actualizar y eliminar platos.
  - Campos como: ID, código, nombre, precio y descripción.
- Gestión de **Mesas**
  - Administración de las mesas del restaurante.
- Gestión de **Pedidos**
  - Asociación de pedidos a mesas y platos.
- Gestión de **Usuarios** (según avance del proyecto)
  - Opciones de “Usuarios”, “Cambios de clave”, “Cambios de usuario” y “Cerrar sesión”.
- **Interfaz gráfica modernizada**
  - Menú lateral fijo estilo “dashboard”.
  - Sección de bienvenida con mensaje tipo landing page.
  - Resumen del día (mesas activas, pedidos en curso, platos registrados).
  - Ventanas de Platos, Mesas y Pedidos embebidas en la ventana principal, con efecto de transición (fade-in).
- **Arquitectura organizada**
  - Capas de **vista**, **controlador**, **modelo/DAO** y **utilidades**.

---

## 🧱 Arquitectura del Proyecto

El proyecto está organizado en paquetes, siguiendo el patrón **Modelo–Vista–Controlador (MVC)**.

- `uts.edu.fpoo.vista`
  - Contiene las interfaces gráficas (formularios Swing):
    - `MenuOpciones` (ventana principal con menú lateral).
    - `PlatosVista`
    - `MesasVista`
    - `PedidosVista`
    - (y otras vistas relacionadas).
- `uts.edu.fpoo.controlador`
  - Controladores que conectan las vistas con la lógica de negocio y la base de datos:
    - `PlatosControlador`
    - `MesasControlador`
    - `PedidosControlador`
    - …
- `uts.edu.fpoo.modelo`
  - Clases de modelo y DAO:
    - Entidades: Plato, Mesa, Pedido, Usuario, etc.
    - DAOs para operaciones CRUD contra la base de datos.
- `uts.edu.fpoo.util`
  - Utilidades como la clase de conexión a la base de datos (`Conexion`) y otras funciones de apoyo.

Esta estructura permite mantener separado el código de:
- **Presentación (GUI)**  
- **Lógica de negocio / controladores**  
- **Acceso a datos (DAO + BD)**  

---

## 🛠 Tecnologías utilizadas

- **Lenguaje:** Java (POO)
- **Entorno de desarrollo:** NetBeans (versión 12 o similar)
- **Interfaz gráfica:** Java Swing
- **Base de datos:** MySQL (via JDBC)
- **Patrón de diseño:** MVC (Modelo–Vista–Controlador)
- **Control de versiones:** Git y GitHub
- **Sistema operativo de desarrollo:** Windows

---

## ⚙️ Requisitos previos

Para ejecutar el proyecto localmente necesitas:

- **Java JDK 8+**
- **NetBeans** (o cualquier IDE compatible con proyectos Java Swing)
- **Servidor MySQL** instalado y corriendo
- Usuario y contraseña de MySQL configurados (coincidir con los que usa la clase `Conexion`)
- **Git** (opcional pero recomendado para clonar el repositorio)

---

## 🚀 Cómo ejecutar el proyecto

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/sebasrb08/POS-RESTAURANTE.git
   cd POS-RESTAURANTE
