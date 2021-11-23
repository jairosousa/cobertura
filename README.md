# Cobertuta

docker run --name sonar -p 9000:9000 sonarqube:community

mvn clean verify sonar:sonar -Dsonar.projectKey=cobertura -Dsonar.host.url=http://localhost:9000 -Dsonar.login=66c7d992b9aa7a67cf14ed5bbb82061116767711

senha administrador do sonar: docker

# Tecnologias

* Jacoco

* SonarQube

* Mapstruct

* Hateoas

* H2