/**
 * 
 */
package com.zl.security.core.validate.code.sms;

import com.zl.security.core.validate.code.ValidateCode;
import com.zl.security.core.validate.code.intf.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhailiang
 *
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {


	/**
	 * 生成的实现
	 * @param request
	 * @return
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(6);
		return new ValidateCode(code, 60);
	}
}
