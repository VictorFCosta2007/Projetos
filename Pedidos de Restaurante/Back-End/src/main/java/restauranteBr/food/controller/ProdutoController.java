package restauranteBr.food.controller;

import restauranteBr.food.model.Produto;
import restauranteBr.food.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto){
        try{
            Produto novoProduto = produtoService.criarProduto(produto);
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("mensagem", produto.getNomeDoProduto() + " Criado/adicionado com sucesso!");
            return ResponseEntity.ok(resposta);
        } catch (Exception e){
            return gerarErro("Erro ao criar produto", e);
        }
    }

    @GetMapping
    public ResponseEntity<?> listarProdutos () {
        try {
            List<Produto> produtos = produtoService.listarTodos();
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("produtos", produtos);
            return ResponseEntity.ok(resposta);
        } catch (Exception e){
            return gerarErro("Erro ao listar os produtos", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar (@PathVariable Long id, @RequestBody Produto produto){
        try{
            Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("mensagem", "Produto atualizado com sucesso!");
            resposta.put("produto", produtoAtualizado);
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    gerarMensagem("Produto não encontrado para atualização (ID: " + id + ")")
            );
        } catch (Exception e){
            return gerarErro("Erro ao atualizar o produto", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        try{
            produtoService.deletarProduto(id);
            return ResponseEntity.ok(gerarMensagem("Produto deletado com Sucesso!"));
        } catch (Exception e){
            return gerarErro("Erro ao deletar o produto", e);
        }
    }


    private Map<String, String> gerarMensagem(String mensagem){
        Map<String, String> resposta = new HashMap<>();
        resposta.put("mensagem", mensagem);
        return resposta;
    }

    private ResponseEntity<Map<String, String>> gerarErro(String mensagem, Exception e){
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", mensagem);
        erro.put("erro", e.getMessage());
        return ResponseEntity.status(500).body(erro);
    }



}
