package leu.demo.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class PersonProfile {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private ZonedDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personId")
    private Person person;

    public PersonProfile() {
    }

    public PersonProfile(String address, ZonedDateTime date) {
        this.address = address;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}
