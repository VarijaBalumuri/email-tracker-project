import { createReducer, on } from '@ngrx/store';
import * as EmailActions from './email.actions';
import { Email } from '../models/email.model';

export interface EmailState {
  emails: Email[];
  filteredStatus: string;
  loading: boolean;
  error: any;
}

export const initialState: EmailState = {
  emails: [],
  filteredStatus: 'all',
  loading: false,
  error: null
};

export const emailReducer = createReducer(
  initialState,
  on(EmailActions.loadEmails, state => ({ ...state, loading: true })),
  on(EmailActions.loadEmailsSuccess, (state, { emails }) => ({ ...state, emails, loading: false })),
  on(EmailActions.loadEmailsFailure, (state, { error }) => ({ ...state, loading: false, error })),
  on(EmailActions.filterEmails, (state, { status }) => ({ ...state, filteredStatus: status }))
);
