package hibernate.hibernate_test;

import hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4 {
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

            // Получаем список всех работников
//            List<Employee> emps = session.
//                    createQuery("FROM Employee"). // создаем (Query) запрос на получение всех объектов
//                    getResultList(); // получаем результат в виде List

            // Получаем список всех работников по имени
            List<Employee> empsName = session.
                    createQuery("FROM Employee WHERE name = 'Aleksandr' AND salary > 700").
                    getResultList();

            for (Employee emp : empsName){
                System.out.println(emp);
            }

            // Закрываем 1-ю сессию(транзакцию)
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close(); // обязательно закрыть factory
        }

    }
}
