package test3;

import javax.sound.sampled.SourceDataLine;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (current.getValue() == node.getValue()) {
                return;
            }
            if (value < current.getValue()) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(node);
                    break;
                }
                current = current.getLeftChild();
            } else {
                if (current.getRightChild() == null) {
                    current.setRightChild(node);
                    break;
                }
                current = current.getRightChild();
            }
        }
    }

    public boolean find(int value){

        Node current= root;
        while(current!=null){
            if( value < current.getValue()){
                current = current.getLeftChild();
            }else if (value > current.getValue()){
                current = current.getRightChild();
            }
         else{
             return true;
            }
        }
        return false;   
     }

     public void traversePreOrder(){
       traversePreOrder(root);
     }

     public void traverseInOrder(){
        traverseInOrder(root);
      }

      public void traversePostOrder(){
        traversePostOrder(root);
      }

     private void traversePreOrder(Node root){
         if(root==null){
             return;
         }
         System.out.print(root.getValue()+" ");
         traversePreOrder(root.getLeftChild());
         traversePreOrder(root.getRightChild());
     }

     private void traverseInOrder(Node root){
        if(root==null){
            return;
        }
        traverseInOrder(root.getLeftChild());
        System.out.print(root.getValue()+" ");
        traverseInOrder(root.getRightChild());
    }

    private void traversePostOrder(Node root){
        if(root==null){
            return;
        }
        traversePostOrder(root.getLeftChild());
        traversePostOrder(root.getRightChild());
        System.out.print(root.getValue()+" ");
    }


    public int height(){
        return height(root);
    }

    public int height(Node root){
        if(root == null){
            return -1;
        }
        if (root.getLeftChild()==null || root.getRightChild()==null){
            return 0;
        }

        return 1 + Math.max(height(root.getLeftChild()),
                     height(root.getRightChild()));

    }

    public int min(){
        return min(root);
    }

    private boolean isLeaf(Node root){
        return root.getLeftChild()==null || root.getRightChild()==null;
    }

    private int min(Node root){
        if (root== null){
            return -1;
        }
        if(isLeaf(root)){
            return root.getValue();
        }
        int left = min(root.getLeftChild());
        int right= min(root.getRightChild());
        return Math.min(Integer.min(left,right), root.getValue());
    }



}
