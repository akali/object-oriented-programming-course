import ThirdTask.MyCollection;
import ThirdTask.MyLinkedList;
import ThirdTask.MyVector;

public class Main {
    public static void main(String args[]){
        MyLinkedList ll= new MyLinkedList();

        MyCollection v = new MyVector();

        for (int i = 1; i <= 10; ++i) {
            ll.add(i * i - i);
            v.add(i * i - i);
        }

        for (int j = 0; j < 10; ++j) {
            ll.add(j, j * j + 256);
            v.add(j, j*j+256);
        }

        System.out.println(ll);
        System.out.println(v);
        
        System.out.println(ll.toString());
        System.out.println( v.toString());
    }
}
