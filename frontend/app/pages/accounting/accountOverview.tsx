import React, {useState} from "react";
import {useLoaderData, useNavigate} from "react-router-dom";
import {Account} from "../../common/types";
import { DataTable } from 'mantine-datatable';
import { useForm } from "@mantine/form";
import {Button, Group, TextInput} from "@mantine/core";
import {AccountApi} from "../../common/api";

export const AccountOverview: React.FC = () => {

  const navigator = useNavigate();

  const [accountsData, setAccountsData] = useState(
      useLoaderData() as Account[]
  );

  const submit = (values :{iban: string, owner: string}) => {
    AccountApi.postAccount(values);
  }

  const reload = async () => {
    setAccountsData(await AccountApi.getAll());
  }

  const validateIban = (iban: string) : string | null => {
    const newIban = iban.split(" ").join("");
    console.log(newIban)
    return newIban.length == 22 ? null : 'Iban should have a length of 22 ';
  }

  const form = useForm({
    initialValues: {
      iban: '',
      owner: "ownerTest",
    },

    validate: {
      iban: (value) => validateIban(value),
    },
  });

  return (
      <>
      <form onSubmit={form.onSubmit((values) => {submit(values); form.reset()})}>
        <TextInput
            withAsterisk
            label="iban"
            placeholder="your Iban"
            {...form.getInputProps('iban')}
        />

        <Group justify="flex-end" mt="md">
          <Button type="button" onClick={() => reload()}>Reload</Button>
          <Button type="reset" onClick={() => form.reset()}>Reset</Button>
          <Button type="submit">Submit</Button>
        </Group>
      </form>
  <DataTable
      withTableBorder
      borderRadius="sm"
      withColumnBorders
      striped
      highlightOnHover
      // provide data
      records={accountsData}
      // define columns
      columns={[
        {
          accessor: 'id',
          // this column has a custom title
          title: '#',
          // right-align column
          textAlign: 'right',
        },
        {accessor: 'iban'},
        {
          accessor: 'owner',
        },
      ]}
      onRowClick={({ record}) => {
        navigator("/account/" + record.id);
      }}
  />
</>
)
  ;
};