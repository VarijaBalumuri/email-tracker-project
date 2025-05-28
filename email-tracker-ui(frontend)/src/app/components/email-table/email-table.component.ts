import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Email } from '../../models/email.model';
import { selectFilteredEmails } from '../../store/email.selectors';
import * as EmailActions from '../../store/email.actions';

@Component({
  selector: 'app-email-table',
  templateUrl: './email-table.component.html',
  styleUrls: ['./email-table.component.scss']
})
export class EmailTableComponent implements OnInit {
  emails$: Observable<Email[]>;

  constructor(private store: Store) {
    this.emails$ = this.store.select(selectFilteredEmails);
  }

  ngOnInit(): void {
    this.store.dispatch(EmailActions.loadEmails());
  }

  statusChipClass(status: string): string {
    switch (status) {
      case 'delivered':
        return 'chip status delivered';
      case 'bounced':
        return 'chip status bounced';
      case 'sent':
      default:
        return 'chip status sent';
    }
  }
}
