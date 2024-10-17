import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListagemProdutosComponent } from './components/views/produto/listagem-produtos/listagem-produtos.component';
import { AdicionarProdutosComponent } from './components/views/produto/adicionar-produtos/adicionar-produtos.component';
import { DetalhesComponent } from './components/views/detalhes/detalhes.component';

const routes: Routes = [
  { path: '', component: ListagemProdutosComponent},
  { path: 'adicionar-produto', component: AdicionarProdutosComponent},
  {path: 'detalhes/:id', component:DetalhesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
