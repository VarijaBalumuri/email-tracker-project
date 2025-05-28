import { createSelector, createFeatureSelector } from '@ngrx/store';
import { EmailState } from './email.reducer';

export const selectEmailState = createFeatureSelector<EmailState>('emails');

export const selectAllEmails = createSelector(
  selectEmailState,
  state => state.emails
);

export const selectFilteredStatus = createSelector(
  selectEmailState,
  state => state.filteredStatus
);

export const selectFilteredEmails = createSelector(
  selectAllEmails,
  selectFilteredStatus,
  (emails, status) => {
    if (status === 'all') {
      return emails;
    }
    return emails.filter(e => e.status === status);
  }
);
