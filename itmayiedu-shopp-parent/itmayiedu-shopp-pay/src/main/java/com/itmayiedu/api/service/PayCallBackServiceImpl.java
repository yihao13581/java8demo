package com.itmayiedu.api.service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.itmayeidu.api.service.PayCallBackService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.dao.PaymentInfoDao;
import com.itmayiedu.entity.PaymentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @CLassName PayCallBackServiceImpl
 * @Description: TODO
 * @date: 2019/12/26 11:40
 * @Version 1.0
 */
@Slf4j
@RestController
public class PayCallBackServiceImpl extends BaseApiService implements PayCallBackService {
	@Autowired
	private PaymentInfoDao paymentInfoDao;

	public ResponseBase synCallBack(@RequestParam Map<String, String> params) {
		//获取支付宝Get过来反馈信息
		try {
			log.info("#####同步回调开始#######：", params);
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
					AlipayConfig.charset, AlipayConfig.sign_type);//调用SDK验证签名
			//------请在这里编写您的程序(以下代码仅供参考)------
			if (!signVerified) {
				return setResultError("验签失败");
			}
			//商户订单号
			String out_trade_no = params.get("out_trade_no");
			//支付宝交易号
			String trade_no = params.get("trade_no");
			//付款金额
			String total_amount = params.get("total_amount");
			JSONObject data = new JSONObject();
			data.put("out_trade_no", out_trade_no);
			data.put("trade_no", trade_no);
			data.put("total_amount", total_amount);
			return setResultSuccess(data);
		} catch (Exception e) {
			log.info("#####PayCallBackServiceImpl###ERROR:#####", e);
			return setResultError("系统错误");
		} finally {
			log.info("######同步回调结束###params", params);
		}}

		//异步回调
		public String aysnCallBack(@RequestParam Map< String,String > params){
			//获取支付宝GET过来反馈信息
			try {
				log.info("#####异步回调开始####params:", params);
				boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
						AlipayConfig.charset, AlipayConfig.sign_type); // 调用SDK验证签名
				// ——请在这里编写您的程序（以下代码仅作参考）——
				if (!signVerified) {
					return "fail";
				}
				// 商户订单号
				String outTradeNo = params.get("out_trade_no");
				PaymentInfo paymentInfo = paymentInfoDao.getByOrderIdPayInfo(outTradeNo);
				if (paymentInfo == null) {
					return "fail";
				}
				Integer state = paymentInfo.getState();
				if (state.equals("1")) {
					return "success";
				}
				// 支付宝交易号
				String trade_no = params.get("trade_no");
				// 交易状态
				String trade_status = params.get("trade_status");
				if (trade_status.equals("TRADE_SUCCESS")) {
					paymentInfo.setPayMessage(params.toString());
					paymentInfo.setPlatformorderId(trade_no);
					paymentInfo.setState(1);
					paymentInfoDao.updatePayInfo(paymentInfo);
				}
				return "success";
			} catch (Exception e) {
				log.info("######PayCallBackServiceImpl##ERROR:#####", e);
				return "fail";
			} finally {
				log.info("####异步回调结束####params:", params);
			}
		}



	}