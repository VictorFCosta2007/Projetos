import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { ListagemProdutosComponent } from './components/views/produto/listagem-produtos/listagem-produtos.component';
import { AdicionarProdutosComponent } from './components/views/produto/adicionar-produtos/adicionar-produtos.component';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MatInput } from '@angular/material/input';
import { MatButton, MatButtonModule } from '@angular/material/button';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatFormFieldModule } from '@angular/material/form-field';
import { DetalhesComponent } from './components/views/detalhes/detalhes.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListagemProdutosComponent,
    AdicionarProdutosComponent,
    DetalhesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatInput,
    MatButtonModule,
    MatButton,
    MatFormFieldModule
  ],
  providers: [provideHttpClient(), provideAnimationsAsync()],
  bootstrap: [AppComponent]
})
export class AppModule { }
