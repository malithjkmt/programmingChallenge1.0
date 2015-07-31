package ui;

import db.Person;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Malith
 */
public class PersonTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "SingleTotalPlays", "SingleEasyWins", "SingleEasyDraws", "SingleHardWins", "SingleHardDraws", "MultiTotalPlays", "Multidraws", "MultiWins",};// this should come from user input..... user can customize what fields to show
    private List<Person> person;

    public PersonTableModel(List<Person> thePerson) {
        person = thePerson;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return person.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Person tempPerson = person.get(row);

        switch (col) {
            case 0:
                return tempPerson.getName();
            case 1:
                return tempPerson.getSingleTotalPlays();
            case 2:
                return tempPerson.getSingleEasyWins();
            case 3:
                return tempPerson.getSingleEasyDraws();
            case 4:
                return tempPerson.getSingleHardWins();
            case 5:
                return tempPerson.getSingleHardDraws();
            case 6:
                return tempPerson.getMultiTotalPlays();
            case 7:
                return tempPerson.getMultiWins();
            case 8:

                return tempPerson.getMultidraws();
            case -1:

                return tempPerson;

            default:
                return tempPerson.getName();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
