import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman manuel API testi icin kullanilir.
     2)Burada RestAPI  API otomasyon testi icin Rest -Assured Library kullanicaz.
     3)Otomasyon kodlarinin yazimi icin su adimlari izliyoruz
     a)Gereksinimleri anlama
     b)Test Case'i yazma
        i)Test case yazimi icin 'Gherkin Language' kullaniyoruz.
            'Gherkin bazi keywordlere saHIP BUNLAR:
            X)Given: On Kosullar
            Y)When: Aksiyonlar==>Get,Put,...
            z)Then: Ciktilar,Donutler==>Assert ,Dogrulama,response
            t)And: Coklu Islemler icin kullanilir

     c) Test kodunun yazimi
            i)Set the URL
            ii)Set the expected data() beklene  datanin olusturulmasi (Post-Put-Patch)
            iii)Type code to send request
            iv)Do Assertion

            Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

    */

    @Test
public void get01(){
       //  i)Set the URL
        String url="https://restful-booker.herokuapp.com/booking/55";
        // ii)Set the expected data() beklene  datanin olusturulmasi (Post-Put-Patch)

        // iii)Type code to send request

       Response response=given().when().get(url);
       // response.prettyPrint();
        // iv)Do Assertion

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        //Status code nasil yazdirilir?
        System.out.println("status code: "+response.statusCode());

        //'content type' nasil yazdirilir?
        System.out.println("content Type:"+response.contentType());

        //'status Line' nasil yazdirilir?
        System.out.println("statusLine: "+response.statusLine());

        //'Header'  nasil yazdirilir?
        System.out.println(response.header("Connection"));

        //'Headers'  nasil yazdirilir?
        System.out.println("HEaders : \n"+response.headers());


        //'Time'  nasil yazdirilir?
        System.out.println("Time : "+response.getTime());

        //'Size'  nasil yazdirilir?
        System.out.println("size : "+response.headers().size());
    }

}
