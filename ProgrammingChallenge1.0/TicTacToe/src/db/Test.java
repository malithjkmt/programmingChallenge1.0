/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malith
 */
public class Test {

    DbConnector dbConnector;
    PersonDAC personDAC;

    public Test() {
        try {
            dbConnector = new DbConnector();
            personDAC = new PersonDAC(dbConnector.getMyConn());

        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void add(Person person){
        try {
            personDAC.addPerson(person);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void update(Person person){
        try {
            personDAC.updatePerson(person);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(String name){
        try {
            personDAC.deletePerson(name);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        Test test = new Test();
        Person person = new Person("jaka",2,1,1,1,1,1,1,1);
        test.delete("jaka");
    }

}
