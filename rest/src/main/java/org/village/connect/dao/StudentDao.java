package org.village.connect.dao;

import org.village.connect.dao.mapper.StudentMapper;
import org.village.connect.model.StudentModel;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Student model dao
 * 
 * @author ranjeet.kumar
 *
 */
@RegisterRowMapper(StudentMapper.class)
public interface StudentDao {

    @SqlQuery("select * from student;")
    List<StudentModel> getStudents();

    @SqlQuery("select * from student where id = :studentId;")
    StudentModel getStudent(@Bind("studentId") int studentId);
    
    @SqlQuery("select * from student where userId = :userId;")
    StudentModel getStudentByUserId(@Bind("userId") int userId);

    @SqlUpdate("insert IGNORE into student (userId, std, gender, college, collegeAddress, economyType, annualIncome, address, fatherName"
            + " ,motherName , parentEducation) Values (:userId, :std, :gender, :college, :collegeAddress"
            + ", :economyType, :annualIncome, :address, :fatherName, :motherName, :parentEducation ) ;")
    void createStudent(@BindBean StudentModel studentModel);

    @SqlUpdate("update student set std=coalesce(:std, std), gender =coalesce(:gender, gender), college = coalesce(:college, college), "
            + "collegeAddress = coalesce(:collegeAddress,collegeAddress) , economyType = coalesce(:economyType, economyType)"
            + ", annualIncome =coalesce(:annualIncome,annualIncome), address = coalesce(:address,address), fatherName =coalesce(:fatherName,fatherName)"
            + " ,motherName = coalesce(:motherName,motherName) , parentEducation = coalesce(:parentEducation,parentEducation), status =coalesce(:status,status), "
            + "modifyDate = :modifyDate where id = :id;")
    void updateStudent(@BindBean StudentModel studentModel);

    @SqlQuery("select last_insert_id();")
    int lastInsertId();

}
