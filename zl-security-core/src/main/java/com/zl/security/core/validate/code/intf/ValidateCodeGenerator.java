package com.zl.security.core.validate.code.intf;

import com.zl.security.core.validate.code.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成抽象接口
 *
 * @author zhanglei
 *
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
