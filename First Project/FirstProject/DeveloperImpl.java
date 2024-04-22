package Week4.FirstProject;

import java.io.*;
import java.sql.*;

public class DeveloperImpl implements Developer{
    private Connection connection;
    private String file;

    public DeveloperImpl(Connection connection, String file) {
        this.connection = connection;
        this.file = file;
    }

    @Override
    public ResultSet loadDevelopers() throws SQLException {
        // Creating Connection to Database
        String url = "jdbc:mysql://localhost:3306/developer";
        String username = "root";
        String password = "Khemzy09@";
        String file = "C:\\Users\\USER\\IdeaProjects\\CodeSamples\\src\\Week4\\FirstProject\\Project.txt";
        String removeHashTag = "C:\\Users\\USER\\IdeaProjects\\CodeSamples\\src\\Week4\\FirstProject\\HashFile.txt";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Creating the 'developers table'
            String developersTableQuery = "CREATE TABLE IF NOT EXISTS developers(name Text, age Integer, location Text, skill Text )";
            statement.executeUpdate(developersTableQuery);

            // Fetching the contents of 'Project.txt'
            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(removeHashTag))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Removing 'HashTag' from the contents
                    String removeHash = line.replaceAll("#", "");
                    writer.write(removeHash + "\n");
                    String[] data = removeHash.split(",");
                    // Populating the fetched data into the database table called 'developers'
                    String insertDevsQuery = "INSERT INTO developers(name,age,location,skill) VALUES (?,?,?,?)"; // developers
                    PreparedStatement prStatement = connection.prepareStatement(insertDevsQuery);
                    prStatement.setString(1, data[0]);

                    // Trying to catch NumberFormatException
                    try {
                        prStatement.setInt(2, Integer.parseInt(data[1].trim()));
                    } catch (NumberFormatException n) {
                        System.out.println(n.getMessage());
                        continue;
                    }
                    prStatement.setString(3, data[2]);
                    prStatement.setString(4, data[3]);
                    prStatement.addBatch();
                    prStatement.executeBatch();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Fetch all loaded Contents
        String allDevs = "SELECT * FROM developers"; // developers
        return connection.createStatement().executeQuery(allDevs);
    }
}
class SampleTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/developer"; // developer
        String username = "root";
        String password = "Khemzy09@";
        String file = "C:\\Users\\USER\\IdeaProjects\\CodeSamples\\src\\Week4\\FirstProject\\Project.txt";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Developer dev = new DeveloperImpl(connection, file);
            ResultSet resultSet =  dev.loadDevelopers();
            System.out.println("Name\t\tAge\tLocation\tSkill");
            while (resultSet.next()) {
                try {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String location = resultSet.getString("location");
                    String skill = resultSet.getString("skill");
                    System.out.printf("%s\t%d\t%s\t%s\t\n",name,age,location,skill);
                }catch (Exception exception){
                    System.out.println(exception.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
    }
   }
}