package library.model.bindingmodel;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class BookBindingModel {

    private String title;
    private String isbn;
    private String[] categories;
    private String yearOfIssue;
    private String publishingHouse;
    private String availabilityStatus;
    private int numberOfPages;
    private String coverType;
    private String content;
    private String description;
    private String language;
    private double rating;
    private BigDecimal price;
    private int quantity;
    private BigDecimal discount;

    private AuthorBindingModel author;
    private SizeBindingModel size;

    private String[] photos;

    public BookBindingModel() {
    }

    public AuthorBindingModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBindingModel author) {
        this.author = author;
    }

    public SizeBindingModel getSize() {
        return size;
    }

    public void setSize(SizeBindingModel size) {
        this.size = size;
    }

    //@Pattern(regexp = "[a-zA-Z]", message = "Title is not correct!")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //@Pattern(regexp = "[A-Z0-9]+", message = "ISBN number is not correct!")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //???
    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    //@Pattern(regexp = "[0-9]+", message = "Year is not correct!")
    public String getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(String yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    //@Pattern(regexp = "[a-zA-Z]+", message = "Publishing house is not correct")
    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    //@Pattern(regexp = "[a-zA-Z]+", message = "Availability status is not correct!")
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    //@Pattern(regexp = "[0-9]+", message = "Number of pages is not correct!")
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    //@Pattern(regexp = "[a-zA-Z]+", message = "Cover Type is not correct!")
    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    //@Pattern(regexp = "[a-zA-Z.;0-9-]+", message = "Content is not correct!")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //@Pattern(regexp = "[a-zA-Z.;0-9-]+", message = "Content is not correct!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //@Pattern(regexp = "[a-zA-Z]+", message = "Language is not correct!")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    //@Pattern(regexp = "[0-9]+", message = "Rating is not correct!")
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    //@DecimalMin(value = "0.01", message = "Incorrect price!")
    //@DecimalMax(value = "150.00", message = "Incorrect price!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //@DecimalMin(value = "1", message = "Incorrect quantity!")
    //@DecimalMax(value = "100", message = "Incorrect quantity!")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //@DecimalMin(value = "1", message = "Incorrect discount!")
    //@DecimalMax(value = "100", message = "Incorrect discount!")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    //???
    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }
}