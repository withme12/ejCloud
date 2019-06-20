package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.OrderLine;
import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.Address;
public class OrderExtend extends Order {
    private Customer customer;
    private OrderLine order_line;
    private Waiter waiter;
    private Comment comment;
    private Address address;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderLine getOrder_line() {
        return order_line;
    }

    public void setOrder_line(OrderLine order_line) {
        this.order_line = order_line;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
