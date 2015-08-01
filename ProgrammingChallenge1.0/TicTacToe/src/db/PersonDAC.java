/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malith
 */
public class PersonDAC {

    private final Connection myConn;

    public PersonDAC(Connection myConn) throws IOException, SQLException {
        this.myConn = myConn;
    }

    public Connection getMyConn() {
        return myConn;
    }

    /**
     * get all person to a List
     *
     */
    public List<Person> getAllPerson() throws Exception {

        List<Person> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from person");

            // load each person object to the Person List
            while (myRs.next()) {
                Person tempPerson = convertRowToPerson(myRs);
                list.add(tempPerson);
            }
            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * return the person object according to the name AC number
     *
     */
    public Person searchPerson(String keyWord) throws Exception {
        keyWord = "%"+keyWord +"%";
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        String query;
        Person person = null;
        query = "select * from person where Name like ?";
        myStmt = myConn.prepareStatement(query);
        myStmt.setString(1, keyWord);

        // execute statement
        myRs = myStmt.executeQuery();
        
        while (myRs.next()) {
            String name = myRs.getString(1);
            int singleTotalPlays = myRs.getInt(2);
            int singleEasyWins = myRs.getInt(3);
            int singleEasyDraws = myRs.getInt(4);
            int singleHardWins = myRs.getInt(5);
            int singleHardDraws = myRs.getInt(6);
            int multiTotalPlays = myRs.getInt(7);
            int multidraws = myRs.getInt(8);
            int multiWins = myRs.getInt(9);
            person = new Person(name, singleTotalPlays, singleEasyWins, singleEasyDraws, singleHardWins, singleHardDraws, multiTotalPlays, multidraws, multiWins);
            
        }
        return person;
       
    }

    /**
     * add a new person
     *
     */
    public void addPerson(Person person) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            //prepare statement
            myStmt = myConn.prepareStatement("INSERT INTO person (Name, SingleTotalPlays, SingleEasyWins, SingleEasyDraws, SingleHardWins, SingleHardDraws, MultiTotalPlays, Multidraws, MultiWins)values (?,?,?,?,?,?,?,?,?)");

            //set params
            myStmt.setString(1, person.getName());
            myStmt.setInt(2, person.getSingleTotalPlays());
            myStmt.setInt(3, person.getSingleEasyWins());
            myStmt.setInt(4, person.getSingleEasyDraws());
            myStmt.setInt(5, person.getSingleHardWins());
            myStmt.setInt(6, person.getSingleHardDraws());
            myStmt.setInt(7, person.getMultiTotalPlays());
            myStmt.setInt(8, person.getMultiWins());
            myStmt.setInt(9, person.getMultidraws());

            // execute the statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    public void updatePerson(Person person) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            //prepare statement
            myStmt = myConn.prepareStatement("update person set  SingleTotalPlays=?, SingleEasyWins=?, SingleEasyDraws=?, SingleHardWins=?, SingleHardDraws=?, MultiTotalPlays=?, Multidraws=?, MultiWins=? where Name=?");

            //set params
            myStmt.setInt(1, person.getSingleTotalPlays());
            myStmt.setInt(2, person.getSingleEasyWins());
            myStmt.setInt(3, person.getSingleEasyDraws());
            myStmt.setInt(4, person.getSingleHardWins());
            myStmt.setInt(5, person.getSingleHardDraws());
            myStmt.setInt(6, person.getMultiTotalPlays());
            myStmt.setInt(7, person.getMultiWins());
            myStmt.setInt(8, person.getMultidraws());
            myStmt.setString(9, person.getName());

            // execute the statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    public void deletePerson(String name) throws SQLException {
        PreparedStatement myStmt = null;
        try {
            // prepare statement
            myStmt = myConn.prepareStatement("delete from person where Name=?");

            //set param
            myStmt.setString(1, name);

            //execute statement
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    private Person convertRowToPerson(ResultSet myRs) throws SQLException {

        String name = myRs.getString(1);
        int singleTotalPlays = myRs.getInt(2);
        int singleEasyWins = myRs.getInt(3);
        int singleEasyDraws = myRs.getInt(4);
        int singleHardWins = myRs.getInt(5);
        int singleHardDraws = myRs.getInt(6);
        int multiTotalPlays = myRs.getInt(7);
        int multidraws = myRs.getInt(8);
        int multiWins = myRs.getInt(9);

        Person tempPerson = new Person(name, singleTotalPlays, singleEasyWins, singleEasyDraws, singleHardWins, singleHardDraws, multiTotalPlays, multidraws, multiWins);
        return tempPerson;
    }

    public void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

        if (myRs != null) {
            myRs.close();
        }
        if (myStmt != null) {
            myStmt.close();
        }
        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    private void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }

}
