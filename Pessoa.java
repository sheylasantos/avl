

public class Pessoa implements Indexable {
    protected String nome;
    protected int idade;
    private int chave;

    public Pessoa(String nome,int idade,int id){
        this.nome=nome;
        this.idade=idade;
        this.chave=id;
    }
    public Pessoa(int id){
        this.chave=id;
    }
    @Override
    public int getKey() {
        return chave;
    }
}
