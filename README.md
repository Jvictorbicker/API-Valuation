#📊 Stock Valuation API

API REST desenvolvida com Spring Boot para calcular o valuation de ações da B3 utilizando dados da Brapi API.

A aplicação busca os dados da ação, calcula o preço justo baseado no valor patrimonial (P/VP) e retorna se a ação está barata ou cara.

🚀 Tecnologias Utilizadas

Java

Spring Boot

Spring Web

Jackson (JSON)

Maven

Brapi API

📁 Estrutura do Projeto
src/main/java/com/example/demo

Controller
 └── ApiController.java

Model
 └── ValuationResponse.java

Service
 ├── ApiCall.java
 ├── Valuation.java
 └── ValuationService.java

DemoApplication.java
Controller

Responsável por receber as requisições HTTP.

Service

Contém a lógica de negócio e integração com API externa.

Model

Define o formato de resposta da API.

📡 Endpoint da API
Calcular valuation de uma ação
GET /api/valuation/{ticker}
Exemplo de requisição
http://localhost:8080/api/valuation/PETR4
📥 Exemplo de Resposta
{
  "ticker": "PETR4",
  "currentPrice": 40.5,
  "bookValuePerShare": 32.97151,
  "fairPrice": 32.97151,
  "cheap": false
}
Significado dos campos
Campo	Descrição
ticker	Código da ação
currentPrice	Preço atual da ação
bookValuePerShare	Valor patrimonial por ação
fairPrice	Preço justo calculado
cheap	Indica se a ação está barata
📊 Fórmula de Valuation

O cálculo utilizado atualmente é baseado no P/VP (Preço / Valor Patrimonial).

Preço Justo = Valor Patrimonial × P/VP Justo

No projeto:

P/VP Justo = 1

Portanto:

Fair Price = Book Value

Se:

Preço atual < Preço justo

A ação é considerada barata.

🔗 Fonte dos Dados

Os dados financeiros são obtidos da API:

https://brapi.dev

Informações utilizadas:

Preço atual da ação

Valor patrimonial por ação

Estatísticas financeiras

⚙️ Como Executar o Projeto
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git
2️⃣ Entrar na pasta do projeto
cd seu-repositorio
3️⃣ Executar a aplicação

Com Maven:

mvn spring-boot:run

Ou executando a classe:

DemoApplication.java
🧪 Testando a API

Após iniciar o projeto, abra no navegador ou Postman:

http://localhost:8080/api/valuation/PETR4

📄 Licença

Projeto open-source para fins educacionais.
