package leu.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "full_name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "person")
    private List<PersonProfile> personProfiles;

    public Person() {
    }

    public Person(String name, int age, List<PersonProfile> personProfiles) {
        this.name = name;
        this.age = age;
        this.personProfiles = personProfiles;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<PersonProfile> getPersonProfiles() {
        return personProfiles;
    }

    public void setPersonProfiles(List<PersonProfile> personProfiles) {
        this.personProfiles = personProfiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
