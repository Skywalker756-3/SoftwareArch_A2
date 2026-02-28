package question3;

import java.util.ArrayList;

// Subject = Changing 
public class ArrayListSubject {

    private ArrayList<String> list;
    private ArrayList<Observer> observers;

    public ArrayListSubject() {
        list = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // attach
    public void addObserver(Observer o) {
        observers.add(o);
    }

    // detach
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // notify
    private void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void append(String item) {
        list.add(item);
    }

    public void delete(String item) {
       // notify observer when delete is called
        notifyObservers();
        list.remove(item);
    }

    public void printList() {
        System.out.println(list);
    }
}

// Observer interface
interface Observer {
    void update();
}

// Concrete Observer
class DeleteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("an item being deleted");
    }
}