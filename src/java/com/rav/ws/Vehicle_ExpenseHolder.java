/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rav.ws;

import com.tsms.entity.Vehicle_Expense;
import java.util.List;

/**
 *
 * @author ravindu
 */
public class Vehicle_ExpenseHolder {
    
    private List<Vehicle_Expense> vehicle_Expenses;

    public List<Vehicle_Expense> getVehicle_Expenses() {
        return vehicle_Expenses;
    }

    public void setVehicle_Expenses(List<Vehicle_Expense> vehicle_Expenses) {
        this.vehicle_Expenses = vehicle_Expenses;
    }        
    
}
