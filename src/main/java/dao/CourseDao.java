package dao;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import entity.Course;
//import cn.hutool.core.bean.PropDesc;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class CourseDao {

    private final Path coursePath = Paths.get("db", "courses.csv");

    private final Path selectPath = Paths.get("db", "selected.csv");



    //list all course, read data from courses.csv

    public List<Course> listAllCourse() throws IOException {
        List<String> lines = Files.readAllLines(coursePath, StandardCharsets.UTF_8);
        List<Course> list = new ArrayList<>(lines.size());
        for (String line : lines) {
            if (StrUtil.isBlank(line)) {
                continue;
            }
            Course course = JSONUtil.toBean(line, Course.class);
            list.add(course);
        }
        return list;
    }

    // get course by courseId, read data from courses.csv,then filter by courseId

    public Course getCourseById(String courseId) throws IOException {
        List<Course> list = listAllCourse();
        for (Course course : list) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }

    //update course by courseId,then write data into courses.csv.

    public void updateCourseById(String courseId, Course update) throws IOException {
        List<Course> list = listAllCourse();
        List<String> lines = new ArrayList<>(list.size());
        for (Course course : list) {
            if (course.getCourseId().equals(courseId)) {
                course.setCourseName(update.getCourseName());
                course.setTeacher(update.getTeacher());
                course.setRestNum(update.getRestNum());
            }
            lines.add(JSONUtil.toJsonStr(course));
        }

        Files.write(coursePath, lines, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
    }

    // add selected course, write data into selected.csv, include stuId,courseId,courseName,teacher...

    public void addSelectCourse(String stuId, Course course) throws IOException {
        List<String> lines = Files.readAllLines(selectPath, StandardCharsets.UTF_8);
        JSONObject jsonObj = new JSONObject();
        jsonObj.set("stuId", stuId);
        jsonObj.set("courseId", course.getCourseId());
        jsonObj.set("courseName", course.getCourseName());
        jsonObj.set("teacher", course.getTeacher());
        lines.add(JSONUtil.toJsonStr(jsonObj));

        Files.write(selectPath, lines, StandardCharsets.UTF_8, StandardOpenOption.WRITE);

    }
}
