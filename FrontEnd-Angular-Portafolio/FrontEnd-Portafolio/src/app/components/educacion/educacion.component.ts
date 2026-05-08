import { AfterViewInit,AfterViewChecked,Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/services/educacion.service';
import {educacion} from 'src/app/models/educacion.model';
import {AuthService} from 'src/app/services/auth.service'
import { ConfirmationService } from 'primeng/api';

declare var FinisherHeader: any;

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit, AfterViewChecked  {

  ed: educacion[] = [];
  modalVisible: boolean = false;
  educacionSeleccionada: any = null;
  modo: 'crear' | 'editar' = 'editar';


  activo = false;
  backgroundIniciado = false;

  constructor(private educacionService: EducacionService, public authService : AuthService,  private confirmationService: ConfirmationService) {}

  ngOnInit(): void {
  this.cargarEducacion();
}

  ngAfterViewChecked(): void {

  if (
    this.authService.isLogged() &&
    !this.backgroundIniciado
  ) {

    this.backgroundIniciado = true;

    setTimeout(() => {
      this.initBackground();
    }, 300);
  }
}

  togglePlus(event: Event) {
    event.preventDefault();
    this.activo = !this.activo;
  }

  initBackground() {

  const viejoCanvas = document.querySelector('.finisher-header canvas');

  if (viejoCanvas) {
    viejoCanvas.remove();
  }

  new FinisherHeader({
    count: 17,

    size: {
      min: 17,
      max: 1027,
      pulse: 0.4
    },

    speed: {
      x: {
        min: 0.6,
        max: 3
      },
      y: {
        min: 0.6,
        max: 3
      }
    },

    colors: {
      background: "#161616",
      particles: [
        "#969595",
        "#444647",
        "#3b3b47",
        "#2c1e22"
      ]
    },

    blending: "lighten",

    opacity: {
      center: 0.6,
      edge: 0
    },

    skew: 0,

    shapes: ["c"]
  });

  window.dispatchEvent(new Event('resize'));
}

  cargarEducacion(): void {
  this.educacionService.getEducacion().subscribe(data => {
    this.ed = data;
  });
}

  
abrirModal(e: any) {
  this.modo = 'editar';
  this.educacionSeleccionada = e;
  this.modalVisible = true;
}

abrirModalCrear(tipo: string) {
  this.modo = 'crear';
  this.educacionSeleccionada = {
    tipo: tipo
  };
  this.modalVisible = true;
}

cerrarModal() {
  this.modalVisible = false;
}

guardarCambios(data: any) {
  if (this.modo === 'editar') {
    if (!this.educacionSeleccionada?.id) {
      console.error("Falta ID");
      return;
    }
    this.educacionService.update(this.educacionSeleccionada.id, data).subscribe({
      next: () => {
        const index = this.ed.findIndex(
          e => e.id === this.educacionSeleccionada.id
        );

        if (index !== -1) {
          this.ed[index] = { ...this.ed[index], ...data };
        }
        this.modalVisible = false;
        this.educacionSeleccionada = null;
      },
      error: err => console.error(err)
    });
  } 
  else if (this.modo === 'crear') {
     console.log(data);
    this.educacionService.save(data).subscribe({
      next: (nueva) => {
        this.ed.push(nueva);

        this.modalVisible = false;
        this.educacionSeleccionada = null;
      },
      error: err => console.error(err)
    });

  }
}

eliminarEducacion(id: number) {
  this.confirmationService.confirm({
    header: 'Confirmación',
    message: '¿Seguro que querés eliminar esta educación?',
    icon: 'pi pi-exclamation-triangle',
    acceptLabel: 'Sí',
    rejectLabel: 'Cancelar',
    accept: () => {
      this.educacionService.delete(id).subscribe({
        next: () => {
          this.ed = this.ed.filter(e => e.id !== id);
        },
        error: err => console.error(err)
      });
    },
    reject: () => {
      console.log("Canceló");
    }
  });

}




}