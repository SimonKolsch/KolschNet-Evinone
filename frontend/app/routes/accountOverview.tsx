import type { Route } from "./+types/accountOverview";
import {AccountApi} from "~/common/api";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "New React Router App" },
    { name: "description", content: "Welcome to React Router!" },
  ];
}

export default function AccountOverview() {
  return (
      <>
        Welcome on Accounting Overview
      </>
  );
}

// export async function accountOverviewLoader() {
//
//   let test: Account[] = await AccountApi.getAll();
//
//   return json(test, {status: 200});
// }
