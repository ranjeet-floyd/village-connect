package org.village.connect.dao.mapper;

import org.village.connect.model.UserModel;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    
    private static final String ID ="id";
    private static final String NAME ="name";
    private static final String PASSWORD ="password";
    

    @Override
    public UserModel map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new UserModel(rs.getInt(ID), rs.getString(NAME), rs.getString(PASSWORD));
        
    }

}
