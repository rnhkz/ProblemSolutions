public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    TreeNode add(int data, TreeNode node){
        if(node==null){
            node = new TreeNode(data);
        }
        else{
            if(!node.isEnd(node)) {
                node.left = add(data, node.goLeft());
                node.right = add(data, node.goRight());
            }
        }
        return node;
    }

    boolean isEnd(TreeNode node){
        TreeNode n;
        if(node.left!=null){
            n = node.left;
            if(n.left==null && n.right==null && n.data ==-1){
                return true;
            }
        }
        if(node.right!=null){
            n = node.right;
            if(n.left==null && n.right==null && n.data ==-1){
                return true;
            }
        }
        return false;
    }

    void print(TreeNode node){
        if (node != null){
            System.out.print(node.data + " ");
            print(node.goLeft());
            print(node.goRight());
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
