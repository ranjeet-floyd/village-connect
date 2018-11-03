package org.village.connect.service;

import org.village.connect.common.AppConst;
import org.village.connect.dao.StudentDao;
import org.village.connect.dao.UserDao;
import org.village.connect.model.StudentModel;
import org.village.connect.model.UserModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private final StudentDao studentDao;
    private final UserDao userDao;

    public StudentService(StudentDao studentDao, UserDao userDao) {
        this.studentDao = studentDao;
        this.userDao = userDao;
    }

    // @CreateSqlObject
    public StudentDao getStudentDao() {
        return studentDao;
    }



    public UserDao getUserDao() {
        return userDao;
    }

    public List<StudentModel> getStudents() {
        return getStudentDao().getStudents();
    }

    public StudentModel getStudent(int studentId) {
        StudentModel student = getStudentDao().getStudent(studentId);
        if (Objects.isNull(student)) {
            throw new WebApplicationException(String.format(AppConst.DATA_NOT_FOUND, studentId), Status.NOT_FOUND);
        }
        return student;
    }

    public StudentModel createStudent(StudentModel student) {
        // check if user exist or not
        UserModel user = getUserDao().getUserById(student.getUserId());
        if (Objects.isNull(user)) {
            throw new WebApplicationException(String.format(AppConst.DATA_NOT_FOUND, student.getUserId()),
                    Status.NOT_FOUND);
        }
        if (Objects.nonNull(getStudentDao().getStudentByUserId(student.getUserId()))) {
            throw new WebApplicationException(String.format(AppConst.USER_ALREADY_EXISTS, student.getUserId()),
                    Status.PRECONDITION_FAILED);
        }
        getStudentDao().createStudent(student);
        LOGGER.debug("student created");
        return getStudentDao().getStudent(getStudentDao().lastInsertId());
    }


}
