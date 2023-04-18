package jpa73.model;

import javax.persistence.*;

@Entity
@Table(name = "orders") /// !!!
public class Order {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne//(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Client client;

	private String date;

	private int no;

	/*  раскомментировать когда дойдем
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> items;

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", client=" + client +
				", date='" + date + '\'' +
				", no=" + no +
				//"\n: " + items +
				'}';
	}
}
