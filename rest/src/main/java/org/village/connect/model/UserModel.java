package org.village.connect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private  Integer id;

    @Size(max = 30)
    @NotEmpty
    private  String name;


    @Size(max = 30)
    @NotEmpty
    private  String password;


}
