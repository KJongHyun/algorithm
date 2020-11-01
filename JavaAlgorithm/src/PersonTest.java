public class PersonTest {

    public static void main(String[] args) {
        Person one = new Person(100, "김철수");
        System.out.println(one.no);
    }

}

class Person {
    int no = 10;
    String name;
    Person(int no) {
        this.no = no;
        System.out.println("Person(int no) 호출됨");
    }

    Person(int no, String name) {
        this(no);
        this.name = name;
        System.out.println("Person(int no, String name) 호출됨");
    }
}
