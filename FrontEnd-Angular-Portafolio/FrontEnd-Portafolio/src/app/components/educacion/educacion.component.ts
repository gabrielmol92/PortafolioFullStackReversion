import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/services/educacion.service';
import {educacion} from 'src/app/models/educacion.model';
import {AuthService} from 'src/app/services/auth.service'
import { ConfirmationService, MessageService} from 'primeng/api';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit  {

  ed: educacion[] = [];
  modalVisible: boolean = false;
  educacionSeleccionada: any = null;
  modo: 'crear' | 'editar' = 'editar';
  activo = false;


  constructor(private educacionService: EducacionService, public authService : AuthService,
      private confirmationService: ConfirmationService,   private messageService: MessageService) {}

  ngOnInit(): void {
  this.cargarEducacion();
}

togglePlus(event: Event): void {
  event.preventDefault();
  this.activo = !this.activo;
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
    this.actualizarEducacion(data);
  }
  else if (this.modo === 'crear') {
    this.crearEducacion(data);
  }
}

private actualizarEducacion(data: any): void {
  if (!this.educacionSeleccionada?.id) {
    this.mostrarError('Falta ID de la educación');
    return;
  }
  this.educacionService
    .update(this.educacionSeleccionada.id, data)
    .subscribe({
      next: () => {
        const index = this.ed.findIndex(
          e => e.id === this.educacionSeleccionada.id
        );
        if (index !== -1) {
          this.ed[index] = {
            ...this.ed[index],
            ...data
          };
        }
        this.mostrarExito(
          'Actualizado',
          'Actualizado correctamente'
        );
        this.cerrarYLimpiarModal();
      },
      error: err => {
        this.mostrarError(
          'No se pudo actualizar'
        );
        console.error(err);
      }
    });
}

private crearEducacion(data: any): void {
  this.educacionService.save(data).subscribe({
    next: (nueva) => {
      this.ed.push(nueva);
      this.mostrarExito(
        'Creado',
        'Creado correctamente'
      );
      this.cerrarYLimpiarModal();
    },
    error: err => {
      this.mostrarError(
        'No se pudo crear'
      );
      console.error(err);
    }
  });
}

private cerrarYLimpiarModal(): void {
  this.modalVisible = false;
  this.educacionSeleccionada = null;
}

private mostrarExito(
  summary: string,
  detail: string
): void {
  this.messageService.add({
    severity: 'success',
    summary,
    detail
  });
}

private mostrarError(detail: string): void {
  this.messageService.add({
    severity: 'error',
    summary: 'Error',
    detail
  });
}

eliminarEducacion(id: number): void {
  this.confirmationService.confirm({
    header: 'Confirmación',
    message: '¿Seguro que querés eliminar?',
    icon: 'pi pi-exclamation-triangle',
    acceptLabel: 'Sí',
    rejectLabel: 'Cancelar',
    accept: () => this.confirmarEliminacion(id),
    reject: () => this.cancelarEliminacion()
  });
}

private confirmarEliminacion(id: number): void {
  this.educacionService.delete(id).subscribe({
    next: () => {
      this.ed = this.ed.filter(
        e => e.id !== id
      );
      this.mostrarExito(
        'Eliminado',
        'Eliminada correctamente'
      );
    },
    error: err => {
      this.mostrarError(
        'No se pudo eliminar'
      );
      console.error(err);
    }
  });
}

private cancelarEliminacion(): void {
  this.messageService.add({
    severity: 'info',
    summary: 'Cancelado',
    detail: 'La eliminación fue cancelada'
  });
}


}