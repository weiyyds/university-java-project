package com.sihai.utils;
import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117648289";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC6AQBh2KnFZrpMrNoJ3OiCCsHCuBOl/R091ZSjysDYUl78dnGLTQREXrp9uXgM+SadiFdJdcMTP/12OnjxgZhLEHKFiSaK/jUSoHLk0ldwHYFwc77sFUXWphT8Syxyo2jwoiZ+3olU75v6mX4xzn4PWHcUPcO/t4pi4yUo+kkKFqHXxfoAAUs1wrtUZhQYDlA7mCn1rKxd28clL6nbGQ4DqiKVDGd0sSPtShEXQps5S9VXpJDlfHWLSDlh4rUecs8dmIu22mzNXBZ6E5gWDBl3s8YdIYdO6gjwzE8bHZ1BGEkLnvRwrmQupg45NR8SWqhQXLtPt5cb7XF8AfzRI4XVAgMBAAECggEBAIpZ8lnVWboeBhbAP1I0wbDwpVzbpKnDkruKoQwP5M9CvapVw3EU8UaVm2umx/gGXsWwQxS+BkLMRxBov8sLVScIbdaLxGKAYSOgurUfC7C2EbB+N5XM4OyfDl7233HJwGW0hqO5jTbjHwcQosATUsrBR5mDs5VnxQR25g4L1MYt93wYO9pCvtEHsAXVaAlLoEKtksHUpJAnZahzuaEtbPViGH/Ygzl/EH2pSQpa8mkz1yJFzHE29JBjjMkJqyco+so9O/GtyLHy/s48pZvMqDJcnFxK8XBhviNxHz7HfFQbLIk1HJhbnHLtRS+0cvasCg46K34coFWmioGiPSHejYECgYEA7o4iyspL8Y08anTjw82B5ACHGwN4f/nxj7ln36khjcJoaynhv4ho4+50NNsKkeJtG+cRF9mRA/sds/2cMCTuZqK4solJlQo5eCzqP5uRa7r9/6zJsy8cHUPv1eY7tjW4DjF4Cl00Akdky0pkvRgNeKp5LR6qWTCxxecUAbmhDqECgYEAx5sUsAjJzLDNxjOjMyrYqvxeXBcOti1/e92w5HQnCa4PJj5Zb9dOSL2l/Pxy3xbiFWkXxyy0EQwef80IN/imZutKRsOBfDOwcyMiwst6hBDItWnke9fR1egHme4KKSdem+kKywVYS5d5WRbqy3dSOqYSToOwu4UjJPjA4vMbbrUCgYEAvRV4SliyfVG/c3oXFpoLvJcWf7juiDGq4IrK5KMAb4aKkXZu8wvCZ/gXr9V2uU9JwHYUPF087nTahFIevKJpPHz5/LmI01N5XeHsAmLijwt2THO+pAJRPHke3uJQrgpCSy22wjBCCxRftirPUnqAIwasabEGwQ8xuXWBjCSAnkECgYA2itXYVE5wNE/GPQ33SVnzPwq5t0M53KzdN/LCOksAhiN1m8vsl7S4g7n7qy/obeRRXWo17q01i046NdhtEvDFZr3hIEMdoTIyBAPXnqpXtA5kJA9fF9Yq0UBie30jSbK8f62HVGqQHU/3XB/EgVJi3EZcVffRBcxYqfBrE2sHkQKBgGSkjYOwQIfktVb1DXmR8KqoPTBbZQOmIGrLusEU1YMeV/pnG7NeDK067N3mscPTOmZqx3/naVNUSDaMj6KZB+kTuk4OIlQfy/DqT5RRSQKnVbOEiOSW9pQdEcihG7+nfiqJ3Nb5FRhNiUQ2fF+NnSK9EC1F9QyUYm3vquuNPesx";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr2YyOT2gGdklP6GzkjtxRUz5fPSmCcbBI2bNYr1hqmvr1hwdL+j6s9Y6Sdo8jV4SS7etBGuNHIGf5zTSclC7AAa+N5eH1LoTYOlLdMTk/6UDcsx1DiyYSNMsmTII1qn1K0w20Kl1CW+Pu8x8xraON2+QvuQIrvaMnRYsQkX8mLTDCPtNRHVcEssR3Y5QgPSrR7gB4IQkrFxxKaH0inl8pfV0inzzIM6RSnebxE3QXBgn/txTeeTuNW2k2X27gUopjyU2vc6w4lB9Nz0tsPifjspNtCW5quWfGdwCs5fWusQEqP5cL6XBYG1XxpyKuOtMj1sU75GUF2SwGQDaahxtnQIDAQAB";

	public static String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice.action";

	public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice.action";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


