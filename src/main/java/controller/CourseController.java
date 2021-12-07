package controller;

import cn.hutool.core.util.StrUtil;
import service.CourseService;

import java.io.IOException;


public class CourseController {

    private CourseService courseService = new CourseService();



    public Object[][] loadCourse() {

        Object[][] objects = new Object[10][4];
        try {
            objects = courseService.loadCourse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public String chooseCourse(String stuId, String courseId) {
        //validate the student id and course id
        if (StrUtil.isBlank(stuId)) {
            return "Stu ID can not be empty or null";
        }
        if (StrUtil.isBlank(courseId)) {
            return "Course ID can not be empty or null";
        }

        String ret = "";
        try {
            ret = courseService.selectCourse(stuId, courseId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


}
