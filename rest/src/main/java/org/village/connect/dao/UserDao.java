package org.village.connect.dao;

import org.village.connect.dao.mapper.UserMapper;
import org.village.connect.model.UserModel;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * JDBI DAO layer
 * 
 * @author ranjeet.kumar
 *
 */
@RegisterRowMapper(UserMapper.class)
public interface UserDao {

    @SqlQuery("select * from user;")
    public List<UserModel> getUsers();

    @SqlQuery("select * from user where id = :id;")
    public UserModel getUserById(@Bind("id") final int id);
    
    @SqlQuery("select * from user where name = :name;")
    public UserModel getUserByName(@Bind("name") final String name);

    @SqlUpdate("insert IGNORE into user(name, password, status, type) values(:name, :password, :status, :type);")
    void createUser(@BindBean final UserModel user);

    @SqlUpdate("update user set name = coalesce(:name, name), code = coalesce(:password, password) where id = :id;")
    void editUser(@BindBean final UserModel user);

    @SqlUpdate("delete from user where id = :id;")
    int deleteUser(@Bind("id") final int id);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();
    
    

}
