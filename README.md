# 🎫 Helpdesk Ticketing API

API RESTful permettant la gestion de tickets d'incidents ou de demandes pour un service support. Projet réalisé en Java + Spring Boot.

## 🔧 Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Swagger UI
- Maven

## 📂 Architecture

Structure MVC + couches de service :
- Controller → DTO → Service → Repository → Entity
- Respect des principes SOLID
- Gestion d'erreurs centralisée avec `@ControllerAdvice`

## 🧱 Fonctionnalités

- 🔐 Authentification utilisateur simulée (version basique)
- 📄 CRUD des tickets : créer, lire, modifier, supprimer
- 🔎 Filtres : par statut, par utilisateur
- 📚 Documentation auto via Swagger

## 🧪 Tests

- Tests unitaires via JUnit + Mockito
- Couverture de code via JaCoCo (à venir)

## 🔌 Endpoints principaux (REST)

| Méthode | Endpoint         | Description              |
|---------|------------------|--------------------------|
| GET     | /api/tickets     | Liste de tous les tickets |
| POST    | /api/tickets     | Créer un nouveau ticket   |
| PUT     | /api/tickets/{id}| Modifier un ticket        |
| DELETE  | /api/tickets/{id}| Supprimer un ticket       |

> Accès Swagger : `http://localhost:8080/swagger-ui/index.html`

## 🏁 Lancer le projet

```bash
git clone https://github.com/Rado23-04/helpdesk-backend.git
cd helpdesk-backend
./mvnw spring-boot:run
