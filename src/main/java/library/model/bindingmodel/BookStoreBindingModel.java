package library.model.bindingmodel;

import javax.validation.constraints.Pattern;

public class BookStoreBindingModel {

    private String storeName;
    private String storePhoneNumber;
    private String storeHoursOfOperation;
    private String country;
    private String region;
    private String postCode;
    private String city;
    private String streetAddress;
    private String streetNumber;
    private String vatNumber;
    private String information;
    private String termsAndConditions;
    private String faq;

    public BookStoreBindingModel() {
    }

    @Pattern(regexp = "[a-zA-Z ]+", message = "Incorrect store name!")
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Pattern(regexp = "[0-9- ]+", message = "Incorrect store number!")
    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    //???
    public String getStoreHoursOfOperation() {
        return storeHoursOfOperation;
    }

    public void setStoreHoursOfOperation(String storeHoursOfOperation) {
        this.storeHoursOfOperation = storeHoursOfOperation;
    }

    @Pattern(regexp = "[a-zA-Z ]+", message = "Incorrect country name!")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Pattern(regexp = "[a-zA-Z ]+", message = "Incorrect region name!")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Incorrect post code!")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Pattern(regexp = "[a-zA-Z ]+", message = "Incorrect city name!")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Pattern(regexp = "[a-zA-Z ]+", message = "Incorrect street!")
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Incorrect street number!")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Pattern(regexp = "[a-zA-Z0-9 ]+", message = "Incorrect vat name!")
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Pattern(regexp = "[a-zA-Z0-9. ]+", message = "Incorrect information!")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Pattern(regexp = "[a-zA-Z0-9.\\- ]+", message = "Incorrect terms and conditions!")
    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    @Pattern(regexp = "[a-zA-Z0-9.\\-? ]+", message = "Incorrect faq!")
    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }
}
