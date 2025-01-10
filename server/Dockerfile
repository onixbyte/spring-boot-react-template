FROM amazoncorretto:21-alpine as builder
WORKDIR /app
ARG APP_VERSION=1.0.0
COPY . .
RUN ./gradlew build -PartefactVersion=${APP_VERSION} -x test

FROM amazoncorretto:21-alpine as runner
WORKDIR /app
COPY --from=builder /app/build/libs/artefact-${APP_VERSION}.jar app.jar
ENV TZ Asia/Hong_Kong
ENV ACTIVE_PROFILES ""
ENTRYPOINT ["/bin/sh", "-c", "java -jar -Dspring.profiles.active=${ACTIVE_PROFILES} app.jar"]