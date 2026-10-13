package com.attic.bj.weixinapi.transport;

import java.util.Map;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.attic.bj.weixinapi.exception.WeixinException;

public class HttpClientTransport implements Transport {

	private CloseableHttpClient httpclient;

	public HttpClientTransport() {
		PoolingHttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder
				.create().setMaxConnTotal(100).setMaxConnPerRoute(100).build();
		httpclient = HttpClients.custom().setConnectionManager(cm).build();
	}

	@Override
	public Object submit(Object object) throws WeixinException {
		// TODO Auto-generated method stub
		try {
			HttpClientRequest request = (HttpClientRequest) object;
			byte[] postData = request.getBody();
			HttpPost httpPost = new HttpPost(request.getUrl());
			httpPost.setEntity(new ByteArrayEntity(postData, null));
			if (request.getHeaders() != null) {
				Map<String, String> headers = request.getHeaders();
				for (String key : headers.keySet()) {
					httpPost.setHeader(key, headers.get(key));
				}
			}
			return httpclient.execute(httpPost, httpResponse -> {
				int result = httpResponse.getCode();
				if (result == 200) {
					byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
					return new HttpClientResponse(result, body);
				}
				EntityUtils.consume(httpResponse.getEntity());
				return new HttpClientResponse(result, null);
			});
		} catch (Exception e) {
			throw new WeixinException(999999, "httpclient.executeMethod", e);
		}
	}

}
