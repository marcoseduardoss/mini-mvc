## Especialização em Engenharia de Software com DevOps (UECE).

Projeto criado como requisito para disciplina de Desenvolvimento Web com Frameworks.

###### Peojetos 
- **Projeto MiniMVC:** [https://github.com/marcoseduardoss/mini-mvc/tree/master/mini-mvc](https://github.com/marcoseduardoss/mini-mvc/tree/master/mini-mvc)
- **Projeto Demo:** [001-crud-books-mvc-servlets-jstl-jpa](https://github.com/marcoseduardoss/mini-mvc/tree/master/demos/001-crud-books-mvc-servlets-jstl-jpa)

#### Autor
Marcos Eduardo da Silva Santos

#### Informações sobre o projeto

Este Projeto foi implementado utilizando o padrão Model-View-Controller (MVC). 

Foi codificado, também, um pequeno Framework MVC, o MiniMVC ([link](https://github.com/marcoseduardoss/mini-mvc/tree/master/mini-mvc)), o qual foi criado/utilziado como uma PoC par  Padrão MVC desenvolvido em Java/Servlet.  

#### Recursos utilizados
- Java, Tomcat9, Servlet, JSTL, Docker, PostgreSQL 12 e Hibernate/JPA.

#### Procedimentos para execução

###### Baixar o projeto
git clone https://github.com/marcoseduardoss/mini-mvc.git

###### Abrir e istalar o SGBD PostgreSQL 
Na raiz do projeto executar: docker up -d

###### Abrir projeto no Eclipse
Abrir como projeto Maven existente 

###### Compilar o projeto 
mvn install

###### Executar
- Opção 1: copiar o WAR da tasta target do projeto para pasta webapps de um Tomcat e executá-lo
- Opção 2: Pode ser gerado o war Intalar o Tomcat no Eclilse Executar o projeto em Tomcat via Eclipse. Obs.: Clicar com o botão direito sobre o projeto --> "Run as" --> "Run on Eclipse" -> Tomcat 9 --> etc 

Obs.: Caso seja possível, providenciarei a execução completa no Docker, com SGBD e Docker. 

##### URL
- [http://localhost:8085/crudbooks](http://localhost:8085/crudbooks)
 
