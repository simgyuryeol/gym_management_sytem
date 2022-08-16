SET SERVEROUTPUT ON;

-- 저장프로시저 

-- 회원의 사용금액을 이용하여 헬스장의 매출을 확인할 수 있다.
-- 구매, 가입, 

CREATE OR REPLACE PROCEDURE SALES(STORE_NAME IN CHAR,STORE_MONEY OUT NUMBER)
AS
    MONEY NUMBER:=0; --매출금액
    BUY NUMBER; -- 구매수량
    PRICE NUMBER; --가격
    NAME2 VARCHAR(70); -- 가게명
    NUMBER_DAY INT;
    PRICE_HEALTH INT;

    CURSOR C IS SELECT 구매수량,가격 FROM 상품,구매 WHERE 상품."상품번호"=구매."구매번호" AND 상품."가게명"=구매."가게명" AND 상품.가게명=STORE_NAME;
    CURSOR D IS SELECT 등록일수,이용료 FROM 헬스장,가입 WHERE 헬스장.가게명=가입."가게명" AND 가입.가게명=STORE_NAME;
BEGIN
    
    OPEN C;
    LOOP
        FETCH C INTO BUY,PRICE;
        EXIT WHEN C%NOTFOUND;
        MONEY :=BUY*PRICE+MONEY;
    END LOOP;
    CLOSE C;
    
    OPEN D;
    LOOP
        FETCH D INTO NUMBER_DAY,PRICE_HEALTH;
        EXIT WHEN D%NOTFOUND;
        MONEY :=NUMBER_DAY*PRICE_HEALTH+MONEY;
    END LOOP;
     CLOSE D;
    
    STORE_MONEY:=MONEY; 
END;




DROP PROCEDURE SALES;

DECLARE
 USER_NUM NUMBER;
 BEGIN
  SALES('토마토휘트니스',USER_NUM);
 DBMS_OUTPUT.PUT_LINE(MONEY);
END;

-- 회원이 빌린 운동기구 개수 출력

CREATE OR REPLACE PROCEDURE HEALTH_TOOL(USER_NUM IN NUMBER, EX_NUM OUT NUMBER)--빌린 운동 기구 갯수
AS
BEGIN
    
    SELECT COUNT(*) INTO EX_NUM FROM 대여 where 대여.회원번호=USER_NUM;
END;




DECLARE
 USER_NUM NUMBER;
 BEGIN
 HEALTH_TOOL('001',USER_NUM);
 DBMS_OUTPUT.PUT_LINE(USER_NUM);
END;

DROP PROCEDURE HEALTH_TOOL;


-- 회원의 가입일과 등록일수를 이용해서 남은 달 구하기
CREATE OR REPLACE PROCEDURE 남은달(days_betwwen OUT varchar,user_num in int)
AS
BEGIN
    SELECT TO_DATE(TO_CHAR(SYSDATE))-TO_DATE(가입일,'YYYY-MM-DD') INTO days_betwwen from 가입 where 가입.회원번호=user_num;
    SELECT 등록일수-CAST(TO_NUMBER(days_betwwen)/30 AS NUMBER(10)) INTO days_betwwen FROM 가입 WHERE 가입.회원번호=user_num;
    IF TO_NUMBER(days_betwwen)<0 THEN
        days_betwwen:='재가입';
        
    END IF; 
END;


DECLARE
 DAYS_BETWEEN VARCHAR(50);
 BEGIN
 남은달(DAYS_BETWEEN,'008');
 DBMS_OUTPUT.PUT_LINE(DAYS_BETWEEN);
END;

DROP PROCEDURE 남은달;


-- 상품 구매 총액

CREATE OR REPLACE PROCEDURE 구매총액(STORE_NAME IN CHAR, SALES OUT NUMBER)
AS
    MONEY NUMBER:=0; --매출금액
    BUY NUMBER; -- 구매수량
    PRICE NUMBER; --가격
    NAME2 VARCHAR(70); -- 가게명

    CURSOR C IS SELECT 구매수량,가격 FROM 상품,구매 WHERE 상품."상품번호"=구매."구매번호" AND 상품."가게명"=구매."가게명" AND 상품.가게명=STORE_NAME;
BEGIN
    
    OPEN C;
    LOOP
        FETCH C INTO BUY,PRICE;
        EXIT WHEN C%NOTFOUND;
        MONEY :=BUY*PRICE+MONEY;
    END LOOP;
    CLOSE C;
    
    SALES:=MONEY;   
END;



DECLARE
 SALES NUMBER;
 BEGIN
 구매총액('토마토휘트니스',SALES);
 DBMS_OUTPUT.PUT_LINE(SALES);
END;

DROP PROCEDURE SALES;

