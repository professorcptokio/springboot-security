# Spring Boot Security

> Projeto de exemplo utilizando Spring Boot com autenticação e segurança.

## Pré-requisitos

- **Java SDK 24 (OpenJDK)**
- **Docker**
- **Maven** (opcional, pois o projeto já possui o wrapper `mvnw`)
- **Extensão [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-spring-boot) da VMware** (VS Code)

## Instalação e Configuração

1. **Instale o Java SDK 24 (OpenJDK):**
	```bash
	sudo apt update && sudo apt install openjdk-24-jdk
	```
	Ou utilize o gerenciador de pacotes da sua distribuição.

2. **Clone o repositório:**
	```bash
	git clone <url-do-repositorio>
	cd springboot-security
	```

3. **Suba o banco de dados com Docker:**
	```bash
	docker-compose up -d
	```

4. **(Opcional) Instale a extensão Spring Boot Extension Pack na sua IDE (VS Code):**
	- Busque por `Spring Boot Extension Pack` no marketplace do VS Code e instale.


## Executando o Projeto

### 1. Via terminal
```bash
cd mysecurity
./mvnw spring-boot:run
```
Ou utilize o atalho da sua IDE para rodar a aplicação.

### 2. Pela extensão do VS Code

Se você instalou o Spring Boot Extension Pack:

1. Abra a pasta `mysecurity` no VS Code.
2. No menu lateral, clique no ícone do Spring Boot Dashboard (uma folha verde).
3. Localize o projeto na lista e clique no botão de "play" (▶️) ao lado do nome do projeto para iniciar a aplicação.
4. O console de saída mostrará os logs do Spring Boot.

### 3. Acesse a aplicação
- Normalmente disponível em: [http://localhost:8080](http://localhost:8080)

#### Usando o GitHub Codespaces

Se estiver utilizando o Codespaces, acesse a aplicação pela aba **Ports** do ambiente. Clique no endereço disponível referente à porta `8080` para abrir a aplicação diretamente no navegador.

## Observações

- Certifique-se de que o banco de dados está rodando antes de iniciar a aplicação.
- Ajuste as configurações em `mysecurity/src/main/resources/application.properties` conforme necessário.

---

Desenvolvido para fins educacionais.


