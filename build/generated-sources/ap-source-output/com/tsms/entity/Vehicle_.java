package com.tsms.entity;

import com.tsms.entity.Expense;
import com.tsms.entity.Supplier;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T12:24:11")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, Long> id;
    public static volatile SingularAttribute<Vehicle, Date> licenceExpiryDate;
    public static volatile SingularAttribute<Vehicle, String> model;
    public static volatile SingularAttribute<Vehicle, String> color;
    public static volatile SingularAttribute<Vehicle, String> number;
    public static volatile SingularAttribute<Vehicle, Integer> seatCapacity;
    public static volatile SingularAttribute<Vehicle, Date> insuranceExpiryDate;
    public static volatile SingularAttribute<Vehicle, Supplier> supplier;
    public static volatile ListAttribute<Vehicle, Expense> expenses;

}