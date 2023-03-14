public class Main {
    public static void main(String[] args) {
//        myList L = new myList();
//        for(int i=1; i<=1; i++)
//            L.pushBack(i);
//
//        L.print();
//        L.popBack();
//        L.print();

        myDList dL = new myDList();
        for (int i = 0; i < 10; i++) {
            dL.pushFront(i);
        }

        dL.print();
        dL.reverse();
        dL.print();

    }
}