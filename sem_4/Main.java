import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();
        int nums = 20;
        int max = 30;
        // int rnd = ThreadLocalRandom.current().nextInt(0, max) + 1;
        for (int i = 0; i < nums; i++) {
            binTree.add(ThreadLocalRandom.current().nextInt(0, max) + 1);
            //binTree.add(i);
        }
        // Красивая печать не вышла...
        // ArrayList<String> data = new ArrayList<>();
        // binTree.data_for_print(binTree.root, 0, data);
        // binTree.print(data);
    }
}