# Reproduction for https://github.com/springdoc/springdoc-openapi/issues/932

To reproduce:

```shell script
git clone git@github.com:Allsimon/springdoc-repro-932.git
cd springdoc-repro-932

mvn spring-boot:run
```

Go to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Make sure that the OpenAPICustomizer has been called: the `GET /foo` endpoint description should contains `REPRO_932`

Then run tests:

```shell script
mvn test
```

The test fetch the `/v3/api-docs/` JSON via MockMvc and check that it contains `REPRO_932`.
