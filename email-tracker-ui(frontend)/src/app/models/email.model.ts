export interface Email {
  id: string;
  recipient: string;
  subject: string;
  status: 'delivered' | 'bounced' | 'sent';
}
