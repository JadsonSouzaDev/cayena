# Cayena - Microserviços

Este repositório contém os microserviços da Cayena, incluindo o serviço de Orders e autenticação com Keycloak.

## 🚀 Tecnologias

- Java 17
- Spring Boot
- MySQL
- Keycloak
- Docker
- Docker Compose

## 📋 Pré-requisitos

- Docker
- Docker Compose
- Git

## 🔧 Configuração e Instalação

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/cayena.git
cd cayena
```

2. Inicie os serviços com Docker Compose:
```bash
docker-compose up -d
```

Este comando irá:
- Construir e iniciar o microserviço Order
- Iniciar o banco de dados MySQL para Orders
- Iniciar o Keycloak para autenticação
- Iniciar o banco de dados MySQL para o Keycloak

## 📦 Serviços Disponíveis

### Order Service
- **URL**: http://localhost:8080
- **Endpoints**:
  - `POST /v1/orders`: Criar um novo pedido
  - `GET /v1/orders`: Listar todos os pedidos
  - `GET /v1/orders/{id}`: Buscar pedido por ID

### Keycloak
- **Admin Console**: http://localhost:8180
- **Credenciais Admin**:
  - Username: admin
  - Password: admin
- **Realm**: cayena
- **URL do Realm**: http://localhost:8180/realms/cayena

## 🔍 Portas Utilizadas

- 8080: Order Service
- 8180: Keycloak
- 3306: MySQL (Orders)
- 3307: MySQL (Keycloak)

## 🛠️ Comandos Úteis

### Gerenciamento dos Containers
```bash
# Parar todos os serviços
docker-compose down

# Parar e remover volumes
docker-compose down -v

# Ver logs de todos os serviços
docker-compose logs -f

# Ver logs de um serviço específico
docker-compose logs -f order-app
docker-compose logs -f keycloak
```

### Verificação de Status
```bash
# Listar todos os containers em execução
docker-compose ps
```

## 🔒 Configuração do Keycloak

Após iniciar os serviços, você precisará:

1. Acessar o Keycloak Admin Console (http://localhost:8180)
2. Fazer login com admin/admin
3. Criar um novo Realm chamado "cayena" (se não existir)
4. Configurar os clients e usuários conforme necessário

## ❗ Solução de Problemas

### Problema com Portas em Uso
Se alguma porta estiver em uso, você pode:
1. Parar o serviço que está usando a porta
2. Ou modificar as portas no arquivo `docker-compose.yml`

### Keycloak não Inicia
Verifique se:
1. O banco de dados do Keycloak está acessível
2. As credenciais do banco estão corretas
3. Os logs do container para mais detalhes: `docker-compose logs keycloak`

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).
