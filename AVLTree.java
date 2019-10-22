import org.omg.CORBA.NO_IMPLEMENT;

public class AVLTree<Value extends Indexable> {
    private Node<Value> root;

    public void insert(Node<Value> node) {
//        if (root == null) {
//            root = node;
//            return;
//        }
//        root.insert(node);

    }



    public void insert(Value value) {

        //insert(new Node<Value>(value));

        root = insert(new Node<Value>(value),root);
    }

    private Node<Value> insert(Node<Value> node, Node<Value> parent) {
        if (parent==null){
            return node;
        }
        if (node.getValue().getKey()==parent.getValue().getKey()){
            parent.setValue(node.getValue());
            return parent;
        }
        if (node.getValue().getKey()<parent.getValue().getKey()){
            parent.setLeft(insert(node,parent.getLeft()));
        }else {
            parent.setRight(insert(node,parent.getRight()));
        }
        return balance(parent);
    }

    private Node<Value> balance(Node<Value> node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor>=-1 && balanceFactor<=1){
            return node;
        }else if (balanceFactor>1){
            //TODO L
            if (node.getLeft().getBalanceFactor()>0){
                //TODO LL
                return rotateRight(node);
            }else {
                //TODO LR
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }else {
            if (node.getLeft().getBalanceFactor()<0){
                //TODO RR
                return rotateLeft(node);
            }else {
                //TODO RL
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }

        }
        //return null;
    }
    public boolean isBalanced(){
        if (root == null){
            return true;
        }
        return Math.abs(root.getBalanceFactor())<=1;
    }
    private Node<Value> rotateLeft(Node<Value> oldRoot) {
        Node<Value> newRoot = oldRoot.getRight();
        oldRoot.setRight(newRoot.getLeft());
        newRoot.setLeft(oldRoot);
        //newRoot.setLeft(node.getLeft());
        return newRoot;
    }

    private Node<Value> rotateRight(Node<Value> oldRoot) {
        Node<Value> newRoot = oldRoot.getLeft();
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);
        //newRoot.setLeft(node.getLeft());
        return newRoot;
    }

    //private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    public Node getRoot() {
        return root;
    }


    /*ublic Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }*/


}
