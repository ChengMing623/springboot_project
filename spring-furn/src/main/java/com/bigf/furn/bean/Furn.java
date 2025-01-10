package com.bigf.furn.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("furn")
public class Furn {
    @TableId(type = IdType.AUTO) //不需要指定id，Springboot会自动处理自增id
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "maker")
    private String maker;
    @TableField(value = "price")
    private Double price;
    @TableField(value = "sales")
    private Integer sales;
    @TableField(value = "stock")
    private Integer stock;
}
