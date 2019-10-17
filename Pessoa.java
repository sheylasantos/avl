

public class Pessoa implements Indexable {
    protected String nome;
    protected int idade;
    private int id;

    public Pessoa(String nome,int idade,int id){
        this.nome=nome;
        this.idade=idade;
        this.id=id;
    }
    @Override
    public int getKey() {
        return id;
    }
}
