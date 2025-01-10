package com.bigf.furn.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigf.furn.bean.Furn;
import com.bigf.furn.mapper.FurnMapper;
import com.bigf.furn.service.FurnService;
import org.springframework.stereotype.Service;

@Service //注入容器
public class FurnServiceImpl extends ServiceImpl<FurnMapper, Furn> implements FurnService {
    //自定义方法
}
