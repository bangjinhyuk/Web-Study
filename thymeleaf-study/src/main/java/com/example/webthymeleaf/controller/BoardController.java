package com.example.webthymeleaf.controller;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "/list";
    }
    @GetMapping("/form")
    public String form(Model model) {
        List<EngineType> engineTypes = new ArrayList<>();
        engineTypes.add(new EngineType("MySQL", false));
        engineTypes.add(new EngineType("Redis", false));

        List<OSType> osTypes = new ArrayList<>();
        osTypes.add(new OSType("Ubuntu", false));
        osTypes.add(new OSType("CentOS", false));

        model.addAttribute("result", new Result());
        model.addAttribute("engineTypes", engineTypes);
        model.addAttribute("osTypes", osTypes);
        return "/form";
    }

    @PostMapping("/form")
    public String formSubmit(@ModelAttribute Result result) {
        System.out.println(result);
        return "redirect:/board/list";
    }

    @Getter
    @Setter
    @ToString
    public static class EngineType {
        String name;
        boolean isDisabled;

        public EngineType(String name, boolean isDisabled) {
            this.name = name;
            this.isDisabled = isDisabled;
        }
    }

    @Getter
    @Setter
    @ToString
    public static class OSType {
        String name;
        boolean isDisabled;

        public OSType(String name, boolean isDisabled) {
            this.name = name;
            this.isDisabled = isDisabled;
        }
    }



    @Getter
    @Setter
    @ToString
    public static class Version {
        String name;
        String version;

        public Version(String name, String version) {
            this.name = name;
            this.version = version;
        }
    }



    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class Result {
        String region;
        String zone;
        String name;
        String description;
        String result = "SUCCESS";
        String createUser;
        String createTime;
        String os;
        String version;

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
