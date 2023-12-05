import {createBrowserRouter, redirect} from "react-router-dom";
import {AccountOverview} from "../../pages/accounting/accountOverview.tsx";
import {accountLoader} from "../../pages/accounting/module.ts";

export const router = createBrowserRouter([
  {
    path: "/",
    loader: async () => {return redirect("/accounts");}
  },
  {
    path: "/accounts",
    loader: accountLoader,
    element: <AccountOverview />,
  },
]);
