package question3;

public class Main {

    public static void main(String[] args) {

        ArrayListSubject subject = new ArrayListSubject();

        // observer
        DeleteObserver obs = new DeleteObserver();
        subject.addObserver(obs);

        // test
        subject.append("A");
        subject.append("B");
        subject.append("C");

        System.out.print("Before delete: ");
        subject.printList();

        subject.delete("B");

        System.out.print("After delete:  ");
        subject.printList();
    }
}