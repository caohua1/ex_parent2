package com.ex.util.weixinPay;


import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
public class MyConfig implements WXPayConfig {

	private byte[] certData;

	public MyConfig() throws Exception {
		String certPath = "C:/acp/cert/apiclient_cert.p12";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	public String getAppID() {
		return "wx34a6e99e81f0014e";
	}

	public String getMchID() {
		return "1512098961";
	}

	public String getKey() {
		return "3FImDblzSDAXkH5381ibAIkDiYVHVQob";
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}

}