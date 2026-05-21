import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../models/persona.model';



@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8090/persona/';
  constructor(private httpClient: HttpClient) { }

  public getPersona(): Observable<persona> {
    return this.httpClient.get<persona>(this.URL+ 'obtener');
  }

  public updatePersona(id: number , persona: persona): Observable<any> {
  const token = sessionStorage.getItem('token');

  const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`
  });

  return this.httpClient.put<any>(this.URL + `editar/${id}`, persona, { headers });
}


}
