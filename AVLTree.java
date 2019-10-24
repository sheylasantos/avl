import org.omg.CORBA.NO_IMPLEMENT;

public class AVLTree<Value extends Indexable> {
    private Node<Value> root;

 //   public void insert(Node<Value> node) {
 //       if (root == null) {
//            root = node;
//            return;
//        }
 //       root.insert(node);

 //   }



    public void insert(Value value) {

        //insert(new Node<Value>(value));

        root = insert(new Node<Value>(value),root);
    }

    public void remove(int key){
       remove(key,root);
    }

    private Node<Value> remove(int key, Node<Value> root) {
        if (root==null){
            return null;
        }
        if (key == root.getValue().getKey()){
            if (root.getLeft() == null){
                return root.getRight();
            }
            if (root.getRight() == null){
                return root.getLeft();
            }
            //TODO tem os 2 filhos
            int balanceFactor = root.getBalanceFactor();
            if (balanceFactor>=0){
                Value max = getMaxValue(root.getLeft());
                root.setValue(max);
                root.setLeft(remove(max.getKey(),root.getLeft()));
            }else{
                Value min = getMinValue(root.getRight());
                root.setValue(min);
                root.setRight(remove(min.getKey(),root.getLeft()));
            }
            return root;
        }
        if (key < root.getValue().getKey()){
            root.setLeft(remove(key,root.getLeft()));
        }else {
            root.setRight(remove(key,root.getRight()));
        }
        return root;
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
        return balance(parent);//TODO arvore de busca binaria return parent;
    }

    public Value getMinValue(){
        return getMinValue(root);
    }

    private Value getMinValue(Node<Value> root) {
        if (root==null){
            return null;
        }
        if (root.getLeft()==null){
            return root.getValue();
        }
        return getMinValue(root.getLeft());
    }

    public Value getMaxValue(){
        return getMaxValue(root);
    }

    private Value getMaxValue(Node<Value> root) {
        if (root==null){
            return null;
        }
        if (root.getRight()==null){
            return root.getValue();
        }
        return getMaxValue(root.getRight());
    }

    private Node<Value> balance(Node<Value> node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor>=-1 && balanceFactor<=1){
            return node;
        }
        if (balanceFactor>1){
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
            if (node.getRight().getBalanceFactor()<0){
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


    public Value search(int key) {
        /*if (root == null) {
            return null;
        }*/
        return root.search(key,root);
    }


}
