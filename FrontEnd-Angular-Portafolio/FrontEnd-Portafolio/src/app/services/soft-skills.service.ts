import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { softSkills } from '../models/softSkills.model'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SoftSkillsService {

    URL = `${environment.apiUrl}/softSkill/`;

  constructor(private httpClient: HttpClient) { }

 public getSkill(): Observable<softSkills[]> {
    return this.httpClient.get<softSkills[]>(this.URL + 'listar');
  }

  public save(softSkill: softSkills): Observable<any>{
       const token = sessionStorage.getItem('token');
       const headers = new HttpHeaders({
       'Authorization': `Bearer ${token}`
    });
  
     return this.httpClient.post<any>(this.URL + 'new', softSkill,{headers})
    }


  public updateSkill(id: number , softSkills: softSkills): Observable<any> {
     const token = sessionStorage.getItem('token');
      const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
  });
    return this.httpClient.put<any>(this.URL + `update/${id}`, softSkills,{headers});
  }

  public delete(id: number): Observable<any>{
      const token = sessionStorage.getItem('token');
      const headers = new HttpHeaders({
     'Authorization': `Bearer ${token}`
  });
     return this.httpClient.delete<any>(this.URL + `delete/${id}`,{headers})
  }



}
