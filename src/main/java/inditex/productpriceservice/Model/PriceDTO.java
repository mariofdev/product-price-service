package inditex.productpriceservice.Model;

import java.util.Date;

public class PriceDTO {

    private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private long productId;
    private double price;


    // Constructores
    public PriceDTO() {
    }
   

    public PriceDTO(int brandId, Date startDate, Date endDate, int priceList, long productId,
            double price) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.price = price;
    }


    public String toString() {
        return "Product [brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate
                + ", priceList=" + priceList + ", productId=" + productId + ", price="
                + price + "]";
    }

    // Getters and setters
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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    


}

    
}
