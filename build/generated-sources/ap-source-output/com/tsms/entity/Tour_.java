package com.tsms.entity;

import com.tsms.entity.Customer;
import com.tsms.entity.Driver;
import com.tsms.entity.Location;
import com.tsms.entity.Vehicle;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T12:24:11")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, Calendar> startDate;
    public static volatile SingularAttribute<Tour, Integer> noOfDays;
    public static volatile SingularAttribute<Tour, Integer> status;
    public static volatile SingularAttribute<Tour, Location> location;
    public static volatile SingularAttribute<Tour, String> paymentType;
    public static volatile SingularAttribute<Tour, Vehicle> vehicle;
    public static volatile SingularAttribute<Tour, Long> startMeter;
    public static volatile SingularAttribute<Tour, Customer> customer;
    public static volatile SingularAttribute<Tour, Calendar> endTime;
    public static volatile SingularAttribute<Tour, Long> id;
    public static volatile SingularAttribute<Tour, Calendar> startTime;
    public static volatile SingularAttribute<Tour, Float> distance;
    public static volatile SingularAttribute<Tour, Float> rate;
    public static volatile SingularAttribute<Tour, Driver> driver;
    public static volatile SingularAttribute<Tour, Long> endMeter;

}