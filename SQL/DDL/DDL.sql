USE samsung;

SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `tbl_user_data_food_review`;
DROP TABLE IF EXISTS `tbl_bookmark`;
DROP TABLE IF EXISTS `tbl_subscribe`;
DROP TABLE IF EXISTS `tbl_block`;
DROP TABLE IF EXISTS `tbl_like`;
DROP TABLE IF EXISTS `tbl_meal_food`;
DROP TABLE IF EXISTS `tbl_success_meal`;
DROP TABLE IF EXISTS `tbl_diet_food`;
DROP TABLE IF EXISTS `tbl_qna_comment`;
DROP TABLE IF EXISTS `tbl_weight`;
DROP TABLE IF EXISTS `tbl_user_data_food`;
DROP TABLE IF EXISTS `tbl_diet_post`;
DROP TABLE IF EXISTS `tbl_meal`;
DROP TABLE IF EXISTS `tbl_success_post`;
DROP TABLE IF EXISTS `tbl_bookmark_category`;
DROP TABLE IF EXISTS `tbl_user_info`;
DROP TABLE IF EXISTS `tbl_personal_info`;
DROP TABLE IF EXISTS `tbl_report`;
DROP TABLE IF EXISTS `tbl_notice_post`;
DROP TABLE IF EXISTS `tbl_open_data_food`;
DROP TABLE IF EXISTS `tbl_point`;
DROP TABLE IF EXISTS `tbl_free_post`;
DROP TABLE IF EXISTS `tbl_deleted_user`;
DROP TABLE IF EXISTS `tbl_comment`;
DROP TABLE IF EXISTS `tbl_point_day`;
DROP TABLE IF EXISTS `tbl_daily_point`;
DROP TABLE IF EXISTS `tbl_qna_post`;
DROP TABLE IF EXISTS `tbl_image`;

SET FOREIGN_KEY_CHECKS = 1;

-- 2) CREATE TABLE 

CREATE TABLE `tbl_personal_info` (
                                     `user_code`      INT          NOT NULL AUTO_INCREMENT,
                                     `user_name`      VARCHAR(255) NOT NULL,
                                     `user_id`        VARCHAR(50)  NOT NULL,
                                     `user_pwd`       VARCHAR(255) NOT NULL,
                                     `user_tel`       VARCHAR(50)  NOT NULL,
                                     `user_email`     VARCHAR(255) NOT NULL,
                                     `user_gender`    CHAR(1)      NOT NULL,
                                     `user_birthday`  VARCHAR(10)  NOT NULL,
                                     `user_enroll_dt` DATETIME     NOT NULL,
                                     CONSTRAINT `PK_TBL_PERSONAL_INFO`
                                         PRIMARY KEY (`user_code`),
                                     UNIQUE KEY `UK_TBL_PERSONAL_INFO_USER_ID` (`user_id`),
                                     UNIQUE KEY `UK_TBL_PERSONAL_INFO_USER_EMAIL` (`user_email`),
                                     UNIQUE KEY `UK_TBL_PERSONAL_INFO_USER_TEL` (`user_tel`)
);

CREATE TABLE `tbl_user_info` (
                                 `user_code`        INT          NOT NULL,
                                 `user_total_pt`    INT          NOT NULL DEFAULT 0,
                                 `user_level`       INT          NOT NULL DEFAULT 1,
                                 `user_nickname`    VARCHAR(255) NOT NULL,
                                 `user_susp_end_dt` DATETIME     NULL,
                                 `user_rpt_cnt`     INT          NOT NULL DEFAULT 0,
                                 CONSTRAINT `PK_TBL_USER_INFO`
                                     PRIMARY KEY (`user_code`),
                                 UNIQUE KEY `UK_TBL_USER_INFO_NICKNAME` (`user_nickname`),
                                 CONSTRAINT `FK_tbl_personal_info_TO_tbl_user_info_1`
                                     FOREIGN KEY (`user_code`)
                                         REFERENCES `tbl_personal_info` (`user_code`)
);

