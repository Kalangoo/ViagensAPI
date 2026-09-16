🚀 Documentação Técnica - API Agência de Viagens (Desafio 2)API RESTful desenvolvida em Java com Spring Boot para gerenciamento de destinos turísticos e avaliações, com persistência relacional em PostgreSQL via Spring Data JPA e controle de acesso robusto com Spring Security (HTTP Basic).🛠️ Requisitos do SistemaJava Development Kit (JDK): Versão 21Build Tool: Maven 3.8+ (ou o Maven Wrapper do projeto)Banco de Dados: PostgreSQL 15+IDE Recomendada: VS Code ou IntelliJ IDEA🗄️ Estrutura do Banco de DadosO schema do banco é gerado automaticamente pelo Hibernate (spring.jpa.hibernate.ddl-auto=update) no banco relacional viagens_db.Tabelas Principais:tb_destino: Armazena os destinos turísticos (id, nome, localizacao, descricao, preco).tb_avaliacao: Armazena as avaliações dos destinos (id, nota, comentario, destino_id).tb_usuario: Usuários cadastrados no sistema (id, username, password, ativo).tb_perfil: Perfis/Roles do sistema (id, nome - e.g., ROLE_ADMIN, ROLE_USER).tb_usuario_perfil: Tabela associativa de relacionamento N:N entre Usuários e Perfis.⚙️ Configuração do Ambiente e Banco de DadosInstalar/Iniciar o PostgreSQL na porta padrão 5432.Criar o Banco de Dados via DBeaver, pgAdmin ou terminal SQL:SQLCREATE DATABASE viagens_db;
Configurar as credenciais em src/main/resources/application.properties:Propertiesspring.application.name=agencia-viagens-api

# Conexão PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/viagens_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
spring.datasource.driver-class-name=org.postgresql.driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
🔐 Autenticação, Autorização e Usuários de TesteA API utiliza autenticação HTTP Basic.Credenciais Padrão para Testes:UsuárioSenhaPerfil / RolePermissõesadminadmin123ROLE_ADMINAcesso total (Listar, Buscar, Cadastrar, Atualizar, Deletar)useruser123ROLE_USERLeitura e Avaliação (Listar, Buscar, Cadastrar Avaliação)📌 Principais Endpoints e Regras de AcessoMétodoEndpointDescriçãoAcesso RequeridoGET/api/destinosListar todos os destinosPúblico / Usuário AutenticadoGET/api/destinos/{id}Buscar destino por IDPúblico / Usuário AutenticadoPOST/api/destinosCadastrar novo destinoAutenticado (ROLE_ADMIN)PUT/api/destinos/{id}Atualizar destino existenteAutenticado (ROLE_ADMIN)DELETE/api/destinos/{id}Remover um destinoAutenticado (ROLE_ADMIN)POST/api/destinos/{id}/avaliarCadastrar avaliação para destinoAutenticado (ROLE_USER / ADMIN)💻 Como Executar o ProjetoClone o repositório Git:Bashgit clone <URL_DO_SEU_REPOSITORIO>
cd ViagensAPI
Compile e rode a aplicação via terminal:PowerShell./mvnw spring-boot:run
(Ou execute diretamente o método main da classe AgenciaViagensApplication.java na sua IDE).Acesse a documentação interativa Swagger UI:Plaintexthttp://localhost:8080/swagger-ui.html
🧪 Exemplo de Requisição (PowerShell)Cadastrar Destino (Autenticado como Admin)PowerShellinvoke-restmethod -uri "http://localhost:8080/api/destinos" `
  -method Post `
  -headers @{ Authorization = "Basic " + [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes("admin:admin123")) } `
  -body '{"nome":"Fernando de Noronha","localizacao":"Pernambuco, Brasil","descricao":"Arquipelago paradisiaco com praias preservadas.","preco":3500.0}' `
  -contenttype "application/json; charset=utf-8"
