package inditex.productpriceservice.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "PRICES")
public class Price {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Transient
    private long id;

    @Column(name = "BRAND_ID")
    private int brandId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRICE_LIST")
    private int priceList;

    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CURR")
    private String currency;


    // Constructores
    public Price() {
    }
   

    public Price(int brandId, Date startDate, Date endDate, int priceList, long productId, int priority,
            double price, String currency) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }


    public String toString() {
        return "Product [id=" + id + ", brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate
                + ", priceList=" + priceList + ", productId=" + productId + ", priority=" + priority + ", price="
                + price + ", currency=" + currency + "]";
    }

    // Getters and setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getBrandId() {
        return brandId;
    }
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endtDate) {
        this.endDate = endtDate;
    }
    public int getPriceList() {
        return priceList;
    }
    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCurreny() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    


}
