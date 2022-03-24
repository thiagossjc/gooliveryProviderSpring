package com.engrenelog.engrenemc.domains;
 	
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class OrderItem implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
	
		
	public OrderItem() {		
	}

	public OrderItem(OrderCustomer orderCustomer, Product product, Double discount, Integer quantity, Double price) {
		super();
		
		id.setOrderCustomer(orderCustomer);
		id.setProduct(product);
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}
	
	//get na frente del nombre para Json reconhecer e exibir
	public double getSubTotal() { 
		return (price - discount)* quantity;
	}
	
	

	@JsonIgnore
	public OrderCustomer getOrderCustomer() {
		return id.getOrderCustomer();
	}
	
	
	public void setOrderCustomer(OrderCustomer order) {
		id.setOrderCustomer(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product prodc) {
		id.setProduct(prodc);
	}
	
	public OrderItemPK getId() {
		return id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		NumberFormat numbFormt = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		StringBuilder builder = new StringBuilder();
		builder.append(this.getProduct().getName());
		builder.append(" , Quant: ");		
		builder.append(this.getQuantity());
		builder.append(", Unit Price: ");
		builder.append(numbFormt.format(this.getPrice()));
		builder.append(" ,SubTotal: ");
		builder.append(numbFormt.format(this.getSubTotal()));
		builder.append("\n");
		builder.append("]");
		return builder.toString();
	}

}