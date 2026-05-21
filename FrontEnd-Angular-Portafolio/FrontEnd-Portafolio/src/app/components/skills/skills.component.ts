import { Component, OnInit } from '@angular/core';
import { SoftSkillsService } from 'src/app/services/soft-skills.service';
import { softSkills } from 'src/app/models/softSkills.model';
import { HardSkillsService } from 'src/app/services/hard-skills.service';
import { hardSkills } from 'src/app/models/hard-skills';
import { AuthService } from 'src/app/services/auth.service';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  modalVisible = false;
  skill: softSkills[]=[]
  hardSkill : hardSkills []=[]
  activo = false;
  tipoSkill: 'soft' | 'hard' = 'soft';
  modo: 'crear' | 'editar' = 'editar';
  skillSeleccionada: any = null;

  constructor(private skillService: SoftSkillsService,private hardSkillService : HardSkillsService, 
    public authService : AuthService,private confirmationService: ConfirmationService,  private messageService: MessageService) { }

  ngOnInit(): void {
    this.cargarSkills()
    this.cargarHardSkill()
  }

cargarSkills(): void {
  if (this.authService.isDemo()) {
    const data = sessionStorage.getItem(
      'demoSoftSkills'
    );
    if (data) {
      this.skill = JSON.parse(data);
      return;
    }
  }
  this.skillService.getSkill().subscribe(data => {
    this.skill = data;
    if (this.authService.isDemo()) {
      sessionStorage.setItem(
        'demoSoftSkills',
        JSON.stringify(data)
      );
    }
  });
}
   
  cargarHardSkill(): void {
  if (this.authService.isDemo()) {
    const data = sessionStorage.getItem(
      'demoHardSkills'
    );
    if (data) {
      this.hardSkill = JSON.parse(data);
      return;
    }
  }
  this.hardSkillService.getSkill().subscribe(data => {
    this.hardSkill = data;
    if (this.authService.isDemo()) {
      sessionStorage.setItem(
        'demoHardSkills',
        JSON.stringify(data)
      );
    }
  });
}
  togglePlus(event: Event) {
    event.preventDefault();
    this.activo = !this.activo;
  }

abrirModalEditar(skill: any, tipo: 'soft' | 'hard') {
  this.modo = 'editar';
  this.tipoSkill = tipo;
  this.skillSeleccionada = skill;
  this.modalVisible = true;
}

abrirModalCrear(tipo: 'soft' | 'hard') {
  this.modo = 'crear';
  this.tipoSkill = tipo;
  this.skillSeleccionada = null;
  this.modalVisible = true;
}

cerrarModal() {
  this.modalVisible = false;
  this.skillSeleccionada = null;
}

guardarSkill(data: any): void {

  if (!this.skillSeleccionada?.id && this.modo === 'editar') {
    this.mostrarError('Falta ID de la skill');
    return;
  }
  if (this.modo === 'editar') {
    this.editarSkill(data);
  }
  else if (this.modo === 'crear') {
    this.crearSkill(data);
  }
}

private editarSkill(data: any): void {

  if (this.tipoSkill === 'soft') {
    this.editarSoftSkill(data);
  }

  else if (this.tipoSkill === 'hard') {
    this.editarHardSkill(data);
  }
}

private crearSkill(data: any): void {
  if (this.tipoSkill === 'soft') {
    this.crearSoftSkill(data);
  }
  else if (this.tipoSkill === 'hard') {
    this.crearHardSkill(data);
  }
}

private editarSoftSkill(data: any): void {
  if (this.authService.isDemo()) {
    const index = this.skill.findIndex(
      s => s.id === this.skillSeleccionada.id
    );
    if (index !== -1) {
      this.skill[index] = {
        ...this.skill[index],
        ...data
      };
      sessionStorage.setItem(
        'demoSoftSkills',
        JSON.stringify(this.skill)
      );

    }
    this.cerrarModal();
    this.mostrarExito(
      'Actualizado',
      'Soft skill actualizada temporalmente'
    );

    return;
  }
  this.skillService
    .updateSkill(this.skillSeleccionada.id, data)
    .subscribe({
      next: () => {
        const index = this.skill.findIndex(
          s => s.id === this.skillSeleccionada.id
        );
        if (index !== -1) {
          this.skill[index] = {
            ...this.skill[index],
            ...data
          };
        }
        this.cerrarModal();
        this.mostrarExito(
          'Actualizado',
          'Soft skill actualizada correctamente'
        );
      },
      error: err => {
        this.mostrarError(
          'No se pudo actualizar la soft skill'
        );
        console.error(err);
      }
    });
}

