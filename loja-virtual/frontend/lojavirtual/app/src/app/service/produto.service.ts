import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Produto } from "../models/Produto";

@Injectable({
  providedIn:"root"
})
export class ProdutoService{
  public baseUrl: string = "http://localhost:8080/produtos";

  constructor(private http: HttpClient){ }

  public obterProdutos(): Observable<Produto[]>{
    return this.http.get<Produto[]>(this.baseUrl)
  }

  public adicionarProduto(produto: Produto): Observable<Produto>{
    return this.http.post<Produto>(this.baseUrl, produto)
  }



  public detalhesProdutos(produtoId: string):Observable<Produto>{
    return this.http.get<Produto>(`${this.baseUrl}/${produtoId}`)
  }

  public removerProduto(id: string): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/${id}`)
  }
}
