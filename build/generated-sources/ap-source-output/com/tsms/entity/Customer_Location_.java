package com.tsms.entity;

import com.tsms.entity.Customer;
import com.tsms.entity.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T12:24:11")
@StaticMetamodel(Customer_Location.class)
public class Customer_Location_ { 

    public static volatile SingularAttribute<Customer_Location, Long> id;
    public static volatile SingularAttribute<Customer_Location, Float> rate;
    public static volatile SingularAttribute<Customer_Location, Location> location;
    public static volatile SingularAttribute<Customer_Location, Customer> customer;

}