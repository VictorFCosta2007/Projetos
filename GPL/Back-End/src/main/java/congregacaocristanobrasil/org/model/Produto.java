package congregacaocristanobrasil.org.model;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoProduto;
    private String imagem;
    private BigDecimal precoUnitario;

    public Produto(){

    }

    public Produto(String nomeDoProduto, String imagem ,BigDecimal precoUnitario){
        this.nomeDoProduto = nomeDoProduto;
        this.imagem = imagem;
        this.precoUnitario = precoUnitario;
        
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNomeDoProduto(){
        return nomeDoProduto;
    }
    public void setNomeDoProduto(String nomeDoProduto){
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getImagem(){
        return imagem;
    }

    public void setImagem(String imagem){
        this.imagem = imagem;
    }

    public BigDecimal getPrecoUnitario(){
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario){
        this.precoUnitario = precoUnitario;
    }

}



