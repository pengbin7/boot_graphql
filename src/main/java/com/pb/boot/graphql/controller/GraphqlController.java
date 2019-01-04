package com.pb.boot.graphql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GraphqlController {

    @RequestMapping(value = "graphiql")
    public String index(){
        return "graphiql";
    }

    @RequestMapping(value = "index")
    public String a(){
        return "index";
    }

}
