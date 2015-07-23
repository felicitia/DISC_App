package util;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public static boolean testGet(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "temperature_id");
		params.put("data_type", "bbb");
		params.put("standard", "ccc");
		System.out.println(getResponseFromGET("http", "localhost:9000", "entityrawcontext", params));
		return true;
	}
	
	public static String getResponseFromGET(String scheme, String host,
			String path, Map<String, String> params) {

		URI uri = null;
		URIBuilder uriBuilder = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String results = null;
		try {
			uriBuilder = new URIBuilder().setScheme(scheme).setHost(host)
					.setPath("/" + path);
			if (params != null) {
				Iterator it = params.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry param = (Map.Entry) it.next();
					uriBuilder.setParameter(param.getKey().toString(), param
							.getValue().toString());
					it.remove();
				}
			}
			uri = uriBuilder.build();
			HttpGet httpget = new HttpGet(uri);
			response = httpclient.execute(httpget);
			results = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return results;
	}
}
