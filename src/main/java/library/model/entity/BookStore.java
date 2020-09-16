package library.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_store")

public class BookStore extends BaseEntity {

    private String storeName;
    private String storePhoneNumber;
    private String storeHoursOfOperation;
    private Address address;
    private String vatNumber;
    private String information;
    private String termsAndConditions;
    private String faq;


    public BookStore() {
    }

    @Column(name = "storeName", nullable = false)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Column(name = "storePhoneNumber", nullable = false)
    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    @Column(name = "storeHoursOfOperation", nullable = false)
    public String getStoreHoursOfOperation() {
        return storeHoursOfOperation;
    }

    public void setStoreHoursOfOperation(String storeHoursOfOperation) {
        this.storeHoursOfOperation = storeHoursOfOperation;
    }

    @OneToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "vatNumber", nullable = false)
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Column(name = "information", nullable = false)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Column(name = "termsAndConditions", nullable = false)
    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    @Column(name = "faq", nullable = false)
    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }
}
