import {AxiosRequestConfig, Method} from "axios";

/**
 * class for a http request
 *
 * @class Request
 */
export class Request {
	/**
	 * config for request with axios
	 */
	private config: AxiosRequestConfig;

	constructor(url: string, method: Method = "GET", config: AxiosRequestConfig = {}) {
		this.config = {
			method,
			url,
			...config,
		};
	}

	/**
	 * get the config for the request
	 */
	public getConfig(): AxiosRequestConfig {
		return this.config;
	}

	/**
	 * add or change a value in config
	 *
	 * @param key
	 * @param value
	 */
	public setConfigValue(key: string, value: any) {
		// @ts-ignore
		this.config[key] = value;
	}
}
