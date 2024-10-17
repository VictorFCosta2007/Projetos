import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../../../service/produto.service';
import { Router } from '@angular/router';
import { Produto } from '../../../../models/Produto';

@Component({
  selector: 'app-listagem-produtos',
  templateUrl: './listagem-produtos.component.html',
  styleUrl: './listagem-produtos.component.css'
})
export class ListagemProdutosComponent implements OnInit {
  public produtos!: Produto[];

  constructor(private produtoService: ProdutoService, private router:Router){}

  ngOnInit(): void {
    this.buscarProdutos();
  }
  public buscarProdutos(){
    this.produtoService.obterProdutos().subscribe(response => {
      this.produtos = response;
      console.log(this.produtos)
    })
  }

  verDetalhes(produtoId: string): void {
    this.router.navigate(['/detalhes',produtoId])
  }
}
