package org.village.connect.dao.mapper;

import org.village.connect.model.StudentModel;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<StudentModel> {

    private static final String ID = "id";
    private static final String USER_ID = "userId";
    private static final String STD = "std";
    private static final String GENDER = "gender";
    private static final String COLLEGE = "college";
    private static final String COLLEGE_ADDRESS = "collegeAddress";
    private static final String ECONOMY_TYPE = "economyType";
    private static final String ANNUAL_INCOME = "annualIncome";
    private static final String ADDRESS = "address";
    private static final String FATHER_NAME = "fatherName";
    private static final String MOTHER_NAME = "motherName";
    private static final String PARENT_EDUCATION = "parentEducation";
    private static final String STATUS = "status";
    public static final String CREATE_DATE = "createDate";
    private static final String MODIFY_DATE = "modifyDate";

    @Override
    public StudentModel map(ResultSet rs, StatementContext ctx) throws SQLException {
        return StudentModel.builder().id(rs.getInt(ID)).userId(rs.getInt(USER_ID)).std(rs.getString(STD))
                .gender(rs.getString(GENDER)).college(rs.getString(COLLEGE))
                .collegeAddress(rs.getString(COLLEGE_ADDRESS)).economyType(rs.getString(ECONOMY_TYPE))
                .annualIncome(rs.getString(ANNUAL_INCOME)).address(rs.getString(ADDRESS))
                .fatherName(rs.getString(FATHER_NAME)).motherName(rs.getString(MOTHER_NAME))
                .parentEducation(rs.getString(PARENT_EDUCATION)).status(rs.getInt(STATUS))
                .createdDate(rs.getTimestamp(CREATE_DATE)).modifyDate(rs.getTimestamp(MODIFY_DATE)).build();
    }

}
