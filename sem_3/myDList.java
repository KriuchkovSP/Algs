public class myDList {
    Node Head, Tail;
    private class Node{
        int value;
        Node next;
        Node prev;
    }

    public void pushFront(int value){
        Node node = new Node();
        node.value = value;

        if(Head == null){
            Tail = node;
        }else{
            if(Head.next == null){
                Head.prev = node;
                node.next = Head;
            }else{
                node.next = Head;
                Head.prev = node;
            }
        }
        Head = node;
    }

    public void reverse(){
        Node temp;
        Node current = Head;
        Tail = current;
        while(current != null) {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            Head = current;
            current = temp;
        }
        

    }

    public void print(){
        Node current = Head;
        while(current != null){
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }
}
