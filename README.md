# Place Tecnologia e Inovação
### Desafio Webservice API
Back-end feito em Java com os métodos **GET, PUT, POST e DELETE**

### **Ferramentas utilizadas**
![](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) ![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot) ![](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

![](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white) ![](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) ![](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

* Após clonar o repositório, baixar todas as dependências e iniciar o servidor, podemos utilizar a ferramenta Postman para realizar as requisições, primeiro realizamos a requisição `POST` na rota `http://localhost:8080/cursos/` com o seguite Body.
  
```json
{
    "nome": "Curso de Programação",
    "quantidadeAlunos": 20,
    "nivelCurso": "Intermediário"
}
```

* Em seguida realizamos a requisição `POST` na rota `http://localhost:8080/turmas/` com o seguite Body.
  
```json
{
    "codigo": "T003",
    "nome": "Turma de Programação Avançada",
    "curso": {
        "id": 1 // <-- o ID deve ser o mesmo valor do ID do curso, você pode realizar um método GET na rota http://localhost:8080/cursos/ para ver o ID antes de fazer uma requisição na rota /turmas/
    }
}
```

* Podemos realizar a requisição `GET` na rota `http://localhost:8080/cursos/` que retornará o seguinte resultado. **Lembre-se de seguir o passo a passo**.
  
```json
response
[
    {
        "id": 1,
        "nome": "Programação",
        "quantidadeAlunos": 25,
        "nivelCurso": "Básico",
        "turmas": [
            {
                "id": 1,
                "codigo": "T001",
                "nome": "Turma de Programação Básica"
            }
        ]
    }
]
```

* Outros métodos como `PUT` na rota `http://localhost:8080/cursos/{id}` aceita o seguinte Body com os campos.
  
```json
{
    "nome": "Programação",
    "quantidadeAlunos": 25,
    "nivelCurso": "Básico"
}
```

* Podemos obter o resultado das turmas **APÓS** criar um curso com o método `GET` na rota `http://localhost:8080/turmas/` ou `http://localhost:8080/turmas/{id}` para retornar uma turma específica.
  
```json
response
[
    {
        "id": 1,
        "codigo": "T003",
        "nome": "Turma de Programação Avançada",
        "curso": {
            "id": 1,
            "nome": "Programação",
            "quantidadeAlunos": 25,
            "nivelCurso": "Básico"
        }
    }
]
```

* O método `PUT` na rota `http://localhost:8080/turmas/{id}` aceita o seguinte Body com os campos para atualizar uma turma específica.
  
```json
{
    "codigo": "T001",
    "nome": "Turma de Programação Básica"
}
```

* Podemos deletar um curso ou uma turma específica pedo ID com o método `DELETE` nas rotas `http://localhost:8080/turmas/{id}` `http://localhost:8080/cursos/{id}` devemos utilizar o Postman para realizar as requisições.
  
```json
response
{
  
}
```

### Utilizei o JPA para relacionar as entidades e o MySQL para o banco de dados, juntamente ao Container Docker.

`resources/aplication.yml`
```yml
server:
  error:
    include-stacktrace: on_param

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/place_ti_mysql?useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
```

`docker-compose.yml`
```yml
version: '3.1'
services:
  db:
    image: mysql
    container_name: place_ti_mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    volumes:
      - place_ti_data:/var/lib/mysql

volumes:
  place_ti_data:
```

# **Contato**
<div align="center">
   <a href="https://www.linkedin.com/in/yago-ferreira-530a46237/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
   <a href="https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox" target="_blank"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"></a>
   <a href="https://wa.me/5561981843371" target="_blank"><img src="https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white"></a>
</div>
