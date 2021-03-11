package com.info5059.casestudy.product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
/**
 * Product entity
 */
@Entity
@Data
@RequiredArgsConstructor
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private int vendorid;
    private String name;
    private BigDecimal costprice;
    private BigDecimal msrp;
    private int rop;
    private int eoq;
    private int qoh;
    private int qoo;
    private String qrcodetext;

    // needed in case 2
    @Basic(optional = true)
    @Lob
    private byte[] qrcode;

    public String getName() {
        return name;
    }

    public String getQrcodetext() {
        return qrcodetext;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setQrcode(byte[] qrcode) {
        this.qrcode = qrcode;
    }

    public int getQoo() {
        return qoo;
    }

    public int getEoq() {
        return eoq;
    }

    public int getQoh() {
        return qoh;
    }
}
