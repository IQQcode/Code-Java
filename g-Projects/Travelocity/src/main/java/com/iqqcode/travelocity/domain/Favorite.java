package com.iqqcode.travelocity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 收藏实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite implements Serializable {
    private int rid;
    private Route route;//旅游线路对象
    private String date;//收藏时间
    private User user;//所属用户
}
