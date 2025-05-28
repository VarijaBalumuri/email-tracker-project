import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { EmailService } from '../services/email.service';
import * as EmailActions from './email.actions';
import { catchError, map, mergeMap, of } from 'rxjs';

@Injectable()
export class EmailEffects {
  loadEmails$ = createEffect(() =>
    this.actions$.pipe(
      ofType(EmailActions.loadEmails),
      mergeMap(() =>
        this.emailService.getEmails().pipe(
          map(emails => EmailActions.loadEmailsSuccess({ emails })),
          catchError(error => of(EmailActions.loadEmailsFailure({ error })))
        )
      )
    )
  );

  constructor(private actions$: Actions, private emailService: EmailService) {}
}
