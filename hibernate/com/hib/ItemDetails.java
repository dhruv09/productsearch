package com.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="productlist")
public class ItemDetails {

	    @Id
	    @Column(name="item_id")
		public long itemId;
		@Column(name="name")
	    public String name;
	    @Column(name="type")
	    public String type;
	    
	    
ItemDetails()
{
	
		this.itemId = itemId;
		this.name = name;
		this.type = type;
	
}
     }
