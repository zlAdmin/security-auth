## 使用到的知识点体系

# 1.maven 
- 模块化
- 依赖管理
- 项目构建
# 2.springboot
- 测试用例的写法、验证、在Mapping中的正则参数校验
- restFul API的用法
- JsonView的用法

# 3. 处理创建请求
- @RequestBody映射请求体到java方法参数
- 日期类型参数的处理
- @Valid注解和BindingResult验证请求参数的合法性并处理校验结果
- validate 参数数据校验
# 4. 异常处理
- springboot默认的错误处理机制,定义404异常页面
- restFul的拦截机制 （过滤器、拦截器、切片）
# 5. 文件上传下载
# 6. 异步处理REST服务 （AsyncController）
- 使用runnable异步处理rest服务
- 使用DeferredResult异步处理REST服务
- 异步处理配置
# 7. 与前端并行工作 
 * 7.1 使用swagger生成html文档
 *  swagger常用三种注解： @ApiOperation, @ApiModelProperty, @ApiParam
 * 7.2 使用wireMock快速伪造RESTFul服务

 - swagger使用步骤： 
- （1）引入依赖
- （2）在spring启动类上加入@EnableSwagger2注解
- （3）http://localhost:8089/swagger-ui.html 
- wiremock使用步骤
-  见MockService

# 8.SpringSecurity 核心功能
 - 认证
 - 授权
 - 攻击防护
 好
## 8.1 自定义用户认证逻辑（处理用户信息获取逻辑、处理用户校验逻辑、处理密码加密解密） 
 - 见MyUserDetailsService，
  用户创建建议流程：前端通过公钥加密密码，传输到后端通过私钥解密，在调用passwordEncoder.encode进行加密存储；
  
 - 个性过用户认证流程
  >> 自定义登录界面
  >> 自定义登录成功处理
  >> 自定义登录失败处理
 