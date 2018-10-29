package org.village.connect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;

import javax.annotation.Nonnegative;
import javax.annotation.Nullable;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Nullable
    private Integer id;

    @Size(max = 30)
    @NotEmpty
    private String name;


    @Size(max = 30)
    @NotEmpty
    private String password;

    private int status;


    private Timestamp createdDate;

    private Timestamp modifyDate;


    @Size(max = 30)
    @NotEmpty
    private String village;

    @Size(max = 30)
    @NotEmpty
    private String district;

    @Nonnegative
    private int pincode;


}
