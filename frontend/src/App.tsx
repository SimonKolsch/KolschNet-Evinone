
import {MantineProvider} from "@mantine/core";
import {RouterProvider} from "react-router-dom";
import {router} from "./setup";

import '@mantine/core/styles.layer.css';
import 'mantine-datatable/styles.layer.css';

import './layout.css'

function App() {

  return (
    <MantineProvider defaultColorScheme="auto">
      <RouterProvider router={router} />
    </MantineProvider>
  )
}

export default App
