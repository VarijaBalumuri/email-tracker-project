import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import * as EmailActions from '../../store/email.actions';

@Component({
  selector: 'app-status-filter',
  templateUrl: './status-filter.component.html',
  styleUrls: ['./status-filter.component.scss']
})
export class StatusFilterComponent {
  statuses = ['all', 'delivered', 'bounced', 'sent'];

  constructor(private store: Store) {}

  filter(status: string): void {
    this.store.dispatch(EmailActions.filterEmails({ status }));
  }
}
