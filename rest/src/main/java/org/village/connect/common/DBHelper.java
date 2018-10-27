package org.village.connect.common;

import org.jdbi.v3.core.ConnectionException;
import org.jdbi.v3.core.statement.UnableToExecuteStatementException;

public class DBHelper {
    

    private String checkUnableToObtainConnectionException(ConnectionException ex) {
        if (ex.getCause() instanceof java.sql.SQLNonTransientConnectionException) {
            return AppConst.DATABASE_REACH_ERROR + ex.getCause().getLocalizedMessage();
        } else if (ex.getCause() instanceof java.sql.SQLException) {
            return AppConst.DATABASE_CONNECTION_ERROR + ex.getCause().getLocalizedMessage();
        } else {
            return AppConst.DATABASE_UNEXPECTED_ERROR + ex.getCause().getLocalizedMessage();
        }
    }

    private String checkUnableToExecuteStatementException(UnableToExecuteStatementException ex) {
        if (ex.getCause() instanceof java.sql.SQLSyntaxErrorException) {
            return AppConst.DATABASE_CONNECTION_ERROR + ex.getCause().getLocalizedMessage();
        } else {
            return AppConst.DATABASE_UNEXPECTED_ERROR + ex.getCause().getLocalizedMessage();
        }
    }

}
