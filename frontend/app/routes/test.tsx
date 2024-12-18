import type { Route } from "./+types/test";
import {Account, LoaderData} from "~/common/types";
import {AccountApi} from "~/common/api";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "New React Router App" },
    { name: "description", content: "Welcome to React Router!" },
  ];
}

export default function Test({loaderData}: {loaderData: LoaderData}) {
  return (
      <>
        Test Me - {loaderData.message}
      </>
  );
}

export async function loader(): Promise<LoaderData> {
  let test: Account = await AccountApi.getByID(1);
  console.log(test);
  return { message: "Hello, world! " + test.iban };
}