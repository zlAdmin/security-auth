package com.zl.dto;

/**
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 14:59
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    private String  path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
