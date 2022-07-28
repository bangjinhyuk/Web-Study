package com.example.webthymeleaf;

import lombok.*;

/**
 * Created by bangjinhyuk on 2022/07/28.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateMySQLReq {
    //OS
    String os;
    //Mysql
    String version;

    //User
    String userName;
    String userPassword;

    //추가 설정
    String timeZone;
    String databaseName;
    String charset;
    String collate;

    //replication 적용 유무
    Boolean isReplication;


    //prefix 설정
    String prefix;

    String name;


    @Builder
    public CreateMySQLReq(String os, String version, String userName, String userPassword, String timeZone, String databaseName, String charset, String collate, boolean isReplication, String prefix, String name) {
        this.os = os;
        this.version = version;
        this.userName = userName;
        this.userPassword = userPassword;
        this.timeZone = timeZone;
        this.databaseName = databaseName;
        this.charset = charset;
        this.collate = collate;
        this.isReplication = isReplication;
        this.prefix = prefix;
        this.name = name;
    }

}
