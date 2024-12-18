import {Api} from "../Api.ts";
import {Account} from "../../types";

export class AccountApi {

  static urlVersion = "v1/account";

  static async getAll(): Promise<Account[]> {
    return await Api.getInstance().get(this.urlVersion + "/get-all")
  }

  static async getByID(accountId: number): Promise<Account> {
    return await Api.getInstance().get(this.urlVersion + "/by-id/" + accountId);
  }

  static async postAccount(newAccount: {iban: string, owner: string}) {
    await Api.getInstance().post(this.urlVersion + "/", newAccount);
  }
}