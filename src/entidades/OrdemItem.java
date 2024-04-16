package entidades;

public class OrdemItem {
    private Integer quantidade;
    private Double valor;

    private Produto produto;

    public OrdemItem(int quantidade, double valor, Produto produto) {
        this.quantidade = this.quantidade;
        this.valor = this.valor;
        this.produto = this.produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double subTotal() {
        return valor * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome()
                + ", $"
                + String.format("%.2f", valor)
                + ", Quantity: "
                + quantidade +
                ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}
