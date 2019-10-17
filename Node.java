

public class Node<ValueType extends Indexable> {
    ValueType value;
    Node<ValueType> left = null;
    Node<ValueType> right = null;

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
