package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        // Создаем фабрику по производству сессий
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // применть файл конфигурации, знает как создавать сессии
                .addAnnotatedClass(Employee.class) // используем класс Employee который имеет аннотации для работы с БД
                .buildSessionFactory(); // создать SessionFactory с указанными параметрами

        try {
            // Создаем сессию
            Session session = factory.getCurrentSession();
            // Создаем объект класса Employee
            Employee emp = new Employee("Andrey", "Wild", "IT", 500);
            // Открываем транзакицю
            session.beginTransaction();
            // Сохраняем объект в тблице employees
            session.save(emp);
            // Закрываем сессию
            session.getTransaction().commit();
        } finally {
            factory.close(); // обязательно закрыть factory
        }

    }
}
