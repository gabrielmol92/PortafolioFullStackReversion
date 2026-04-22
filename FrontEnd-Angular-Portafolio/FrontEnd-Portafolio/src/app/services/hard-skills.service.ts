import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { hardSkills } from '../models/hard-skills';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HardSkillsService {

   URL = 'http://localhost:8090/hardSkill/';

  constructor(private http: HttpClient) { }

  public getSkill(): Observable<hardSkills[]> {
      return this.http.get<hardSkills[]>(this.URL + 'listar');
    }
  
    public updateSkill(id: number , hardSkills: hardSkills): Observable<any> {
      return this.http.put<any>(this.URL + `update/${id}`, hardSkills);
    }
}
