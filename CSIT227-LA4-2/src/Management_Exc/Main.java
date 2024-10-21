package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        // get manager
        Manager m = null;
        Employee e = null;

        for(Person p : persons) {
            if(p.getName() == manager && !(p instanceof Manager)) throw new ClassCastException("name is not a/n " + Manager.class.getSimpleName());
            if(p instanceof Manager && p.getName() == manager) m = (Manager) p;
        }
        if(m == null) throw new NoSuchElementException("“name does not exist");

        // get employee
        for(Person p : persons) {
            if(p.getName() == employee && !(p instanceof Employee)) throw new ClassCastException("name is not a/n " + Employee.class.getSimpleName());
            if(p instanceof Employee && p.getName() == employee) e = (Employee) p;
        }
        if(e == null) throw new NoSuchElementException("“name does not exist");

        m.giveRaise(e, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        // get manager
        Manager m = null;
        Developer d = null;

        for(Person p : persons) {
            if(p.getName() == manager && !(p instanceof Manager)) throw new ClassCastException("name is not a/n " + Manager.class.getSimpleName());
            if(p instanceof Manager && p.getName() == manager) m = (Manager) p;
        }
        if(m == null) throw new NoSuchElementException("“name does not exist");

        // get employee
        for(Person p : persons) {
            if(p.getName() == developer && !(p instanceof Developer)) throw new ClassCastException("name is not a/n " + Developer.class.getSimpleName());
            if(p instanceof Employee && p.getName() == developer) d = (Developer) p;
        }
        if(d == null) throw new NoSuchElementException("“name does not exist");

        d.setProjectManager(m);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws IllegalArgumentException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        return null;
    }
}
