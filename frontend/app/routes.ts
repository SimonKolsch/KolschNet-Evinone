import {type RouteConfig, index, route, layout} from "@react-router/dev/routes";

export default [
    layout("pages/layout.tsx", [
        index("routes/home.tsx"),
        route("test", "routes/test.tsx"),
        layout("pages/hokebo/layout/layout.tsx", [
            route("account", "routes/account.tsx"),
            route("accountOverview", "routes/accountOverview.tsx")
        ]),
    ]),
] satisfies RouteConfig;
