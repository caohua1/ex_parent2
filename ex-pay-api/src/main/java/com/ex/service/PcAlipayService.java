package com.ex.service;

import java.io.IOException;

public interface PcAlipayService {

    public String PcAlipay(String  out_trade_no, String total_amount, String subject, String body) throws IOException;

}
