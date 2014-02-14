package com.tsms.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-16T12:24:11")
@StaticMetamodel(Expense.class)
public class Expense_ { 

    public static volatile SingularAttribute<Expense, Long> id;
    public static volatile SingularAttribute<Expense, Float> amount;
    public static volatile SingularAttribute<Expense, String> description;
    public static volatile SingularAttribute<Expense, String> name;

}