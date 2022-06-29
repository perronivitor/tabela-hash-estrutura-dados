import java.util.Scanner;

/**
 * Trabalho de Estrutura de Dados II
 * <p>
 * Autor: Vitor Romanelli Perroni
 */

public class TesteHasing {
    public static void main(String[] args) {
        Tabela hash = new Tabela();
        Scanner sc = new Scanner(System.in);
        String cpf = "";
        int op;

        do {
            System.out.print("\nOpções: " + "\n"+
                    "1) inserir " +
                    "// 2) mostrar " +
                    "// 3) pesquisar " +
                    "// 4) remover " +
                    "// 5) alterar " +
                    "// 0 - fim " + "\n" +
                    "=> ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    hash.inserir(getBrasileiro(sc));
                    break;
                case 2:
                    hash.mostrar();
                    break;
                case 3:
                    System.out.print("\nPesquisar número CPF: ");
                    cpf = sc.nextLine();
                    if (hash.procurar(cpf))
                        System.out.print("\nCPF encontrado\n");
                    else
                        System.out.print("\nCPF não encontrado\n");
                    break;
                case 4:
                    System.out.print("\nRemover número CPF: ");
                    cpf = sc.nextLine();
                    if (hash.procurar(cpf)) {
                        if (hash.remover(cpf)) {
                            System.out.println("Removido");
                        }
                    }else
                            System.out.print("\nCPF não encontrado\n");
                    break;

                case 5:
                    System.out.print("\nAlterar usuario de CPF: ");
                    cpf = sc.nextLine();
                    if (hash.procurar(cpf)) {
                        System.out.println("Informe os dados atualizados:");
                        hash.alterar(cpf, getBrasileiro(sc));
                    } else
                        System.out.print("\nCPF não encontrado\n");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 0);
    }

    private static Brasileiro getBrasileiro(Scanner sc) {
        Brasileiro brasileiro = new Brasileiro();
        System.out.print("\nNome: ");
        brasileiro.setNome(sc.nextLine());

        String cpf;
        do {
            System.out.print("\nCPF: ");
            cpf = sc.nextLine();
        } while (!validaCPF(cpf));

        brasileiro.setCpf(cpf);

        System.out.print("\nTelefone: ");
        brasileiro.setTelefone(sc.nextLine());

        System.out.print("\nEndereço: ");
        brasileiro.setEndereco(sc.nextLine());
        return brasileiro;
    }

    private static boolean validaCPF(String cpf) {
        if (cpf.length() != 11 ) {
            System.out.println("CPF inválido");
            return false;
        }
        return true;
    }
}
