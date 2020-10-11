package library.model.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "banners")
public class Banner extends BaseEntity implements Serializable {

    private String companyName;
    private LocalDateTime startingDate;
    private LocalDateTime endingDate;
    private BigDecimal count;
    private double price;
    private List<String> imgurl;


    public Banner() {
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ElementCollection
    public List<String> getImgurl() {
        return imgurl;
    }

    public void setImgurl(List<String> imgurl) {
        this.imgurl = imgurl;
    }


    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "starting_date")
    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    @Column(name = "ending_date")
    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    @Column(name = "count")
    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
