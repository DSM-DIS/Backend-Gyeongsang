FROM openjdk:11-jre-slim
COPY ./build/libs/*.jar gyeongsang.jar
ENTRYPOINT ["java", "-Xmx100m", "-jar", "/gyeongsang.jar"]
