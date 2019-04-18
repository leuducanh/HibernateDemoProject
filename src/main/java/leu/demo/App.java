package leu.demo;

import leu.demo.model.Person;
import leu.demo.model.PersonProfile;
import leu.demo.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory;
        try {
            persist(sessionFactory);
            persist(sessionFactory);
//            load(sessionFactory);
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
        List<PersonProfile> personProfiles = new ArrayList<>();
        personProfiles.add(new PersonProfile("abc", ZonedDateTime.now()));

        Person p1 = new Person("John", 35);
        p1.setPersonProfiles(personProfiles);
        Person p2 = new Person("Tina", 30);
        p2.setPersonProfiles(personProfiles);
        Person p3 = new Person("Tina", 30);
        p3.setPersonProfiles(personProfiles);
        System.out.println("-- persisting persons --");
        System.out.printf("- %s%n- %s%n", p1, p2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();

        session.beginTransaction();
        p1.setName(new String("John1"));
        List<PersonProfile> personProfiles1 = new ArrayList<>(10);
        personProfiles1.add(personProfiles.get(0));
        p2.setPersonProfiles(personProfiles1);
        session.save(p2);
        session.getTransaction().commit();

        session.close();
    }
}
