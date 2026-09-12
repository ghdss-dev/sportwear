# Sportwear

Sistema de Artigos Esportivos.

## 📋 Sobre o projeto

O **Sportwear** é um sistema voltado para a gestão/comercialização de artigos esportivos, desenvolvido por [ghdss-dev](https://github.com/ghdss-dev).

> ⚠️ **Nota:** este README foi gerado a partir das informações públicas do repositório (nome, descrição e estrutura de pastas). Como o conteúdo interno da pasta `back-end` não pôde ser inspecionado automaticamente, algumas seções (stack, endpoints, instruções de execução) estão como modelo — ajuste-as de acordo com o que realmente está implementado.

## 🚀 Tecnologias utilizadas

*(confirme/ajuste conforme o projeto real)*

- Java
- Spring Boot
- Maven
- Lombok
- Spring Boot Starter Web
- Banco de dados: MySQL / PostgreSQL / SQLite *(indicar qual)*

## 📁 Estrutura do projeto

```
sportwear/
└── back-end/
    ├── src/
    ├── pom.xml
    └── ...
```

## ✅ Funcionalidades

- [ ] Cadastro de artigos esportivos
- [ ] Listagem e busca de produtos
- [ ] Atualização e remoção de itens
- [ ] Controle de estoque
- [ ] Autenticação de usuários

*(marque/edite conforme as funcionalidades realmente implementadas)*

## 🔧 Pré-requisitos

- Java 17+ (ou a versão utilizada no projeto)
- Maven 3.8+
- Banco de dados configurado (indicar qual)

## ▶️ Como executar

```bash
# Clone o repositório
git clone https://github.com/ghdss-dev/sportwear.git

# Acesse a pasta do back-end
cd sportwear/back-end

# Rode o projeto com Maven
mvn spring-boot:run
```

A aplicação ficará disponível em `http://localhost:8080` (ajuste a porta se for diferente).

## 📡 Endpoints principais

| Método | Rota              | Descrição                  |
|--------|-------------------|-----------------------------|
| GET    | /produtos         | Lista todos os artigos      |
| GET    | /produtos/{id}    | Busca um artigo por ID      |
| POST   | /produtos         | Cadastra um novo artigo     |
| PUT    | /produtos/{id}    | Atualiza um artigo          |
| DELETE | /produtos/{id}    | Remove um artigo            |

*(atualize com as rotas reais do projeto)*

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Faça commit das alterações (`git commit -m 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença que você definir (ex: MIT). Adicione um arquivo `LICENSE` ao repositório.

## 👤 Autor

**Gustavo (ghdss-dev)**
- GitHub: [@ghdss-dev](https://github.com/ghdss-dev)
