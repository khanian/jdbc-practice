package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(User user, String sql, PreparedStatementSetter pss) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = ConnectionManager.getConnection();
            pstmt = connection.prepareStatement(sql);
            pss.setter(pstmt);

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}
