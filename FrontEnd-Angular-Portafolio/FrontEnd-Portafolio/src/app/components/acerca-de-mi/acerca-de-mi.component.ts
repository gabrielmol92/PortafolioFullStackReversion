import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/models/persona.model';
import { PersonaService } from 'src/app/services/persona.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-acerca-de-mi',
  templateUrl: './acerca-de-mi.component.html',
  styleUrls: ['./acerca-de-mi.component.css']
})
export class AcercaDeMiComponent implements OnInit {
  
  persona: persona = new persona("","","","","");
  modalVisible: boolean = false;
  
  constructor( public personaService: PersonaService, public authService: AuthService) { }

  ngOnInit(): void {
    this.cargarPersona();
  }

  cargarPersona():void{
    this.personaService.getPersona().subscribe(data => {this.persona = data})
  }

  abrirModal() {
  this.modalVisible = true;
}

cerrarModal() {
  this.modalVisible = false;
}

guardarCambios(data: any) {
  if (!this.persona.id) {
      console.log(this.persona)
    console.error("Falta ID");
    return;
  }
  this.personaService.updatePersona(this.persona.id, data).subscribe({
    next: () => {
      this.persona = { ...this.persona, ...data }; // mezcla datos  
      this.modalVisible = false;
    },
    error: err => console.error(err)
  });
}

}
