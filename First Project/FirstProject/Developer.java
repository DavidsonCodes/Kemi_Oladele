package Week4.FirstProject;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Developer {
    ResultSet loadDevelopers() throws SQLException;
}