import { ProdutoService } from './../../../service/produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../../../models/Produto';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detalhes',
  templateUrl: './detalhes.component.html',
  styleUrl: './detalhes.component.css'
})
export class DetalhesComponent implements OnInit {
  public produto!: Produto;

  constructor(private ProdutoService: ProdutoService,
    private route: ActivatedRoute, private router:Router){}

  ngOnInit(): void {
    const produtoId = this.route.snapshot.paramMap.get('id') ?? ''

    this.ProdutoService.detalhesProdutos(produtoId).subscribe(response => {
      this.produto = response
    })
  }

  public deletarProduto(id: string): void{
    this.ProdutoService.removerProduto(id).subscribe(response => {
      console.log(response)
      this.router.navigate(['/'])})
  }

}
