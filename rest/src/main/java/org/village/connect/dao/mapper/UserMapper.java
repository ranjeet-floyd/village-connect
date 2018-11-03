package org.village.connect.dao.mapper;

import org.village.connect.model.UserModel;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String STATUS = "status";
    private static final String CREATE_DATE = "createDate";
    private static final String MODIFY_DATE = "modifyDate";
    private static final String TYPE = "type";


    @Override
    public UserModel map(ResultSet rs, StatementContext ctx) throws SQLException {
        return UserModel.builder().id(rs.getInt(ID)).name(rs.getString(NAME)).password(rs.getString(PASSWORD))
                .status(rs.getInt(STATUS)).createDate(rs.getTimestamp(CREATE_DATE))
                .modifyDate(rs.getTimestamp(MODIFY_DATE)).type(rs.getInt(TYPE)).build();
    }

}
