import java.util.List;

public class Main {
    public static void main(String[] args) {
        DaoSample daoSample = new DaoSample();
        List<DtoSample> dtoSampleList = daoSample.findEmployee();

        for (DtoSample str : dtoSampleList) {
            System.out.println(str.getName());
            System.out.println(str.getAddress());
            System.out.println(str.getPhone());
            System.out.println("******************");
        }
    }
}
