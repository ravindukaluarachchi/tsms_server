/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rav.ws;

import com.tsms.entity.Expense;
import java.util.List;

/**
 *
 * @author ravindu
 */
public class ExpenseHolder {
    private List<Expense> expenses;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
    
}
