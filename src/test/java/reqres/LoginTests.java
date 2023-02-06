package reqres;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTests  {
    AuthDataObject reqData = new AuthDataObject();

    @Test
    @DisplayName("Authorization with valid credentials")
    void loginWithValidCreds() {
        given()
                .log().uri()
                .contentType(JSON)
                .body(reqData.authData)
                .when()
                .post(reqData.authUrl)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is(notNullValue()));
    }

    @Test
    @DisplayName("Authorization without password -  invalid credentials")
    void loginWithoutPassword() {
        given()
                .log().uri()
                .contentType(JSON)
                .body(reqData.authDataWithoutPassword)
                .when()
                .post(reqData.authUrl)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

}
