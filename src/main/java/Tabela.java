public class Tabela {
    private static final int TAM = 100;

    private Brasileiro[] lista;

    public Tabela() {
        lista = new Brasileiro[TAM];
        for (int i = 0; i < TAM; i++) {
            this.lista[i] = null;
        }
    }

    public void inserir(
            Brasileiro br
    ) {
        int valor = this.transformar(br.getCpf());
        int pos = this.funcao_hash(valor);

        Brasileiro aux, novo = new Brasileiro(
                br.getCpf(),
                br.getNome(),
                br.getTelefone(),
                br.getEndereco()
        );

        if (this.lista[pos] == null)
            this.lista[pos] = novo;
        else {
            aux = this.lista[pos];
            while (aux.brasileiro != null) aux = aux.brasileiro;
            aux.brasileiro = novo;
        }
    }

    public boolean remover(
            String cpf
    ) {

        if (!procurar(cpf)) return false;

        int valor = this.transformar(cpf);
        int pos = this.funcao_hash(valor);

        Brasileiro aux = this.lista[pos];
        while (aux != null) {
            if (aux.getCpf().equals(cpf)) {
                Brasileiro br = aux.brasileiro;
                aux = br;
                break;
            }
            aux = aux.brasileiro;
        }
        this.lista[pos] = aux;

        return true;
    }

    public void alterar(
            String cpf,
            Brasileiro novo
    ) {

        if (!procurar(cpf)) return;

        remover(cpf);

        inserir(novo);

    }

    public int transformar(String cpf) {
        int valor = 0;

        for (int i = 0; i < cpf.length(); i++)
            valor += cpf.charAt(i);
        return valor;
    }

    public int funcao_hash(int valor) {
        return valor % TAM;
    }

    public void mostrar() {
        System.out.println("Conteúdo da tabela hash: ");

        for (int i = 0; i < TAM; i++) {
            System.out.print(i);
            if (this.lista[i] != null) {
                Brasileiro aux;
                aux = this.lista[i];
                while (aux != null) {
                    System.out.print(" -> " + aux);
                    aux = aux.brasileiro;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean procurar(String cpf) {
        int valor = this.transformar(cpf);
        int pos = this.funcao_hash(valor);

        Brasileiro aux = this.lista[pos];
        while (aux != null) {
            if (aux.getCpf().equals(cpf)) return true;
            aux = aux.brasileiro;
        }
        return false;
    }


}
