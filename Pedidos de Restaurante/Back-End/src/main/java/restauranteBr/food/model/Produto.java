package restauranteBr.food.model;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoProduto;
    private String imagem;
    private int tamanhoPorNumero;
    private char tamanhoPorLetra;
    private BigDecimal precoUnitario;

    public Produto(){

    }

    public Produto(String nomeDoProduto, String imagem, int tamanhoPorNumero, char tamanhoPorLetra ,BigDecimal precoUnitario){
        this.nomeDoProduto = nomeDoProduto;
        this.imagem = imagem;
        this.tamanhoPorNumero = tamanhoPorNumero;
        this.tamanhoPorLetra = tamanhoPorLetra;
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

    public int getTamanhoPorNumero(int tamanhoPorNumero){
        return tamanhoPorNumero;
    }

    public void setTamanhoPorNumero(){
        this.tamanhoPorNumero = tamanhoPorNumero;
    }

    public char getTamanhoPorLetra(char tamanhoPorLetra){
        return tamanhoPorLetra;
    }

    public void setTamanhoPorLetra(){
        this.tamanhoPorLetra = tamanhoPorLetra;
    }

    public BigDecimal getPrecoUnitario(){
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario){
        this.precoUnitario = precoUnitario;
    }

}



