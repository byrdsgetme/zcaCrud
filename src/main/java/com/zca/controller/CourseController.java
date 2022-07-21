package com.zca.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zca.domain.Course;
import com.zca.controller.utils.R;
import com.zca.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public R getAll()
    {
        return new R(true,courseService.getAll());
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id)
    {
        return new R(true,courseService.getById(id));
    }

    @PostMapping
    public R save(@RequestBody Course course)
    {


        return new R(courseService.save(course));
    }

    @PutMapping
    public R update(@RequestBody Course course)
    {
        return new R(courseService.update(course));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id)
    {
        return new R(courseService.delete(id));
    }


    @GetMapping("{currentpage}/{pagesize}")
    public R getPage(@PathVariable int currentpage,@PathVariable int pagesize,@RequestBody Course course)
    {
        IPage page= courseService.getPage(currentpage,pagesize,course);
        if(currentpage>page.getPages())
        {
            page=courseService.getPage((int)page.getPages(),pagesize,course);
        }
        return new R(true,page);
    }

}
