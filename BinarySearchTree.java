class TreeNode {
    // Package access members
    TreeNode left;
    int data;
    TreeNode right;
    
    public TreeNode(int d){
        data = d;
        left = right = null; //Node has no children
    }
    
    public synchronized void insert(int d){
        if(d < data){
            if(left == null)
                left = new TreeNode(d);
            else
                left.insert(d);
        } else if(d >= data){
            if(right == null)
                right = new TreeNode(d);
            else
                right.insert(d);
        }
    }
}


class Tree {
    private TreeNode root;

    public Tree(){
        root = null;
    }

    public void insertNode(int d){
        if(root == null)
            root = new TreeNode(d);
        else
            root.insert(d);
    }
    
    public void remove(int d){
        root = remove(d, root);
    }

    private TreeNode remove(int d, TreeNode node){
        if(node == null)
            return node;
        if(d < node.data)
            node.left = remove(d, node.left);
        else if(d > node.data)
            node.right = remove(d, node.right);
        else if(node.left != null && node.right != null){
            node.data = findMax(node.left).data;
            node.left = remove(node.data, node.left);
        } else
            node = (node.left != null) ? node.left : node.right;
        return node;
    }

    private TreeNode findMax(TreeNode node){
        if(node != null)
            while(node.right != null)
                node = node.right;
        return node;
    }

    @Override
    public String toString(){
        if(isEmpty())
            return("");
        else
            return(printTree(root));
    } 

    private String printTree(TreeNode node){
        StringBuilder buf = new StringBuilder("");
        if(node != null){
            buf.append(printTree(node.left));
            buf.append(node.data + " ");
            buf.append(printTree(node.right));
        }
        return buf.toString();
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return sizeHelper(root);
    }

    public int sizeHelper(TreeNode node){
        if(node == null)
            return 0;
        return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }

    public int height(){
        return heightHelper(root);
    }

    public int heightHelper(TreeNode node){
        if(node == null)
            return 0;
        else
            return 1 + Math.max(heightHelper(node.left),
                    heightHelper(node.right));
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
    
        tree.insertNode(20);
        tree.insertNode(12);
        tree.insertNode(9);
        tree.insertNode(18);
        tree.insertNode(15);
        tree.insertNode(31);
        tree.insertNode(25);
        tree.insertNode(41);
        tree.insertNode(35);
        tree.insertNode(60);

        System.out.println("The BST contains the following integers:");
        System.out.println(tree);
        System.out.println("The BST contains " + tree.size() + " nodes, and has a height of " +
            tree.height() + '.');

        System.out.println("\nRemoving leaf node 9");
        tree.remove(9);

        System.out.println("The BST now contains the following integers:");
        System.out.println(tree);
        
        System.out.println("\nRemoving node with one child: 18");
        tree.remove(18);
        
        System.out.println("The BST now contains the following integers:");
        System.out.println(tree);

        System.out.println("The BST contains " + tree.size() + " nodes, and has a height of " +
            tree.height() + '.');

        System.out.println("\nAdding back node 9");
        tree.insertNode(9);

        System.out.println("Adding back node 18");
        tree.insertNode(18);

        System.out.println("The BST now contains the following integers:");
        System.out.println(tree);
    
    }
}
