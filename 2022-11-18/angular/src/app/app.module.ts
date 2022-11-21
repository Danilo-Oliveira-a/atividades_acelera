import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CdkTableModule } from '@angular/cdk/table';
import { MatMenuModule } from '@angular/material/menu';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatDatepickerModule, } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CuidadorComponent } from './cuidador/cuidador.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FilterPipe } from './pipes/filter.pipe';
import { EditarCuidadorDialogComponent } from './cuidador/dialog/editar-cuidador-dialog/editar-cuidador-dialog.component';
import { AdicionarCuidadorDialogComponent } from './cuidador/dialog/adicionar-cuidador-dialog/adicionar-cuidador-dialog.component';
import { JaulaComponent } from './jaula/jaula.component';
import { HomeComponent } from './home/home/home.component';

import { HeaderComponent } from './header/header/header.component';
import { EditarJaulaDialogComponent } from './jaula/dialog/editar-jaula-dialog/editar-jaula-dialog.component';
import { AdicionarJaulaDialogComponent } from './jaula/dialog/adicionar-jaula-dialog/adicionar-jaula-dialog.component';
import { ConfirmarExcluirJaulaComponent } from './jaula/dialog/editar-jaula-dialog/confirmarDialog/confirmar-excluir-jaula/confirmar-excluir-jaula.component';
import { DeletarCuidadorDialogComponent } from './cuidador/dialog/deletar-cuidador-dialog/deletar-cuidador-dialog.component';
import { AnimalComponent } from './animal/animal/animal.component';
import { AdicionarAnimalComponent } from './animal/adicionar/adicionar-animal/adicionar-animal.component';




@NgModule({
  declarations: [
    AppComponent,
    CuidadorComponent,
    FilterPipe,
    EditarCuidadorDialogComponent,
    AdicionarCuidadorDialogComponent,
    JaulaComponent,
    HomeComponent,

    HeaderComponent,
    EditarJaulaDialogComponent,
    AdicionarJaulaDialogComponent,
    ConfirmarExcluirJaulaComponent,
    DeletarCuidadorDialogComponent,
    AnimalComponent,
    AdicionarAnimalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatDialogModule,
    MatInputModule,
    FormsModule,
    CdkTableModule,
    MatMenuModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
