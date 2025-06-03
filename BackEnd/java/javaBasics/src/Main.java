//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Omar", 21);
        System.out.print("Hello " + person.name()+ " and welcome!");


    }


}
record Person(String name ,int age ){}

