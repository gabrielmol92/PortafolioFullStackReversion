import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { softSkills } from '../models/softSkills.model'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SoftSkillsService {

    URL = 'http://localhost:8090/softSkill/';

  constructor(private http: HttpClient) { }

 public getSkill(): Observable<softSkills[]> {
    return this.http.get<softSkills[]>(this.URL + 'listar');
  }

  public updateSkill(id: number , softSkills: softSkills): Observable<any> {
    return this.http.put<any>(this.URL + `update/${id}`, softSkills);
  }

}
