import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/services/educacion.service';
import { SoftSkillsService } from 'src/app/services/soft-skills.service';
import { softSkills } from 'src/app/models/softSkills.model';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skill: softSkills[]=[]
  constructor(private skillService: SoftSkillsService) { }

  ngOnInit(): void {
    this.cargarSkills()
  }

  cargarSkills(): void {
  this.skillService.getSkill().subscribe(data => {
    this.skill = data;
    })}

  }
