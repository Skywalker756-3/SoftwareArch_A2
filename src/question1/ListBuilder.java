/*
the following are the methods used as per the UML Diagram
1. buildOpenBranket()
2. buildCloseBracket()
3. buildElement()

Using the methods of this class
clients can build their list and 
potentially it's sublists, utilizing the 
composite architecture
 */


package question1;

import java.util.Stack;

public class ListBuilder {
    private ListComponent root;
    private Stack<ListComposite> stack;

    public ListBuilder() {
        stack = new Stack<>();
    }

    public void buildOpenBracket() {
        ListComposite composite = new ListComposite();
        // If this is the very much the first bracket, it's our root
        if (root == null) {
            root = composite;
        } 
        // If we are already inside a list, add this new list as a child
        else if (!stack.isEmpty()) {
            ListComposite parent = stack.peek();
            parent.addChild(parent.getChildrenCount(), composite);
        }
        
        // Push the new list onto the stack so we can add elements to it
        stack.push(composite);
    }

    public void buildCloseBracket() {
        if (!stack.isEmpty()) {
            stack.pop(); // We are done with this list, step back out
        }
    }

    public void buildElement(int element) {
        if (!stack.isEmpty()) {
            Item item = new Item(element);
            ListComposite parent = stack.peek();
            parent.addChild(parent.getChildrenCount(), item);
        }
    }

    public ListComponent getList() {
        return root;
    }
}