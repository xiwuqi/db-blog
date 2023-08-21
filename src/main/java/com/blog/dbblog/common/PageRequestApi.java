package com.blog.dbblog.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;

/**
 * 封装请求的参数
 *
 * @author wuxi
 * @create 2023-08-21
 */

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class PageRequestApi<T> {

    @Valid
    private T body = null;

    public PageRequestApi() {
    }

    public PageRequestApi(T body) {
        this.body = body;
    }

    public static <T> PageRequestApi<T> instance(T body) {
        return new PageRequestApi(body);
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(final T body) {
        this.body = body;
    }

}
