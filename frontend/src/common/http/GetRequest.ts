import {Request} from "./Request.ts";
import {AxiosRequestConfig} from "axios";

/**
 * request for http method GET
 *
 * @class GetRequest
 */
export class GetRequest extends Request {
	constructor(url: string, config: AxiosRequestConfig = {}) {
		super(url, "GET", config);
	}
}
