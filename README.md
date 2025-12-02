# TIF - Aplicación FullStack Java

Proyecto de ejemplo con backend Spring Boot y frontend estático + Thymeleaf.

Cómo ejecutar:

1. Construir: `mvn -v` y luego `mvn package`
2. Ejecutar: `mvn spring-boot:run` o `java -jar target/tif-0.0.1-SNAPSHOT.jar`
3. Frontend: abrir `http://localhost:8080/` (static) o `http://localhost:8080/products` (Thymeleaf)

Base de datos en memoria H2: consola en `http://localhost:8080/h2-console` (jdbc url ya configurada)

Endpoints principales:
- `GET /api/products` listar
- `POST /api/products` crear
- `PUT /api/products/{id}` actualizar
- `DELETE /api/products/{id}` eliminar
- `POST /api/orders` crear orden (verifica stock)

Incluye archivo `postman_collection.json` y `er_diagram.svg`.
# TIF
Proyecto Integrador Final
