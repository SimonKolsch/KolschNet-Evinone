import {json} from "react-router-dom";

export async function homeLoader() {
  return json(null, {status: 200});
}
