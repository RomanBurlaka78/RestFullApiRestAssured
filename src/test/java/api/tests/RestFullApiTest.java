package api.tests;


import api.pojo.DataObjects;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;



public class RestFullApiTest {
    private static final String URL = "https://api.restful-api.dev";
    private static final String ITEM = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";


    @Test
    public void testGetListOfAllObjects() {
        List response = given()
                .when()
                .contentType(ContentType.JSON)
                .log().all()
                .get(URL + "/objects")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().as(List.class);

        response.stream().forEach(System.out::println);

        System.out.println(response.get(1));
        Assert.assertEquals(response.get(1).toString(), "{id=2, name=Apple iPhone 12 Mini, 256GB, Blue, data=null}");
    }


    @Test
    public void testGetSingleObject() {
        DataObjects response = given()
                .when()
                .contentType(ContentType.JSON)
                .log().all()
                .get(URL + "/objects/7")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(DataObjects.class);

        Assert.assertEquals(response.getName(), "Apple MacBook Pro 16");
        Assert.assertEquals(response.getData().toString(), "{year=2019, price=1849.99, CPU model=Intel Core i9, Hard disk size=1 TB}");
    }


    @Test
    public void testGetListById() {
        List objectList = given()
                .when()
                .contentType(ContentType.JSON)
                .log().all()
                .get(URL + "/objects?id=3&id=5&id=10")
                .then().log().all()
                .extract().body().as(List.class);

        Assert.assertEquals(objectList.get(1).toString(),
                "{id=5, name=Samsung Galaxy Z Fold2, data={price=689.99, color=Brown}}");
        System.out.println(objectList.get(0));
        System.out.println(objectList.get(2));
    }


    @Test
    public void testAddObjectWithString() {
        Response post = given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(ITEM)
                .post(URL + "/objects")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        assertThat(post).isNotNull();

    }


    @Test
    public void testAddObjectWithPojo() {
        DataObjects.Data newData = new DataObjects.Data();
        newData.setYear(219);
        newData.setPrice("1849.99");
        newData.setCpuModel("Intel Core i9");
        newData.setHardDiskSize("1 TB");

        DataObjects newObject = new DataObjects();
        newObject.setName("Apple MacBook Pro 16");
        newObject.setData(newData);

        Response post = given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .body(newObject)
                .post(URL + "/objects")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        System.out.println(post.asString());

    }


}
