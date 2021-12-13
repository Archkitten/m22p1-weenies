package com.nighthawk.csa;
/*
This project was made by altering "Greet" from the spring_portfolio
I changed variables to make them stand out and be more meaningful, instead of everything being called 'name'
Hopefully this code is easier to read!
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Controller
public class AboutRyanController {

    @GetMapping("/aboutRyan")
    public String aboutRyan(Model model) throws IOException, InterruptedException, ParseException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://odds.p.rapidapi.com/v1/sports"))
                .header("x-rapidapi-host", "odds.p.rapidapi.com")
                .header("x-rapidapi-key", "f128759824mshba003fd35249c3cp186f26jsnf2cc1c16cd0d")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //alternative #1: convert response.body() to java hash map
        var map = new ObjectMapper().readValue(response.body(), HashMap.class);

        //alternative #2: convert response.body() to JSON object
        Object obj = new JSONParser().parse(response.body());
        JSONObject jn = (JSONObject) obj;

        //pass stats to view
        //model.addAttribute("map", map);
        model.addAttribute("jn", jn);
        //model.addAttribute("timezone", map.get("timezone")  ); //illustrative of map get
        //model.addAttribute("timezone", jo.get("timezone"));  //illustrative of jo get


        return "aboutRyan";
    }
}
