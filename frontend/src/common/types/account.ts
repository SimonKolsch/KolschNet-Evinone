import {AuditInformation} from "./";

export type Account = {
  id: number;
  iban: string;
  owner: string;
  auditInfo: AuditInformation
}
