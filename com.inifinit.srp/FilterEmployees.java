import java.util.Arrays;
import java.util.*;

public class FilterEmployees{
    public static void main(String args[]){
        Employee emp1 = new Employee(2,"Vinay", 45000, 24);
        Employee emp2 = new Employee(3,"Hari", 55000, 28);
        Employee emp3 = new Employee(4,"Nandish", 65000, 30);
        Employee emp4 = new Employee(6,"Kiran", 25000, 20);
        Employee emp5 = new Employee(10,"Ajay", 65000, 30);
        Employee emp6 = new Employee(14,"Harish", 90000, 36);
        Employee emp7 = new Employee(22,"Lokesh", 60000, 24);

        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        list.add(emp7);

        filterEmployees(new FilterEmployeeByAgeLt30(), list).stream().forEach(employee -> System.out.println(employee));
    }

   /* private static List<Employee> filterEmployees(List<Employee> employees){
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
                if(employee.getAge() < 30){
                    //add to the a new list
                    filteredEmployees.add(employee);
                }
        }
        return filteredEmployees;
    }*/

    // improved version with Open closed principle
    private static List<Employee> filterEmployees( Filter<Employee> applyFilter, List<Employee> employees){
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
                if(applyFilter.filter(employee)){
                    //add to the a new list
                    filteredEmployees.add(employee);
                }
        }
        return filteredEmployees;
    }
}

interface Filter<T>{
    boolean filter(T t);
}

class FilterEmployeeByAgeLt30 implements Filter<Employee>{
    public boolean filter(Employee employee){
        return employee.getAge() < 30;
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee ( int id, String name, double salary, int age){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String toString(){
        return (" { "+ "id = "+ this.id + "name = "+ this.name + " salary = "+ this.salary + " age = "+ this.age + "}");
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public int getId(){
        return this.id;
    }
}