package one_to_one;



import one_to_one.entiti.Detail;
import one_to_one.entiti.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        // Создаем фабрику по производству сессий
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // применть файл конфигурации, знает как создавать сессии
                .addAnnotatedClass(Employee.class) // используем класс Employee который имеет аннотации для работы с БД
                .addAnnotatedClass(Detail.class) // используем класс Detail который имеет аннотации для работы с БД
                .buildSessionFactory(); // создать SessionFactory с указанными параметрами

        Session session = null; // объявляем сессию

        try {

            /* Связь One-to-One */
//            session = factory.getCurrentSession(); // создаем сессию
//
//            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
//            Detail detail = new Detail("New-York", "963258741", "niko@gmail.com");
//
//            employee.setEmpDetail(detail); // добавляем работнику детали
//            detail.setEmployee(employee); // добавляем к деталям работника
//
//            session.beginTransaction();
//
//            session.save(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            /* Получаем информацию о работнике из деталей */
//            session = factory.getCurrentSession(); // создаем сессию
//            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session = factory.getCurrentSession(); // создаем сессию
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null); // разрываю связь между работником и деталями
            session.delete(detail); // удаляем детали
            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            session.close(); // закрываем сессию в finally если в try выскочил ERROR
            factory.close(); // обязательно закрыть factory
        }

    }
}
