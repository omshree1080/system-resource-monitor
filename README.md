# System Resource Monitor Microservice (Java)
A Spring Boot microservice that exposes system metrics via `/stats` endpoint and supports Docker, Jenkins CI/CD, and visualization using Grafana + Graphite.

## Technologies
- Java 17
- Spring Boot
- OSHI
- Docker & Docker Compose
- Jenkins
- Grafana & Graphite

## Run

### Local
```bash
mvn spring-boot:run
```

### Docker
```bash
docker build -t system-monitor .
docker-compose up
```

### Jenkins CI
Use included Jenkinsfile.

## API
GET `/stats` returns:
```json
{
  "cpu_load": 25.43,
  "memory_total_MB": 8096,
  "memory_available_MB": 5120,
  "disk_total_GB": 256,
  "disk_free_GB": 120
}
```
