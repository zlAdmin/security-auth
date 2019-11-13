package com.zl.security.core.validate.code.sms;

import com.zl.security.core.validate.code.intf.SmsCodeSender;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
 *
 */
@Component
public class DefaultSmsCodeSender implements SmsCodeSender {

	/**
	 * 发送
	 * @param mobile
	 * @param code
	 */
	@Override
	public void send(String mobile, String code) {
		// TODO: 2019/11/12  发送实现
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
