# syntax=docker/dockerfile:experimental
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

COPY ./gradlew /workspace/app
COPY ./gradle /workspace/app/gradle
COPY ./settings.gradle.kts /workspace/app/settings.gradle.kts
COPY ./buildSrc /workspace/app/buildSrc
COPY ./ms-products /workspace/app/ms-products
RUN --mount=type=cache,target=/root/.gradle /workspace/app/gradlew clean build -x test
RUN mkdir -p build/dependency
RUN cd build/dependency; jar -xf /workspace/app/ms-products/infrastructure/build/libs/*-SNAPSHOT.jar
EXPOSE 8080
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","jva.cloud.MsProductsApplicationKt"]