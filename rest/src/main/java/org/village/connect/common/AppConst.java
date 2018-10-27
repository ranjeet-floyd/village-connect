package org.village.connect.common;

public interface AppConst {

    // database
    static final String DATABASE_REACH_ERROR =
            "Could not reach the MySQL database. The database may be down or there may be network connectivity issues. Details: ";
    static final String DATABASE_CONNECTION_ERROR =
            "Could not create a connection to the MySQL database. The database configurations are likely incorrect. Details: ";
    static final String DATABASE_UNEXPECTED_ERROR =
            "Unexpected error occurred while attempting to reach the database. Details: ";

    static final String USER_NOT_FOUND = "User id %s not found.";

    static final String SUCCESS = "Success...";
    static final String UNEXPECTED_ERROR = "An unexpected error occurred while deleting part.";

}