CREATE TABLE `tbl_user_data_food` (
                                      `udf_code`      INT           NOT NULL AUTO_INCREMENT,
                                      `udf_name`      VARCHAR(255)  NOT NULL,
                                      `udf_sv_size`   INT           NOT NULL,
                                      `udf_uom`       VARCHAR(50)   NOT NULL,
                                      `udf_sv_unit`   VARCHAR(50)   NOT NULL,
                                      `udf_calories`  FLOAT         NOT NULL CHECK (udf_calories >= 0),
                                      `udf_carbs`     FLOAT         NULL CHECK (udf_carbs >= 0),
                                      `udf_sugar`     FLOAT         NULL CHECK (udf_sugar >= 0),
                                      `udf_protein`   FLOAT         NULL CHECK (udf_protein >= 0),
                                      `udf_fat`       FLOAT         NULL CHECK (udf_fat >= 0),
                                      `udf_acc_cnt`   INT           NOT NULL DEFAULT 0,
                                      `udf_inacc_cnt` INT           NOT NULL DEFAULT 0,
                                      `udf_created_dt` DATETIME     NOT NULL,
                                      `user_code`     INT           NOT NULL,
                                      CONSTRAINT `PK_TBL_USER_DATA_FOOD`
                                          PRIMARY KEY (`udf_code`),
                                      UNIQUE KEY `UK_TBL_UDF_USER_NAME` (`user_code`, `udf_name`),
                                      CONSTRAINT `FK_tbl_user_info_TO_tbl_user_data_food_1`
                                          FOREIGN KEY (`user_code`)
                                              REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_bookmark_category` (
                                         `bm_ctgy_code` INT          NOT NULL AUTO_INCREMENT,
                                         `bm_ctgy_name` VARCHAR(255) NOT NULL DEFAULT '기본',
                                         `user_code`    INT          NOT NULL,
                                         CONSTRAINT `PK_TBL_BOOKMARK_CATEGORY`
                                             PRIMARY KEY (`bm_ctgy_code`),
                                         UNIQUE KEY `UK_TBL_BM_CATEGORY_USER_NAME` (`user_code`, `bm_ctgy_name`),
                                         CONSTRAINT `FK_tbl_user_info_TO_tbl_bookmark_category_1`
                                             FOREIGN KEY (`user_code`)
                                                 REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_success_post` (
                                    `succ_code`       INT          NOT NULL AUTO_INCREMENT,
                                    `succ_title`      VARCHAR(255) NOT NULL,
                                    `succ_conts`      TEXT         NOT NULL,
                                    `succ_created_dt` DATETIME     NOT NULL,
                                    `succ_view_cnt`   INT          NOT NULL DEFAULT 0,
                                    `succ_like_cnt`   INT          NOT NULL DEFAULT 0,
                                    `succ_cmt_cnt`    INT          NOT NULL DEFAULT 0,
                                    `succ_term`       VARCHAR(50)  NOT NULL,
                                    `succ_isdeleted`  BOOLEAN      NOT NULL DEFAULT FALSE,
                                    `user_code`       INT          NOT NULL,
                                    CONSTRAINT `PK_TBL_SUCCESS_POST`
                                        PRIMARY KEY (`succ_code`),
                                    CONSTRAINT `FK_tbl_user_info_TO_tbl_success_post_1`
                                        FOREIGN KEY (`user_code`)
                                            REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_meal` (
                            `meal_code`     INT          NOT NULL AUTO_INCREMENT,
                            `meal_dt`       VARCHAR(50)  NOT NULL,
                            `meal_title`    VARCHAR(255) NOT NULL,
                            `meal_desc`     VARCHAR(255) NULL,
                            `meal_calories` FLOAT        NOT NULL DEFAULT 0 CHECK (meal_calories >= 0),
                            `meal_carbs`    FLOAT        NOT NULL DEFAULT 0 CHECK (meal_carbs >= 0),
                            `meal_sugar`    FLOAT        NOT NULL DEFAULT 0 CHECK (meal_sugar >= 0),
                            `meal_protein`  FLOAT        NOT NULL DEFAULT 0 CHECK (meal_protein >= 0),
                            `meal_fat`      FLOAT        NOT NULL DEFAULT 0 CHECK (meal_fat >= 0),
                            `user_code`     INT          NOT NULL DEFAULT 0,
                            CONSTRAINT `PK_TBL_MEAL`
                                PRIMARY KEY (`meal_code`),
                            UNIQUE KEY `UK_TBL_MEAL_USER_DATETIME` (`user_code`, `meal_dt`),
                            CONSTRAINT `FK_tbl_user_info_TO_tbl_meal_1`
                                FOREIGN KEY (`user_code`)
                                    REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_diet_post` (
                                 `diet_code`      INT          NOT NULL AUTO_INCREMENT,
                                 `diet_upload_dt` DATETIME     NOT NULL,
                                 `diet_title`     VARCHAR(255) NOT NULL,
                                 `diet_conts`     TEXT         NOT NULL,
                                 `diet_view_cnt`  INT          NOT NULL DEFAULT 0,
                                 `diet_like_cnt`  INT          NOT NULL DEFAULT 0,
                                 `diet_cmt_cnt`   INT          NOT NULL DEFAULT 0,
                                 `diet_calories`  FLOAT        NOT NULL DEFAULT 0 CHECK (diet_calories >= 0),
                                 `diet_carbs`     FLOAT        NOT NULL DEFAULT 0 CHECK (diet_carbs >= 0),
                                 `diet_sugar`     FLOAT        NOT NULL DEFAULT 0 CHECK (diet_sugar >= 0),
                                 `diet_protein`   FLOAT        NOT NULL DEFAULT 0 CHECK (diet_protein >= 0),
                                 `diet_fat`       FLOAT        NOT NULL DEFAULT 0 CHECK (diet_fat >= 0),
                                 `diet_isdeleted` BOOLEAN      NOT NULL DEFAULT FALSE,
                                 `user_code`      INT          NOT NULL,
                                 CONSTRAINT `PK_TBL_DIET_POST`
                                     PRIMARY KEY (`diet_code`),
                                 CONSTRAINT `FK_tbl_user_info_TO_tbl_diet_post_1`
                                     FOREIGN KEY (`user_code`)
                                         REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_notice_post` (
                                   `noti_code`       INT          NOT NULL AUTO_INCREMENT,
                                   `noti_title`      VARCHAR(255) NOT NULL,
                                   `noti_conts`      TEXT         NOT NULL,
                                   `noti_created_dt` DATETIME     NOT NULL,
                                   `noti_view_cnt`   INT          NOT NULL DEFAULT 0,
                                   `noti_updated_dt` DATETIME     NULL,
                                   CONSTRAINT `PK_TBL_NOTICE_POST`
                                       PRIMARY KEY (`noti_code`)
);

CREATE TABLE `tbl_subscribe` (
                                 `subs_user_code`    INT NOT NULL,
                                 `subs_tg_user_code` INT NOT NULL,
                                 CONSTRAINT `PK_TBL_SUBSCRIBE`
                                     PRIMARY KEY (`subs_user_code`, `subs_tg_user_code`),
                                 CONSTRAINT `FK_tbl_user_info_TO_tbl_subscribe_1`
                                     FOREIGN KEY (`subs_user_code`)
                                         REFERENCES `tbl_user_info` (`user_code`),
                                 CONSTRAINT `FK_tbl_user_info_TO_tbl_subscribe_2`
                                     FOREIGN KEY (`subs_tg_user_code`)
                                         REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_block` (
                             `blc_user_code`    INT NOT NULL,
                             `blc_tg_user_code` INT NOT NULL,
                             CONSTRAINT `PK_TBL_BLOCK`
                                 PRIMARY KEY (`blc_user_code`, `blc_tg_user_code`),
                             CONSTRAINT `FK_tbl_user_info_TO_tbl_block_1`
                                 FOREIGN KEY (`blc_user_code`)
                                     REFERENCES `tbl_user_info` (`user_code`),
                             CONSTRAINT `FK_tbl_user_info_TO_tbl_block_2`
                                 FOREIGN KEY (`blc_tg_user_code`)
                                     REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_like` (
                            `likes_target_code` INT                 NOT NULL,
                            `likes_target_type` ENUM('FREE','DIET','SUCCESS') NOT NULL,
                            `user_code`         INT                 NOT NULL,
                            CONSTRAINT `PK_TBL_LIKE`
                                PRIMARY KEY (`likes_target_code`, `likes_target_type`, `user_code`),
                            CONSTRAINT `FK_tbl_user_info_TO_tbl_like_1`
                                FOREIGN KEY (`user_code`)
                                    REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_bookmark` (
                                `bm_post_type` ENUM('FREE','DIET','SUCCESS') NOT NULL,
                                `bm_post_code` INT     NOT NULL,
                                `bm_ctgy_code` INT     NOT NULL,
                                `user_code`    INT     NOT NULL,
                                CONSTRAINT `PK_TBL_BOOKMARK`
                                    PRIMARY KEY (`bm_post_type`, `bm_post_code`, `bm_ctgy_code`, `user_code`),
                                CONSTRAINT `FK_tbl_bookmark_category_TO_tbl_bookmark_1`
                                    FOREIGN KEY (`bm_ctgy_code`)
                                        REFERENCES `tbl_bookmark_category` (`bm_ctgy_code`),
                                CONSTRAINT `FK_tbl_user_info_TO_tbl_bookmark_1`
                                    FOREIGN KEY (`user_code`)
                                        REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_user_data_food_review` (
                                             `rvw_user_code` INT NOT NULL,
                                             `udf_code`      INT NOT NULL,
                                             `rvw_type`      ENUM('ACCURATE','INACCURATE') NOT NULL,
                                             CONSTRAINT `PK_TBL_USER_DATA_FOOD_REVIEW`
                                                 PRIMARY KEY (`rvw_user_code`, `udf_code`),
                                             CONSTRAINT `FK_tbl_user_data_food_TO_tbl_user_data_food_review_1`
                                                 FOREIGN KEY (`udf_code`)
                                                     REFERENCES `tbl_user_data_food` (`udf_code`),
                                             CONSTRAINT `FK_tbl_user_info_TO_tbl_user_data_food_review_2`
                                                 FOREIGN KEY (`rvw_user_code`)
                                                     REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_weight` (
                              `weight_dt`  VARCHAR(50) NOT NULL,
                              `user_code`  INT         NOT NULL,
                              `cur_weight` INT         NOT NULL,
                              CONSTRAINT `PK_TBL_WEIGHT`
                                  PRIMARY KEY (`weight_dt`, `user_code`),
                              CONSTRAINT `FK_tbl_user_info_TO_tbl_weight_1`
                                  FOREIGN KEY (`user_code`)
                                      REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_meal_food` (
                                 `meal_food_code` INT NOT NULL AUTO_INCREMENT,
                                 `meal_food_type` ENUM('OPENDATA','USERDATA') NOT NULL,
                                 `meal_code`      INT NOT NULL,
                                 `meal_food_cnt`  FLOAT NOT NULL CHECK ( meal_food_cnt > 0 ),
                                 CONSTRAINT `PK_TBL_MEAL_FOOD`
                                     PRIMARY KEY (`meal_food_code`, `meal_food_type`, `meal_code`),
                                 CONSTRAINT `FK_tbl_meal_TO_tbl_meal_food`
                                     FOREIGN KEY (`meal_code`)
                                         REFERENCES `tbl_meal` (`meal_code`)
);

CREATE TABLE `tbl_success_meal` (
                                    `meal_code` INT NOT NULL,
                                    `succ_code` INT NOT NULL,
                                    CONSTRAINT `PK_TBL_SUCCESS_MEAL`
                                        PRIMARY KEY (`meal_code`, `succ_code`),
                                    CONSTRAINT `FK_tbl_meal_TO_tbl_success_meal_1`
                                        FOREIGN KEY (`meal_code`)
                                            REFERENCES `tbl_meal` (`meal_code`),
                                    CONSTRAINT `FK_tbl_success_post_TO_tbl_success_meal_1`
                                        FOREIGN KEY (`succ_code`)
                                            REFERENCES `tbl_success_post` (`succ_code`)
);

CREATE TABLE `tbl_open_data_food` (
                                      `odf_code`      INT           NOT NULL AUTO_INCREMENT,
                                      `odf_name`      VARCHAR(255)  NOT NULL,
                                      `odf_calories`  FLOAT         NOT NULL,
                                      `odf_carbs`     FLOAT         NULL CHECK ( odf_carbs >= 0 ),
                                      `odf_sugar`     FLOAT         NULL CHECK ( odf_sugar >= 0 ),
                                      `odf_protein`   FLOAT         NULL CHECK ( odf_protein >= 0 ),
                                      `odf_fat`       FLOAT         NULL CHECK ( odf_fat >= 0 ),
                                      `odf_update_dt` DATETIME      NOT NULL,
                                      CONSTRAINT `PK_TBL_OPEN_DATA_FOOD`
                                          PRIMARY KEY (`odf_code`)
);

CREATE TABLE `tbl_point` (
                             `point_code`      INT         NOT NULL AUTO_INCREMENT,
                             `point_user_code` INT         NOT NULL,
                             `point_amt`       INT         NOT NULL,
                             `point_rcv_dt`    DATETIME    NOT NULL,
                             `point_rcv_code`  INT         NOT NULL,
                             `point_rcv_type`  VARCHAR(50) NOT NULL,
                             CONSTRAINT `PK_TBL_POINT`
                                 PRIMARY KEY (`point_code`),
                             CONSTRAINT `FK_tbl_user_info_TO_tbl_point_1`
                                 FOREIGN KEY (`point_user_code`)
                                     REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_free_post` (
                                 `free_code`       INT          NOT NULL AUTO_INCREMENT,
                                 `free_title`      VARCHAR(255) NOT NULL,
                                 `free_conts`      TEXT         NOT NULL,
                                 `free_created_dt` DATETIME     NOT NULL,
                                 `free_view_cnt`   INT          NOT NULL DEFAULT 0,
                                 `free_like_cnt`   INT          NOT NULL DEFAULT 0,
                                 `free_cmt_cnt`    INT          NOT NULL DEFAULT 0,
                                 `free_isdeleted`  BOOLEAN      NOT NULL DEFAULT FALSE,
                                 `user_code`       INT          NOT NULL,
                                 CONSTRAINT `PK_TBL_FREE_POST`
                                     PRIMARY KEY (`free_code`),
                                 CONSTRAINT `FK_tbl_user_info_TO_tbl_free_post_1`
                                     FOREIGN KEY (`user_code`)
                                         REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_diet_food` (
                                 `diet_food_code` INT                NOT NULL AUTO_INCREMENT,
                                 `diet_food_type` ENUM('OPENDATA','USERDATA') NOT NULL,
                                 `diet_code`      INT                NOT NULL,
                                 `diet_food_cnt`  INT                NOT NULL CHECK ( diet_food_cnt > 0 ),
                                 CONSTRAINT `PK_TBL_DIET_FOOD`
                                     PRIMARY KEY (`diet_food_code`, `diet_food_type`, `diet_code`),
                                 CONSTRAINT `FK_tbl_diet_post_TO_tbl_diet_food_1`
                                     FOREIGN KEY (`diet_code`)
                                         REFERENCES `tbl_diet_post` (`diet_code`)
);

CREATE TABLE `tbl_report` (
                              `rpt_code`           INT           NOT NULL AUTO_INCREMENT,
                              `rpt_user_code`      INT           NOT NULL,
                              `rpt_conts`          VARCHAR(255)  NOT NULL,
                              `rpt_created_dt`     DATETIME      NOT NULL,
                              `rpt_target_type`    ENUM('FREE','DIET','SUCCESS','COMMENT','USERFOOD') NOT NULL,
                              `rpt_target_ty_code` INT           NOT NULL,
                              `rpt_status`         BOOLEAN       DEFAULT NULL,
                              `rpt_admin_code`     INT           NULL,
                              `rpt_cmt`            VARCHAR(255)  NULL,
                              `user_code`          INT           NOT NULL,
                              CONSTRAINT `PK_TBL_REPORT`
                                  PRIMARY KEY (`rpt_code`),
                              CONSTRAINT `FK_tbl_user_info_TO_tbl_report_1`
                                  FOREIGN KEY (`rpt_user_code`)
                                      REFERENCES `tbl_user_info` (`user_code`),
                              CONSTRAINT `FK_tbl_user_info_TO_tbl_report_2`
                                  FOREIGN KEY (`user_code`)
                                      REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_deleted_user` (
                                    `user_code`         INT          NOT NULL,
                                    `dlt_user_name`     VARCHAR(255) NOT NULL,
                                    `dlt_user_id`       VARCHAR(255) NOT NULL,
                                    `dlt_user_pwd`      VARCHAR(255) NOT NULL,
                                    `dlt_user_tel`      VARCHAR(50)  NOT NULL,
                                    `dlt_user_email`    VARCHAR(255) NOT NULL,
                                    `dlt_user_gender`   CHAR(1)      NOT NULL,
                                    `dlt_user_birthday` VARCHAR(10)  NOT NULL,
                                    `dlt_user_enroll_dt` DATETIME    NOT NULL,
                                    `user_info_dlt_dt`  DATETIME     NOT NULL,
                                    CONSTRAINT `PK_TBL_DELETED_USER`
                                        PRIMARY KEY (`user_code`),
                                    UNIQUE KEY `UK_TBL_DELETED_USER_ID` (`dlt_user_id`),
                                    UNIQUE KEY `UK_TBL_DELETED_USER_TEL` (`dlt_user_tel`),
                                    UNIQUE KEY `UK_TBL_DELETED_USER_EMAIL` (`dlt_user_email`)
);

CREATE TABLE `tbl_comment` (
                               `cmt_code`       INT          NOT NULL AUTO_INCREMENT,
                               `cmt_conts`      VARCHAR(255) NOT NULL,
                               `cmt_created_dt` DATETIME     NOT NULL,
                               `cmt_updated_dt` DATETIME     NULL,
                               `cmt_target_type` ENUM('FREE','DIET','SUCCESS')         NOT NULL,
                               `cmt_target_code` INT         NOT NULL,
                               `cmt_isdeleted`  BOOLEAN      NOT NULL DEFAULT FALSE,
                               `user_code`      INT          NOT NULL,
                               CONSTRAINT `PK_TBL_COMMENT`
                                   PRIMARY KEY (`cmt_code`),
                               CONSTRAINT `FK_tbl_user_info_TO_tbl_comment_1`
                                   FOREIGN KEY (`user_code`)
                                       REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_daily_point` (
                                   `d_point_code`    INT                NOT NULL AUTO_INCREMENT,
                                   `d_point_rcv_amt` INT                NOT NULL,
                                   `d_point_rcv_dt`  DATETIME           NOT NULL,
                                   `d_point_rcv_type` ENUM('REGIST_USERFOOD','ACCURATE_USERFOOD','REVIEW_USERFOOD','MEAL','DIET','FREE','SUCCESS') NOT NULL,
                                   `d_point_rcv_code` INT               NOT NULL,
                                   `user_code`      INT                NOT NULL,
                                   CONSTRAINT `PK_TBL_DAILY_POINT`
                                       PRIMARY KEY (`d_point_code`),
                                   CONSTRAINT `FK_tbl_user_info_TO_tbl_daily_point_1`
                                       FOREIGN KEY (`user_code`)
                                           REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_qna_post` (
                                `qna_code`       INT          NOT NULL AUTO_INCREMENT,
                                `qna_title`      VARCHAR(255) NOT NULL,
                                `qna_conts`      TEXT         NOT NULL,
                                `qna_created_dt` DATETIME     NOT NULL,
                                `qna_view_cnt`   INT          NOT NULL DEFAULT 0,
                                `qna_isdeleted`  BOOLEAN      NOT NULL DEFAULT FALSE,
                                `user_code`      INT          NOT NULL,
                                CONSTRAINT `PK_TBL_QNA_POST`
                                    PRIMARY KEY (`qna_code`),
                                CONSTRAINT `FK_tbl_user_info_TO_tbl_qna_post_1`
                                    FOREIGN KEY (`user_code`)
                                        REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_qna_comment` (
                                   `qna_cmt_code`     INT          NOT NULL AUTO_INCREMENT,
                                   `qna_code`         INT          NOT NULL,
                                   `qna_cmt_conts`    VARCHAR(255) NOT NULL,
                                   `qna_cmt_created_dt` DATETIME   NOT NULL,
                                   `qna_cmt_isdeleted` BOOLEAN     NOT NULL DEFAULT FALSE,
                                   `user_code`        INT          NOT NULL,
                                   CONSTRAINT `PK_TBL_QNA_COMMENT`
                                       PRIMARY KEY (`qna_cmt_code`),
                                   CONSTRAINT `FK_tbl_qna_post_TO_tbl_qna_comment_1`
                                       FOREIGN KEY (`qna_code`)
                                           REFERENCES `tbl_qna_post` (`qna_code`),
                                   CONSTRAINT `FK_tbl_user_info_TO_tbl_qna_comment_1`
                                       FOREIGN KEY (`user_code`)
                                           REFERENCES `tbl_user_info` (`user_code`)
);

CREATE TABLE `tbl_image` (
                             `img_code`        INT          NOT NULL AUTO_INCREMENT,
                             `img_orgn_name`   VARCHAR(255) NOT NULL,
                             `img_updated_name` VARCHAR(255) NOT NULL,
                             `img_ext`         VARCHAR(10)  NOT NULL,
                             `img_post_type`   ENUM('MEAL','SUCCESS','DIET','FREE') NOT NULL,
                             `img_post_code`   INT          NOT NULL,
                             `img_path`        VARCHAR(255) NOT NULL,
                             `img_isdeleted`   BOOLEAN      NOT NULL DEFAULT FALSE,
                             CONSTRAINT `PK_TBL_IMAGE`
                                 PRIMARY KEY (`img_code`),
                             UNIQUE KEY `UK_TBL_IMAGE` (`img_updated_name`)
);
