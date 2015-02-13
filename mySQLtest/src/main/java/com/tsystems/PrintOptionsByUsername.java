package main.java.com.tsystems;

import java.sql.*;
import org.apache.log4j.Logger;

/**
 * Created by sevasan on 2/12/2015.
 */
public class PrintOptionsByUsername{
    final static Logger logger = Logger.getLogger(PrintOptionsByUsername.class);

    public static void main(String args[]){
        PrintOptionsByUsername obj = new PrintOptionsByUsername();
        obj.runMe("Вася");
    }

    private void runMe(String parameter) {
        String user = "root";
        String pass = "secret";
        String url = "jdbc:mysql://localhost:3306/my_db";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
        } catch (Exception e) {
            logger.error(e);
        }

        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement st = con.prepareStatement(
                    "select options.name_options " +
                            "from options " +
                            "where options.id_options in (" +
                            "select contracts.optionID_contracts " +
                            "from contracts " +
                            "where contracts.userID_contracts = (" +
                            "select users.id_users " +
                            "from users " +
                            "where users.name_users = ?" +
                            ")" +
                            ");");
            st.setString(1, parameter);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                logger.info(rs.getString("name_options"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }
}
