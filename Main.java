import java.sql.*;

public class Main {
  public static void main(String[] main) {
    Strign url = "jdbc:mysql://localhost:3306/testdb";
    String user = "Ayush";
    String password = "123456";

    String query = "SELECT EmpId, Name, Salary FROM Employee";

    try(Connection con = DriveManager.getConnection(url, user, password)
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query)) {
        System.out.println("EmployeeId | Name | Salary");
        System.out.println("---------------------------");
        while(rs.next()) {
          int empId = rs.getInt("EmpId");
          String name = rs.getString("Name");
          Double salary = rs.getDouble("Salary");
          System.out.println(empId + "|" + name + "|" + salary);
        }
    } catch(SqlException e) {
        e.printStackTrace();
    }
  }
}
