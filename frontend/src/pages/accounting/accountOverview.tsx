import React from "react";
import {useLoaderData} from "react-router-dom";
import {Account} from "../../common/types";

export const AccountOverview: React.FC = () => {
  const data: Account[] = useLoaderData() as Account[];
  const listItems = data.map((account) =>
      <li key={account.id}>
        {account.auditInfo.lastModifiedBy}
      </li>
  );
  return (
      <ul>{listItems}</ul>
  );
};