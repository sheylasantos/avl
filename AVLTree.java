

public class AVLTree<Type extends Indexable> {
    private Node<Type> root;

    public void insert(Node<Type> node) {
        if (root == null) {
            root = node;
            return;
        }
        root.insert(node);
    }

    public void insert(Type node) {
        insert(new Node<Type>());
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
