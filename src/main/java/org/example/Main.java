package org.example;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static  spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        new Post("This is my first post", "Juan", "2022-01-01", 12);
        new Post("This is my second post", "Joseph", "2022-01-01", 13);
        new Post("This is my third post", "Mikky", "2022-01-01", 14);
        get("/", (request, response) -> {
            // get request query parameters
            String author = request.queryParams("author");
            String content = request.queryParams("content");
            String date = request.queryParams("date");
            if(author != null && content != null && date != null) {
                new Post(content, author, date, 12);
            }
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("posts", Post.getPosts());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine()); //

        get("/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "new.hbs");

        } , new HandlebarsTemplateEngine());

        //Post - Delete and Update(Patch, Put)- Research about post

//        get("/posts/:id", (request, response) -> {
//            String q = "?";
//            String id = request.params("id").split(q)[0];
//            int id = Integer.parseInt();
//            Post.delete(id);
//            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("posts", Post.getPosts());
//            return new ModelAndView(model, "index.hbs");
//        } , new HandlebarsTemplateEngine());


    }
}