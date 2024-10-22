package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
            if(Objects.equals(p.getName(), manager) && !(p instanceof Manager)) throw new ClassCastException(String.format("%s is not a %s", manager, Manager.class.getSimpleName().toLowerCase()));
            if(p instanceof Manager && Objects.equals(p.getName(), manager)) m = (Manager) p;
        }
        if(m == null) throw new NoSuchElementException(String.format("%s does not exist", manager));

        // get employee
        for(Person p : persons) {
            if(Objects.equals(p.getName(), employee) && !(p instanceof Employee)) throw new ClassCastException(String.format("%s is not an %s", employee, Employee.class.getSimpleName().toLowerCase()));
            if(p instanceof Employee && Objects.equals(p.getName(), employee)) e = (Employee) p;
        }
        if(e == null) throw new NoSuchElementException(String.format("%s does not exist", employee));

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
            if(Objects.equals(p.getName(), manager) && !(p instanceof Manager)) throw new ClassCastException(String.format("%s is not a %s", manager, Manager.class.getSimpleName().toLowerCase()));
            if(p instanceof Manager && Objects.equals(p.getName(), manager)) m = (Manager) p;
        }
        if(m == null) throw new NoSuchElementException(String.format("%s does not exist", manager));

        // get employee
        for(Person p : persons) {
            if(Objects.equals(p.getName(), developer) && !(p instanceof Developer)) throw new ClassCastException(String.format("%s is not a %s", developer, Developer.class.getSimpleName().toLowerCase()));
            if(p instanceof Employee && Objects.equals(p.getName(), developer)) d = (Developer) p;
        }
        if(d == null) throw new NoSuchElementException(String.format("%s does not exist", developer));

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
        Customer c = null;
        Employee e = null;

        for(Person p : persons) {
            if(Objects.equals(p.getName(), customer) && !(p instanceof Customer)) throw new ClassCastException(String.format("%s is not a %s", customer, Customer.class.getSimpleName().toLowerCase()));
            if(p instanceof Customer && Objects.equals(p.getName(), customer)) c = (Customer) p;
        }
        if(c == null) throw new NoSuchElementException(String.format("%s does not exist", customer));

        // get employee
        for(Person p : persons) {
            if(Objects.equals(p.getName(), employee) && !(p instanceof Employee)) throw new ClassCastException(String.format("%s is not an %s", employee, Employee.class.getSimpleName().toLowerCase()));
            if(p instanceof Employee && Objects.equals(p.getName(), employee)) e = (Employee) p;
        }
        if(e == null) throw new NoSuchElementException(String.format("%s does not exist", employee));

        return c.speak(e);
    }
}
