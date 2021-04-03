package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 前后端约定好的统一响应数据格式
 * 前端发送ajax请求后，需要根据该格式来解析
 */
public class Response {
    /**
     * 当前HTTP请求的业务操作是否成功
     */
    private boolean ok;
    /**
     * 操作成功时，响应的业务数据
     */
    private Object data;
    /**
     * 操作失败时，响应的错误码
     */
    private String code;
    /**
     * 操作失败时，响应的错误信息
     */
    private String message;
}
