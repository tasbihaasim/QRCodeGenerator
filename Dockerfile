FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle :app:installDist --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/app/build/install/app .
EXPOSE 8080
CMD ["bin/app"]