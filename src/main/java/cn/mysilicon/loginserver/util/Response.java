package cn.mysilicon.loginserver.util;

import java.util.Objects;


public class Response {
    private Integer user_id;
    private String uname;
    private Integer code;
    private String msg;
    private String token;


    public Response(Integer user_id, String uname, Integer code, String msg, String token) {
        this.user_id = user_id;
        this.uname = uname;
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    @Override
    public String toString() {
        return "Response{" +
                "user_id='" + user_id +'\'' +
                "uname='" + uname + '\'' +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return  Objects.equals(user_id, response.user_id) &&
                Objects.equals(uname, response.uname) &&
                Objects.equals(code, response.code) &&
                Objects.equals(msg, response.msg) &&
                Objects.equals(token, response.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id,uname, code, msg, token);
    }
}


