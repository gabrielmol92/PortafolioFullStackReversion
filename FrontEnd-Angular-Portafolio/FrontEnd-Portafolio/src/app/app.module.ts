import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgxTypedJsModule } from 'ngx-typed-js';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AcercaDeMiComponent } from './components/acerca-de-mi/acerca-de-mi.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ContactComponent } from './components/contact/contact.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor } from './interceptors/jwt.interceptor';
import { LoginModalComponent } from './components/login-modal/login-modal.component';
import { ButtonModule } from 'primeng/button';
import { AcercaDeMiEditComponent } from './components/acerca-de-mi-edit/acerca-de-mi-edit.component';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EducacionCrudComponent } from './components/educacion-crud/educacion-crud.component';
import { ConfirmationService } from 'primeng/api';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { SkillsCrudComponent } from './components/skills-crud/skills-crud.component';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AcercaDeMiComponent,
    EducacionComponent,
    SkillsComponent,
    ContactComponent,
    FooterComponent,
    LoginModalComponent,
    AcercaDeMiEditComponent,
    EducacionCrudComponent,
    SkillsCrudComponent
        
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxTypedJsModule,
    DialogModule,
    ButtonModule,
    InputTextModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ConfirmDialogModule,
    ToastModule
  ],
  providers: [
   { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },ConfirmationService,MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
