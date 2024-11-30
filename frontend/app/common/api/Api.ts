import {AxiosRequestConfig} from "axios";
import {Http} from "../http";

/**
 * class for api calls
 *
 * @class Api
 */
export class Api {
  /**
   * static instance of the api
   */
  public static apiInstance: Api;

  /**
   * get the api instance
   *
   * when no instance exists a new one is created
   */
  public static getInstance() {
    if (!Api.apiInstance) {
      Api.apiInstance = new Api();
    }
    return Api.apiInstance;
  }

  /**
   * url to api
   */
  private apiUrl: string;

  /**
   * object for http requests to api
   */
  private http: Http;

  constructor() {
    this.apiUrl = `http://localhost:9900/hokebo`;
    this.http = new Http();
  }

  /**
   * get request to api
   *
   * @param path
   */
  public get(path: string) {
    console.log(path, "PATH");
    return this.http.get(this.buildUrl(path), this.getHttpConfigWithAuthorizationHeader());
  }

  /**
   * post request to api
   *
   * @param path
   * @param data
   */
  public post(path: string, data: any) {
    return this.http.post(this.buildUrl(path), data, this.getHttpConfigWithAuthorizationHeader());
  }

  /**
   * put request to api
   *
   * @param path
   * @param data
   */
  public put(path: string, data: any) {
    return this.http.put(this.buildUrl(path), data, this.getHttpConfigWithAuthorizationHeader());
  }

  /**
   * delete request to api
   *
   * @param path
   */
  public delete(path: string) {
    return this.http.delete(this.buildUrl(path), this.getHttpConfigWithAuthorizationHeader());
  }

  /**
   * build the path to a api endpoint
   *
   * @param path
   */
  private buildUrl(path: string) {
    return this.apiUrl + "/" + path;
  }

  private getHttpConfigWithAuthorizationHeader(): AxiosRequestConfig {
    return {};
  }
}
