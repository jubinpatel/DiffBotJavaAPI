/**
 * 
 */
package com.DiffBot.Api;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.PostMethod;

import com.DiffBot.Constant.DiffBotConstant;
import com.DiffBot.Json.JSONException;
import com.DiffBot.Json.JSONObject;

/**
 * @author Administrator
 * 
 */
public class DiffBot {

	/**
	 * DiffBot's comman api call function
	 * 
	 * @param url
	 *            website url Which needs to check \n Example :
	 *            'http://www.roopfashion.com'
	 * @param token
	 *            Developer token which provided by DiffBot.
	 * @param api
	 *            Name of api which we need to call.
	 * @param fields
	 *            Which fields need in return object. \n Example : meta \n
	 *            querystring \n images(*)
	 * @param version
	 *            the version of api if required.
	 * 
	 * @return JSONObject
	 * 
	 * @throws URIException
	 *             If any URIException are detected.
	 * @throws JSONException
	 *             If any JSONExceptions are detected.
	 * @throws IOException
	 *             If any IOException are detected.
	 * @throws Exception
	 *             If any Exception are detected.
	 * */
	public static JSONObject APICall(String url, String token, String api, String[] fields, Integer version) {
		JSONObject jsonObject = null;
		try {

			String urlTosend = DiffBotConstant.DIFFBOT_API_URL;
			Boolean apicallFalg = false;
			if (version > 0) {
				urlTosend += "/" + DiffBotConstant.DIFFBOT_VERSION + "" + version;
			}
			if (api != null && api.trim().length() > 0) {
				urlTosend += "/" + api.trim();
			} else {
				return new JSONObject("{}");
			}
			if (token != null && token.trim().length() > 0) {
				urlTosend += DiffBotConstant.DIFFBOT_TOKEN + "" + token;
			} else {
				return new JSONObject("{}");
			}
			if (url != null && url.trim().length() > 0) {
				urlTosend += DiffBotConstant.DIFFBOT_REQ_URL + "" + url;
				apicallFalg = true;
			} else {
				return new JSONObject("{}");
			}
			if (fields != null && fields.length > 0) {
				boolean firstFieldFlag = true;
				for (String str : fields) {
					if (str != null && str.trim().length() > 0) {
						if (firstFieldFlag) {
							urlTosend += DiffBotConstant.DIFFBOT_FIELDS + "" + str.trim();
							firstFieldFlag = false;
						} else {
							urlTosend += "," + str.trim();
						}
					}
				}
			}

			if (apicallFalg) {
				HttpClient client = new HttpClient();
				PostMethod postMethod = new PostMethod(urlTosend);
				client.setConnectionTimeout(DiffBotConstant.DIFFBOT_TIMEOUT);
				postMethod.setRequestHeader(DiffBotConstant.DIFFBOT_HEADER_NAME, DiffBotConstant.DIFFBOT_HEADER_VALUE);
				client.executeMethod(postMethod);
				byte[] res = postMethod.getResponseBody();
				postMethod.releaseConnection();
				String response = new String(res);
				System.out.println("responseresponse = = = " + response);
				jsonObject = new JSONObject(response);
			}
		} catch (URIException uriE) {
			uriE.toString();
			uriE.printStackTrace();
			return new JSONObject("{}");
		} catch (JSONException jsoE) {
			jsoE.toString();
			jsoE.printStackTrace();
			return new JSONObject("{}");
		} catch (IOException ioE) {
			ioE.toString();
			ioE.printStackTrace();
			return new JSONObject("{}");
		} catch (Exception e) {
			e.toString();
			e.printStackTrace();
			return new JSONObject("{}");
		}
		return jsonObject;
	}

}
