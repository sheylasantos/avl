

public class Main {

    public static void main(String[] args) {
        AVLTree<Pessoa> pessoas = new AVLTree<>();
        AVLTree<Time> times = new AVLTree<>();

        pessoas.insert(new Pessoa(1));
        pessoas.insert(new Pessoa(2));
        pessoas.insert(new Pessoa(3));
        pessoas.insert(new Pessoa(4));
        pessoas.insert(new Pessoa(5));
        pessoas.insert(new Pessoa(6));

//        Node<Pessoa> node1 = new Node(1);
//        node1.setValue( new Pessoa("Sheyla",25,1));
//        pessoas.insert(node1);
//        Node<Pessoa> node2 = new Node<>(2);
//        node2.setValue( new Pessoa("Sheyla",25,2));
//        pessoas.insert(node2);
//        Node<Pessoa> node3 = new Node<>(3);
//        node3.setValue( new Pessoa("Sheyla",25,3));
//        pessoas.insert(node3);
//        Node<Pessoa> node4 = new Node<>(4);
//        node4.setValue( new Pessoa("Sheyla",25,4));
//        pessoas.insert(node4);
//        Node<Pessoa> node5 = new Node<>(5);
//        node5.setValue( new Pessoa("Sheyla",25,5));
//        pessoas.insert(node5);
//        Node<Pessoa> node6 = new Node<>(6);
//        node6.setValue( new Pessoa("Sheyla",25,6));
//        pessoas.insert(node6);
        //AVLTree<Integer> numeros = new AVLTree<Integer>();

        if (pessoas.isBalanced()){
            System.out.printf("BALANCEADA");
        }

        Node <Pessoa> tmp = pessoas.getRoot();
        SumVisitor s = new SumVisitor();
        pessoas.getRoot().acessPreOrder(s);
        System.out.println(s.getSum());

        System.out.println(tmp.getValue().getKey());
        //tmp=tmp.left;
        System.out.println(pessoas.getRoot().getRight().getValue().getKey());


    }
}
