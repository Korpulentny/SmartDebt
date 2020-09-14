
FROM adoptopenjdk/maven-openjdk11

WORKDIR /debts

COPY src/ src
COPY pom.xml pom.xml

RUN mvn clean install

ENTRYPOINT ["mvn", "spring-boot:run"]