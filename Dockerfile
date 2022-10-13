FROM eclipse-temurin:17
WORKDIR app
COPY target/*.jar vizsgafeladat.jar
ENTRYPOINT ["java","-jar","vizsgafeladat.jar"]