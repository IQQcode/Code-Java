package com.iqqcode.anno;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running.....");
    }
}
