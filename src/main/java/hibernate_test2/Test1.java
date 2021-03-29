package hibernate_test2;


import hibernate_test2.entiti.Detail;
import hibernate_test2.entiti.Employee;
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
//            // Создаем сессию
//            Session session = factory.getCurrentSession();
//
//            // Создаем объект Employee
//            Employee employee = new Employee("Andrey", "Wild", "IT", 500);
//            // Создаем объект Detail
//            Detail detail = new Detail("Pinsk", "123456789", "andrei@mail.ru");
//
//            // Присваиваем Employee его Detail
//            employee.setEmpDetail(detail);
//
//
//            // Открываем транзакицю
//            session.beginTransaction();
//
//
//            // Сохряняю данные в таблицу
//            session.save(employee);
//
//
//            // Закрываем сессию
//            session.getTransaction().commit();
//
//            System.out.println("Done!");


//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Moscow", "987654321", "smirnov@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            session = factory.getCurrentSession(); // создаем сессию
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 10); // получаем объект Employee с id = 1
//            System.out.println(emp.getEmpDetail()); // выводим Detail полученного объекта
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session = factory.getCurrentSession(); // создаем сессию
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 2); // получаем объект Employee с id = 2
            session.delete(emp); // Удалится объект Employee и привязанный к нему Detail

            session.getTransaction().commit();
            System.out.println("Done!");


        } finally {
            session.close(); // закрываем сессию в finally если в try выскочил ERROR
            factory.close(); // обязательно закрыть factory
        }

    }
}
