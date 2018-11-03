package org.village.connect.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;

import javax.annotation.Nonnegative;
import javax.annotation.Nullable;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
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

    @Nonnegative
    private int status;
    
    @Nonnegative
    private int type;


    private Timestamp createDate;

    private Timestamp modifyDate;

}
