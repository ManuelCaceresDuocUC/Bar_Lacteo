
# Bar Lácteo - Microservicio de Inventario

Este proyecto es un microservicio desarrollado con Spring Boot para gestionar productos, proveedores, movimientos de inventario y órdenes de compra del sistema del Bar Lácteo.

## 🛠 Tecnologías
- Java 17+
- Spring Boot 3
- Maven
- MySQL (usado con Docker)
- Git + GitHub

## 📁 Estructura del microservicio

- `/productos` → gestión de productos
- `/categorias` → categorías de productos
- `/proveedores` → proveedores registrados
- `/movimientos` → entradas y salidas de inventario
- `/ordenes` → órdenes de compra

## 🚀 Instalación y uso

### 1. Clonar el proyecto

```bash
git clone https://github.com/ManuelCaceresDuocUC/Bar_Lacteo.git
cd Bar_Lacteo
```

### 2. Configurar base de datos con Docker

```bash
docker run --name mysql-bar-lacteo -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=bar_lacteo_inventario -p 3306:3306 -d mysql:8
```

### 3. Configurar Spring Boot

En `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bar_lacteo_inventario
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

### 4. Ejecutar la aplicación

Desde tu IDE, ejecuta `InventarioServiceApplication.java`

## 📬 Endpoints de ejemplo (usar con Postman)

- POST `/productos`
- GET `/movimientos`
- POST `/ordenes`
- POST `/proveedores`

## 👥 Trabajo en grupo

Usar ramas para colaborar:

```bash
git checkout -b nueva-rama
git add .
git commit -m "Agrego nuevo módulo"
git push origin nueva-rama
```

## 📄 Licencia
Proyecto con fines académicos - Duoc UC
