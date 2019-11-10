package com.zl.wirmock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;

/**
 * wiremock使用
 * wiremock作用：伪造后端接口，供前端快速调用，一般返回数据固定，读取固定的json
 *
 * 使用步骤：
 * （1）：下载服务的jar包 ：http://wiremock.org/docs/running-standalone/    并启动服务 java -jar wiremock-standalone-2.25.1.jar --port 8062
 * （2）：项目引入wiremock的依赖
 * （3）：写wiremock的连接
 *  (4): 启动main方法
 *  (5): 前端访问localhost:8062 ,调用相关接口即可
 *
 *
 *  此项目一般部署成单独项目，不放在主项目工程中
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 16:48
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/

public class MockService {

    /*public static void main(String[] args) throws IOException {
        WireMock.configureFor(8062);
        WireMock.removeAllMappings();

        getMock("/order/1", "01");
        postMock("/order", "02");
    }*/

    private static void getMock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/resource/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
    private static void postMock(String url, String file) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/resource/" + file + ".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "\n");
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}
