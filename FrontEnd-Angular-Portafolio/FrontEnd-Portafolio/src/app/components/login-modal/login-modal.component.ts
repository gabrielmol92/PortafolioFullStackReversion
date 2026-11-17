import { Component, Output, EventEmitter, OnInit } from '@angular/core'; 
import { ActivatedRoute } from '@angular/router'; 
import { AuthService } from '../../services/auth.service';
import Swal from 'sweetalert2'; 

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.css'] 
})
export class LoginModalComponent implements OnInit { 

  @Output() close = new EventEmitter<void>();

  username = '';
  password = '';

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute 
  ) {}

  
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      if (params['demo'] === 'true') {
        this.username = 'demo'; 
        this.password = 'demo'; 
      }
    });
  }

  login() {
    const data = {
      username: this.username,
      password: this.password
    };

    this.authService.login(data).subscribe({
      next: (res) => {
        this.authService.saveToken(res.token);
        this.authService.saveUsername(
          this.username
        );
        if (this.username === 'demo') {
          Swal.fire({
            icon: 'success',
            title: 'Modo demo',
            text: 'Podés editar temporalmente el portfolio 👋',
            timer: 1500,
            showConfirmButton: false
          });
        }
        else {
          Swal.fire({
            icon: 'success',
            title: 'Login exitoso',
            text: 'Bienvenido 👋',
            timer: 1500,
            showConfirmButton: false
          });
        }
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