package org.iqqcode.domain;

import lombok.Data;
import org.iqqcode.domain.Person;

import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-19 22:43
 * @Description:Role实   体类---与Person多对多
 * 一个用户可以有多个角色
 * 一个角色可以赋予多个用户
 */
@Data
public class Role {
    //与表中字段不一致，需要在映射中添加 resultMap
    private Integer roleId;
    private String roleName;
    private String roleDesc;

    //多对多的关系映射：一个角色可以赋予多个用户
    //user表，role表，person_role表为连接两表
    private List<Person> persons;

}
