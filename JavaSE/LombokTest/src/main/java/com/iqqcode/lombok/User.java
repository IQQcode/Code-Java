package com.iqqcode.lombok;


import lombok.*;
import lombok.extern.java.Log;

import java.util.Objects;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Data
@Builder
@Log
public class User {
    private int id;
    private int age;
    private String username;
    private String password;

    public void fun(String s) {
        log.info("test");
    }
}
