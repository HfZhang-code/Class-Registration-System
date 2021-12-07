package service;

import dao.StudentDao;
import entity.Student;

import java.io.IOException;

public class LoginService {

    private final StudentDao studentDao = new StudentDao();

    public String doLogin(String stuId, String password) throws IOException {
        Student student = studentDao.getStudentByStuIdAndPwd(stuId, password);
        if (student == null) {
            return "stuId or password is error";
        }
        return "";
    }
}
