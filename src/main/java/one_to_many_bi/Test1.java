package one_to_many_bi;


import one_to_many_bi.entiti.Department;
import one_to_many_bi.entiti.Employee;
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
//            Department department = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Andrey", "Wild", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//
//            department.addEmployeeToDepartment(emp1); // добавляем в депратамент работников
//            department.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//            ****************************************************************************************

            /* Получаем информацию о работниках департамента*/
//            session = factory.getCurrentSession(); // создаем сессию
//            session.beginTransaction();
//
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
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

            session = factory.getCurrentSession(); // создаем сессию
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);

            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");



        } finally {
            session.close(); // закрываем сессию в finally если в try выскочил ERROR
            factory.close(); // обязательно закрыть factory
        }

    }
}
