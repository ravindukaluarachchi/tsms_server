package com.tsms.entity;

import com.tsms.entity.Expense;
import com.tsms.entity.Vehicle;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T12:24:11")
@StaticMetamodel(Vehicle_Expense.class)
public class Vehicle_Expense_ { 

    public static volatile SingularAttribute<Vehicle_Expense, Long> id;
    public static volatile SingularAttribute<Vehicle_Expense, Float> amount;
    public static volatile SingularAttribute<Vehicle_Expense, Vehicle> vehicle;
    public static volatile SingularAttribute<Vehicle_Expense, Date> expenseDate;
    public static volatile SingularAttribute<Vehicle_Expense, String> remarks;
    public static volatile SingularAttribute<Vehicle_Expense, Expense> expenses;

}