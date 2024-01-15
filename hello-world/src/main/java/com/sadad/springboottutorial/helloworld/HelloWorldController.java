package com.sadad.springboottutorial.helloworld;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

   // @RequestMapping(path = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String helloWorld(){
        return  "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
       //return  "Hello World";
        return new HelloWorldBean("Hello World");
    }

//    http://localhost:9090/hello-world-bean-path-variable/mohsen
    @GetMapping("/hello-world-bean-path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable  String name){
        //return  "Hello World";
//        return new HelloWorldBean("Hello World");
//        return new HelloWorldBean("Hello World "+ name);
        return new HelloWorldBean(String.format("Hello World %s",name));
    }


    @GetMapping("/hello-world-bean-request-param")
    public HelloWorldBean helloWorldBeanRequestParam(@RequestParam String firstName,
                                                     @RequestParam String lastName){
        //return  "Hello World";
//        return new HelloWorldBean("Hello World");
//        return new HelloWorldBean("Hello World "+ name);
        return new HelloWorldBean(String.format("Hello World %s %s",firstName,lastName));
    }


}
