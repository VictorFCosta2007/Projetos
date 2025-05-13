package congregacaocristanobrasil.org.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    private Produto produto;

    private int quantidade;
    private BigDecimal subtotal;

    @ManyToOne
    private Pedido pedido;

    @PrePersist
    @PreUpdate
    public void calcularSubtotal(){
        if(produto != null){
            this.subtotal = produto.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidade));
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
