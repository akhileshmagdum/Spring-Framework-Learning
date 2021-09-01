package com.akhilesh;

import com.akhilesh.validation.CustomerId;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    @NotNull(message = "Please Fill the name")
    @Size(min = 2,max=15,message = "Please enter valid name")
    private String firstName;

    @NotNull(message = "Please Fill the name")
    @Size(min = 2,max=15,message = "Please enter valid name")
    private String lastName;

    @NotNull(message = "Can't be empty")
    @Min(value = 0,message = "can't be negative")
    @Max(value = 10,message = "can't be more than 10")
    private Integer cardPoints;

    @CustomerId
    private String customerIdentity;

    public Customer(){ }

    public String getCustomerIdentity() {
        return customerIdentity;
    }

    public void setCustomerIdentity(String customerIdentity) {
        this.customerIdentity = customerIdentity;
    }

    public Integer getCardPoints() {
        return cardPoints;
    }

    public void setCardPoints(Integer cardPoints) {
        this.cardPoints = cardPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
