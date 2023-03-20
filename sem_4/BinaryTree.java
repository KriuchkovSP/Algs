// import java.util.ArrayList;

public class BinaryTree {
    Node root;

    private class Node{
        private int value;

        private Color color;
        private Node left;
        private Node right;
    }

    private enum Color {
        RED, BLACK
    }

    public boolean add(int value){
        if(root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
    private boolean addNode (Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            } 
        }
    }
    
    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance = true;
        while (needRebalance) {
            needRebalance = false;
            // чтобы сделать левого ребенка красным, повернем вправо
            if (result.right != null && result.right.color == Color.RED && (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            // 2 последовательно левые ноды красные не должны быть, поскольку у красной ноды дети черного цвета
            if (result.left != null && result.left.color == Color.RED && result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
                //чаще всего после этой операции снова нужна ребалансировка colorSwap
            }
            // У красной ноды все дети черного цвета - смена цвета
            if (result.left != null && result.left.color == Color.RED && result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        return result;
    }

    private Node rightSwap (Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        // делаем ноду красной
        node.color = Color.RED;
        return right;
    }

    private Node leftSwap (Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        // делаем ноду красной
        node.color = Color.RED;
        return left;
    }

    private void colorSwap (Node node) {
        //делаем ноду красной
        node.color = Color.RED;
        // а ее детей черными
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
    }

    // public void data_for_print(Node node, int level, ArrayList<String> data){
    //     if (node != null) {
    //         if (data.size() > level) {
    //             data.set(level, String.format("%s %2d %5s        ", data.get(level), node.value, node.color));
    //         } else {
    //             data.add(String.format("%d %5s         ", node.value, node.color));
    //         }
    //         data_for_print (node.left, level + 1, data);
    //         data_for_print (node.right, level + 1, data);
    //     } else {
    //         if (data.size() > level) {
    //             data.set(level, String.format("%s          ", data.get(level)));
    //         } else {
    //             data.add(String.format(""));
    //         }
    //     }
    // }

    // public void print(ArrayList<String> data) {
    //     for (int i = 0; i < data.size(); i++) {
    //         String temp = "";
    //         for (int j = 0; j < ((data.size() * 13) / 2) - (8 * i); j++) {
    //             temp += " ";
    //         }
    //         System.out.printf("%s%s\r\n",temp,data.get(i));
    //     }
    // }

}
