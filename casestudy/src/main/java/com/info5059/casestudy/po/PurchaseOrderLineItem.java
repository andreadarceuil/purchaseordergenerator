package com.info5059.casestudy.po;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@RequiredArgsConstructor
public class PurchaseOrderLineItem {
    // PurchaseOrderLineitem private members
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long poid;
    private String productid;
    private int qty;
    private BigDecimal price;

    /*public void setProductQty(Product product, int qty) {
        product.setQoo(qty);
    }*/

    public void setPoid(Long poid) {
        this.poid = poid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
