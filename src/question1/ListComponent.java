package question1;

public abstract class ListComponent {
    
    public abstract void printValue();
    
    // Default test case implementations that throw exceptions for leaf nodes
    public void addChild(int index, ListComponent child) {
        throw new UnsupportedOperationException("Current operation is not supported for this object");
    }
    
    public void removeChild(int index) {
        throw new UnsupportedOperationException("Current operation is not supported for this object");
    }
    
    public ListComponent getChild(int index) {
        throw new UnsupportedOperationException("Current operation is not supported for this object");
    }
}