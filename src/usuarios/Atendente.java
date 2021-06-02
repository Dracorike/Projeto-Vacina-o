package usuarios;

public class Atendente {
    private int _id;
    private String nome;
    private int idade;
    private boolean areasaude;
    private String endereco;
    private String datavacinacao;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAreasaude() {
        return areasaude;
    }

    public void setAreasaude(boolean areasaude) {
        this.areasaude = areasaude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDatavacinacao() {
        return datavacinacao;
    }

    public void setDatavacinacao(String datavacinacao) {
        this.datavacinacao = datavacinacao;
    }
}
