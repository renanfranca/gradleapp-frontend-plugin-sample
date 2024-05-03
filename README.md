# Chips Project

## Prerequisites

### Node.js and NPM

Before you can build this project, you must install and configure the following dependencies on your machine:

[Node.js](https://nodejs.org/): We use Node to run a development web server and build the project.
Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

```
npm install
```

## Local environment

- [Local server](http://localhost:8081)
- [Local API doc](http://localhost:8081/swagger-ui.html)

<!-- jhipster-needle-localEnvironment -->

## Start up

```bash
docker compose -f src/main/docker/sonar.yml up -d
```

```bash
./gradlew clean build sonar --info
```

```bash
docker compose -f src/main/docker/postgresql.yml up -d
```


<!-- jhipster-needle-startupCommand -->

## Documentation

- [sonar](documentation/sonar.md)
- [Package types](documentation/package-types.md)
- [Assertions](documentation/assertions.md)
- [Property Based Testing](documentation/property-based-testing.md)
- [Logs Spy](documentation/logs-spy.md)
- [CORS configuration](documentation/cors-configuration.md)
- [Postgresql](documentation/postgresql.md)
- [JWT basic auth](documentation/jwt-basic-auth.md)
- [Cucumber](documentation/cucumber.md)
- [Cucumber authentication](documentation/cucumber-authentication.md)

<!-- jhipster-needle-documentation -->
