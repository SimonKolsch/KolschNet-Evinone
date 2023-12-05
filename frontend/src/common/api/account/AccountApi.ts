import {Api} from "../Api.ts";
import {Account} from "../../types";

export class AccountApi {

  static async getAll(): Promise<Account[]> {
    return await Api.getInstance().get("account/get-all")
  }
}