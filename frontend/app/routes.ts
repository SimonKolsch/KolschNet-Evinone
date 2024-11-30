import {type RouteConfig, index, route} from "@react-router/dev/routes";

export default [
    index("routes/home.tsx"),
    route("test", "routes/test.tsx"),
    route("account", "routes/account.tsx"),
    route("accountOverview", "routes/accountOverview.tsx")
] satisfies RouteConfig;
