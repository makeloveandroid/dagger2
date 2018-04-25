package com.example.mvp.entity;

/**
 * Created by wenyingzhi on 2018/4/23.
 */

public class UserInfo {

    /**
     * status : error
     * msg : failuserid
     */

    private String status;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
