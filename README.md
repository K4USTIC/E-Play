# E-Play

## Ejecutar con Docker Compose

Desde la raíz del proyecto, inicia el gateway y los tres microservicios:

```sh
docker compose up --build
```

El gateway queda disponible en `http://localhost:8080`; también se publican
directamente los microservicios en los puertos `8081` (compras), `8082`
(usuarios) y `8083` (juegos). PostgreSQL escucha en el puerto `5432` y cada
microservicio tiene su propia base de datos. Los datos se conservan en el
volumen `postgres_data` incluso al ejecutar `docker compose down`; para
borrarlos intencionalmente, usa `docker compose down -v`.

Las credenciales incluidas son solo para desarrollo local; cámbialas antes de
usar esta configuración en un entorno compartido o de producción.
