package com.helper;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import net.rim.device.api.io.IOUtilities;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;
import org.json.me.JSONTokener;

public class JSONParser {
	static InputStream is = null;
	static Object jObj = null;
	static String json = null;
	public JSONParser() {		
	}

	/**
	 * Gets the json from url.
	 *
	 * @param url the url
	 * @return the json from url
	 */
	public Object getJsonFromUrl(String url){
		//Making Http GET request
		try {
			HttpConnection con = (HttpConnection) Connector.open(url);
			con.setRequestMethod(HttpConnection.GET);
			is = con.openInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			json = new String(IOUtilities.streamToBytes(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Check JSON string for it is jObj or jArray
		try {
			Object jCheck = new JSONTokener(json).nextValue();
			if (jCheck != null) {
				if (jCheck instanceof JSONObject) {
					//Try to parse the string to JSON object
					jObj = new JSONObject(json);
				}else if (jCheck instanceof JSONArray) {
					//Try to parse the string to JSON array
					jObj = new JSONArray(json);
				}
			}else {
				jObj = null;
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jObj;
	}
}
