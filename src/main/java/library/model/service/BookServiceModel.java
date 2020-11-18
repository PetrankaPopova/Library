package library.model.service;

import library.model.bindingmodel.AuthorBindingModel;
import library.model.bindingmodel.SizeBindingModel;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceModel extends BaseServiceModel {

    private String title;
    private String isbn;
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
    private MultipartFile[] photos;
    private String[] categories;
    private SizeServiceModel size;
    private AuthorServiceModel author;
    private List<CategoryServiceModel> category;

    public BookServiceModel() {
    }


}
