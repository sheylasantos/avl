

public class Node<ValueType extends Indexable> {
    ValueType value;
    Node<ValueType> left = null;
    Node<ValueType> right = null;

    public Node(ValueType value) {

    }


    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }

    public Node<ValueType> getLeft() {
        return left;
    }

    public void setLeft(Node<ValueType> left) {
        this.left = left;
    }

    public Node<ValueType> getRight() {
        return right;
    }

    public void setRight(Node<ValueType> right) {
        this.right = right;
    }


    public void insert(Node<ValueType> node) {
        if (node.value!=null){
            if (node.value.getKey() <  this.value.getKey()) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.insert(node);
                }
            } else if (node.value.getKey() > this.value.getKey() || left!=null) {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.insert(node);
                }
            }
        }

    }

    public void acessPreOrder(NodeVisitor v){
        v.visit(this);

        if (left!=null){
            left.acessPreOrder(v);
        }
        if (right!=null){
            right.acessPreOrder(v);
        }

    }
    public void acessInOrder(NodeVisitor v){

        if (left!=null){
            left.acessInOrder(v);
        }

        v.visit(this);

        if (right!=null){
            right.acessInOrder(v);
        }

    }
    public void acessPostOrder(NodeVisitor v){
        if (left!=null){
            left.acessPostOrder(v);
        }
        if (right!=null){
            right.acessPostOrder(v);
        }
        v.visit(this);
    }

    public int getBalanceFactor() {
        int leftHeight = getLeft() == null ? 0 : 1 + getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : 1 + getRight().getHeight();

        return leftHeight - rightHeight;
    }

    public int getHeight(){
        if (getLeft() == null && getRight() == null){
            return 0;
        }
        if (getLeft()==null){
            return 1 + getRight().getHeight();
        }
        if (getRight()==null){
            return 1 + getLeft().getHeight();
        }

        return Math.max(1 + getLeft().getHeight(), 1 + getRight().getHeight());
    }

   /* public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }
    */


}