-- 헬스장 인원수
CREATE OR REPLACE PROCEDURE 헬스장인원수(SOTRE_NAME IN CHAR, USER_NUM OUT NUMBER)
AS
BEGIN
    SELECT COUNT(*) INTO USER_NUM FROM 가입 WHERE 가입.가게명=SOTRE_NAME;
END;




DECLARE
 SALES NUMBER;
 BEGIN
 헬스장인원수('토마토휘트니스',SALES);
 DBMS_OUTPUT.PUT_LINE(SALES);
END;




-- 트리거
-- 운동기구 대여 여부 Y 대여중이면 못빌림

CREATE OR REPLACE TRIGGER 운동기구대여
    BEFORE INSERT ON 대여
    FOR EACH ROW
DECLARE
    PERMISSION CHAR;
BEGIN
    SELECT 대여여부 INTO PERMISSION FROM 운동기구 WHERE :NEW.기구번호=운동기구.기구번호 AND :NEW.가게명=운동기구.가게명 ;
    IF   PERMISSION='Y' THEN
       RAISE_APPLICATION_ERROR(-20999,'이미대여중');
    ELSE
    UPDATE 운동기구 SET 대여여부 = 'Y' WHERE :NEW.기구번호=운동기구.기구번호 AND :NEW.가게명=운동기구.가게명 ;
    END IF;
END;



DROP TRIGGER 운동기구대여;
 
 
  -- 상품을 구매하면 상품 구매목록 갯수가 줄어든다 0개 이하면 구매 추가가 삭제됨
 CREATE OR REPLACE TRIGGER 상품구매
    BEFORE INSERT ON 구매
    FOR EACH ROW
DECLARE
    SALE_NUM NUMBER;
    buy_number NUMBER;
BEGIN
    SELECT 상품수량 INTO SALE_NUM FROM 상품 WHERE :NEW.가게명=상품.가게명 AND :NEW.구매번호=상품.상품번호;
    SELECT :NEW.구매수량 INTO buy_number FROM DUAL;
    IF SALE_NUM-1 <= 0 THEN
        RAISE_APPLICATION_ERROR(-20999,'갯수부족');
    ELSE
        UPDATE 상품 SET 상품.상품수량=상품.상품수량-buy_number WHERE :NEW.가게명=상품.가게명 AND :NEW.구매번호=상품.상품번호;
    END IF;
END;



-- 회원 추가시 순위 입력
CREATE OR REPLACE TRIGGER 우수회원
    AFTER INSERT ON 회원
    FOR EACH ROW
BEGIN
    INSERT INTO 우수회원 VALUES('BRONZE','0','0',:NEW.회원번호);
END;


 -- 회원 헬스장 탈퇴시 PT도, 운동기구 자동으로 없어짐 대여정보 N
 
CREATE OR REPLACE TRIGGER 회원탈퇴
    AFTER DELETE ON 회원
    FOR EACH ROW
BEGIN
    DELETE FROM 대여 WHERE :OLD.회원번호=대여.회원번호;
    DELETE FROM PT WHERE :OLD.회원번호=PT.회원번호;
    DELETE FROM 우수회원 WHERE :OLD.회원번호=우수회원.회원번호;
    DELETE FROM 구매 WHERE :OLD.회원번호=구매.회원번호;
    DELETE FROM 가입 WHERE :OLD.회원번호=가입.회원번호;
END;


CREATE OR REPLACE TRIGGER 회원탈퇴시기구회수
    BEFORE DELETE ON 대여
    FOR EACH ROW
DECLARE
 운동기구수 NUMBER;
BEGIN
    SELECT COUNT(*) INTO 운동기구수 FROM 운동기구 WHERE :OLD.기구번호=운동기구.기구번호 AND :OLD.가게명=운동기구.가게명 ;
    IF 운동기구수>0 THEN
        UPDATE 운동기구 SET 대여여부 = 'N' WHERE :OLD.기구번호=운동기구.기구번호 AND :OLD.가게명=운동기구.가게명 ;
    END IF;
END;


commit;
DROP TRIGGER 회원탈퇴시기구회수;




--헬스장 삭제시 운동기구, 상품, 트레이너, 가입 삭제
CREATE OR REPLACE TRIGGER 헬스장삭제
    AFTER DELETE ON 헬스장
    FOR EACH ROW
BEGIN
    DELETE FROM 운동기구 WHERE :OLD.가게명=운동기구.가게명;
    DELETE FROM 상품 WHERE :OLD.가게명=상품.가게명;
    DELETE FROM 트레이너 WHERE :OLD.가게명=트레이너.가게명;
    DELETE FROM 가입 WHERE :OLD.가게명=가입.가게명;
    DELETE FROM 대여 WHERE :OLD.가게명=대여.가게명;
