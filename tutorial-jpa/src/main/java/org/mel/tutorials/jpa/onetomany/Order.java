package org.mel.tutorials.jpa.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.tutorials.jpa.IDEntity;

@Entity
@Table(name="T_ORDER")
public class Order extends IDEntity {
	@Column(name="ORDER_NO", length = 50, nullable = false)
	private String orderNo;

	@Column(name="AMOUNT", nullable = false)
	private Float amount = 0F;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="order")
	private Set<OrderItem> items = new HashSet<OrderItem>();

	public void addItem(OrderItem item) {
		if (!items.contains(item)) {
			items.add(item);
		}
	}

	public void removeItem(OrderItem item) {
		if (items.contains(item)) {
			items.remove(item);
		}
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Order() {
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
