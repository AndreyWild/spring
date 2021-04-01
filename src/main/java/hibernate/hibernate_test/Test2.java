package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        // Создаем фабрику по производству сессий
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // применть файл конфигурации, знает как создавать сессии
                .addAnnotatedClass(Employee.class) // используем класс Employee который имеет аннотации для работы с БД
                .buildSessionFactory(); // создать SessionFactory с указанными параметрами

        try {
            /** Добавление объекта в одной сессии, получение в другой */
            // Создаем сессию
            Session session = factory.getCurrentSession();
            // Создаем объект класса Employee
            Employee emp = new Employee("Oleg", "Sidorov", "HR", 700);
            // Открываем 1-ю транзакицю
            session.beginTransaction();
            // Сохраняем объект в тблице employees
            session.save(emp);
            // Закрываем 1-ю транзакицю
            session.getTransaction().commit();

            int myId = emp.getId();
            // Создаем сессию
            session = factory.getCurrentSession();
            // Открываем 2-ю транзакицю(сессию)
            session.beginTransaction();
            // Получаю объект через указаие класса и ключа объекта(id)
            Employee employee = session.get(Employee.class, myId);
            // Закрываем 2-ю сессию(транзакцию)
            session.getTransaction().commit();

            System.out.println(employee);

            System.out.println("Done!");
        } finally {
            factory.close(); // обязательно закрыть factory
        }

    }
}
