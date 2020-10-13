package library.model.bindingmodel;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

import static library.constant.GlobalConstants.*;

public class BannerAddBindingModel {

    private String companyName;
    private LocalDateTime startingDate;
    private LocalDateTime endingDate;
    private double price;

    public BannerAddBindingModel() {
    }

    @Length(min = 3, max = 20, message = COMPANY_NAME_SIZE)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = DATE_IN_FUTURE)
    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = DATE_IN_FUTURE)
    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    @DecimalMin(value = "0",message = VALID_PRICE)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
