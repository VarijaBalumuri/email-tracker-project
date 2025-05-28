import { createAction, props } from '@ngrx/store';
import { Email } from '../models/email.model';

export const loadEmails = createAction('[Email] Load Emails');
export const loadEmailsSuccess = createAction('[Email] Load Emails Success', props<{ emails: Email[] }>());
export const loadEmailsFailure = createAction('[Email] Load Emails Failure', props<{ error: any }>());
export const filterEmails = createAction('[Email] Filter Emails', props<{ status: string }>());
