package jpa73.repository;

import java.math.BigInteger;

public class Phone {

    String fullName;
    BigInteger phone;

    public Phone(String fullName, BigInteger phone) {
        this.fullName = fullName;
        this.phone = phone;
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
}
