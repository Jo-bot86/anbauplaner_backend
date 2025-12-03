# Anbauplaner – Backend

Dieses Projekt stellt die Server-API zur Verfügung.  
Technologien:

- Spring Boot 3
- Java 21
- Spring Security
- JWT Authentifizierung
- PostgreSQL
- Hibernate JPA
- Gradle oder Maven (je nachdem)

---

## 🚀 Projekt starten (lokal)

### Voraussetzungen:
- Java 17
- PostgreSQL lokal

```bash
./mvnw spring-boot:run
```

Server läuft unter:
```arduino
http://localhost:8080
```


## 💾 Datenbank-Konfiguration
Lokalprofil `application-local.yml`
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/anbauplaner
    username: postgres
    password:
  jpa:
    hibernate:
      ddl-auto: update
```

## 🐳 Docker Betrieb

Backend wird gemeinsam mit der DB im Docker-Compose gestartet:
```bash
docker compose up --build
```

Wichtig:
Im Docker-Profil:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/anbauplaner
```

## 🔐 Authentifizierung

* Registrieren erzeugt User in DB

* Password wird verschlüsselt via BCrypt

* Login erzeugt JWT

* Zugriffsschutz via Spring Security FilterChain

* Autorisierung via Bearer-Token

  

## 🔑 JWT Secret

Das Secret wird gesetzt über:
```ini
JWT_SECRET=....
```
Nicht im Code hardcoded!


## 📁 API Endpunkte

### User
```bash
POST   /api/auth/register
POST   /api/auth/login
GET    /api/user/
GET    /api/user/{id}
PUT    /api/user/{id}
DELETE /api/user/{id}
```

### Plant
```bash
GET    /api/plant/
GET    /api/plant/{id}
PUT    /api/plant/{id}
DELETE /api/plant/{id}
```


## 📁 Projektstruktur
```pgsql
backend/
 ├─ domain/
 ├─ application/
 ├─ infrastructure/
 │   ├─ security/
 │   │   ├─ jwt/
 │   │   ├─ config/
 │   ├─ persistence/
 │   ├─ web/
 └─ AnbauplanerApplication.java
```

## 🧪 Tests

(geplant)

* Integration Tests
  
* Security Tests
  
* Controller-Tests


## ✨ Features

✔ Userverwaltung

✔ Passwort-Hashing

✔ JWT-basierte Authentifizierung

✔ PostgreSQL-Persistent-Storage

✔ Docker-Container-Deployment

✔ valide CORS-Konfiguration
