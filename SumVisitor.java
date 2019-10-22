public class SumVisitor implements NodeVisitor{
    private int sum=0;

    @Override
    public void visit(Node node) {
        sum++;
    }

    public int getSum() {
        return sum;
    }
    public void reset(){
        sum=0;
    }
}
