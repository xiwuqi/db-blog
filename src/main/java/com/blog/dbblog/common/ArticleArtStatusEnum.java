package com.blog.dbblog.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文章发布形式的枚举类
 *
 * @author wuxi
 * @create 2023-08-24
 */

@Getter
@AllArgsConstructor
public enum ArticleArtStatusEnum {
    /**
     * 发布
     */
    PUBLISH(1, "发布"),
    /**
     * 仅我可见
     */
    ONLYME(2, "仅我可见"),
    /**
     * 草稿
     */
    DRAFT(3, "草稿");

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 描述
     */
    private final String desc;
}

