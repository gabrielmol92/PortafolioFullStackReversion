import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { hardSkills } from '../models/hard-skills';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HardSkillsService {

   URL = 'http://localhost:8090/hardSkill/';

  constructor(private httpClient: HttpClient) { }

  public getSkill(): Observable<hardSkills[]> {
      return this.httpClient.get<hardSkills[]>(this.URL + 'listar');
    }
  
     public save(hardSkill: hardSkills): Observable<any>{
           const token = sessionStorage.getItem('token');
           const headers = new HttpHeaders({
           'Authorization': `Bearer ${token}`
        });
      
         return this.httpClient.post<any>(this.URL + 'new', hardSkill,{headers})
        }


    public updateSkill(id: number , hardSkills: hardSkills): Observable<any> {
         const token = sessionStorage.getItem('token');
         const headers = new HttpHeaders({
        'Authorization': `Bearer ${token}`
  });

    return this.httpClient.put<any>(this.URL + `update/${id}`, hardSkills,{headers});
    }


    public delete(id: number): Observable<any>{
      const token = sessionStorage.getItem('token');
      const headers = new HttpHeaders({
     'Authorization': `Bearer ${token}`
  });
     return this.httpClient.delete<any>(this.URL + `delete/${id}`,{headers})
  }

}
