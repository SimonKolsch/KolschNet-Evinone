import {createBrowserRouter} from "react-router-dom";
import {
  AccountOverview,
  Account,
  accountLoader,
  accountOverviewLoader,
  homeLoader, Home
} from "../../pages";

export const router = createBrowserRouter([
  {
    path: "/",
    loader: homeLoader,
    element: <Home />,
    //loader: async () => {return redirect("/accounts");}
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
