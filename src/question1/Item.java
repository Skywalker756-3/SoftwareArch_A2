/*
This is a leaf class of the composition structure,
 listComponents can contain 
 Items but items cannot contain listComponents
*/

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