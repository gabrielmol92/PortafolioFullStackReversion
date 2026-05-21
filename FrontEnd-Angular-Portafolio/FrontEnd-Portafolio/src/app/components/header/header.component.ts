import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'] 
})
export class HeaderComponent implements OnInit {

  mostrarLogin = false;
  isLogged = false; // 

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.isLogged = this.authService.isLogged();
  }

  abrirLogin() {
     console.log("CLICK LOGIN");
    this.mostrarLogin = true;
  }

  cerrarLogin() {
    this.mostrarLogin = false;
    this.isLogged = this.authService.isLogged();
  }

  logout() {
    this.authService.logout();
    this.isLogged = false;
      Swal.fire({
    icon: 'info',
    title: 'Sesión cerrada',
    text: 'Has salido correctamente'
  });
  }
}