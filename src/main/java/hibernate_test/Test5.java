package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/** Изменение полей объекта в таблице */
public class Test5 {
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

            // Получили объект
            // Employee emp = session.get(Employee.class, 1);
            // Поменяли значение поля при этом поменялось значение в таблице
            // emp.setSalary(1500);

            session.createQuery("UPDATE Employee SET salary = 1000 WHERE name = 'Aleksandr'").
                    executeUpdate(); // выполнить обновление


            // Закрываем 1-ю сессию(транзакцию)
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close(); // обязательно закрыть factory
        }

    }
}
