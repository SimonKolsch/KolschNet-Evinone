import {Request} from "./Request.ts";
import {AxiosRequestConfig} from "axios";

/**
 * request for http method POST
 *
 * @class PostRequest
 */
export class PostRequest extends Request {
	constructor(url: string, data: any, config: AxiosRequestConfig = {}) {
		super(url, "POST", config);
		this.setConfigValue("data", data);
	}
}
