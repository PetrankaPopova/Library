package library.model.bindingmodel;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


public class BookBindingModel {

    @Pattern(regexp = "[a-zA-Z]", message = "Title is not correct!")
    private String title;
    @Pattern(regexp = "[A-Z0-9]+", message = "ISBN number is not correct!")
    private String isbn;
    @Pattern(regexp = "[0-9]+", message = "Year is not correct!")
    private String yearOfIssue;
    @Pattern(regexp = "[a-zA-Z]+", message = "Publishing house is not correct")
    private String publishingHouse;
    @Pattern(regexp = "[a-zA-Z]+", message = "Availability status is not correct!")
    private String availabilityStatus;
    @Pattern(regexp = "[0-9]+", message = "Number of pages is not correct!")
    private int numberOfPages;
    @Pattern(regexp = "[a-zA-Z]+", message = "Cover Type is not correct!")
    private String coverType;
    @Pattern(regexp = "[a-zA-Z.;0-9-]+", message = "Content is not correct!")
    private String content;
    @Pattern(regexp = "[a-zA-Z.;0-9-]+", message = "Description is not correct!")
    private String description;
    @Pattern(regexp = "[a-zA-Z]+", message = "Language is not correct!")
    private String language;
    @Pattern(regexp = "[0-9]+", message = "Rating is not correct!")
    private double rating;
    @DecimalMin(value = "0.01", message = "Incorrect price!")
    @DecimalMax(value = "150.00", message = "Incorrect price!")
    private BigDecimal price;
    @DecimalMin(value = "1", message = "Incorrect quantity!")
    @DecimalMax(value = "100", message = "Incorrect quantity!")
    private int quantity;
    @DecimalMin(value = "1", message = "Incorrect quantity!")
    @DecimalMax(value = "100", message = "Incorrect quantity!")
    private BigDecimal discount;

    private AuthorBindingModel author;
    private SizeBindingModel size;
    private String[] categories;
    private MultipartFile[] photos;

    public BookBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(String yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public MultipartFile[] getPhotos() {
        return photos;
    }

    public void setPhotos(MultipartFile[] photos) {
        this.photos = photos;
    }
}
