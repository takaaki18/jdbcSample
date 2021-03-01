import java.util.List;

public class Main {
	public static void main(String[] args) {
		DaoSample daoSample = new DaoSample();
		List<DtoSample> dtoSampleList = daoSample.findEmployee();

		for (DtoSample str : dtoSampleList) {
			System.out.println(str.getEmployeeId());
			System.out.println(str.getEmployeeName());
			System.out.println(str.getDepartmentId());
			System.out.println(str.getPhone());
			System.out.println("******************");
			System.out.println("******************");
		}
	}
}
