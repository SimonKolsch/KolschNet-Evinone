import React from "react";
import {useLoaderData} from "react-router-dom";

export const Account: React.FC = () => {

  console.log(useLoaderData());

  return (
      <>
       Hey I am your Account
      </>
  );
};