package com.theFork.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class Test3_PokeAPI {
    @Test
    public void test() {

        List<String> all_urls = new ArrayList<>();
        List<String> normal_type_urls = new ArrayList<>();


        //Store  API information of "https://pokeapi.co/api/v2/pokemon" url inside response object
        Response response = given().accept(ContentType.JSON).queryParam("limit", 30)
                            .when().get("https://pokeapi.co/api/v2/pokemon");

        //Assert status code if it is successful or not
        Assert.assertEquals(SC_OK, response.getStatusCode());

         //Store response body inside a map object via De-serialization
         //It is used Gson dependency to achieve De-serialization
        Map responseBody = response.body().as(Map.class);

        //Get information of results element in the response body and store it inside a list object
        List<Map<String, String>> results = (List<Map<String, String>>) responseBody.get("results");

        //Get all urls in the result element and store it inside list object
        for (Map<String, String> result : results) {
            all_urls.add(result.get("url"));
        }

        //Send GET request for all urls and store only urls that are normal type or that one of their types is normal type.
        for (String url : all_urls) {
            Response response2 = given().accept(ContentType.JSON)
                                .when().get(url);

            List<String> types = response2.body().path("types");

            for (int i = 0; i < types.size(); i++) {
                if (response2.body().path("types[" + i + "].type.name").equals("normal")) normal_type_urls.add(url);
            }
        }

        //Write urls that are normal type or that one of their types is normal type in the console
        normal_type_urls.forEach(System.out::println);

    }
}
