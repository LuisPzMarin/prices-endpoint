package com.regegal.pricesapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table

public class Price {

    @Column(nullable = false)
    private Long brandId;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int priceList;

    @Column(nullable = false)
    private Long productId;


    private int priority;

    @Column(nullable = false)
    private Double price;
    @Enumerated(EnumType.STRING)
    private Currency curr;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Price() {
    }

    public Price(Long brandId, Date startDate, Date endDate, int priceList, Long productId, int priority, Double price, Currency curr, Long id) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public int getPriceList() {
        return this.priceList;
    }

    public Long getProductId() {
        return this.productId;
    }

    public int getPriority() {
        return this.priority;
    }

    public Double getPrice() {
        return this.price;
    }

    public Currency getCurr() {
        return this.curr;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Price)) return false;
        final Price other = (Price) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$brandId = this.getBrandId();
        final Object other$brandId = other.getBrandId();
        if (this$brandId == null ? other$brandId != null : !this$brandId.equals(other$brandId)) return false;
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
        final Object this$endDate = this.getEndDate();
        final Object other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) return false;
        if (this.getPriceList() != other.getPriceList()) return false;
        if (this.getProductId() != other.getProductId()) return false;
        if (this.getPriority() != other.getPriority()) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$curr = this.getCurr();
        final Object other$curr = other.getCurr();
        if (this$curr == null ? other$curr != null : !this$curr.equals(other$curr)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Price;
    }



    public String toString() {
        return "Price(brandId=" + this.getBrandId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", priceList=" + this.getPriceList() + ", productId=" + this.getProductId() + ", priority=" + this.getPriority() + ", price=" + this.getPrice() + ", curr=" + this.getCurr() + ", id=" + this.getId() + ")";
    }
}
