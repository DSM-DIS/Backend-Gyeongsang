FROM openjdk:11-jre-slim
COPY ./build/libs/*.jar gyeongsang.jar
ENTRYPOINT ["java", "-Xmx200m", "-jar", "/gyeongsang.jar"]