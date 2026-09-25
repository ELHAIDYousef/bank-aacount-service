#  Bank Account Service

Micro-service Spring Boot pour la gestion de comptes bancaires, exposé via **REST**, **Spring Data REST** et **GraphQL**.

Projet réalisé dans le cadre du module Microservices — Pr. Mohamed Youssfi, ENSET Mohammedia.

---

## Présentation

Ce micro-service permet de créer, consulter, modifier et supprimer des comptes bancaires. Un même service métier est exposé de **trois façons différentes** (REST, Spring Data REST, GraphQL) afin de comparer les approches. L'application est construite en couches (entité → repository → service → présentation), et l'entité JPA n'est jamais exposée directement : les échanges se font via des **DTOs**.

## Technologies

Java 21 · Spring Boot · Spring Data JPA · H2 · Lombok · Spring Data REST · springdoc-openapi (Swagger) · Spring for GraphQL · Maven

## Structure du projet
- entity/ → Entité JPA BankAccount
- enums/ → AccountType (CURRENT_ACCOUNT, SAVING_ACCOUNT)
- repository/ → BankAccountRepository (Spring Data JPA)
- dto/ → AccountRequest (entrée), AccountResponse (sortie)
- mapper/ → Conversion entité <-> DTO
- service/ → Couche métier (interface + implémentation)
- projection/ → Projections pour Spring Data REST
- web/ → Contrôleurs REST et GraphQL


## Les trois façons d'exposer l'API

**1. API REST classique** — un contrôleur `BankAccountController` avec les endpoints CRUD standards. C'est l'approche la plus contrôlée : on choisit précisément les status codes, les DTOs et la logique.

**2. Spring Data REST** — le repository est exposé automatiquement en API REST, sans écrire de contrôleur. Les **projections** permettent de choisir les champs renvoyés (et d'afficher l'`id`, masqué par défaut). Idéal pour un CRUD simple.

**3. GraphQL** — un point d'entrée unique (`/graphql`) où le client demande exactement les champs qu'il veut. Le schéma définit des **queries** (lecture) et des **mutations** (écriture).

## Démarrage

```bash
mvn spring-boot:run
```

L'application démarre sur `http://localhost:8080`.

## Endpoints

| Ressource | URL |
|-----------|-----|
| API REST | `GET/POST/PUT/DELETE /accounts` |
| Swagger UI | `/swagger-ui.html` |
| Spring Data REST | `/accounts?projection=fullAccount` |
| GraphQL (GraphiQL) | `/graphiql` |
| Console H2 | `/h2-console` — JDBC : `jdbc:h2:mem:bank-account-db` |

**Exemple GraphQL :**
```graphql
# Query
query { accountsList { id balance currency type } }

# Mutation
mutation {
  saveAccount(account: { balance: 5000, currency: "MAD", type: SAVING_ACCOUNT }) {
    id balance type
  }
}
```

## Travail réalisé

1.  Projet Spring Boot (Web, Spring Data JPA, H2, Lombok)
2.  Entité JPA `BankAccount`
3.  Interface `BankAccountRepository` (Spring Data)
4.  Test de la couche DAO (`CommandLineRunner`)
5.  Web service RESTful de gestion des comptes
6.  Test avec Postman
7.  Documentation Swagger des API REST
8.  API Spring Data REST avec projections
9.  DTOs et Mappers
10.  Couche Service (métier)
11.  Web service GraphQL (queries + mutations)



---

*Yousef ELHAID — GLSID, ENSET Mohammedia*
