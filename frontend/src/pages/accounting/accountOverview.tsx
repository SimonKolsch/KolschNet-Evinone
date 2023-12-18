import React from "react";
import {useLoaderData} from "react-router-dom";
import {Account} from "../../common/types";
import { DataTable } from 'mantine-datatable';
import { useForm } from "@mantine/form";
import {Button, Group, TextInput } from "@mantine/core";

export const AccountOverview: React.FC = () => {
  const data: Account[] = useLoaderData() as Account[];
  const form = useForm({
    initialValues: {
      iban: '',
      owner: 1,
    },

    validate: {
      iban: (value) => (value.length == 22 ? null : 'Iban should have a length of 22 '),
    },
  });

  const submit = (values :{iban: string, owner: number}) => {
    console.log(values)
  }

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