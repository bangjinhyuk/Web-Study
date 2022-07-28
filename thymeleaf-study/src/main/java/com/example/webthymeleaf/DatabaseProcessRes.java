package com.example.webthymeleaf;

/**
 * Created by bangjinhyuk on 2022/07/28.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseProcessRes {
    Long id;
    String planId;
    String name;
    String zone;
    EngineType engineType;
    String description;
    List<String> dbTags = new ArrayList<>();
    Status planStatus;
    Step requestStep;
    String planUrl;
    String serverType;
    String createUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    MySQLRes mySQLRes;

    List<InstanceRes> instanceResList = new ArrayList<>();

    @Getter
    @Setter
    public static class InstanceRes {
        String hostName;
        String ip;
        String clusterName;
        String description;
        Status status;
        String imageName;
        String instanceType;
        String confUrl;
        String computeUrl;
    }
    @Getter
    @Setter
    public static class MySQLRes {
        String masterUserName;
        String masterUserPassword;
        String databaseName;
        String charset;
        String collate;
        String timezone;
        Boolean isReplication;
    }

    public enum EngineType {
        MYSQL, REDIS
    }

    public enum Status {
        ING, SUCCESS
    }

    public enum Step {
        CREATE_PLAN, UPDATE_PLAN ,APPLY_PLAN
    }
}

