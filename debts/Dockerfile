
FROM adoptopenjdk/maven-openjdk11

WORKDIR /debts

COPY src/ src
COPY pom.xml pom.xml

RUN ["mvn", "clean"]
RUN ["mvn", "install", "-Dmaven.test.skip=true"]

ENTRYPOINT ["mvn", "spring-boot:run"]