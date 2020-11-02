package com.structuralpatterns.proxy;

import java.sql.Connection;

public class Solution {
    public static void main(String[] args) throws Exception{
        EmployeeManagerProxy obj = new EmployeeManagerProxy();
        System.out.println(obj.getAllRows());
        obj.deleteAllRows();
    }
}

/**
 * Below interface signifies the queries that can be performed the table
 * You would have many other methods as well
 */
interface Query {
    public String getAllRows() throws Exception;
    public void deleteAllRows();
    public String getRowById(int id);
}


/**
 * Performs the queries on a table & also has extra states & behaviours
 * Below class normally would also contain many other operations
 * Here we have omitted other methods & variables to make things simple
 * we don't want to create as many objects as we want on this real table which is responsible for actual operations
 * You might create many objects as you want but you won't end up using it i.e., in this case not calling any methods on the object
 * So, all those objects would actually occupy space on the stack which is not used at all
 * The proxy pattern can be used in scenarios where the creation of the object is costly
 */
class EmployeeManager implements Query {

    EmployeeManager() {
        // Perform initialization of many variables
        // Makes db calls for fetching prerequisite data
        // Also perform logging
    }


    @Override
    public String getAllRows() {
        // contains logic for getting all rows
        return "Real object: data of all rows";
    }


    @Override
    public void deleteAllRows() {
        // logic for delete all rows
        System.out.println("Real object: Deleted all rows");
    }


    @Override
    public String getRowById(int id) {
        // logic for getting row by id
        return "one row";
    }


    /**
     * makes the connection to the db
     * @return - Connection object
     */
    public Connection getConnection() {
        // has the connection logic
        // loads the driver and makes the connection
        return null;
    }

}



/**
 * Acts as a placeholder for original object
 * Proxy controls the access to the original object
 * Proxy can also perform some additional security checks
 *
 */

class EmployeeManagerProxy implements Query {
    // Reference for original object
    // Below reference is private so we have controlled the access to original object
    private EmployeeManager employee;

    EmployeeManagerProxy() {
        // perform initialization
        // we are not creating the real object(Employee) inside the proxy constructor
        // we create the employee object only when a method of the proxy is called
        // Simply put, we are creating the object only on demand
    }

    @Override
    public String getAllRows() throws Exception{
        if (!hasEnoughPermissions()) {
            throw new Exception("Access denied");
        }
        EmployeeManager obj = getEmployeeManagerObject();
        return obj.getAllRows();
    }


    @Override
    public void deleteAllRows() {
        EmployeeManager obj = getEmployeeManagerObject();
        obj.deleteAllRows();
    }


    @Override
    public String getRowById(int id) {
        EmployeeManager obj = getEmployeeManagerObject();
        return obj.getRowById(id);
    }

    /**
     * creates or returns the employee object when invoked
     * It is made private so the clients cannot call this method
     * @return - Employee
     */
    private synchronized EmployeeManager getEmployeeManagerObject() {
        if (employee == null) {
            employee = new EmployeeManager();
        }
        return employee;
    }

    private boolean hasEnoughPermissions() {
        return true;
    }

}




