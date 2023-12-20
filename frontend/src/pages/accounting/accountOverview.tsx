import React from "react";
import {useLoaderData} from "react-router-dom";
import {Account} from "../../common/types";
import { DataTable } from 'mantine-datatable';
import { useForm } from "@mantine/form";
import {Button, Group, TextInput } from "@mantine/core";
import {AccountApi} from "../../common/api";

export const AccountOverview: React.FC = () => {
  const data: Account[] = useLoaderData() as Account[];

  const submit = (values :{iban: string, owner: string}) => {
    AccountApi.postAccount(values);
  }

  const form = useForm({
    initialValues: {
      iban: '',
      owner: "ownerTest",
    },

    validate: {
      iban: (value) => (value.length == 22 ? null : 'Iban should have a length of 22 '),
    },
  });

  return (
      <>
      <form onSubmit={form.onSubmit((values) => submit(values))}>
        <TextInput
            withAsterisk
            label="iban"
            placeholder="your Iban"
            {...form.getInputProps('iban')}
        />

        <Group justify="flex-end" mt="md">
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
      records={data}
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
  />
</>
)
  ;
};