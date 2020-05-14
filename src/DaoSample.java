import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoSample {
    private static final String URL = "jdbc:mysql://localhost:3306/sampleDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String SQL = "select * from employee";

    public List<DtoSample> findEmployee() {

        List<DtoSample> employeeList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    DtoSample employeeDto = new DtoSample();
                    employeeDto.setName(resultSet.getString("name"));
                    employeeDto.setAddress(resultSet.getString("address"));
                    employeeDto.setPhone(resultSet.getString("phone"));
                    employeeList.add(employeeDto);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return employeeList;
    }
}
