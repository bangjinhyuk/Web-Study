package com.example.webthymeleaf.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bangjinhyuk on 2022/07/24.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public String list(Model model) {
        List<Result> results = new ArrayList<>();
        results.add(
                Result.builder()
                        .region("IDC(VM)")
                        .zone("QA")
                        .name("이름-1")
                        .result("SUCCESS")
                        .description("~~ㅇ비니다.")
                        .createUser("bbangi98")
                        .createTime("2022-10-21").build()
        );
        model.addAttribute("results", results);
        return "list";
    }

    @Getter
    @Setter
    public static class Result {
        String region;
        String zone;
        String name;
        String description;
        String result;
        String createUser;
        String createTime;

        @Builder
        public Result(String region, String zone, String name, String description, String result, String createUser, String createTime) {
            this.region = region;
            this.zone = zone;
            this.name = name;
            this.description = description;
            this.result = result;
            this.createUser = createUser;
            this.createTime = createTime;
        }
    }
}
