package ru.otus.jpa72.model;

public class Order {
	private long id;

	private Client client;

	private String date;

	private int no;

	/*private List<OrderItem> items;

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}*/

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
			//	"\n: " + items +
				'}';
	}
}
