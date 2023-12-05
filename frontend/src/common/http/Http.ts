import axios, {AxiosInstance, AxiosRequestConfig} from "axios";

import {
  Request,
  GetRequest,
  PostRequest,
  PutRequest,
  DeleteRequest
} from "./index.ts";

/**
 * class for requesting to server
 *
 * @class Http
 */
export class Http {
  /**
   * axios instance for http requests
   */
  private http: AxiosInstance;

  /**
   * default config for axios
   */
  private defaultConfig: AxiosRequestConfig = {};

  constructor() {
    this.http = axios.create(this.defaultConfig);
  }

  /**
   * http get request
   *
   * @param url
   * @param config
   */
  public get(url: string, config: AxiosRequestConfig = {}) {
    const request = new GetRequest(url, config);
    return this.request(request);
  }

  /**
   * http post request
   *
   * @param url
   * @param data
   * @param config
   */
  public post(url: string, data: any, config: AxiosRequestConfig = {}) {
    const request = new PostRequest(url, data, config);
    return this.request(request);
  }

  /**
   * http put request
   *
   * @param url
   * @param data
   * @param config
   */
  public put(url: string, data: any, config: AxiosRequestConfig = {}) {
    const request = new PutRequest(url, data, config);
    return this.request(request);
  }

  /**
   * http delete request
   *
   * @param url
   * @param config
   */
  public delete(url: string, config: AxiosRequestConfig = {}) {
    const request = new DeleteRequest(url, config);
    return this.request(request);
  }

  /**
   * execute a http request for Request Object
   *
   * @param request
   */
  public request(request: Request) {
    return this.http.request(request.getConfig()).then(response => response.data);
  }
}
