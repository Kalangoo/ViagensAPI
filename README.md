🚀 API Agência de Viagens (Desafio 2)

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de destinos turísticos e avaliações, contando com persistência relacional em PostgreSQL via Spring Data JPA e controle de acesso com Spring Security.

🛠️ Requisitos do Sistema

Java Development Kit (JDK): Versão 21

Build Tool: Maven 3.8+ (ou Maven Wrapper ./mvnw)

Banco de Dados: PostgreSQL 15+

IDE Recomendada: VS Code ou IntelliJ IDEA

🗄️ Estrutura do Banco de Dados

O schema do banco é gerado automaticamente pelo Hibernate (spring.jpa.hibernate.ddl-auto=update) na base relacional viagens_db.

tb_destino: Armazena os destinos turísticos (id, nome, localizacao, descricao, preco).

tb_avaliacao: Armazena as avaliações dos destinos (id, nota, comentario, destino_id).

tb_usuario: Usuários cadastrados no sistema (id, username, password, ativo).

tb_perfil: Perfis/Roles do sistema (id, nome — ex: ROLE_ADMIN, ROLE_USER).

tb_usuario_perfil: Tabela associativa (N:N) entre Usuários e Perfis.

⚙️ Configuração do Ambiente

Certifique-se de que o PostgreSQL esteja rodando na porta padrão 5432.

Crie o banco de dados via DBeaver, pgAdmin ou terminal SQL:
CREATE DATABASE viagens_db;

Ajuste as credenciais em src/main/resources/application.properties:
spring.application.name=agencia-viagens-api

Conexão PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/viagens_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
spring.datasource.driver-class-name=org.postgresql.Driver

JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

🔐 Autenticação e Perfis de Teste

A API utiliza autenticação HTTP Basic.

Usuário: admin
Senha: admin123
Perfil / Role: ROLE_ADMIN
Permissões: Acesso total (Listar, Buscar, Cadastrar, Atualizar, Deletar)

Usuário: user
Senha: user123
Perfil / Role: ROLE_USER
Permissões: Leitura e Avaliação (Listar, Buscar, Cadastrar Avaliação)

📌 Endpoints e Regras de Acesso

GET /api/destinos -> Listar todos os destinos -> Público / Usuário Autenticado

GET /api/destinos/{id} -> Buscar destino por ID -> Público / Usuário Autenticado

POST /api/destinos -> Cadastrar novo destino -> Autenticado (ROLE_ADMIN)

PUT /api/destinos/{id} -> Atualizar destino existente -> Autenticado (ROLE_ADMIN)

DELETE /api/destinos/{id} -> Remover um destino -> Autenticado (ROLE_ADMIN)

POST /api/destinos/{id}/avaliar -> Cadastrar avaliação para destino -> Autenticado (ROLE_USER / ROLE_ADMIN)

💻 Como Executar o Projeto

Clone o repositório:
git clone https://github.com/Kalangoo/ViagensAPI.git
cd ViagensAPI

Execute a aplicação via terminal:
./mvnw spring-boot:run
(Ou execute a classe principal AgenciaViagensApplication.java diretamente na sua IDE).

Acesse a documentação Swagger UI no navegador:
http://localhost:8080/swagger-ui.html

🧪 Exemplo de Requisição (PowerShell)

Para realizar o cadastro de um novo destino como administrador:

invoke-restmethod -uri "http://localhost:8080/api/destinos" -method Post -headers @{ Authorization = "Basic " + [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes("admin:admin123")) } -body '{"nome":"Fernando de Noronha","localizacao":"Pernambuco, Brasil","descricao":"Arquipelago paradisiaco com praias preservadas.","preco":3500.0}' -contenttype "application/json; charset=utf-8"
