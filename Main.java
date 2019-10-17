

public class Main {

    public static void main(String[] args) {
        AVLTree<Pessoa> pessoas = new AVLTree<>();
        AVLTree<Time> times = new AVLTree<>();
        Node<Pessoa> node1 = new Node<>();
        node1.setValue( new Pessoa("Sheyla",25,1));
        pessoas.insert(node1);
        Node<Pessoa> node2 = new Node<>();
        node2.setValue( new Pessoa("Sheyla",25,2));
        pessoas.insert(node2);
        Node<Pessoa> node3 = new Node<>();
        node3.setValue( new Pessoa("Sheyla",25,3));
        pessoas.insert(node3);
        Node<Pessoa> node4 = new Node<>();
        node4.setValue( new Pessoa("Sheyla",25,4));
        pessoas.insert(node4);
        Node<Pessoa> node5 = new Node<>();
        node5.setValue( new Pessoa("Sheyla",25,5));
        pessoas.insert(node5);
        Node<Pessoa> node6 = new Node<>();
        node6.setValue( new Pessoa("Sheyla",25,6));
        pessoas.insert(node6);
        //AVLTree<Integer> numeros = new AVLTree<Integer>();

        Node <Pessoa> tmp = pessoas.getRoot();

        System.out.println(tmp.getValue().getKey());
        //tmp=tmp.left;
        System.out.println(pessoas.getRoot().getRight().getValue().getKey());


    }
}
