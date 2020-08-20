package Company1;

public class Main {


    public static void main(String[] args) {



    }

    public boolean add(E value){
        Element newElem = new Element(value);
        if(head==null){
            head==newElem;
            return true;
        }
        Element tail=head;
        while (tail.getNext() != null)
            tail = tail.getNext();
            tail.setNext(newElem);
            return true;

    }
}
