-- MySQL 테이블(tbl_open_data_food)이 utf8mb4인지 확인하고, 아니라면 변경해야 합니다.
# SHOW CREATE TABLE tbl_open_data_food;

-- 만약 CHARSET=euckr로 설정되어 있다면, utf8mb4로 변경하는 것이 좋습니다.
# ALTER TABLE tbl_open_data_food CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

# LOAD DATA INFILE '/Users/mac/Downloads/total_food.csv'
#     INTO TABLE tbl_open_data_food
#     CHARACTER SET utf8
#     FIELDS TERMINATED BY ','
#     ENCLOSED BY '"'
#     LINES TERMINATED BY '\n'
#     IGNORE 1 LINES
#     (
#      @dummy, -- Unnamed: 0 (인덱스) 무시
#      odf_name,
#      @nutrient_standard, -- 영양성분함량기준량
#      @odf_calories,
#      @odf_carbs,
#      @odf_sugar,
#      @odf_protein,
#      @odf_fat,
#      @company_name, -- 회사명
#      @odf_update_dt
#         )
#     SET
#         odf_calories = NULLIF(TRIM(REPLACE(@odf_calories, ',', '')), ''),
#         odf_carbs    = NULLIF(TRIM(REPLACE(@odf_carbs, ',', '')), ''),
#         odf_protein  = NULLIF(TRIM(REPLACE(@odf_protein, ',', '')), ''),
#         odf_fat      = NULLIF(TRIM(REPLACE(@odf_fat, ',', '')), ''),
#         odf_sugar    = NULLIF(TRIM(REPLACE(@odf_sugar, ',', '')), ''),
#         odf_update_dt = STR_TO_DATE(TRIM(@odf_update_dt), '%Y-%m-%d');

LOAD DATA INFILE '/Users/mac/Downloads/total_food (1).csv'
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