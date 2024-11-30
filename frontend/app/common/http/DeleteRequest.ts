import {Request} from "./Request.ts";
import {AxiosRequestConfig} from "axios";

/**
 * request for http method DELETE
 *
 * @class DeleteRequest
 */
export class DeleteRequest extends Request {
	constructor(url: string, config: AxiosRequestConfig = {}) {
		super(url, "DELETE", config);
	}
}
