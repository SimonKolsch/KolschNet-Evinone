import {Api} from "../Api.ts";
import {Account} from "../../types";

export class AccountApi {

  static async getAll(): Promise<Account[]> {
    return await Api.getInstance().get("account/get-all")
  }

  static async postAccount(newAccount: {iban: string, owner: string}) {
    await Api.getInstance().post("account/", newAccount);
  }
}