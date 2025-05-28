import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Email } from '../models/email.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class EmailService {
  private baseUrl = `${environment.apiBaseUrl}/emails`;

  constructor(private http: HttpClient) {}

  getEmails(): Observable<Email[]> {
    return this.http.get<Email[]>(this.baseUrl);
  }
}
