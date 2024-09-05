import {createBrowserRouter, redirect} from "react-router-dom";
import {AccountOverview, Account, accountLoader, accountOverviewLoader} from "../../pages";

export const router = createBrowserRouter([
  {
    path: "/",
    loader: async () => {return redirect("/accounts");}
  },
  {
    path: "/accounts",
    loader: accountOverviewLoader,
    element: <AccountOverview />,
  },
  {
    path: "/account/:accountId",
    loader: ({params}) => accountLoader(params.accountId),
    element: <Account />,
  },
]);
