API de Gerenciamento de Destinos de Viagem  

API RESTful desenvolvida em Java com Spring Boot para cadastro, consulta, avaliação e exclusão de destinos turísticos.  
  
---  
  
Visão Geral  
Sistema voltado para agências de viagens para catalogar destinos turísticos e gerenciar avaliações de usuários. A aplicação roda localmente e armazena os dados temporariamente em memória.  
  
---  
  
Arquitetura em Camadas  
  
src/main/java/com/agencia/viagens/  
 controller/ㅤㅤㅤㅤ·ㅤㅤㅤEntradas HTTP e validações da API  
 dto/ㅤㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤObjetos para transferência de dados  
 service/ㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤRegras de negócio e calculo da média de notas  
 repository/ㅤㅤㅤㅤ·ㅤㅤㅤPersistência temporária em memória (Thread-safe)  
 model/ㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤEntidade principal (Destino)  
  
---  
  
Tecnologias Utilizadas  
    
Java 21: Garante segurança por tipagem forte, padrão de código reconhecido no mercado e alta performance.  
Spring Boot 3: Agiliza o desenvolvimento com servidor embutido (Tomcat) e facilita a organização do código em camadas desacopladas.  
SpringDoc OpenAPI (Swagger UI): Gera documentação automática e permite testar as rotas da API direto no navegador.  
Jakarta Bean Validation: Valida as entradas da API com anotações simples (ex: @NotBlank, @Min, @Max), impedindo dados inválidos.  
  
---  
  
Métodoㅤㅤ·ㅤㅤEndpointㅤㅤ·ㅤㅤDescrição  
  
POSTㅤㅤㅤㅤ·ㅤㅤㅤ/api/destinosㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤCadastra um novo destino.  
GETㅤㅤㅤㅤ·     /api/destinosㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤLista todos os destinos.  
GETㅤㅤㅤㅤ·     /api/destinos/{id}ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤBusca destino por ID.  
GETㅤㅤㅤㅤ·     /api/destinos/pesquisa?termo=...ㅤㅤㅤ·ㅤㅤㅤPesquisa por nome ou localização  
POSTㅤㅤㅤ·     /api/destinos/{id}/avaliarㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤAdiciona nota (1 a 10) e recalcula a média  
DELETEㅤㅤ·     /api/destinos/{id}ㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤㅤ·ㅤㅤㅤRemove um destino  
  
---  
  
Como Executar o Projeto  
  
Pré-requisitos: Java JDK 17+ instalado.  
Baixar o repositório:Bashgit clone (https://github.com/Kalangoo/ViagensAPI)  
cd agencia-viagens-api  
Executar via terminal (Windows):PowerShell.\mvnw.cmd spring-boot:run  
(Ou abra a classe AgenciaViagensApplication.java no VS Code e clique em Run).  
  
