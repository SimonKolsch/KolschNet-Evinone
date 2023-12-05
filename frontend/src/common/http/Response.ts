/**
 * class for a http response from server
 *
 * @class Response
 */
export class Response {
	/**
	 * status code of the response
	 */
	private _status: number;

	/**
	 * data of the response
	 */
	private _data: any;

	constructor(status: number, data: any = null) {
		this._status = status;
		this._data = data;
	}

	/**
	 * getter for status code
	 */
	get status(): number {
		return this._status;
	}

	/**
	 * getter for data
	 */
	get data(): any {
		return this._data;
	}
}
