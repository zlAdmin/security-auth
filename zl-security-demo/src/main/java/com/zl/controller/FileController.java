package com.zl.controller;

import com.zl.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件上传
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 14:58
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@RestController
@RequestMapping("/file")
public class FileController {
    String  folder = "F:\\testFile";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        /**
         * 将文件流的一些操作放到try的括号后，jdk会自动关闭这些文件流
         */
        try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename-test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
