/**
 * 
 */
package com.zl.security.core.validate.code.intf;

/**
 * @author zhailiang
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
