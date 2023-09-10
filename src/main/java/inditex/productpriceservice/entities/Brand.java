package inditex.productpriceservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BRANDS")
public class Brand {
    
    @Id
    @Column(name = "BRAND_ID")
    private int id;

    @Column(name = "BRAND_NAME")
    private String brandName;


    // Constructores
    public Brand() {
    }


    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }


    // Getters y Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
