import { Component, Output, EventEmitter } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import Swal from 'sweetalert2'; 

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.css'] 
})
export class LoginModalComponent {

  @Output() close = new EventEmitter<void>();

  username = '';
  password = '';

  constructor(private authService: AuthService) {}

  login() {

    const data = {
      username: this.username,
      password: this.password
    };

    this.authService.login(data).subscribe({

      next: (res) => {
        this.authService.saveToken(res.token);
        Swal.fire({
          icon: 'success',
          title: 'Login exitoso',
          text: 'Bienvenido 👋',
          timer: 1500,
          showConfirmButton: false
        });

        this.close.emit();
      },

      error: () => {
         this.close.emit(); 
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Usuario o contraseña incorrectos'
        });
      }
    });
  }

  cerrar() {
    this.close.emit();
  }
}