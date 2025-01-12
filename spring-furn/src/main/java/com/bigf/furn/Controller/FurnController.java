package com.bigf.furn.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigf.furn.bean.Furn;
import com.bigf.furn.service.FurnService;
import com.bigf.furn.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class FurnController {
    @Resource
    private FurnService furnService;

    @PostMapping("/save")
    public Result save(@RequestBody Furn furn) {
        try {
            if (furn == null) {
                return Result.error("400", "家具数据不能为空");
            }
            log.info("接收到的家具数据: {}", furn);
            boolean saved = furnService.save(furn);
            if (saved) {
                return Result.success();
            } else {
                return Result.error("500", "保存失败");
            }
        } catch (Exception e) {
            log.error("保存家具数据失败", e);
            return Result.error("500", "服务器错误: " + e.getMessage());
        }
    }

    @RequestMapping("/furns")
    public Result listFurns() {
        List<Furn> list=furnService.list();
        return Result.success(list);

    }

    @PutMapping("/update")
    public Result update(@RequestBody Furn furn) {
        furnService.updateById(furn);
        return Result.success();
    }

    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        furnService.removeById(id);
        return Result.success();
    }

    @GetMapping("/furnsByPage")
    public Result listFurnByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Furn> page = furnService.page(new Page<>(pageNum, pageSize));
        return Result.success(page);
    }
    /**
     * 根据条件（name）进行查询
     *
     * @param pageNum  第几页 默认1
     * @param pageSize 页的大小 默认5
     * @param search   查询条件 默认为空即不带条件
     * @return
     */
    @GetMapping("/furnsByCondition")
    public Result listFurnsByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "5") Integer pageSize,
                                           @RequestParam(defaultValue = "") String search) {
        // 获取QueryWrapper对象
        QueryWrapper<Furn> query = Wrappers.query();
        if (StringUtils.hasText(search)) {
            //查询条件是name like。。。
            query.like("name", "%" + search + "%");
        }

        //返回page对象
        Page<Furn> page = furnService.page(new Page<>(pageNum, pageSize), query);
        return Result.success(page);
    }

}
