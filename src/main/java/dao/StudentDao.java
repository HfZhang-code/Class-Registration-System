package dao;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import entity.Student;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private static Path studentPath = Paths.get("db","students.csv");

    // get all student, read data from students.csv
    public List<Student> getAllStudent() throws IOException {
        List<Student> list = new ArrayList<>();

        List<String> lines = Files.readAllLines(studentPath, StandardCharsets.UTF_8);
        for (String line : lines) {
            Student student = JSONUtil.toBean(line, Student.class);
            list.add(student);
        }

        return list;
    }

    //get student by stuId and password. read data from students.csv,then filter by stuId and password

    public Student getStudentByStuIdAndPwd(String stuId, String pwd) throws IOException {
        List<String> lines = Files.readAllLines(studentPath,StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println("In case you forget the student id and password.");
            System.out.println(line);
            if (StrUtil.isBlank(line)) {
                continue;
            }
            JSONObject jsonObject = JSONUtil.parseObj(line);
            if (StrUtil.equals(stuId, jsonObject.getStr("stuId"))
                    && StrUtil.equals(pwd, jsonObject.getStr("password"))) {
                Student student = JSONUtil.toBean(jsonObject, Student.class);
                return student;
            }
        }
        return null;
    }


}
