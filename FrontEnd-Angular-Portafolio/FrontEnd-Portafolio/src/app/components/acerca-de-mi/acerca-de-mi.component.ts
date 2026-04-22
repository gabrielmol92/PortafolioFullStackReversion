import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/models/persona.model';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-acerca-de-mi',
  templateUrl: './acerca-de-mi.component.html',
  styleUrls: ['./acerca-de-mi.component.css']
})
export class AcercaDeMiComponent implements OnInit {
  
  persona: persona = new persona("","","","","");
  
  constructor( public personaService: PersonaService) { }

  ngOnInit(): void {
    this.cargarPersona();
  }

  cargarPersona():void{
    this.personaService.getPersona().subscribe(data => {this.persona = data})
  }

  /* editarPersona(): void{
    this.personaService.updatePersona(id: , this.persona).subscribe(data => {this.persona = data})
  } */

}
