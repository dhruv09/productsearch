package com.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails 
{
    @Id
    @Column(name="ITEM_ID")
	private long itemId;
    @Column(name="PARENTITEM_ID")
    private long parentItemId;
    @Column(name="NAME")
    private String name;
    @Column(name="SALE_PRICE")
    private double salePrice;
    @Column(name="SHORT_DESCRIPTION")
    @Type(type="text")
    private String shortDescription;
    @Column(name="LONG_DESCRIPTION")
    @Type(type="text")
    private String longDescription;
    @Column(name="BRAND_NAME")
    private String brandName;
    @Column(name="AVAILABLE_ONLINE")
    private Boolean availableOnline;
    @Column(name="COLOR")
    private String color;
    @Column(name="size")
    private String size;
   
    public String getColor() {
		return color;
	}

	public String getSize() {
		return size;
	}

	public long getItemId() {
		return itemId;
	}
	
	public long getParentItemId() {
		return parentItemId;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public Boolean getAvailableOnline() {
		return availableOnline;
	}
	
	 
	
	public UserDetails(long itemId, long parentItemId,String name,double salePrice,String shortDescription,String longDescription,String brandName,Boolean availableOnline,String color,String size)
	{
		this.itemId = itemId;
		this.parentItemId = parentItemId;
		this.name = name;
		this.salePrice = salePrice;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.brandName = brandName;
		this.availableOnline = availableOnline;
		this.color=color;
		this.size=size;
	}
	public UserDetails()
	{
		
	}
	@Override
    public String toString() {
 
        return this.itemId+" | "+this.parentItemId+" | "+this.name+" | "+this.salePrice+" | "+this.shortDescription+" | "+this.longDescription+" | "+this.brandName+" | "+this.availableOnline;
    }
}
