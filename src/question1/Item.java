//I changed the class and method names to match up with the uml diagram
//also fixed the logic a bit, constructive criticism is appreciated :D

package question1;

public class Item extends ListComponent {
    private int value;

    public Item(int value) {
        this.value = value;
    }

    @Override
    public void printValue() {
        System.out.print(value + " ");
    }
}