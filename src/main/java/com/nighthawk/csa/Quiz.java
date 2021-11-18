package com.nighthawk.csa;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz {
    @GetMapping("/quiz")
    public String greeting(@RequestParam(name= "UserInput", required=false, defaultValue="...") String UserInputJava, Model model) {
        if (UserInputJava.equals("...")) {
            model.addAttribute("output", UserInputJava);
        }
        else if (UserInputJava.equals("19.0")) {
            model.addAttribute("output", "Correct!");
        }
        else {
            model.addAttribute("output", "Wrong!");
        }
        model.addAttribute("question", "What is the BMI of a 6 foot person that weighs 140 pounds? Answer to the nearest tenth.");
        return "quiz";
    }
}