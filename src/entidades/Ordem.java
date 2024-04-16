package entidades;

import entidades.enums.Status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ordem {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date data;
    private Status status;

    private Cliente cliente;
    private List<OrdemItem> itens = new ArrayList<>();

    public Ordem(Date data, Status status, Cliente cliente) {
        this.data = data;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdemItem> getItens() {
        return itens;
    }

    public void addProduto(OrdemItem it) {
        itens.add(it);
    }

    public void removeProduto(OrdemItem it) {
        itens.remove(it);
    }
    public double total() {
        double sum = 0.0;
        for (OrdemItem it : itens) {
            sum += it.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hora do pedido: ");
        sb.append(sdf.format(data) + "\n");
        sb.append("Status: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Ordem dos Itens:\n");
        for (OrdemItem item : itens) {
            sb.append(item + "\n");
        }
        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
