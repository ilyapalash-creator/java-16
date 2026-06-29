import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestSchema {
    @Test
    void shouldValidateAccountsSchema() {
        given()
                .baseUri("http://localhost:9999") 
                .when()
                .get("/api/accounts")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
