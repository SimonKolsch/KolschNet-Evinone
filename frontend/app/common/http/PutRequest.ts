import {Request} from "./Request.ts";
import {AxiosRequestConfig} from "axios";

/**
 * request for http method PUT
 *
 * @class PutRequest
 */
export class PutRequest extends Request {
	constructor(url: string, data: any, config: AxiosRequestConfig = {}) {
		super(url, "PUT", config);
		this.setConfigValue("data", data);
	}
}
