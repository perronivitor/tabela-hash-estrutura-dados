public class Brasileiro {

    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Brasileiro{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Brasileiro brasileiro;

    public Brasileiro(String cpf, String nome, String telefone, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.brasileiro = null;
    }

    public Brasileiro() {
        this.cpf = null;
        this.nome = null;
        this.telefone = null;
        this.endereco = null;
        this.brasileiro = null;
    }
}
