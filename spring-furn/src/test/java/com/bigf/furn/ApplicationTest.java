package com.bigf.furn;

import com.bigf.furn.bean.Furn;
import com.bigf.furn.mapper.FurnMapper;

import com.bigf.furn.service.FurnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Resource
    private FurnMapper furnMapper;
    @Autowired
    private FurnService furnService;

    @Test
    public void FurnMapperTest() {
        List<Furn> list =furnService.list();
        for (Furn furn : list) {
            System.out.println(furn);
        }
    }
}
