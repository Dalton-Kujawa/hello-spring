package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {
//     Handles request at path /hello
    @RequestMapping(value = "hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }
    //lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

//    // Handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name,Model model){
        String greeting = "Hello, " + name+ "1";
        model.addAttribute("greeting",greeting);
        return "Hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
    List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Dalton");
        names.add("Calista");
        model.addAttribute("names",names);
        return "hello-list";
    }
//
//    @RequestMapping(value="hello", method = RequestMethod.POST)
//    @ResponseBody
//    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        if (name == null) {
//            name = "World";
//        }
//
//        return createMessage(name, language);
//
//        // For a bonus mission, students can change this response text to look nicer.
//        // This is subjective, but students should be modifying the HTML of the response string.
//    }
//
//    public static String createMessage(String n, String l) {
//        String greeting = "";
//
//        if (l.equals("english")) {
//            greeting = "Hello";
//        }
//        else if (l.equals("french")) {
//            greeting = "Bonjour";
//        }
//        else if (l.equals("italian")) {
//            greeting = "Bonjourno";
//        }
//        else if (l.equals("spanish")) {
//            greeting = "Hola";
//        }
//        else if (l.equals("german")) {
//            greeting = "Hallo";
//        }
//
//        return greeting + " " + n;
//    }
}