END;

DELETE FROM 대여 WHERE '굿모닝휘트니스'=대여.가게명;

COMMIT;

-- 트레이너 삭제시 PT,순위정보 삭제
CREATE OR REPLACE TRIGGER 트레이너삭제
    AFTER DELETE ON 트레이너
    FOR EACH ROW
BEGIN
    DELETE FROM PT WHERE :OLD.트레이너번호=PT.트레이너번호;
    DELETE FROM 순위 WHERE :OLD.트레이너번호=순위.트레이너번호;
END;


-- 상품 삭제시 구매정보 삭제
CREATE OR REPLACE TRIGGER 상품구삭제
    AFTER DELETE ON 상품
    FOR EACH ROW
BEGIN
    DELETE FROM 구매 WHERE :OLD.가게명=구매.가게명 AND :OLD.상품번호=구매.구매번호;
END;


-- 운동기구 삭제시 대여정보 삭제
CREATE OR REPLACE TRIGGER 운동기구삭제
    AFTER DELETE ON 운동기구
    FOR EACH ROW
BEGIN
    DELETE FROM 대여 WHERE :OLD.가게명=대여.가게명;
END;



commit;



DROP TRIGGER 운동기구삭제;












-- PT 추가시 트레이너 PT인원 초과
CREATE OR REPLACE TRIGGER PT인원초과
    AFTER INSERT ON PT
    FOR EACH ROW
DECLARE
 V_인원수 NUMBER;
BEGIN
    SELECT COUNT(*) INTO V_인원수 FROM PT WHERE :NEW.트레이너번호=PT.트레이너번호;
    IF V_인원수>3 THEN
       RAISE_APPLICATION_ERROR(-20999,'인원초과');
    END IF;
END;



COMMIT;

DROP TRIGGER PT인원초과;
SELECT * FROM PT;






-- 상품 주문시 상품 추가
CREATE OR REPLACE TRIGGER 상품추가
    AFTER INSERT ON 상품
    FOR EACH ROW
DECLARE
    OBJECT_NUM NUMBER;--VARCHAR(20);
    STORE_NAME VARCHAR(70);
BEGIN
    --SELECT 상품이름,가게명 INTO OBJECT_NUM,STORE_NAME FROM 상품 WHERE 상품.상품이름=:NEW.상품이름 AND :NEW.가게명=상품.가게명;
    --IF :NEW.상품이름=OBJECT_NUM AND :NEW.가게명=STORE_NAME THEN
       -- UPDATE 상품 SET 상품수량=상품수량+:NEW.상품수량 WHERE 상품.상품이름=:NEW.상품이름 AND :NEW.가게명=상품.가게명;
       DELETE FROM 상품 WHERE '002'=상품.상품번호 AND '내셔널팀휘트니스'=상품.가게명;
   
    --END IF;
END;

drop trigger 상품추가;


DECLARE
    OBJECT_NUM VARCHAR(20);
    STORE_NAME VARCHAR(70);
BEGIN
    SELECT 상품이름,가게명 INTO OBJECT_NUM,STORE_NAME FROM 상품 WHERE 상품.상품이름='손목보호대' AND '내셔널팀휘트스'=상품.가게명;
    DBMS_OUTPUT.PUT_LINE(STORE_NAME);
END;


commit;









--개인별 사용금액
CREATE OR REPLACE PROCEDURE user_money(USER_NUMBER IN NUMBER,USER_MONEY OUT NUMBER)
AS
    MONEY NUMBER:=0; --매출금액
    BUY NUMBER; -- 구매수량
    PRICE NUMBER; --가격
    NAME2 VARCHAR(70); -- 가게명
    NUMBER_DAY INT;
    PRICE_HEALTH INT;

    CURSOR C IS SELECT 구매수량,가격 FROM 상품,구매 WHERE 상품."상품번호"=구매."구매번호" AND 상품."가게명"=구매."가게명" AND 상품.가게명=STORE_NAME;
    CURSOR D IS SELECT 등록일수,이용료 FROM 헬스장,가입 WHERE 헬스장.가게명=가입."가게명" AND 가입.가게명=STORE_NAME;
BEGIN
    
    OPEN C;
    LOOP
        FETCH C INTO BUY,PRICE;
        EXIT WHEN C%NOTFOUND;
        MONEY :=BUY*PRICE+MONEY;
    END LOOP;
    CLOSE C;
    
    OPEN D;
    LOOP
        FETCH D INTO NUMBER_DAY,PRICE_HEALTH;
        EXIT WHEN D%NOTFOUND;
        MONEY :=NUMBER_DAY*PRICE_HEALTH+MONEY;
    END LOOP;
     CLOSE D;
    
    STORE_MONEY:=MONEY;
    
END;



