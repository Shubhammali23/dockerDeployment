Step 1#before adding docker file once use command maven clean install

Step 2#Dockerfile directly created with name Dockerfilein the main project folder

FROM eclipse-temurin:17
LABEL mainterner="malishubham391@gmail.com"
WORKDIR /app
COPY target/spring-boot-data-jpa-0.0.1-SNAPSHOT.jar /app/spring-boot-crud-docker.jar
ENTRYPOINT ["java", "-jar", "spring-boot-crud-docker.jar"]



1.always start with FROM
to write FROM need to go in https://hub.docker.com/
search java copy one of below
amazoncorretto
eclipse-temurin
ibm-semeru-runtimes
ibmjava
sapmachine
then version of jdk: eg. 17
 and follow space and : =

2.copy target/jar name(note not use jar.original)
space /mentioned working directory/name which want to give to that jar

3.ENTRYPOINT space ["lang name", "-jar", "name which we want given above to that jar"

step 3#before creating final jar maintained the name of mysql instead of localhost here we use crud
#application.properties file details
spring.datasource.url= jdbc:mysql://crud:3306/testDB?useSSL=false
spring.datasource.username= root
spring.datasource.password= root

spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto= update
server.port=8081

Step 4 #to create image of our local mysql on docker
docker run --name crud -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=testDB -p 3306:3306 -d mysql:8

docker run --name (name which we want instead of localhost) MYSQL_ROOT_PASSWORD=(local mysql password) MYSQL_DATABASE=(name of schema which we want) -p (port of local):(port need to mentioned on docker) -d mysql:(version)

step 5#maven clean install
jar created
 step 6#open cmd runner on folder where dockerfile is present
D:\JAVA\crud\spring-boot-data-jpa-mysql>docker build -t springbootcrud:springbootcrud .
here . means current directory
step 7#to run jar
docker run --name sprinbootcrudnew-app --link crud:mysql -p 8081:8081 -d springbootcrud:springbootcrud

docker run --name (name which we want on docker for container) --link (name given to mysql):mysql -p (port of local jar):(port of docker where we want to run on docker) -d (name given while building):()

access api on postman using localhost and port 8081 of docker

-------------------------------------------------------------------------------
integrate gemini
https://www.youtube.com/watch?v=rrNRGsJbFZc&t=507s

need to add gemini key in environment variable of intellij idea of the project 
 go in edit configuration by clicking arrow near to run symbol
click on modify option
click on environment variable
paste GOOGLE_API_KEY=AIzaSyAf6zKYsbg29CMez_Kln9AVCZQItdqXa30
then apply and ok