private editarHardSkill(data: any): void {
  if (this.authService.isDemo()) {
    const index = this.hardSkill.findIndex(
      h => h.id === this.skillSeleccionada.id
    );
    if (index !== -1) {
      this.hardSkill[index] = {
        ...this.hardSkill[index],
        ...data
      }
      sessionStorage.setItem(
        'demoHardSkills',
        JSON.stringify(this.hardSkill)
      );

    }
    this.cerrarModal();
    this.mostrarExito(
      'Actualizado',
      'Hard skill actualizada temporalmente'
    );
    return;
  }
  this.hardSkillService
    .updateSkill(this.skillSeleccionada.id, data)
    .subscribe({
      next: () => {
        const index = this.hardSkill.findIndex(
          h => h.id === this.skillSeleccionada.id
        );
        if (index !== -1) {
          this.hardSkill[index] = {
            ...this.hardSkill[index],
            ...data
          };

        }
        this.cerrarModal();
        this.mostrarExito(
          'Actualizado',
          'Hard skill actualizada correctamente'
        );
      },
      error: err => {
        this.mostrarError(
          'No se pudo actualizar la hard skill'
        );
        console.error(err);
      }
    });
}

private crearSoftSkill(data: any): void {
  if (this.authService.isDemo()) {
    const nueva = {
      id: Date.now(),
      ...data
    };
    this.skill.push(nueva);
    sessionStorage.setItem(
      'demoSoftSkills',
      JSON.stringify(this.skill)
    );
    this.cerrarModal();
    this.mostrarExito(
      'Creado',
      'Soft skill creada temporalmente'
    );
    return;
  }
  this.skillService
    .save(data)
    .subscribe({
      next: (nueva) => {
        this.skill.push(nueva);
        this.cerrarModal();
        this.mostrarExito(
          'Creado',
          'Soft skill creada correctamente'
        );
      },
      error: err => {
        this.mostrarError(
          'No se pudo crear la soft skill'
        );
        console.error(err);
      }
    });
}
private crearHardSkill(data: any): void {
  if (this.authService.isDemo()) {
    const nueva = {
      id: Date.now(),
      ...data
    };
    this.hardSkill.push(nueva);
    sessionStorage.setItem(
      'demoHardSkills',
      JSON.stringify(this.hardSkill)
    );
    this.cerrarModal();
    this.mostrarExito(
      'Creado',
      'Hard skill creada temporalmente'
    );
    return;
  }
  this.hardSkillService
    .save(data)
    .subscribe({
      next: (nueva) => {
        this.hardSkill.push(nueva);
        this.cerrarModal();
        this.mostrarExito(
          'Creado',
          'Hard skill creada correctamente'
        );
      },
      error: err => {
        this.mostrarError(
          'No se pudo crear la hard skill'
        ); 
        console.error(err);
      }
    });
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

eliminarSkill(
  id: number,
  tipo: 'soft' | 'hard'
): void {
  this.confirmationService.confirm({
    header: 'Confirmación',
    message: '¿Seguro que querés eliminar esta skill?',
    icon: 'pi pi-exclamation-triangle',
    acceptLabel: 'Sí',
    rejectLabel: 'Cancelar',
    accept: () => this.confirmarEliminacionSkill(id, tipo),
    reject: () => this.cancelarEliminacion()
  });
}

private confirmarEliminacionSkill(
  id: number,
  tipo: 'soft' | 'hard'
): void {
  if (tipo === 'soft') {
    this.eliminarSoftSkill(id);
  }
  else if (tipo === 'hard') {
    this.eliminarHardSkill(id);
  }
}

private eliminarSoftSkill(id: number): void {
  if (this.authService.isDemo()) {
    this.skill = this.skill.filter(
      s => s.id !== id
    );
    sessionStorage.setItem(
      'demoSoftSkills',
      JSON.stringify(this.skill)
    );
    this.mostrarExito(
      'Eliminado',
      'Soft skill eliminada temporalmente'
    );
    return;
  }
  this.skillService.delete(id).subscribe({
    next: () => {
      this.skill = this.skill.filter(
        s => s.id !== id
      );
      this.mostrarExito(
        'Eliminado',
        'Soft skill eliminada correctamente'
      );
    },
    error: err => {
      this.mostrarError(
        'No se pudo eliminar la soft skill'
      );
      console.error(err);
    }
  });
}

private eliminarHardSkill(id: number): void {
  if (this.authService.isDemo()) {
    this.hardSkill = this.hardSkill.filter(
      h => h.id !== id
    );
    sessionStorage.setItem(
      'demoHardSkills',
      JSON.stringify(this.hardSkill)
    );
    this.mostrarExito(
      'Eliminado',
      'Hard skill eliminada temporalmente'
    );
    return;
  }
  this.hardSkillService.delete(id).subscribe({
    next: () => {
      this.hardSkill = this.hardSkill.filter(
        h => h.id !== id
      );
      this.mostrarExito(
        'Eliminado',
        'Hard skill eliminada correctamente'
      );
    },
    error: err => {
      this.mostrarError(
        'No se pudo eliminar la hard skill'
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
