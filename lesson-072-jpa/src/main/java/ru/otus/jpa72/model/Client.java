package ru.otus.jpa72.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private long id;
	private String fullName;
	private BigInteger phone;

	public Client() {}

	public Client(String fullName, BigInteger phone) {
		this.fullName = fullName;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", phone=" + phone +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (id != client.id) return false;
		if (fullName != null ? !fullName.equals(client.fullName) : client.fullName != null) return false;
		return phone != null ? phone.equals(client.phone) : client.phone == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
		return result;
	}
}
