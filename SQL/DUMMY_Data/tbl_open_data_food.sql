LOAD DATA INFILE './total_food.csv' -- 파일 경로는 개인별로 수정해야 함
    INTO TABLE tbl_open_data_food
    CHARACTER SET euckr
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (
     odf_name,
     @odf_calories,
     @odf_carbs,
     @odf_protein,
     @odf_fat,
     @odf_sugar,
     @odf_update_dt
        )
    SET
        odf_calories = NULLIF(@odf_calories, ''),
        odf_carbs    = NULLIF(@odf_carbs, ''),
        odf_protein  = NULLIF(@odf_protein, ''),
        odf_fat      = NULLIF(@odf_fat, ''),
        odf_sugar    = NULLIF(@odf_sugar, ''),
        odf_update_dt = STR_TO_DATE(TRIM(@odf_update_dt), '%Y-%m-%d');