# Fluxo da Arquitetura do Projeto

## Objetivo

Este documento descreve o fluxo arquitetural atual do backend `duma`, com base na estrutura real do código. O foco é mostrar como as camadas se relacionam, como os dados percorrem a aplicação e como os domínios principais estão organizados.

## Visão Geral

O projeto é um backend Spring Boot organizado por domínio funcional. Cada domínio concentra seus próprios componentes de entrada, regra de negócio, persistência e contratos de API.

Fluxo principal da aplicação:

```text
Cliente HTTP
  -> SecurityFilterChain
  -> Controller
  -> Service
  -> Repository
  -> Banco relacional (PostgreSQL) e/ou MongoDB
  -> Service
  -> Mapper
  -> DTO de resposta
  -> Cliente HTTP
```

## Stack Atual

- Spring Boot 4
- Java 21
- Spring Web
- Spring Data JPA
- Spring Data MongoDB
- Spring Security com OAuth2 Resource Server
- MapStruct
- Lombok
- PostgreSQL
- MongoDB
- Redis configurado no ambiente
- RabbitMQ configurado no ambiente
- Springdoc OpenAPI

## Bootstrap da Aplicação

O ponto de entrada está em [DumaApplication.java](/home/matheus/Documentos/DevProjects/duma/duma-backend/src/main/java/io/github/mattheusffalbuquerque/duma/DumaApplication.java).

Responsabilidades observadas:

- inicializar o contexto Spring Boot
- habilitar auditoria JPA com `@EnableJpaAuditing`

Isso permite que entidades JPA com `@CreatedDate` sejam preenchidas automaticamente.

## Segurança

A configuração de segurança está em [SecurityConfig.java](/home/matheus/Documentos/DevProjects/duma/duma-backend/src/main/java/io/github/mattheusffalbuquerque/duma/config/SecurityConfig.java).

Fluxo atual de segurança:

```text
Requisição HTTP
  -> Spring Security
  -> validação JWT via OAuth2 Resource Server
  -> liberação apenas para rotas autenticadas
```

Rotas públicas atualmente:

- `/actuator/**`
- `/swagger-ui/**`
- `/v3/api-docs/**`

Todo o restante exige autenticação.

## Organização por Domínio

O código segue uma estrutura por domínio dentro de `src/main/java/io/github/mattheusffalbuquerque/duma/domains`.

Cada domínio tende a agrupar:

- `Entity` ou `Document`
- `Repository`
- `Service`
- `Controller`
- `Mapper`
- `dto/`
- `enums/` quando necessário

Exemplos de domínios presentes:

- `user`
- `student`
- `teacher`
- `skill`
- `stage`
- `module`
- `lesson`
- `exercice`
- `attempt`
- `lessonProgress`
- `modulePerformance`
- `meeting`
- `enrollment`

## Padrão de Fluxo por Requisição

### 1. Entrada HTTP

Os controllers expõem endpoints REST e delegam a regra de negócio ao service. Eles tendem a ser finos, com pouca lógica além do roteamento e empacotamento da resposta.

Exemplo de padrão:

```text
Controller
  -> recebe DTO de request
  -> chama Service
  -> devolve ResponseEntity com DTO de resposta
```

### 2. Regra de Negócio

Os services concentram:

- validação de existência de entidades relacionadas
- composição entre domínios
- atualização campo a campo em operações de update
- decisão de qual repositório consultar

Esse é o ponto onde o projeto conecta domínios relacionais e documentos Mongo quando necessário.

### 3. Persistência

Os repositories usam dois estilos no projeto:

- `JpaRepository` para entidades relacionais
- `MongoRepository` para documentos no MongoDB

Isso cria uma arquitetura híbrida de persistência.

### 4. Conversão de Dados

Os mappers usam MapStruct para converter:

- entidade -> DTO de resposta
- DTO de criação -> entidade

Em alguns casos, o service ainda complementa o mapeamento resolvendo relacionamentos por ID.

## Modelo de Persistência Híbrida

O backend usa PostgreSQL para a maior parte das entidades relacionais e MongoDB para exercícios.

### PostgreSQL

Usado pelos domínios JPA, como:

- `Student`
- `Teacher`
- `Lesson`
- `Stage`
- `Module`
- `Enrollment`
- `Meeting`
- `LessonProgress`
- `ModulePerformance`
- `Attempt`

