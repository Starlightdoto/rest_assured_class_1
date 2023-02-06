package reqres;

public class UserDataObject {
    private final String userData = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
    final String createUserUrl = "https://reqres.in/api/users";
    final String updateUserUrl = "https://reqres.in/api/users/2";
    final String deleteUserUrl = "https://reqres.in/api/users/2";
    final String listAllUsersUrl = "https://reqres.in/api/users?page=2";

    public String getUserData() {
        return userData;
    }
}
