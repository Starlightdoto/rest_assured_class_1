package reqres;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class UserTests {
    AuthDataObject reqData = new AuthDataObject();
    UserDataObject userData = new UserDataObject();

    @Test
    @DisplayName("Create a new user")
    void createUser() {
        given()
                .log().uri()
                .contentType(JSON)
                .body(userData.getUserData())
                .when()
                .post(userData.createUserUrl)
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("id", is(notNullValue()));
    }

    @Test
    @DisplayName("Update user data")
    void updateUser() {
        given()
                .log().uri()
                .contentType(JSON)
                .body(userData.getUserData())
                .when()
                .put(userData.updateUserUrl)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("updatedAt", is(notNullValue()));

    }

    @Test
    @DisplayName("Delete user")
    void deleteUser() {
        given()
                .log().uri()
                .when()
                .delete(userData.updateUserUrl)
                .then()
                .log().status()
                .statusCode(204);
    }

    @Test
    @DisplayName("List all users")
    void listAllUsers() {
        given()
                .log().uri()
                .when()
                .get(userData.listAllUsersUrl)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data", is(notNullValue()));
    }

}
