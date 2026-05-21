import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL = 'http://localhost:8090/auth';

  constructor(private http: HttpClient) {}

  login(data: any) {
    return this.http.post<any>(`${this.URL}/login`, data);
  }

  saveToken(token: string) {
    sessionStorage.setItem('token', token);
  }

  getToken() {
    return sessionStorage.getItem('token');
  }
  
 saveUsername(username: string) {
    sessionStorage.setItem(
      'username',
      username
    );
  }

  getUsername(): string | null {
    return sessionStorage.getItem(
      'username'
    );
  }

isLogged(): boolean {
  const token = this.getToken();
  if (!token) return false;

  try {
    const payload = JSON.parse(atob(token.split('.')[1]));
    return payload.exp * 1000 > Date.now();
  } catch {
    return false;
  }
}

  isDemo(): boolean {
    return this.getUsername() === 'demo';
  }


logout() {
  sessionStorage.clear();
  window.location.reload();
}
}