### MongoDB

Usado pelo domínio de exercícios:

- `Exercise`

O `Attempt` mostra bem esse desenho híbrido:

- `student` e `lesson` são relacionamentos JPA
- `exerciseId` é apenas uma referência textual ao documento salvo no MongoDB

Isso significa que a integridade entre `Attempt` e `Exercise` não vem por chave estrangeira do banco, mas por validação aplicada no service.

## Fluxo Arquitetural do Domínio de Aprendizagem

O fluxo funcional mais claro hoje é:

```text
Skill
  -> Stage
  -> Module
  -> Lesson
  -> Exercise
  -> Attempt
  -> LessonProgress
  -> ModulePerformance
```

Leitura desse encadeamento:

- `Skill` organiza a área de conhecimento
- `Stage` representa uma etapa dentro da progressão
- `Module` agrupa conteúdo dentro da etapa
- `Lesson` representa a unidade de aprendizagem
- `Exercise` representa a atividade da aula e fica no MongoDB
- `Attempt` registra a submissão do aluno para um exercício
- `LessonProgress` acompanha avanço na aula
- `ModulePerformance` consolida métricas no módulo

## Exemplo de Fluxo Real: Attempt

O domínio `attempt` é um bom exemplo do padrão arquitetural do projeto.

Fluxo:

```text
POST /attempts
  -> AttemptController recebe CreateAttemptRequest
  -> AttemptService converte request em entidade
  -> valida Student no PostgreSQL
  -> valida Lesson no PostgreSQL
  -> valida exerciseId no MongoDB
  -> AttemptRepository salva em PostgreSQL
  -> AttemptMapper transforma em AttemptResponse
  -> resposta HTTP
```

Esse fluxo mostra um ponto importante da arquitetura atual:

- entrada e saída por DTO
- regra de negócio centralizada no service
- persistência híbrida entre JPA e Mongo
- controller sem lógica complexa

## Auditoria

O projeto usa auditoria JPA para alguns campos temporais, especialmente `createdAt`.

Isso depende de:

- `@EnableJpaAuditing` no bootstrap
- `@EntityListeners(AuditingEntityListener.class)` nas entidades
- campos anotados com `@CreatedDate` e, quando aplicável, `@LastModifiedDate`

Importante:

- isso vale para entidades JPA
- documentos Mongo podem seguir outra estratégia de auditoria

## Infraestrutura Declarada no Projeto

A configuração em [application.yaml](/home/matheus/Documentos/DevProjects/duma/duma-backend/src/main/resources/application.yaml) mostra dependência de:

- PostgreSQL
- MongoDB
- Redis
- RabbitMQ
- Keycloak como emissor JWT

Pelo código lido nesta análise:

- PostgreSQL está em uso ativo
- MongoDB está em uso ativo
- Keycloak/JWT está parcialmente integrado pela configuração de resource server
- Redis e RabbitMQ estão configurados no ambiente, mas não apareceram como fluxos já implementados nos domínios inspecionados

## Decisões Arquiteturais Visíveis

- Organização vertical por domínio em vez de separação global por camada
- Controllers finos
- Services como núcleo da regra de negócio
- Repositories simples, com queries derivadas do Spring Data
- DTOs como contrato explícito da API
- MapStruct para reduzir mapeamento manual
- Persistência híbrida entre relacional e documento

## Limites Atuais Observados

Com base no código inspecionado, alguns pontos merecem atenção:

- não há uma pasta de documentação arquitetural prévia além do `README.md`
- a integridade entre JPA e Mongo depende de validação no service, não de mecanismo transacional unificado
- há configurações de Redis e RabbitMQ, mas sem fluxo funcional evidente nos domínios lidos
- o comentário em `SecurityConfig` indica que a parte de autenticação ainda está em evolução

## Resumo Executivo

O backend `duma` segue uma arquitetura backend clássica em Spring Boot, organizada por domínio e com separação clara entre controller, service, repository, mapper e DTOs. O ponto mais característico da solução é a persistência híbrida:

- dados acadêmicos e relacionais em PostgreSQL
- exercícios em MongoDB

O fluxo principal é previsível e consistente:

```text
HTTP -> Security -> Controller -> Service -> Repository -> Banco -> Mapper -> Response
```

Para onboarding técnico, este é o modelo correto para ler e expandir o projeto hoje.
