package com.example.smarthomeweb;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yihan Chen
 * @date 2022/7/22 11:10
 */
@Data
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -7995058338163551623L;
    public static final int SUCCESS_CODE = 200;
    private int code;
    private String message;
    private T data;
    private boolean success;
    private Map<String, Object> params;
    public ApiResult() {
        this.code = 200;
        this.success = true;
    }
    private ApiResult(T data) {
        this.code = 200;
        this.data = data;
        this.success = true;
    }
    private ApiResult(int errorCode, String message) {
        this.code = errorCode == 0 ? 500 : errorCode;
        this.message = message;
        this.success = false;
    }
    public void addParams(String key, Object value) {
        if (!key.isBlank()) {
            if (null == this.params) {
                this.params = new HashMap();
            }
            this.params.put(key, value);
        }
    }
    public static <T> ApiResult<T> ok() {
        return new ApiResult();
    }

    public static <T> ApiResult<T> ok(T data) {

        return new ApiResult(data);

    }
    public static <T> ApiResult<T> error(String message) {
        return new ApiResult(500, message);
    }

    public static <T> ApiResult<T> error(int errorCode, String message) {
        return new ApiResult(errorCode, message);
    }
    public static <T> ApiResult<T> badRequest(String message) {
        return new ApiResult(400, message);
    }
    @Override
    public String toString() {
        return "ApiResult{code=" + this.code + ", message='" + this.message + '\'' + ", data=" + this.data + ", success=" + this.success + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResult)) {
            return false;
        } else {
            ApiResult<?> other = (ApiResult) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }
                if (this.isSuccess() != other.isSuccess()) {
                    return false;
                } else {
                    Object this$params = this.getParams();
                    Object other$params = other.getParams();
                    if (this$params == null) {
                        return other$params == null;
                    } else {
                        return this$params.equals(other$params);
                    }
                }
            }
        }
    }
    protected boolean canEqual(Object other) {
        return other instanceof ApiResult;
    }
}
