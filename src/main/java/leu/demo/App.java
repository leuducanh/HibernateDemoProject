package leu.demo;

import leu.demo.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        try {
            persist(sessionFactory);
            load(sessionFactory);
        } finally {
            sessionFactory.close();
        }
    }

    private static void load(SessionFactory sessionFactory) {
        System.out.println("-- loading persons --");
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Person> persons = session.createQuery("select p FROM Person p").list();
        persons.forEach((x) -> {
            x.setAge(10);
        });

        System.out.println(persons.get(0).getAge());

        session.beginTransaction();


        session.getTransaction().commit();
        session.close();
    }

    private static void persist(SessionFactory sessionFactory) {
        String[] s = new String[]{"a","b"};
        Person p1 = new Person("John", 35);
        p1.setId(1);
        Person p2 = new Person("Tina", 30);
        p2.setId(1);
        System.out.println("-- persisting persons --");
        System.out.printf("- %s%n- %s%n", p1, p2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
    }
}
