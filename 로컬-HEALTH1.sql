SET SERVEROUTPUT ON;

-- �������ν��� 

-- ȸ���� ���ݾ��� �̿��Ͽ� �ｺ���� ������ Ȯ���� �� �ִ�.
-- ����, ����, 

CREATE OR REPLACE PROCEDURE SALES(STORE_NAME IN CHAR,STORE_MONEY OUT NUMBER)
AS
    MONEY NUMBER:=0; --����ݾ�
    BUY NUMBER; -- ���ż���
    PRICE NUMBER; --����
    NAME2 VARCHAR(70); -- ���Ը�
    NUMBER_DAY INT;
    PRICE_HEALTH INT;

    CURSOR C IS SELECT ���ż���,���� FROM ��ǰ,���� WHERE ��ǰ."��ǰ��ȣ"=����."���Ź�ȣ" AND ��ǰ."���Ը�"=����."���Ը�" AND ��ǰ.���Ը�=STORE_NAME;
    CURSOR D IS SELECT ����ϼ�,�̿�� FROM �ｺ��,���� WHERE �ｺ��.���Ը�=����."���Ը�" AND ����.���Ը�=STORE_NAME;
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
  SALES('�丶����Ʈ�Ͻ�',USER_NUM);
 DBMS_OUTPUT.PUT_LINE(MONEY);
END;

-- ȸ���� ���� ��ⱸ ���� ���

CREATE OR REPLACE PROCEDURE HEALTH_TOOL(USER_NUM IN NUMBER, EX_NUM OUT NUMBER)--���� � �ⱸ ����
AS
BEGIN
    
    SELECT COUNT(*) INTO EX_NUM FROM �뿩 where �뿩.ȸ����ȣ=USER_NUM;
END;




DECLARE
 USER_NUM NUMBER;
 BEGIN
 HEALTH_TOOL('001',USER_NUM);
 DBMS_OUTPUT.PUT_LINE(USER_NUM);
END;

DROP PROCEDURE HEALTH_TOOL;


-- ȸ���� �����ϰ� ����ϼ��� �̿��ؼ� ���� �� ���ϱ�
CREATE OR REPLACE PROCEDURE ������(days_betwwen OUT varchar,user_num in int)
AS
BEGIN
    SELECT TO_DATE(TO_CHAR(SYSDATE))-TO_DATE(������,'YYYY-MM-DD') INTO days_betwwen from ���� where ����.ȸ����ȣ=user_num;
    SELECT ����ϼ�-CAST(TO_NUMBER(days_betwwen)/30 AS NUMBER(10)) INTO days_betwwen FROM ���� WHERE ����.ȸ����ȣ=user_num;
    IF TO_NUMBER(days_betwwen)<0 THEN
        days_betwwen:='�簡��';
        
    END IF; 
END;


DECLARE
 DAYS_BETWEEN VARCHAR(50);
 BEGIN
 ������(DAYS_BETWEEN,'008');
 DBMS_OUTPUT.PUT_LINE(DAYS_BETWEEN);
END;

DROP PROCEDURE ������;


-- ��ǰ ���� �Ѿ�

CREATE OR REPLACE PROCEDURE �����Ѿ�(STORE_NAME IN CHAR, SALES OUT NUMBER)
AS
    MONEY NUMBER:=0; --����ݾ�
    BUY NUMBER; -- ���ż���
    PRICE NUMBER; --����
    NAME2 VARCHAR(70); -- ���Ը�

    CURSOR C IS SELECT ���ż���,���� FROM ��ǰ,���� WHERE ��ǰ."��ǰ��ȣ"=����."���Ź�ȣ" AND ��ǰ."���Ը�"=����."���Ը�" AND ��ǰ.���Ը�=STORE_NAME;
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
 �����Ѿ�('�丶����Ʈ�Ͻ�',SALES);
 DBMS_OUTPUT.PUT_LINE(SALES);
END;

DROP PROCEDURE SALES;

-- �ｺ�� �ο���
CREATE OR REPLACE PROCEDURE �ｺ���ο���(SOTRE_NAME IN CHAR, USER_NUM OUT NUMBER)
AS
BEGIN
    SELECT COUNT(*) INTO USER_NUM FROM ���� WHERE ����.���Ը�=SOTRE_NAME;
END;




DECLARE
 SALES NUMBER;
 BEGIN
 �ｺ���ο���('�丶����Ʈ�Ͻ�',SALES);
 DBMS_OUTPUT.PUT_LINE(SALES);
END;




-- Ʈ����
-- ��ⱸ �뿩 ���� Y �뿩���̸� ������

CREATE OR REPLACE TRIGGER ��ⱸ�뿩
    BEFORE INSERT ON �뿩
    FOR EACH ROW
DECLARE
    PERMISSION CHAR;
