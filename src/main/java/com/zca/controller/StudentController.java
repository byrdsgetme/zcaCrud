package com.zca.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zca.domain.Student;
import com.zca.controller.utils.R;
import com.zca.service.StudentService;
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
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public R getAll()
    {
        return new R(true,studentService.getAll());
    }

//    @GetMapping("{id}")
//    public R getById(@PathVariable Integer id)
//    {
//        return new R(true,studentService.getById(id));
//    }

    @GetMapping("{id}")
    public R selectStudentCourseById(@PathVariable Integer id)
    {
        if(studentService.getStudentCourseBySid(id).isEmpty())
        {
            return new R(false);
        }
        else {
            return new R(true, studentService.getStudentCourseBySid(id));
        }
    }
    @PostMapping
    public R save(@RequestBody Student student)
    {


        return new R(studentService.save(student));
    }

    @PostMapping("{sid}/{cid}")
    public R saveStudentCourse(@PathVariable Integer sid, @PathVariable Integer cid)
    {
        return new R(studentService.saveStudentCourse(sid,cid));
    }
    @PutMapping
    public R update(@RequestBody Student student)
    {
        return new R(studentService.update(student));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id)
    {
        return new R(studentService.delete(id));
    }
//    @GetMapping("{currentpage}/{pagesize}")
//    public R getPage(@PathVariable int currentpage,@PathVariable int pagesize)
//    {
//        IPage page= studentService.getPage(currentpage,pagesize);
//        if(currentpage>page.getPages())
//        {
//            page=studentService.getPage((int)page.getPages(),pagesize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("{currentpage}/{pagesize}")
    public R getPage(@PathVariable int currentpage,@PathVariable int pagesize,@RequestBody Student student)
    {
        IPage page= studentService.getPage(currentpage,pagesize,student);
        if(currentpage>page.getPages())
        {
            page=studentService.getPage((int)page.getPages(),pagesize,student);
        }
        return new R(true,page);
    }


}
