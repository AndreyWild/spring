package hibernate.loading_types;



import hibernate.loading_types.entiti.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        // Создаем фабрику по производству сессий
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // применть файл конфигурации, знает как создавать сессии
                .addAnnotatedClass(Employee.class) // используем класс Employee который имеет аннотации для работы с БД
                .addAnnotatedClass(Department.class) // используем класс Detail который имеет аннотации для работы с БД
                .buildSessionFactory(); // создать SessionFactory с указанными параметрами

        Session session = null; // объявляем сессию

        try {
//            session = factory.getCurrentSession(); // создаем сессию
//
//            Department department = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Andrey", "Wild", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            department.addEmployeeToDepartment(emp1); // добавляем в депратамент работников
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            ****************************************************************************************

            /* Получаем информацию о работниках департамента*/
            session = factory.getCurrentSession(); // создаем сессию
            session.beginTransaction();

            System.out.println("Get department.");
            Department department = session.get(Department.class, 3);

            System.out.println("Show department.");
            System.out.println(department);
            System.out.println("Show employees of the department.");
            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done!");

//            ****************************************************************************************

            /* Получаем информацию о департаменте через работника*/
//            session = factory.getCurrentSession(); // создаем сессию
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            ****************************************************************************************

//            session = factory.getCurrentSession(); // создаем сессию
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 2);
//
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



        } finally {
            session.close(); // закрываем сессию в finally если в try выскочил ERROR
            factory.close(); // обязательно закрыть factory
        }

    }
}
