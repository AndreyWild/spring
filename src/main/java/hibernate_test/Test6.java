package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** Удаление объекта из таблицы */
public class Test6 {
    public static void main(String[] args) {
        // Создаем фабрику по производству сессий
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // применть файл конфигурации, знает как создавать сессии
                .addAnnotatedClass(Employee.class) // используем класс Employee который имеет аннотации для работы с БД
                .buildSessionFactory(); // создать SessionFactory с указанными параметрами

        try {
            // Создаем сессию
            Session session = factory.getCurrentSession();
            // Открываем 1-ю транзакицю
            session.beginTransaction();


             Employee emp = session.get(Employee.class, 10);
             // Удаляем объект из таблицы
             session.delete(emp);

            // Удаляем объект с определенным параметром
            // session.createQuery("DELETE Employee WHERE name = 'Aleksandr'").executeUpdate();

            // Закрываем 1-ю сессию(транзакцию)
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close(); // обязательно закрыть factory
        }

    }
}
