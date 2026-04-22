import { Component, OnInit } from '@angular/core';
import { SoftSkillsService } from 'src/app/services/soft-skills.service';
import { softSkills } from 'src/app/models/softSkills.model';
import { HardSkillsService } from 'src/app/services/hard-skills.service';
import { hardSkills } from 'src/app/models/hard-skills';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skill: softSkills[]=[]
  hardSkill : hardSkills []=[]
  constructor(private skillService: SoftSkillsService,private hardSkillService : HardSkillsService) { }

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


  }
