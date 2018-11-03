package org.village.connect.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModel {


    @Nullable
    private Integer id;

    @Nonnegative
    private int userId;
    @Size(max = 30)
    private String std;
    @Size(max = 10)
    private String gender;
    @Size(max = 30)
    private String college;
    @Size(max = 50)
    private String collegeAddress;
    @Size(max = 30)
    private String economyType;
    @Size(max = 30)
    private String annualIncome;
    @Size(max = 30)
    private String address;
    @Size(max = 30)
    private String fatherName;
    @Size(max = 30)
    private String motherName;
    @Size(max = 30)
    private String parentEducation;

    private int status;
    private Timestamp createdDate;
    private Timestamp modifyDate;


}
