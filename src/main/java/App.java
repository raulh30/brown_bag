import dao.EmployeeDAO;
import entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {


        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
        EmployeeDAO dao = (EmployeeDAO) ctx.getBean("EmployeeDao");

        Employee me = new Employee();
        me.setFirstName("John");
        me.setLastName("Doe");
        dao.save(me);

        System.out.println("Sucess!");


    }
}
