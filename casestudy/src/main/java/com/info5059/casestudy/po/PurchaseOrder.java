package com.info5059.casestudy.po;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
@Entity
@Data
@RequiredArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue
    private Long Id;
    private Long vendorid;
    private BigDecimal amount;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date podate;
    @OneToMany(mappedBy = "poid", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderLineItem> items = new ArrayList<PurchaseOrderLineItem>();

    public Long getId() {
        return Id;
    }

    public Date getPodate() {
        return podate;
    }

    public Long getVendorid() {
        return vendorid;
    }

    public void setVendorid(Long vendorid) {
        this.vendorid = vendorid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPodate(Date pd) {
       /* String pattern = "MM-dd-yyyy HH:mm.ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String c = simpleDateFormat.format(pd);
        Date d = pd;
        try {
             d =  simpleDateFormat.parse(c);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        this.podate = pd;
    }

    public List<PurchaseOrderLineItem> getItems() {
        return items;
    }

}
