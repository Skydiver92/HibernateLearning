import com.kuzmenko.hibernatelearning.dao.EmployeeDAOImpl;
import com.kuzmenko.hibernatelearning.dao.HibernateUtil;
import com.kuzmenko.hibernatelearning.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class StoreData {

    public static void main( String[] args )
    {

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
//        Session session = employeeDAO.getSession();
//        Transaction t = session.beginTransaction();

        Employee e1=new Employee();
        e1.setId(14);
        e1.setFirstName("Robert");
        e1.setLastName("Jonson");

        employeeDAO.add(e1);
        List<Employee> list = employeeDAO.getAll();
        for (Employee em : list) {
            System.out.println(em.toString());
        }

        System.out.println(employeeDAO.getByID(3).toString());
        employeeDAO.update(new Employee(3,"Bob","Hartly"));
        employeeDAO.remove(new Employee(1,"Robert","Jonson"));
//        session.save(e1);
//        t.commit();
//        System.out.println("successfully saved");
        employeeDAO.closeSession();
    }
}  