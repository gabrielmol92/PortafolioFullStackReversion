import { Component, OnInit } from '@angular/core';
import { SoftSkillsService } from 'src/app/services/soft-skills.service';
import { softSkills } from 'src/app/models/softSkills.model';
import { HardSkillsService } from 'src/app/services/hard-skills.service';
import { hardSkills } from 'src/app/models/hard-skills';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skill: softSkills[]=[]
  hardSkill : hardSkills []=[]
  activo = false;
  
  constructor(private skillService: SoftSkillsService,private hardSkillService : HardSkillsService, public authService : AuthService) { }

  ngOnInit(): void {
    this.cargarSkills()
    this.cargarHardSkill()
  }

  cargarSkills(): void {
  this.skillService.getSkill().subscribe(data => {
    this.skill = data;
    })}
   
  cargarHardSkill() : void {
    this.hardSkillService.getSkill().subscribe(data =>{
        this.hardSkill = data;
    })
  }  
  togglePlus(event: Event) {
    event.preventDefault();
    this.activo = !this.activo;
  }

  }
