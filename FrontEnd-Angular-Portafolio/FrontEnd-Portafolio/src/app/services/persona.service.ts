import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../models/persona.model';



@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8090/persona/';
  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona> {
    return this.http.get<persona>(this.URL+ 'obtener');
  }

  public updatePersona(id: number , persona: persona): Observable<any> {
    return this.http.put<any>(this.URL + `update/${id}`, persona);
  }


}
