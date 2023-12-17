public class TreeNode {
    private int data;
    private int height;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int data){
        this.data = data;
        height = 0;
        left = null;
        right = null;
    }

    TreeNode(int data, int h){
        this.data = data;
        height = h;
        left = null;
        right = null;
    }

    TreeNode add(int data, TreeNode node){
        return add(data, node, -1);
    }

    TreeNode add(int data, TreeNode node, int h){
        h++;
        if(node==null){
            node = new TreeNode(data, h);
        }
        else{
            if(node.data > data){
                node.left = add(data, node.goLeft(), h);
            }
            else{
                node.right = add(data, node.goRight(), h);
            }
        }
        return node;
    }

    boolean isLeaf(){
        return (left==null && right==null);
    }

    void printPretty(TreeNode node){
        if (node != null){
            printPretty(node.goRight());
            for(int x = 0; x < node.height; x++){
                System.out.print("   ");
            }
            System.out.println(node.data);
            printPretty(node.goLeft());
        }
    }

    void printInOrder(TreeNode node){
        if (node != null){
            printInOrder(node.goLeft());
            System.out.print(node.data + ", ");
            printInOrder(node.goRight());
        }
    }
    //Get
    TreeNode goLeft(){
        return left;
    }

    TreeNode goRight(){
        return right;
    }
}
