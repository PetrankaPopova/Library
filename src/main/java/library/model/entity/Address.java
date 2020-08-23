package library.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{

    private String Street;
    private String City;
    private String State;
    private String Zip;

    public Address() {
    }

    @Column(name = "street", nullable = false, unique = true)
    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }


    @Column(name = "city", nullable = false, unique = true)
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Column(name="state", nullable = false)
    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Column(name = "zip", nullable = false)
    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }
}
