// class to create nodes
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

  // additional variable - flag - which stores information whether the value 
    // is found or not
    // the flag is set in searchTree() method
    public static boolean foundFlag = false;

  
  // Traverse search tree
  public static void traverseTree(Node node, int value) {
    if (node != null) {
      traverseTree(node.left, value);
      // System.out.print(" " + node.key);
      if (node.key == value)
            foundFlag = true;
      traverseTree(node.right, value);
    }
  }

    
    public static void searchTree(Node node, int searchedValue) {
        //Check whether the tree is empty
        if(node == null){
            System.out.println("Tree is empty");
        }
        else{
            //If value is found in the given binary tree then, set 
            //the flag to true
            if(node.key == searchedValue){
                foundFlag = true;
                return;
            }
            //Search in left subtree
            if(foundFlag == false && node.left != null){
                searchTree(node.left, searchedValue);
            }
            //Search in right subtree
            if(foundFlag == false && node.right != null){
                searchTree(node.right, searchedValue);
            }
        }
    }



    public static void main(String[] args) {
        // create an node object
        Node root = new Node(10);

        // create nodes of the tree
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
        
   
    }
}






