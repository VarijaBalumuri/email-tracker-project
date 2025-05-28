import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { EmailTableComponent } from './components/email-table/email-table.component';
import { StatusFilterComponent } from './components/status-filter/status-filter.component';
import { emailReducer } from './store/email.reducer';
import { EmailEffects } from './store/email.effects';
import { MatCardModule } from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    EmailTableComponent,
    StatusFilterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    StoreModule.forRoot({ emails: emailReducer }),
    EffectsModule.forRoot([EmailEffects]),
    MatCardModule,
    StoreDevtoolsModule.instrument({ maxAge: 25 }),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
