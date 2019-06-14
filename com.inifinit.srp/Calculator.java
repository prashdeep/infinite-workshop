public class Calculator {

    public int sum(int a, int b){
        return a + b;
    }

    public int sub(int a , int b ){
        return  a - b;
    }

    public int multiply(int a , int b){
        return a * b;
    }

    public static void main(String args[]){
        new Calculator().sum(23, 45);
    }
}