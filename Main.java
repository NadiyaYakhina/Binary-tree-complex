class Node {
    int key;
    Node left;
    Node right;

    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }
}

class Main {

    public static boolean foundFlag = false;
    public static int sum = 0;
    public static int counter = 0;
  
    public static void traverseTree(Node node, int value) {
        if (node != null) {
            traverseTree(node.left, value);
            if (node.key == value)
                foundFlag = true;
            traverseTree(node.right, value);
        }
    }

    public static void searchTree(Node node, int searchedValue) {
        if(node == null){
            System.out.println("Tree is empty");
        }
        else{
            if(node.key == searchedValue){
                foundFlag = true;
                return;
            }
            if(foundFlag == false && node.left != null){
                searchTree(node.left, searchedValue);
            }
            if(foundFlag == false && node.right != null){
                searchTree(node.right, searchedValue);
            }
        }
    }
    
    //Sum tree
    public static int sumTree(Node node) {
        if (node.left != null) { sumTree(node.left); }
        sum += node.key;
        if (node.right != null) { sumTree(node.right); }
        return sum;
    }
    
    //Mean tree
    public static int meanTree(Node node) {
        if (node.left != null) { meanTree(node.left); }
        sum += node.key;
        counter++;
        if (node.right != null) { meanTree(node.right); }
        return sum/counter;
    }



    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
        root.left.left.left = new Node(12);
        root.left.left.right = new Node(17);
        root.left.right.right = new Node(14);
        root.left.right.left = new Node(41);
        
        long startTime = System.currentTimeMillis();
        for(long i = 0; i < 100000000; i++){
                foundFlag = false;
                traverseTree(root, 7);
            }
        long endTime = System.currentTimeMillis();
        System.out.println(foundFlag);
        System.out.println("TraverseTree: " + (endTime - startTime));    
        
        
        
        startTime = System.currentTimeMillis();
        for(long i = 0; i < 100000000; i++){
                foundFlag = false;        
                searchTree(root, 7);
            }
        endTime = System.currentTimeMillis();
        System.out.println(foundFlag);
        System.out.println("SearchTree: " + (endTime - startTime)); 
        
        
        startTime = System.currentTimeMillis();
        for (long i=0; i<100000000;i++) {
            sum = 0;
            sumTree(root);
        }
        endTime = System.currentTimeMillis();
        sum = 0;
        System.out.println(sumTree(root));
        System.out.println("SumTree: " + (endTime - startTime));
        
        startTime = System.currentTimeMillis();
        for (long i=0; i<100000000;i++) {
            sum = 0;
            sumTree(root);
        }
        endTime = System.currentTimeMillis();
        sum = 0;
        counter = 0;
        System.out.println(meanTree(root));
        System.out.println("MeanTree: " + (endTime - startTime));
    }
}







