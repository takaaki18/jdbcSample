import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoSample {
	private static final String URL = "jdbc:mysql://localhost:3306/test_db";
	private static final String USER = "test_user";
	private static final String PASSWORD = "test_pass";
	private static final String SQL = "select * from employee";

	public List<DtoSample> findEmployee() {

		List<DtoSample> employeeList = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					DtoSample employeeDto = new DtoSample();
					employeeDto.setEmployeeId(resultSet.getInt("employee_id"));
					employeeDto.setEmployeeName(resultSet.getString("employee_name"));
					employeeDto.setDepartmentId(resultSet.getInt("department_id"));
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
