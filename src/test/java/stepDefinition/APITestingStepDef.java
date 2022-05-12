package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class APITestingStepDef {
    RequestSpecification request;
    JSONObject requestParams = new JSONObject();
    Response response;

    public APITestingStepDef() {
    }

    @Given("I set POST registration service API endpoint")
    public void i_set_post_registration_service_api_endpoint() throws Exception {
        try {
            RestAssured.baseURI = "https://vmos2.vmos-demo.com/user/v1/user";
            request = RestAssured.given();
        } catch (Exception var2) {
            throw new Exception(var2);
        }
    }

    @When("I set request headers")
    public void i_set_request_headers() throws Exception {
        try {
            request.header("authority", "vmos2.vmos-demo.com");
            request.header("accept", "application/json, text/plain, */*");
            request.header("accept-language", "en-US,en;q=0.9");
            request.header("content-type", "application/json");
            request.header("origin", "https://fego.vmos-demo.com");
            request.header("referer", "https://fego.vmos-demo.com/");
            request.header("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"101\", \"Google Chrome\";v=\"101\"");
            request.header("tenant","695a1486-80e7-4ee6abc55-f4911944ef2a");
            request.header("sec-ch-ua-mobile","?0");
            request.header("sec-ch-ua-platform","Windows");
            request.header("sec-fetch-dest","empty");
            request.header("sec-fetch-mode","cors");
            request.header("sec-fetch-site","same-site");
            request.header("user-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36");
            request.header("x-requested-from","online");
        } catch (Exception var2) {
            throw new Exception(var2);
        }
    }

    @When("Send a POST request with user registration details")
    public void send_a_post_request_with_user_registration_details() throws Exception {
        try {
            requestParams.put("firstName", "Pritam");
            requestParams.put("email", "pritam.chibde5@gmail.com");
            requestParams.put("phone","+91 96378 93329");
            requestParams.put("password", "Tester12345");
            request.body(requestParams.toJSONString());
        } catch (Exception var2) {
            throw new Exception(var2);
        }
    }

    @When("Send a POST request with login details")
    public void send_a_post_request_with_login_details() throws Exception {
        try {
            requestParams.put("email", "pritam.chibde@gmail.com");
            requestParams.put("password", "tester12345");
            request.body(requestParams.toJSONString());
            response = request.post("");
        } catch (Exception var2) {
            throw new Exception(var2);
        }
    }

    @Given("I set POST Login service API endpoint")
    public void iSetPOSTLoginServiceAPIEndpoint() throws Exception {
        try {
            RestAssured.baseURI = "https://vmos2.vmos-demo.com/user/v1/auth";
            request = RestAssured.given();
        } catch (Exception var2) {
            throw new Exception(var2);
        }
    }

    @Then("I status code {int} should be received")
    public void iStatusCodeShouldBeReceived(int code) throws Exception {
        try {
            ResponseBody body = response.getBody();
            System.out.println(response.getStatusLine());
            System.out.println(response.statusCode());
            System.out.println(body.asString());
            int responseCode = response.statusCode();
            Assert.assertEquals(responseCode, code, "Test Pass");
        } catch (Exception var3) {
            throw new Exception(var3);
        }
    }
}
