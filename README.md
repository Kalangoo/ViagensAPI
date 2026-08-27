API de Gerenciamento de Destinos de Viagem

API RESTful desenvolvida em Java com Spring Boot para cadastro, consulta, avaliação e exclusão de destinos turísticos.

---

Visão Geral
Sistema voltado para agências de viagens para catalogar destinos turísticos e gerenciar avaliações de usuários. A aplicação roda localmente e armazena os dados temporariamente em memória.

---

Arquitetura em Camadas

src/main/java/com/agencia/viagens/
 controller/   # Entradas HTTP e validações da API
 dto/          # Objetos para transferência de dados
 service/      # Regras de negócio e calculo da média de notas
 repository/   # Persistência temporária em memória (Thread-safe)
 model/        # Entidade principal (Destino)

---

Tecnologias Utilizadas

Justificativa Técnica (Resumida)
Java 21: Garante segurança por tipagem forte, padrão de código reconhecido no mercado e alta performance.
Spring Boot 3: Agiliza o desenvolvimento com servidor embutido (Tomcat) e facilita a organização do código em camadas desacopladas.
SpringDoc OpenAPI (Swagger UI): Gera documentação automática e permite testar as rotas da API direto no navegador.
Jakarta Bean Validation: Valida as entradas da API com anotações simples (ex: @NotBlank, @Min, @Max), impedindo dados inválidos.

---

Método,Endpoint,Descrição
POST,/api/destinos,Cadastra um novo destino
GET,/api/destinos,Lista todos os destinos
GET,/api/destinos/{id},Busca destino por ID
GET,/api/destinos/pesquisa?termo=...,Pesquisa por nome ou localização
POST,/api/destinos/{id}/avaliar,Adiciona nota (1 a 10) e recalcula a média
DELETE,/api/destinos/{id},Remove um destino

---

Como Executar o Projeto

Pré-requisitos: Java JDK 17+ instalado.
Baixar o repositório:Bashgit clone [https://github.com/seu-usuario/agencia-viagens-api.git](https://github.com/seu-usuario/agencia-viagens-api.git)
cd agencia-viagens-api
Executar via terminal (Windows):PowerShell.\mvnw.cmd spring-boot:run
(Ou abra a classe AgenciaViagensApplication.java no VS Code e clique em Run).
