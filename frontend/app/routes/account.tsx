import type { Route } from "./+types/account";
import {AccountApi} from "~/common/api";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "New React Router App" },
    { name: "description", content: "Welcome to React Router!" },
  ];
}

export default function Account() {
  return (
      <>
        Welcome on Accounting
      </>
  );
}

// export async function accountLoader(accountId: string | undefined) {
//
//   console.log(accountId);
//   if(accountId == undefined) {
//     console.log("No AccountId present");
//     return json("", {status: 500});
//   }
//
//   let account: Account = await AccountApi.getByID(accountId);
//
//   return json(account, {status: 200});
// }