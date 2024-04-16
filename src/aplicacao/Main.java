package aplicacao;

import entidades.Cliente;
import entidades.Ordem;
import entidades.OrdemItem;
import entidades.Produto;
import entidades.enums.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("INFORMAÇÕES CLIENTE:");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("E-mail: ");
        String email = sc.next();
        System.out.print("Aniversário (DD/MM/AAAA): ");
        Date dataNascimento = sdf.parse(sc.next());

        Cliente cliente = new Cliente(name, email, dataNascimento);

        System.out.println("DETALHES DO PEDIDO: ");
        System.out.print("Status: ");
        Status status = Status.valueOf(sc.next());

        Ordem ordem = new Ordem(new Date(), status, cliente);

        System.out.print("Quantos itens para esse pedido:  ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println("Informações do Produto #" + i + ": ");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço do produto: ");
            double valor = sc.nextDouble();

            Produto produto = new Produto(nome, valor);

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            OrdemItem ordemItem = new OrdemItem(quantidade, valor, produto);

            ordem.addProduto(ordemItem);
        }

        System.out.println();
        System.out.println("SUMÁRIO: ");
        System.out.println(ordem);

        sc.close();
    }
}