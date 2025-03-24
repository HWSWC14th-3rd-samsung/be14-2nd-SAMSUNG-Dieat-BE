-- ============================
-- 🌟 INSERT: 초기 데이터 등록
-- ============================

-- 1. bbq 황금올리브
INSERT INTO tbl_open_data_food (
    odf_name, odf_calories, odf_carbs, odf_sugar,
    odf_protein, odf_fat, odf_update_dt
) VALUES (
             'bbq 황금올리브', 298, 14.3, 0.8, 20.1, 17.8, NOW()
         );

-- 2. bhc 핫후라이드
INSERT INTO tbl_open_data_food (
    odf_name, odf_calories, odf_carbs, odf_sugar,
    odf_protein, odf_fat, odf_update_dt
) VALUES (
             'bhc 핫후라이드', 299, 14.0, 1.1, 19.5, 18.0, NOW()
         );

-- 3. 굽네 고추바사삭
INSERT INTO tbl_open_data_food (
    odf_name, odf_calories, odf_carbs, odf_sugar,
    odf_protein, odf_fat, odf_update_dt
) VALUES (
             '굽네 고추바사삭', 186, 5.8, 2.4, 27.7, 6.1, NOW()
         );

-- 4. 푸라닭 고추마요
INSERT INTO tbl_open_data_food (
    odf_name, odf_calories, odf_carbs, odf_sugar,
    odf_protein, odf_fat, odf_update_dt
) VALUES (
             '푸라닭 고추마요', 253, 14.1, 4.4, 17.8, 15.1, NOW()
         );

INSERT INTO tbl_open_data_food (odf_name, odf_calories, odf_carbs, odf_sugar, odf_protein, odf_fat, odf_update_dt)
VALUES ('네네 스노윙치즈', 310.0, 17.5, 3.2, 18.9, 19.2, NOW());

INSERT INTO tbl_open_data_food (odf_name, odf_calories, odf_carbs, odf_sugar, odf_protein, odf_fat, odf_update_dt)
VALUES ('bbq 자메이카 통다리구이', 203.0, 9.3, 5.1, 25.0, 7.2, NOW());

INSERT INTO tbl_open_data_food (odf_name, odf_calories, odf_carbs, odf_sugar, odf_protein, odf_fat, odf_update_dt)
VALUES ('bhc 뿌링클', 312.0, 16.9, 2.8, 20.3, 20.0, NOW());

INSERT INTO tbl_open_data_food (odf_name, odf_calories, odf_carbs, odf_sugar, odf_protein, odf_fat, odf_update_dt)
VALUES ('굽네 볼케이노', 190.0, 6.2, 3.0, 27.0, 6.5, NOW());

INSERT INTO tbl_open_data_food (odf_name, odf_calories, odf_carbs, odf_sugar, odf_protein, odf_fat, odf_update_dt)
VALUES ('푸라닭 블랙알리오', 247.0, 13.6, 2.7, 18.5, 14.8, NOW());

INSERT INTO tbl_open_data_food (odf_name, odf_calories, odf_carbs, odf_sugar, odf_protein, odf_fat, odf_update_dt)
VALUES ('처갓집 슈프림양념', 330.0, 21.0, 6.0, 17.0, 20.5, NOW());

-- ============================
-- 🛠️ UPDATE: 이름 및 영양소 수정
-- ============================

-- odf_code = 1 (bbq 황금올리브 → bbq 핫황금올리브)
UPDATE tbl_open_data_food
SET
    odf_name = 'bbq 핫황금올리브',
    odf_calories = 304,
    odf_carbs = 15.1,
    odf_sugar = 1.0,
    odf_protein = 19.7,
    odf_fat = 18.7,
    odf_update_dt = NOW()
WHERE odf_code = 1;

-- ============================
-- ❌ DELETE: 특정 데이터 삭제
-- ============================

-- odf_code = 2인 음식 삭제
DELETE FROM tbl_open_data_food
WHERE odf_code = 2;

-- ============================
-- 🔍 SELECT: 예외 고려 조회 쿼리
-- ============================

-- 1. 전체 조회
SELECT * FROM tbl_open_data_food;

-- 2. 이름에 '고추'가 들어간 음식 검색
SELECT * FROM tbl_open_data_food
WHERE odf_name LIKE '%고추%';

-- 3. 단백질이 20 이상인 고단백 음식
SELECT * FROM tbl_open_data_food
WHERE odf_protein >= 20;

-- 4. 지방 수치가 NULL인 음식 (데이터 오류 확인용)
SELECT * FROM tbl_open_data_food
WHERE odf_fat IS NULL;

-- 5. 최근 3일 내 수정된 음식
SELECT * FROM tbl_open_data_food
WHERE odf_update_dt >= DATE_SUB(NOW(), INTERVAL 3 DAY);

-- 6. 칼로리 높은 순 정렬 (TOP 3)
SELECT * FROM tbl_open_data_food
ORDER BY odf_calories DESC
    LIMIT 3;

-- 7. odf_code가 없는(존재하지 않는) 음식 조회 (예외 테스트)
SELECT * FROM tbl_open_data_food
WHERE odf_code = 9999;