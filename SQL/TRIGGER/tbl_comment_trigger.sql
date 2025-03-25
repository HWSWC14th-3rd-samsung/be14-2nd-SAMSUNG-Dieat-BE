-- 삭제 트리거 --
DELIMITER $$
CREATE TRIGGER trg_after_soft_delete_tbl_comment
    AFTER UPDATE ON tbl_comment
    FOR EACH ROW
BEGIN
    IF OLD.cmt_isdeleted = 0 AND NEW.cmt_isdeleted = 1 THEN
        IF NEW.cmt_target_type = 'FREE' THEN
            UPDATE tbl_free_post
            SET free_cmt_cnt = free_cmt_cnt - 1
            WHERE free_code = NEW.cmt_target_code;
        ELSEIF NEW.cmt_target_type = 'DIET' THEN
            UPDATE tbl_diet_post
            SET diet_cmt_cnt = diet_cmt_cnt - 1
            WHERE diet_code = NEW.cmt_target_code;
        ELSEIF NEW.cmt_target_type = 'SUCCESS' THEN
            UPDATE tbl_success_post
            SET succ_cmt_cnt = succ_cmt_cnt - 1
            WHERE succ_code = NEW.cmt_target_code;
        END IF;
    END IF;
END$$
DELIMITER ;

-- 등록 트리거 --
DELIMITER $$
CREATE TRIGGER trg_after_insert_tbl_comment
    AFTER INSERT ON tbl_comment
    FOR EACH ROW
BEGIN
    IF NEW.cmt_target_type = 'FREE' THEN
        UPDATE tbl_free_post
        SET free_cmt_cnt = free_cmt_cnt + 1
        WHERE free_code = NEW.cmt_target_code;
    ELSEIF NEW.cmt_target_type = 'DIET' THEN
        UPDATE tbl_diet_post
        SET diet_cmt_cnt = diet_cmt_cnt + 1
        WHERE diet_code = NEW.cmt_target_code;
    ELSEIF NEW.cmt_target_type = 'SUCCESS' THEN
        UPDATE tbl_success_post
        SET succ_cmt_cnt = succ_cmt_cnt + 1
        WHERE succ_code = NEW.cmt_target_code;
    END IF;
END$$
DELIMITER ;