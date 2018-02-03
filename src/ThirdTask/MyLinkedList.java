package ThirdTask;

public class MyLinkedList extends MyCollection {
    Node head = null, tail = null;

    public void add(int value) {
        if (tail == null) {
            head = tail = new Node(value);
        } else {
            Node n = new Node(value);
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
    }

    @Override
    public void add(int index, int element) {
        Node n = new Node(element);
        if (index == 0) {
            n.setNext(head);
            head.setPrev(n);
            head = n;
            if (n.getNext() == null)
                tail = n;
        } else {
            Node tmp = getOnPosition(index);
            n.setNext(tmp.getNext());
            tmp.getNext().setPrev(n);
            tmp.setNext(n);
        }
    }

    private Node getOnPosition(int position) {
        if (position == 0) return head;
        Node cur = head;
        for (int i = 0; i < position; ++i) {
            cur = cur.getNext();
        }
        if (cur.getPrev() == null) return cur;
        return cur.getPrev();
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public boolean contains(int o) {
        return indexOf(o) != -1;
    }

    public int get(int position){
        return getOnPosition(position).getValue();
    }

    @Override
    public int indexOf(int o) {
        Node tmp=head;
        int i = 1;
        do {
            if(tmp.getValue()==o){
                return i;
            }
            tmp=tmp.getNext();
            i++;
        } while (tmp != tail);
        return -1;
    }

    @Override
    public void insertElementAt(int element, int index) {
        add(element,index);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void removeAt(int index) {
        if (index == 0) {
            head = (head.getNext());
            head.setPrev(null);
        } else {
            Node n = getOnPosition(index);

            // if (n.getPrev() !=  null) {
                n.getPrev().setNext(n.getNext());
                n.getNext().setPrev(n.getPrev());
            // } else {
            //    head = head.getNext();
            // }
        }
    }

    @Override
    public void remove(int element) {
        Node tmp=head;
        int i = 1;
        do {
            if(tmp.getValue() == element){
                removeAt(i);
                break;
            }
            ++i;
        } while (tmp != tail);
    }

    @Override
    public void removeAll(int element) {
        do
            if (head.getValue() == element) {
                head = head.getNext();
                head.setPrev(null);
            } else
                break;
        while (head != tail);

        Node prev = head, cur = head;
        do {
            if (element == cur.getValue()) {
                prev.setNext(cur.getNext());
                cur.getNext().setPrev(prev);
            } else {
                prev = cur;
            }
            cur = cur.getNext();
        } while(cur != tail);
    }

    @Override
    public void reverse() {
        Node l = head, r = tail;
        do {
             swap(l, r);
             if (l.getNext() == r) break;
             l = l.getNext();
             r = r.getPrev();
        } while (l != r);
    }

    // 5 5 1 4 7 8

    private void swap(Node a, Node b) {
        int t = a.getValue();
        a.setValue(b.getValue());
        b.setValue(t);
    }

    public void set(int value, int position){
        getOnPosition(position).setValue(value);
    }

    @Override
    public int size() {
        Node tmp=head;
        int i = 0;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            ++i;
        }
        return i;
    }

    @Override
    public void sort() {

    }

    @Override
    public int[] toArray() {
        int[] array=new int[size()+1];
        Node tmp=head;
        for(int i=0;i<size();i++){
            array[i]=tmp.getValue();
            tmp=tmp.getNext();
        }
        return array;
    }

    public void mergeSort() {

    }

    @Override
    public String toString() {
        Node tmp=head;
        String str=new String();
        str+="[";
        for(int i=0;i<=size();i++){
            str+=tmp.getValue();
            tmp=tmp.getNext();

            if(i!=size())str+=", ";
        }
        return str+"]";
    }
}