BEGIN
    SELECT �뿩���� INTO PERMISSION FROM ��ⱸ WHERE :NEW.�ⱸ��ȣ=��ⱸ.�ⱸ��ȣ AND :NEW.���Ը�=��ⱸ.���Ը� ;
    IF   PERMISSION='Y' THEN
       RAISE_APPLICATION_ERROR(-20999,'�̴̹뿩��');
    ELSE
    UPDATE ��ⱸ SET �뿩���� = 'Y' WHERE :NEW.�ⱸ��ȣ=��ⱸ.�ⱸ��ȣ AND :NEW.���Ը�=��ⱸ.���Ը� ;
    END IF;
END;



DROP TRIGGER ��ⱸ�뿩;
 
 
  -- ��ǰ�� �����ϸ� ��ǰ ���Ÿ�� ������ �پ��� 0�� ���ϸ� ���� �߰��� ������
 CREATE OR REPLACE TRIGGER ��ǰ����
    BEFORE INSERT ON ����
    FOR EACH ROW
DECLARE
    SALE_NUM NUMBER;
    buy_number NUMBER;
BEGIN
    SELECT ��ǰ���� INTO SALE_NUM FROM ��ǰ WHERE :NEW.���Ը�=��ǰ.���Ը� AND :NEW.���Ź�ȣ=��ǰ.��ǰ��ȣ;
    SELECT :NEW.���ż��� INTO buy_number FROM DUAL;
    IF SALE_NUM-1 <= 0 THEN
        RAISE_APPLICATION_ERROR(-20999,'��������');
    ELSE
        UPDATE ��ǰ SET ��ǰ.��ǰ����=��ǰ.��ǰ����-buy_number WHERE :NEW.���Ը�=��ǰ.���Ը� AND :NEW.���Ź�ȣ=��ǰ.��ǰ��ȣ;
    END IF;
END;



-- ȸ�� �߰��� ���� �Է�
CREATE OR REPLACE TRIGGER ���ȸ��
    AFTER INSERT ON ȸ��
    FOR EACH ROW
BEGIN
    INSERT INTO ���ȸ�� VALUES('BRONZE','0','0',:NEW.ȸ����ȣ);
END;


 -- ȸ�� �ｺ�� Ż��� PT��, ��ⱸ �ڵ����� ������ �뿩���� N
 
CREATE OR REPLACE TRIGGER ȸ��Ż��
    AFTER DELETE ON ȸ��
    FOR EACH ROW
BEGIN
    DELETE FROM �뿩 WHERE :OLD.ȸ����ȣ=�뿩.ȸ����ȣ;
    DELETE FROM PT WHERE :OLD.ȸ����ȣ=PT.ȸ����ȣ;
    DELETE FROM ���ȸ�� WHERE :OLD.ȸ����ȣ=���ȸ��.ȸ����ȣ;
    DELETE FROM ���� WHERE :OLD.ȸ����ȣ=����.ȸ����ȣ;
    DELETE FROM ���� WHERE :OLD.ȸ����ȣ=����.ȸ����ȣ;
END;


CREATE OR REPLACE TRIGGER ȸ��Ż��ñⱸȸ��
    BEFORE DELETE ON �뿩
    FOR EACH ROW
DECLARE
 ��ⱸ�� NUMBER;
BEGIN
    SELECT COUNT(*) INTO ��ⱸ�� FROM ��ⱸ WHERE :OLD.�ⱸ��ȣ=��ⱸ.�ⱸ��ȣ AND :OLD.���Ը�=��ⱸ.���Ը� ;
    IF ��ⱸ��>0 THEN
        UPDATE ��ⱸ SET �뿩���� = 'N' WHERE :OLD.�ⱸ��ȣ=��ⱸ.�ⱸ��ȣ AND :OLD.���Ը�=��ⱸ.���Ը� ;
    END IF;
END;


commit;
DROP TRIGGER ȸ��Ż��ñⱸȸ��;




--�ｺ�� ������ ��ⱸ, ��ǰ, Ʈ���̳�, ���� ����
CREATE OR REPLACE TRIGGER �ｺ�����
    AFTER DELETE ON �ｺ��
    FOR EACH ROW
BEGIN
    DELETE FROM ��ⱸ WHERE :OLD.���Ը�=��ⱸ.���Ը�;
    DELETE FROM ��ǰ WHERE :OLD.���Ը�=��ǰ.���Ը�;
    DELETE FROM Ʈ���̳� WHERE :OLD.���Ը�=Ʈ���̳�.���Ը�;
    DELETE FROM ���� WHERE :OLD.���Ը�=����.���Ը�;
    DELETE FROM �뿩 WHERE :OLD.���Ը�=�뿩.���Ը�;
END;

DELETE FROM �뿩 WHERE '�¸����Ʈ�Ͻ�'=�뿩.���Ը�;

