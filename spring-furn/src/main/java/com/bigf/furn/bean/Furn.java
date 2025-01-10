package com.bigf.furn.bean;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("furn")
public class Furn {
    private Integer id;
    private String name;
    private String maker;
    private Double price;
    private Integer sales;
    private Integer stock;
}
