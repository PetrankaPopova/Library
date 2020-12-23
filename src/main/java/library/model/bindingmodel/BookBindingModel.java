package library.model.bindingmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
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




}
