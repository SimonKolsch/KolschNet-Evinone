import {json} from "react-router-dom";
import {AccountApi} from "../../common/api";
import {Account} from "../../common/types";

export async function accountOverviewLoader() {

  let test: Account[] = await AccountApi.getAll();

  return json(test, {status: 200});
}


export async function accountLoader(accountId: string | undefined) {

  console.log(accountId);
  if(accountId == undefined) {
    console.log("No AccountId present");
    return json("", {status: 500});
  }

  let account: Account = await AccountApi.getByID(accountId);

  return json(account, {status: 200});
}