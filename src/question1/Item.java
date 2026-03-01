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