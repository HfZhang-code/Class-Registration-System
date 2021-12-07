package service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import dao.CourseDao;
import entity.Course;

import java.io.IOException;
import java.util.List;


public class CourseService {

    private final CourseDao courseDao = new CourseDao();



    //load courses into the table
    public Object[][] loadCourse() throws IOException {
        List<Course> list = courseDao.listAllCourse();
        //create table with four columns
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            Course course = list.get(i);
            JSONObject jsonObject = JSONUtil.parseObj(course);
            data[i][0] = jsonObject.getStr("courseId");
            data[i][1] = jsonObject.getStr("courseName");
            data[i][2] = jsonObject.getStr("teacher");
            data[i][3] = jsonObject.getStr("restNum");

        }

        return data;
    }

    public String selectCourse(String stuId, String courseId) throws IOException {
        Course course = courseDao.getCourseById(courseId);
        //if user change the course id in the table, it will return error
        if (course == null) {
            return "There is not exists Course ID[" + courseId + "]";
        }
        //user select course and remaining seat get deducted
        if (course.getRestNum() > 0) {
            course.setRestNum(course.getRestNum() - 1);
            courseDao.updateCourseById(courseId, course);
            courseDao.addSelectCourse(stuId, course);
            return "";
        } else {
            return "Course rest number is not enough";
        }
    }

}
