DELIMITER $$

CREATE TRIGGER trg_tbl_like_after_insert
AFTER INSERT ON tbl_like
FOR EACH ROW
BEGIN
    IF NEW.likes_target_type = 'FREE' THEN
        UPDATE tbl_free_post
           SET free_like_cnt = free_like_cnt + 1
         WHERE free_code = NEW.likes_target_code;
    ELSEIF NEW.likes_target_type = 'DIET' THEN
        UPDATE tbl_diet_post
           SET diet_like_cnt = diet_like_cnt + 1
         WHERE diet_code = NEW.likes_target_code;
    ELSEIF NEW.likes_target_type = 'SUCCESS' THEN
        UPDATE tbl_success_post
           SET succ_like_cnt = succ_like_cnt + 1
         WHERE succ_code = NEW.likes_target_code;
    END IF;
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER trg_tbl_like_after_delete
AFTER DELETE ON tbl_like
FOR EACH ROW
BEGIN
    IF OLD.likes_target_type = 'FREE' THEN
        UPDATE tbl_free_post
           SET free_like_cnt = free_like_cnt - 1
         WHERE free_code = OLD.likes_target_code;
    ELSEIF OLD.likes_target_type = 'DIET' THEN
        UPDATE tbl_diet_post
           SET diet_like_cnt = diet_like_cnt - 1
         WHERE diet_code = OLD.likes_target_code;
    ELSEIF OLD.likes_target_type = 'SUCCESS' THEN
        UPDATE tbl_success_post
           SET succ_like_cnt = succ_like_cnt - 1
         WHERE succ_code = OLD.likes_target_code;
    END IF;
END$$

DELIMITER ;
