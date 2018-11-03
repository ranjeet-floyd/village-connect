package org.village.connect.service;

import org.village.connect.common.AppConst;
import org.village.connect.dao.UserDao;
import org.village.connect.model.UserModel;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // @CreateSqlObject
    public UserDao getUserDao() {
        return userDao;
    }

    public List<UserModel> getUsers() {
        return getUserDao().getUsers();
    }

    public UserModel getUser(int id) {
        UserModel user = getUserDao().getUserById(id);
        if (Objects.isNull(user)) {
            throw new WebApplicationException(String.format(AppConst.DATA_NOT_FOUND, id), Status.NOT_FOUND);
        }
        return user;
    }

    public UserModel createUser(UserModel user) {
        if (null == getUserDao().getUserByName(user.getName())) {
            getUserDao().createUser(user);
            return getUserDao().getUserByName(user.getName());
        } else {
            throw new WebApplicationException(String.format(AppConst.USER_ALREADY_EXISTS, user.getName()),
                    Status.BAD_REQUEST);
        }


    }

    public UserModel editUser(UserModel user) {
        if (Objects.isNull(getUserDao().getUserById(user.getId()))) {
            throw new WebApplicationException(String.format(AppConst.DATA_NOT_FOUND, user.getId()), Status.NOT_FOUND);
        }
        getUserDao().editUser(user);
        return getUserDao().getUserById(user.getId());
    }

    public String deleteUser(final int id) {
        int result = getUserDao().deleteUser(id);
        switch (result) {
            case 1:
                return AppConst.SUCCESS;
            case 0:
                throw new WebApplicationException(String.format(AppConst.DATA_NOT_FOUND, id), Status.NOT_FOUND);
            default:
                throw new WebApplicationException(AppConst.UNEXPECTED_ERROR, Status.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean validate(UserModel user) {
        UserModel userDb = getUserDao().getUserByName(user.getName());
        if (Objects.nonNull(userDb)) {
            if (userDb.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }



}
