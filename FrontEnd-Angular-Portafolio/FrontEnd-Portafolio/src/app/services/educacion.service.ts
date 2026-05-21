import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { educacion } from '../models/educacion.model';


@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  URL = 'http://localhost:8090/educacion/';

  constructor(private httpClient: HttpClient) { }

  public getEducacion(): Observable<educacion[]>{
   return this.httpClient.get<educacion[]>(this.URL + 'listar');

  }

  public detail(id:number): Observable<educacion>{
    return this.httpClient.get<educacion>(this.URL + `detail/${id}`)
  }

  public save(educacion: educacion): Observable<any>{
     const token = sessionStorage.getItem('token');
     const headers = new HttpHeaders({
     'Authorization': `Bearer ${token}`
  });

   return this.httpClient.post<any>(this.URL + 'new', educacion,{headers})
  }

  public update(id: number , educacion: educacion): Observable<any> {
     const token = sessionStorage.getItem('token');
     const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`
  });

    return this.httpClient.put<any>(this.URL + `update/${id}`, educacion,{headers});
  }
 
  public delete(id: number): Observable<any>{
    const token = sessionStorage.getItem('token');
    const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}`
  });
    return this.httpClient.delete<any>(this.URL + `delete/${id}`,{headers})
  }

}
