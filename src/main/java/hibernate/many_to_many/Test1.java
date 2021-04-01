package hibernate.many_to_many;


import hibernate.many_to_many.entiti.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        // Создаем фабрику по производству сессий
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // применть файл конфигурации, знает как создавать сессии
                .addAnnotatedClass(Section.class) // используем класс Employee который имеет аннотации для работы с БД
                .addAnnotatedClass(Child.class) // используем класс Detail который имеет аннотации для работы с БД
                .buildSessionFactory(); // создать SessionFactory с указанными параметрами

        Session session = null;

        try{
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Basketball");
//            Child child1 = new Child("Andrey", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasja", 6);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            ****************************************************************************

//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//
//
//            Child child1 = new Child("Igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            ****************************************************************************

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            ****************************************************************************

            session = factory.getCurrentSession();
            session.beginTransaction();

            Child child = session.get(Child.class, 4);

            System.out.println(child);
            System.out.println(child.getSections());


            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }



    }






}
