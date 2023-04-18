package jpa73.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private long id;

	private String item;

	private int no;

	private int quantity;

	public OrderItem() {
	}

	public OrderItem(String item, int no, int quantity) {
		this.item = item;
		this.no = no;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem{" +
				"id=" + id +
				", item='" + item + '\'' +
				", no=" + no +
				", quantity=" + quantity +
				'}';
	}
}
