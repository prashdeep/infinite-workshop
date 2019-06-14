
public class LiskovSustitution {
    public static void main(String args[]){

    }
}

abstract class Employee {
    private int id;
    private String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public abstract void benifits();
}

class RegularEmployee extends Employee {
    private int vacationDays;
    private double salary;

    public RegularEmployee(int id, String name, int vacationDays, double salary){
        super(id, name);
        this.vacationDays = vacationDays;
        this.salary = salary;
    }

    public void benifits(){
        System.out.println("Can take EL leaves ");
        System.out.println("Can go for onsite trips");
    }

}

class ContractEmployee extends Employee {
    private int fixedDuration;
    private double payPerHour;

    public ContractEmployee(int id, String name, int duration, double payPerHour){
        super(id, name);
        this.vacationDays = vacationDays;
        this.salary = salary;
    }

    public void benifits(){
        throw new RuntimeException("Benifits do not apply for this class");
    }
}