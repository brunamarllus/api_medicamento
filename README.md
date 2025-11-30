# API Medicamento 

Este repositório contém uma API simples para registrar ingestão e horarios de medicamentos.

Layout do projeto
- Código-fonte Java: `src/main/java`
  - `model` — classes de domínio
  - `service` — serviços em memória e `Application.java`
  - `controller` — controllers REST

Requisitos
- Java 11
- Maven instalado (mvn)

Build e execução
1. Compilar o projeto:

```bash
mvn -DskipTests package
```

2. Executar a aplicação:

```bash
mvn spring-boot:run
```

(Se preferir, execute a classe `service.Application` a partir de sua IDE.)

Endpoints (exemplos)
- Lista agendas
  - GET http://localhost:8080/api/agenda

- Criar agenda
  - POST http://localhost:8080/api/agenda
  - Content-Type: application/json
  - Body exemplo:

```json
{
  "usuario": { "id": 1, "nome": "Maria" , "email":"maria@example.com"},
  "medicamento": { "id": 1, "nome": "Clonazepam", "dosagem":"2mg", "descricao":""},
  "horario": "08:00",
  "dataInicio": "2025-12-01",
  "dataFim": "2025-12-31"
}
```

- Lista usuários
  - GET http://localhost:8080/api/usuarios

- Criar usuário
  - POST http://localhost:8080/api/usuarios
  - Body exemplo:

```json
{ "nome": "Maria Silva", "email": "maria@example.com" }
```

- Lista medicamentos
  - GET http://localhost:8080/api/medicamentos

- Criar medicamento
  - POST http://localhost:8080/api/medicamentos
  - Body exemplo:

```json
{ "nome": "Clonazepam", "dosagem": "2mg", "descricao": "Medicamento controlado" }
```

- Registros de dose
  - GET http://localhost:8080/api/registro
  - POST http://localhost:8080/api/registro
  - Body exemplo:

```json
{ "idAgenda": 1, "data": "2025-12-01", "horario": "08:00", "tomada": true, "observacao": "Dose tomada" }
```

Notas finais
- O projeto atualmente usa serviços em memória (listas) para armazenar dados — isso facilita execução local e testes.


