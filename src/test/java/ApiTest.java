import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTest {
    String token;

    @Test()
    public void testLogin() {
        System.out.println("Executing login test");
        // Add your login test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";

        String requestBody = "{\n" +
                "  \"email\": \"albertsimanjuntak12@gmail.com\",\n" +
                "  \"password\": \"@dmin123\"\n" +
                "}"; 
        // Send a POST request to the login endpoint
        Response response = RestAssured.given()
                // .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post("webhook/api/login");
                // System.out.println("Response: " + response.asString());
                token = response.jsonPath().getString("token");
                System.out.println("Token: " + token);
                
    }
    @Test(dependsOnMethods = "testLogin")
    public void testGetAllProduct() {
        System.out.println("Executing get all product test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get("/webhook/api/objects");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 2)
    public void testGetListOfObjectByIds(){
        System.out.println("Executing get list of object by ids test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get("webhook/api/objectslistId?id=104");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 3)
    public void testGetSingleObject(){
        System.out.println("Executing get single object test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get("webhook/8749129e-f5f7-4ae6-9b03-93be7252443c/api/objects/41");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 4)
    public void testPostAddObject(){
        System.out.println("Executing post add object test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        String requestBody = "{\n" +
                "  \"name\": \"Apple MacBook Pro 16\",\n" +
                "  \"data\": {\n" +
                "    \"year\": 2019,\n" +
                "    \"price\": 1849.99,\n" +
                "    \"cpu_model\": \"Intel Core i9\",\n" +
                "    \"hard_disk_size\": \"1 TB\",\n" +
                "    \"capacity\": \"2 cpu\",\n" +
                "    \"screen_size\": \"14 Inch\",\n" +
                "    \"color\": \"red\"\n" +
                "  }\n" +
                "}";
        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .log().all()
                .when()
                .post("/webhook/api/objects");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 5)
    public void testPutUpdateObject(){
        System.out.println("Executing put update object test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        String requestBody = "{\n" +
                "  \"name\": \"Apple MacBook Pro 16\",\n" +
                "  \"data\": {\n" +
                "    \"year\": 2019,\n" +
                "    \"price\": 1849.99,\n" +
                "    \"cpu_model\": \"Intel Core i9\",\n" +
                "    \"hard_disk_size\": \"1 TB\",\n" +
                "    \"capacity\": \"2 cpu\",\n" +
                "    \"screen_size\": \"14 Inch\",\n" +
                "    \"color\": \"red\"\n" +
                "  }\n" +
                "}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .log().all()
                .when()
                .put("/webhook/37777abe-a5ef-4570-a383-c99b5f5f7906/api/objects/151");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 6)
    public void testDeleteObject(){
        System.out.println("Executing delete object test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .delete("/webhook/d79a30ed-1066-48b6-83f5-556120afc46f/api/objects/152");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 7)
    public void testGetAllDepartment(){
        System.out.println("Executing get all department test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get("/webhook/api/department");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
    @Test(dependsOnMethods = "testLogin", priority = 8)
    public void testPatchPartiallyUpdatedObject(){
        System.out.println("Executing patch partially update object test");
        // Add your get user test code here
        RestAssured.baseURI = "https://whitesmokehouse.com";
        String requestBody = "{\n" +
                "  \"name\": \"Apple MacBook Pro 1611-albert12\",\n" +
                "  \"year\": \"2030\"\n" +
                "}";
        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .log().all()
                .when()
                .patch("/webhook/39a0f904-b0f2-4428-80a3-391cea5d7d04/api/object/153");
        System.out.println("Response: " + response.asString());

        assert response.getStatusCode() == 200 : "Expected status code 200, but got " + response.getStatusCode();
    }
}
