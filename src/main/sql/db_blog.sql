DROP TABLE IF EXISTS `person_article`;
CREATE TABLE `person_article` (
  `id`             INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  `author`         VARCHAR(128)    NOT NULL                            COMMENT '作者',
  `title`          VARCHAR(255)    NOT NULL                            COMMENT '文章标题',
  `user_id`        INT(11)         NOT NULL                            COMMENT '用户id',
  `content`        LONGTEXT        NOT NULL                            COMMENT '文章内容',
  `views`          BIGINT          NOT NULL DEFAULT 0                  COMMENT '文章浏览量',
  `total_words`    BIGINT          NOT NULL DEFAULT 0                  COMMENT '文章总字数',
  `commentable_id` INT    		       NULL                            COMMENT '评论id',
  `art_status`     TINYINT    	   NOT NULL DEFAULT 1                  COMMENT '发布，默认1, 1-发布, 2-仅我可见  3-草稿',
  `description`    VARCHAR(255)        NULL                            COMMENT '描述',
  `image_url`      VARCHAR(255)        NULL                            COMMENT '文章logo',
  `create_time`    DATETIME            NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  `update_time`    DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
    COMMENT '文章管理表';

DROP TABLE IF EXISTS `person_article_tag`;
CREATE TABLE `person_article_tag` (
  `id`          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
  `tag_id`		INT             NOT NULL            COMMENT '标签id',
  `article_id`	INT             NOT NULL            COMMENT '文章id',
  CONSTRAINT fk_article_tag_tag_id
      FOREIGN KEY (tag_id) REFERENCES person_tag(id),
  CONSTRAINT fk_article_tag_article_id
      FOREIGN KEY (article_id) REFERENCES person_article(id)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '文章和标签关联表';

DROP TABLE IF EXISTS `person_article_category`;
CREATE TABLE `person_article_category` (
   `id`          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
   `category_id` INT             NOT NULL            COMMENT '分类id',
   `article_id`	 INT             NOT NULL            COMMENT '文章id',
   CONSTRAINT fk_article_category_category_id
       FOREIGN KEY (category_id) REFERENCES person_category(category_id),
   CONSTRAINT fk_article_category_article_id
       FOREIGN KEY (article_id) REFERENCES person_article(id)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '文章和分类关联表';


DROP TABLE IF EXISTS `person_user`;
CREATE TABLE `person_user` (
   `id`                 INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
   `username`           VARCHAR(255)    NOT NULL                            COMMENT '用户名',
   `password`           VARCHAR(255)    NOT NULL                            COMMENT '密码',
   `email`              VARCHAR(64)         NULL                            COMMENT '邮箱',
   `last_login_time`    datetime            NULL                            COMMENT '上次登录时间',
   `phone`              BIGINT          NOT NULL DEFAULT 0                  COMMENT '手机号',
   `nickname`			  VARCHAR(255)        NULL                            COMMENT '昵称',
   `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
   `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '用户管理表';


DROP TABLE IF EXISTS `person_tag`;
CREATE TABLE `person_tag` (
    `id`                 INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
    `tag_name`			  VARCHAR(255)        NULL                                COMMENT '标签名',
    `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
    `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '标签管理表';


DROP TABLE IF EXISTS `person_notice`;
CREATE TABLE `person_notice` (
    `notice_id`          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
    `notice_title`		  VARCHAR(255)    NOT NULL                                COMMENT '公告标题',
    `notice_type`		  TINYINT    	  NOT NULL DEFAULT '0'                    COMMENT '公告类型，默认0, 0-公告, 1-通知, 2-提醒',
    `notice_status`      tinyint(4)      NOT NULL DEFAULT '0'                    COMMENT '状态，默认0, 0-正常, 1-关闭',
    `notice_content`     text                NULL                                COMMENT '公告内容',
    `create_by`   		  VARCHAR(128)    NOT NULL                                COMMENT '创建者',
    `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
    `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '通知公告表';


DROP TABLE IF EXISTS `person_category`;
CREATE TABLE `person_category` (
    `category_id`        INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
    `category_name`      VARCHAR(128)    NOT NULL                                COMMENT '分类名称',
    `create_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间',
    `update_time`        DATETIME            NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '文章分类管理表';


DROP TABLE IF EXISTS `person_operation_log`;
CREATE TABLE `person_operation_log` (
    `id`                    INT             NOT NULL PRIMARY KEY AUTO_INCREMENT     COMMENT '主键',
    `operation_ip`          VARCHAR(128)        NULL DEFAULT 0                      COMMENT '主机地址',
    `opera_location`        VARCHAR(255)        NULL DEFAULT ''                     COMMENT '操作地点',
    `methods`               TEXT                NULL                                COMMENT '方法名',
    `args`          		  TEXT                NULL                                COMMENT '请求参数',
    `operation_name`        VARCHAR(50)     NOT NULL DEFAULT ''                     COMMENT '操作人',
    `operation_type` 		  VARCHAR(50)     NOT NULL DEFAULT ''                     COMMENT '操作类型',
    `return_value`   		  TEXT                NULL                                COMMENT '返回参数',
    `create_time`        	  DATETIME            NULL DEFAULT CURRENT_TIMESTAMP      COMMENT '创建时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
  COMMENT '操作日志表';


DROP TABLE IF EXISTS `person_login_log`;
CREATE TABLE `person_login_log` (
    `id`                BIGINT(20)           NOT NULL 	PRIMARY KEY AUTO_INCREMENT    	COMMENT '登录访问id',
    `login_name`     	VARCHAR(50)    		 NULL		DEFAULT ''                		COMMENT '登录账号',
    `ip_address`        VARCHAR(128)   		 NULL		DEFAULT ''                		COMMENT '登录IP地址',
    `login_location`    VARCHAR(255)  		 NULL       DEFAULT ''                		COMMENT '登录地点',
    `browser_type`      VARCHAR(50)   		 NULL       DEFAULT ''                		COMMENT '浏览器类型',
    `os`             	VARCHAR(50)   		 NULL 	    DEFAULT ''                		COMMENT '操作系统',
    `login_status`      TINYINT       		 NULL 	    DEFAULT 0               		COMMENT '登录状态，默认0, 0-成功, 1-失败',
    `create_time`       DATETIME             NULL 	    DEFAULT CURRENT_TIMESTAMP       COMMENT '创建时间'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = Dynamic
    COMMENT '登录日志表';

