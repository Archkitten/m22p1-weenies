package com.nighthawk.csa;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Controller
public class AboutRohanController {
    // GET request, no parameters
    @GetMapping("/aboutRohan")
    public String soccer(Model model) throws IOException, InterruptedException, ParseException {
        // https://rapidapi.com/spamakashrajtech/api/corona-virus-world-and-india-data/
        //rapidapi setup:
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/players/topscorers?league=39&season=2020"))
                .header("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
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
        return "aboutRohan";
    }
}

