package sample.test.sampletest.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sample.test.sampletest.domain.Member;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }


    @GetMapping("hello-mvc")
//    required 파라미터 필요여부
    public String helloMvc(/*@RequestParam(value = "name", required = false) String name,*/
            @ModelAttribute("mem") Member mem, Model model) {
//    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
        /*model.addAttribute("name", "dkdkdk");*/
        mem.setName("");
        model.addAttribute("memb", mem);
        return "hello-template";
    }

//    http://sk.sktelecom.com/aaa
//    ?name=asdsad

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = false) String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
//    @RequestMapping(value = "/hello-api", method = RequestMethod.GET)
    public Hello helloApi(
//            @ModelAttribute("Hello") Hello hello, Model mo
            @RequestParam(value = "name", required = false) String name
//            ,@RequestParam(value = "hh", required = false) String hh
            ){
        Hello hello = new Hello();
//        hello.setName("11");
//        hello.setHh(hh);
//        hello.name = "11";
//        hello.hh = "d";
//        mo.addAttribute("hello",hello);
//        mo.addAttribute("h","d");
//        return "/hello";
        return hello;
    }

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    static class Hello{
        private String name;
        private String hh;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

//        public String getHh() {
//            return hh;
//        }

//        public void setHh(String hh) {
//            this.hh = hh;
//        }

    }

}