COMMIT;

-- Ʈ���̳� ������ PT,�������� ����
CREATE OR REPLACE TRIGGER Ʈ���̳ʻ���
    AFTER DELETE ON Ʈ���̳�
    FOR EACH ROW
BEGIN
    DELETE FROM PT WHERE :OLD.Ʈ���̳ʹ�ȣ=PT.Ʈ���̳ʹ�ȣ;
    DELETE FROM ���� WHERE :OLD.Ʈ���̳ʹ�ȣ=����.Ʈ���̳ʹ�ȣ;
END;


-- ��ǰ ������ �������� ����
CREATE OR REPLACE TRIGGER ��ǰ������
    AFTER DELETE ON ��ǰ
    FOR EACH ROW
BEGIN
    DELETE FROM ���� WHERE :OLD.���Ը�=����.���Ը� AND :OLD.��ǰ��ȣ=����.���Ź�ȣ;
END;


-- ��ⱸ ������ �뿩���� ����
CREATE OR REPLACE TRIGGER ��ⱸ����
    AFTER DELETE ON ��ⱸ
    FOR EACH ROW
BEGIN
    DELETE FROM �뿩 WHERE :OLD.���Ը�=�뿩.���Ը�;
END;



commit;



DROP TRIGGER ��ⱸ����;












-- PT �߰��� Ʈ���̳� PT�ο� �ʰ�
CREATE OR REPLACE TRIGGER PT�ο��ʰ�
    AFTER INSERT ON PT
    FOR EACH ROW
DECLARE
 V_�ο��� NUMBER;
BEGIN
    SELECT COUNT(*) INTO V_�ο��� FROM PT WHERE :NEW.Ʈ���̳ʹ�ȣ=PT.Ʈ���̳ʹ�ȣ;
    IF V_�ο���>3 THEN
       RAISE_APPLICATION_ERROR(-20999,'�ο��ʰ�');
    END IF;
END;



COMMIT;

DROP TRIGGER PT�ο��ʰ�;
SELECT * FROM PT;






-- ��ǰ �ֹ��� ��ǰ �߰�
CREATE OR REPLACE TRIGGER ��ǰ�߰�
    AFTER INSERT ON ��ǰ
    FOR EACH ROW
DECLARE
    OBJECT_NUM NUMBER;--VARCHAR(20);
    STORE_NAME VARCHAR(70);
BEGIN
    --SELECT ��ǰ�̸�,���Ը� INTO OBJECT_NUM,STORE_NAME FROM ��ǰ WHERE ��ǰ.��ǰ�̸�=:NEW.��ǰ�̸� AND :NEW.���Ը�=��ǰ.���Ը�;
    --IF :NEW.��ǰ�̸�=OBJECT_NUM AND :NEW.���Ը�=STORE_NAME THEN
       -- UPDATE ��ǰ SET ��ǰ����=��ǰ����+:NEW.��ǰ���� WHERE ��ǰ.��ǰ�̸�=:NEW.��ǰ�̸� AND :NEW.���Ը�=��ǰ.���Ը�;
       DELETE FROM ��ǰ WHERE '002'=��ǰ.��ǰ��ȣ AND '���ų�����Ʈ�Ͻ�'=��ǰ.���Ը�;
   
    --END IF;
END;

drop trigger ��ǰ�߰�;


DECLARE
    OBJECT_NUM VARCHAR(20);
    STORE_NAME VARCHAR(70);
BEGIN
    SELECT ��ǰ�̸�,���Ը� INTO OBJECT_NUM,STORE_NAME FROM ��ǰ WHERE ��ǰ.��ǰ�̸�='�ո�ȣ��' AND '���ų�����Ʈ��'=��ǰ.���Ը�;
    DBMS_OUTPUT.PUT_LINE(STORE_NAME);
END;


commit;









--���κ� ���ݾ�
CREATE OR REPLACE PROCEDURE user_money(USER_NUMBER IN NUMBER,USER_MONEY OUT NUMBER)
AS
    MONEY NUMBER:=0; --����ݾ�
    BUY NUMBER; -- ���ż���
    PRICE NUMBER; --����
    NAME2 VARCHAR(70); -- ���Ը�
    NUMBER_DAY INT;
    PRICE_HEALTH INT;

    CURSOR C IS SELECT ���ż���,���� FROM ��ǰ,���� WHERE ��ǰ."��ǰ��ȣ"=����."���Ź�ȣ" AND ��ǰ."���Ը�"=����."���Ը�" AND ��ǰ.���Ը�=STORE_NAME;
    CURSOR D IS SELECT ����ϼ�,�̿�� FROM �ｺ��,���� WHERE �ｺ��.���Ը�=����."���Ը�" AND ����.���Ը�=STORE_NAME;
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



