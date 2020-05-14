package com.iqqcode.travelocity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商家实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller implements Serializable {
    private int sid;//商家id
    private String sname;//商家名称
    private String consphone;//商家电话
    private String address;//商家地址
}
