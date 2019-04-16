package leu.demo.model;

import javax.persistence.*;
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
    private Set<PersonProfile> personProfiles;

    public Person() {
    }

    public Person(String name, int age, Set<PersonProfile> personProfiles) {
        this.name = name;
        this.age = age;
        this.personProfiles = personProfiles;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
