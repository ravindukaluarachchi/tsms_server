/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsmsws;

import com.tsms.controller.ExpenseJpaController;
import com.tsms.controller.VehicleJpaController;
import com.tsms.controller.CustomerJpaController;
import com.tsms.controller.TourJpaController;
import com.tsms.controller.SupplierJpaController;
import com.tsms.controller.DriverJpaController;
import com.tsms.entity.Customer;
import com.tsms.entity.Vehicle;
import com.tsms.entity.Driver;
import com.tsms.entity.Supplier;
import com.tsms.entity.Expense;
import com.tsms.entity.Tour;
import com.rav.ws.CustomerHolder;
import com.rav.ws.DriverHolder;
import com.rav.ws.ExpenseHolder;
import com.rav.ws.LocationHolder;
import com.rav.ws.SupplierHolder;
import com.rav.ws.TsmsException;
import com.rav.ws.TourHolder;
import com.rav.ws.VehicleHolder;
import com.rav.ws.Vehicle_ExpenseHolder;
import com.tsms.controller.LocationJpaController;
import com.tsms.controller.Vehicle_ExpenseJpaController;
import com.tsms.entity.Location;
import com.tsms.entity.Vehicle_Expense;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.NoResultException;

/**
 *
 * @author ravindu
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WS {

    @WebMethod
    public void createCustomer(Customer customer) throws TsmsException {
        try {
            new CustomerJpaController().create(customer);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editCustomer(Customer customer) throws TsmsException {
        try {
            new CustomerJpaController().edit(customer);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void destroyCustomer(Long id) throws TsmsException {
        try {
            new CustomerJpaController().destroy(id);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public CustomerHolder findCustomerEntites() {
        List<Customer> customers = new CustomerJpaController().findCustomerEntities();
        CustomerHolder ch = new CustomerHolder();
        ch.setCustomers(customers);
        return ch;
    }

    @WebMethod
    public Customer findCustomer(Long id) {
        return new CustomerJpaController().findCustomer(id);
    }

    //Driver 
    @WebMethod
    public void createDriver(Driver driver) throws TsmsException {
        try {
            new DriverJpaController().create(driver);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editDriver(Driver driver) throws TsmsException {
        try {
            new DriverJpaController().edit(driver);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void destroyDriver(String nic) throws TsmsException {
        try {
            new DriverJpaController().destroy(nic);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public DriverHolder findDriverEntites() {
        DriverHolder dh = new DriverHolder();
        dh.setDrivers(new DriverJpaController().findDriverEntities());
        return dh;
    }

    @WebMethod
    public Driver findDriver(String nic) {
        return new DriverJpaController().findDriver(nic);
    }

    //Expense
    @WebMethod
    public void createExpense(Expense expense) throws TsmsException {
        try {
            new ExpenseJpaController().create(expense);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editExpense(Expense expense) throws TsmsException {
        try {
            new ExpenseJpaController().edit(expense);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void destroyExpense(Long id) throws TsmsException {
        try {
            new ExpenseJpaController().destroy(id);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public ExpenseHolder findExpenseEntites() {
        ExpenseHolder eh = new ExpenseHolder();
        eh.setExpenses(new ExpenseJpaController().findExpenseEntities());
        return eh;
    }

    @WebMethod
    public Expense findExpense(Long id) {
        return new ExpenseJpaController().findExpense(id);
    }

    //Supplier
    @WebMethod
    public void createSupplier(Supplier supplier) throws TsmsException {
        try {
            new SupplierJpaController().create(supplier);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editSupplier(Supplier supplier) throws TsmsException {
        try {
            new SupplierJpaController().edit(supplier);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void destroySupplier(Long id) throws TsmsException {
        try {
            new SupplierJpaController().destroy(id);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public SupplierHolder findSupplierEntites() {
        SupplierHolder sh = new SupplierHolder();
        sh.setSuppliers(new SupplierJpaController().findSupplierEntities());
        return sh;
    }

    @WebMethod
    public Supplier findSupplier(Long id) {
        return new SupplierJpaController().findSupplier(id);
    }

    //Tour
    @WebMethod
    public void createTour(Tour tour) throws TsmsException {
        try {
            new TourJpaController().create(tour);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editTour(Tour tour) throws TsmsException {
        try {
            new TourJpaController().edit(tour);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void destroyTour(Long id) throws TsmsException {
        try {
            new TourJpaController().destroy(id);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public TourHolder findTourEntites() {
        TourHolder th = new TourHolder();
        th.setTours(new TourJpaController().findTourEntities());
        return th;
    }

    @WebMethod
    public Tour findTour(Long id) {
        return new TourJpaController().findTour(id);
    }

    //Vehicle
    @WebMethod
    public void createVehicle(Vehicle vehicle) throws TsmsException {
        try {
            new VehicleJpaController().create(vehicle);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editVehicle(Vehicle vehicle) throws TsmsException {
        try {
            new VehicleJpaController().edit(vehicle);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void destroyVehicle(Long id) throws TsmsException {
        try {
            new VehicleJpaController().destroy(id);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public VehicleHolder findVehicleEntites() {
        VehicleHolder vh = new VehicleHolder();
        vh.setVehicles(new VehicleJpaController().findVehicleEntities());
        return vh;
    }

    @WebMethod
    public Vehicle findVehicle(Long id) {
        return new VehicleJpaController().findVehicle(id);
    }

    @WebMethod
    public void addExpenseToVehicle(Vehicle vehicle, Expense expense) {
    }

    @WebMethod
    public void addExpensesToVehicle(Vehicle vehicle, ExpenseHolder expenseHolder) {
    }

    @WebMethod
    public Customer login(String username, String password) {
        try {
            return new CustomerJpaController().findCustomer(username, password);
        } catch (NoResultException e) {
            return new Customer();
        }
    }

    @WebMethod
    public void requestTour(Long customerId, String date, int noOfDates, String time, Long locationId, int noOfVehicles) throws TsmsException {
        System.out.println("customer id " + customerId);
        System.out.println("date : " + date);
        System.out.println("no of dates " + noOfDates);
        System.out.println("time " + time);
        System.out.println("location " + locationId);
        System.out.println("no of vehicles " + noOfVehicles);
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        DateFormat tf = new SimpleDateFormat("hh:mm aa");

        try {
            Date d = df.parse(date);
            System.out.println("d : " + d);
            Date t = tf.parse(time);
            System.out.println("t : " + t);
            Calendar cd = Calendar.getInstance();
            cd.setTime(d);

            Calendar ct = Calendar.getInstance();
            ct.setTime(t);
            new TourJpaController().create(customerId, cd, noOfDates, ct, locationId, noOfVehicles);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public TourHolder getRequestedTours() {
        TourHolder th = new TourHolder();
        th.setTours(new TourJpaController().findRequestedTours());
        return th;
    }

    @WebMethod
    public void createLocation(Location location) throws TsmsException {
        try {
            new LocationJpaController().create(location);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editLocation(Location location) throws TsmsException {
        try {
            new LocationJpaController().edit(location);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public LocationHolder findLocations() {
        LocationHolder lh = new LocationHolder();
        lh.setLocations(new LocationJpaController().findLocationEntities());
        return lh;
    }

    @WebMethod
    public void createVehicleExpense(Vehicle_Expense ve) throws TsmsException {
        try {

            new Vehicle_ExpenseJpaController().create(ve);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public void editVehicleExpense(Vehicle_Expense ve) throws TsmsException {
        try {
            System.out.println("############\n ve :  " + ve.toString() + "\n\n");
            new Vehicle_ExpenseJpaController().edit(ve);
        } catch (Exception e) {
            throw new TsmsException(e.getMessage());
        }
    }

    @WebMethod
    public Vehicle_ExpenseHolder findVehicleExpenses() {
        Vehicle_ExpenseHolder veh = new Vehicle_ExpenseHolder();
        veh.setVehicle_Expenses(new Vehicle_ExpenseJpaController().findVehicle_ExpenseEntities());
        return veh;
    }

    @WebMethod
    public Vehicle_ExpenseHolder findVehicleExpensesByMonth(Integer month) {
        Vehicle_ExpenseHolder veh = new Vehicle_ExpenseHolder();
        veh.setVehicle_Expenses(new Vehicle_ExpenseJpaController().findVehicle_ExpenseEntitiesByMonth(month));
        return veh;

    }

    @WebMethod
    public Vehicle_ExpenseHolder findVehicleExpensesByMonthAndVehicle(Long vehicleId, Integer month) {
        Vehicle_ExpenseHolder veh = new Vehicle_ExpenseHolder();
        veh.setVehicle_Expenses(new Vehicle_ExpenseJpaController().findVehicle_ExpenseEntitiesByMonth(vehicleId, month));
        return veh;
    }

    @WebMethod
    public Vehicle_ExpenseHolder findVehicleExpensesByVehicle(Long vehicleId) {
        Vehicle_ExpenseHolder veh = new Vehicle_ExpenseHolder();
        veh.setVehicle_Expenses(new Vehicle_ExpenseJpaController().findVehicle_ExpenseEntities(vehicleId));
        return veh;
    }
    
    @WebMethod
    public TourHolder findCustomerTours(Long customerId,Integer month){
        TourHolder th = new TourHolder();
        th.setTours(new TourJpaController().findTours(customerId, month));
        return th;
    }
    
    @WebMethod
    public TourHolder findCustomerAllTours(Long customerId){
        TourHolder th = new TourHolder();
        th.setTours(new TourJpaController().findTours(customerId));
        return th;
    }
    
    @WebMethod
    public TourHolder findTours(Integer month){
        TourHolder th = new TourHolder();
        th.setTours(new TourJpaController().findTours(month));
        return th;
    }
}
