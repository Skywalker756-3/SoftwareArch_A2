package question1;

import java.util.ArrayList;
import java.util.List;

public class ListComposite extends ListComponent {
    private List<ListComponent> children = new ArrayList<>();

    @Override
    public void printValue() {
        System.out.print("[ ");
        for (ListComponent child : children) {
            child.printValue();
        }
        System.out.print("] ");
    }

    @Override
    public void addChild(int index, ListComponent child) {
        children.add(index, child);
    }

    @Override
    public void removeChild(int index) {
        children.remove(index);
    }

    @Override
    public ListComponent getChild(int index) {
        return children.get(index);
    }
    
    // Helper method to let the Builder know where to append
    public int getChildrenCount() {
        return children.size();
    }
}