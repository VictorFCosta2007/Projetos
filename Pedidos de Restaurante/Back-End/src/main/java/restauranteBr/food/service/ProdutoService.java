package restauranteBr.food.service;

import restauranteBr.food.model.Produto;
import restauranteBr.food.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos(){

        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto criarProduto(Produto produto){
        if(produto.getId() != null){
            throw new IllegalArgumentException("Novo produto não deve ter ID");
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado){
        Produto produtoExistente = produtoRepository.findById(id).orElseThrow((
        ) -> new RuntimeException("Produto não encontrado com o ID: " + id));

        produtoExistente.setNomeDoProduto(produtoAtualizado.getNomeDoProduto());
        produtoExistente.setImagem(produtoAtualizado.getImagem());
        produtoExistente.setPrecoUnitario(produtoAtualizado.getPrecoUnitario());

        return  produtoRepository.save(produtoExistente);
    }

    public void deletarProduto(Long id){
       if (!produtoRepository.existsById(id)){
           throw new RuntimeException("Produto não encontrado com o ID: " + id);
       }
       produtoRepository.deleteById(id);

    }
}
