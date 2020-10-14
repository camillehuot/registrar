# Registrar

Meant for a web form to add email/name about someone into a database, then
redirect to another page.

## Configuration

`application.properties` (or alternative Spring Boot format) is expected to
configure access to the Cloudant database.
A sample is provided `src/main/resources/application.properties`.

Destination URLs must be configured via environment variables.

Example:

```shell
export REGISTRAR_SUCCESS_URL=https://my.website.org/success.html
export REGISTRAR_ERROR_URL=https://my.website.org/error.html
```

## Development

### Run registrar in local

```shell
./mvn spring-boot:run
```

### Manual test

```shell
curl -i -X POST http://localhost:8080/register?email=camille@email.org
```

### Test from HTML

Open `test.html` in your browser, enter an email and submit.

## Publish

### Build the jar

```shell
./mvn package
```

### Build container image

```shell
buildah bud -t docker.io/camillehuot/registrar .
```

### Publish container image

```shell
buildah push docker.io/camillehuot/registrar
```
