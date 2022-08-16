ALTER session set "_ORACLE_SCRIPT"=true;

DROP USER UNIV CASCADE; -- 기존 사용자 삭제(현재 접속되어 있으면 삭제 안 됨)
	-- CASCADE option : 관련 스키마 개체들도 함께 삭제.  Default는 No Action
CREATE USER HEALTH IDENTIFIED BY 1234  -- 사용자 ID : UNIV, 비밀번호 : 1234
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP;
GRANT connect, resource, dba TO HEALTH;

DROP TABLE DD;

CREATE TABLE 헬스장 (
	가게명 VARCHAR(70),
	전화번호 VARCHAR(25),
	이용료 INT,
	주소 VARCHAR(100) NOT NULL,
	락커현황 INT,
	PRIMARY KEY(가게명)
    );

CREATE TABLE 회원(
	회원번호 INT,
	이름 VARCHAR(10),
	연락처 VARCHAR(20),
	주소 VARCHAR(100),
	키 INT,
	몸무게 INT,
	나이 INT,
	성별 VARCHAR(5),
	PRIMARY KEY(회원번호)
);

CREATE TABLE 운동기구(
    기구명 VARCHAR(20),
	기구번호 INT,
	대여여부 VARCHAR(5),
	가게명 VARCHAR(70),
	PRIMARY KEY(기구번호,가게명),
	FOREIGN KEY(가게명) REFERENCES 헬스장(가게명)
);

CREATE TABLE 상품(
	상품번호 INT,
	상품이름 VARCHAR(50),
	상품수량 INT,
	가격 INT,
	가게명 VARCHAR(70),
	PRIMARY KEY(상품번호,가게명),
	FOREIGN KEY(가게명) REFERENCES 헬스장(가게명)
);

CREATE TABLE 트레이너(
	트레이너번호 INT,
	이름 VARCHAR(10),
	연락처 VARCHAR(20),
	주소 VARCHAR(100),
	나이 INT,
	경력 INT,
	성별 VARCHAR(5),
	가게명 VARCHAR(70),
	입사일 VARCHAR(20),
	연봉 VARCHAR(20),
	PRIMARY KEY(트레이너번호),
	FOREIGN KEY(가게명) REFERENCES 헬스장(가게명)
);

CREATE TABLE PT(
	수업일수 INT,
	식단 VARCHAR(100),
	일정 VARCHAR(100),
	회원번호 INT,
	트레이너번호 INT,
	PRIMARY KEY (트레이너번호,회원번호),
	FOREIGN KEY(트레이너번호) REFERENCES 트레이너(트레이너번호),
	FOREIGN KEY(회원번호) REFERENCES 회원(회원번호)
);

CREATE TABLE 순위(
	등급 VARCHAR(20),
	수업료 INT,
	트레이너번호 INT,
	PRIMARY KEY(트레이너번호),
	FOREIGN KEY(트레이너번호) REFERENCES 트레이너(트레이너번호)
);

CREATE TABLE 우수회원(
	등급 VARCHAR(20),
	사용금액 INT,
	마일리지 INT,
	회원번호 INT,
	PRIMARY KEY(회원번호),
	FOREIGN KEY(회원번호) REFERENCES 회원(회원번호)
);

CREATE TABLE 가입(
	가입일 VARCHAR(20),
	등록일수 INT,
	회원번호 INT,
	가게명 VARCHAR(70),
	PRIMARY KEY (가게명,회원번호),
	FOREIGN KEY(가게명) REFERENCES 헬스장(가게명),
	FOREIGN KEY(회원번호) REFERENCES 회원(회원번호)
);

CREATE TABLE 대여(
	대여일자 VARCHAR(20),
	회원번호 INT,
	가게명 VARCHAR(70),
    기구번호 INT,
	PRIMARY KEY (가게명,회원번호,기구번호),
    FOREIGN KEY(기구번호,가게명) REFERENCES 운동기구(기구번호,가게명),
	FOREIGN KEY(가게명) REFERENCES 헬스장(가게명),
	FOREIGN KEY(회원번호) REFERENCES 회원(회원번호)
);



CREATE TABLE 구매(
	구매일자 VARCHAR(20),
	구매수량 INT,
	구매번호 INT,
	회원번호 INT,
	가게명 VARCHAR(70),
	PRIMARY KEY (가게명,회원번호,구매번호,구매일자),
    FOREIGN KEY(구매번호,가게명) REFERENCES 상품(상품번호,가게명),
	FOREIGN KEY(가게명) REFERENCES 헬스장(가게명),
	FOREIGN KEY(회원번호) REFERENCES 회원(회원번호)
);

DROP TABLE 헬스장;
DROP TABLE 회원;
DROP TABLE 운동기구;
DROP TABLE 상품;
DROP TABLE 트레이너;
DROP TABLE PT;
DROP TABLE 순위;
DROP TABLE 우수회원;
DROP TABLE 가입;
DROP TABLE 대여;
DROP TABLE 구매;

-- 헬스장 추가
INSERT INTO 헬스장 VALUES('토마토휘트니스','051-555-7621','80000','부산광역시 동래구 명륜동 명륜로129번길 20','50');
INSERT INTO 헬스장 VALUES('멋짐휘트니스','051-558-8689','70000','부산광역시 동래구 명륜동 명륜로103번길 8 스카이뷰 4,5층','40');
INSERT INTO 헬스장 VALUES('위드피트니스','051-514-4887','60000','부산광역시 금정구 부곡2동 부산대학로 10','30');
INSERT INTO 헬스장 VALUES('우리동네헬스장','051-898-1011','50000','부산광역시 부산진구 가야동 56-2','30');
INSERT INTO 헬스장 VALUES('린바디휘트니스','051-627-3172','80000','부산광역시 남구 대연3동 수영로 282','50');
INSERT INTO 헬스장 VALUES('림휘트니스','051-724-7885','75000','부산광역시 기장군 기장읍 서부리 76-1','40');
INSERT INTO 헬스장 VALUES('굿모닝휘트니스','051-253-3585','60000','부산광역시 중구 보수동1가 144-4','50');
INSERT INTO 헬스장 VALUES('굿바디휘트니스','051-403-9825','65000','부산광역시 영도구 동삼동 317-8','40');
INSERT INTO 헬스장 VALUES('리본휘트니스','051-752-2242','80000','부산광역시 수영구 광안동 379-48번지 6층 7층 702호','30');
INSERT INTO 헬스장 VALUES('내셔널팀휘트니스','051-755-8111','90000','수영동 444-2번지 4층 보명빌딩 수영구 부산광역시 KR','60');

delete from 헬스장 where 헬스장.가게명='내셔널팀휘트니스';
SELECT * FROM 회원;
SELECT * FROM 상품;
commit;
-- 회원 추가
INSERT INTO 회원 VALUES('001','최진오','010-1111-1111','부산광역시 중구 중앙동','180','65','21','남');
INSERT INTO 회원 VALUES('002','조한승','010-2222-1111','부산광역시 중구 중앙동','170','60','23','남');
INSERT INTO 회원 VALUES('003','한두원','010-3333-1111','부산광역시 동구 범일동','175','65','25','남');
INSERT INTO 회원 VALUES('004','하서화','010-4444-1111','부산광역시 동구 범일동','160','50','20','여');
INSERT INTO 회원 VALUES('005','한가현','010-1111-5555','부산광역시 부산진구 가야동','155','49','26','여');
INSERT INTO 회원 VALUES('006','최남영','010-1111-6666','부산광역시 부산진구 가야동','174','80','23','남');
INSERT INTO 회원 VALUES('007','안진경','010-1111-7777','부산광역시 부산진구 개금동','153','45','28','여');
INSERT INTO 회원 VALUES('008','한기영','010-1111-1888','부산광역시 부산진구 개금동','188','80','24','남');
INSERT INTO 회원 VALUES('009','박덕선','010-1111-0991','부산광역시 부산진구 부암동','168','55','21','여');
INSERT INTO 회원 VALUES('010','최정혜','010-1431-1111','부산광역시 동래구 수민동','164','60','24','여');
INSERT INTO 회원 VALUES('011','박나예','010-1541-1111','부산광역시 동래구 복산동','163','55','26','여');
INSERT INTO 회원 VALUES('012','강세빈','010-3331-1111','부산광역시 동래구 명륜동','173','65','25','여');
INSERT INTO 회원 VALUES('013','강인정','010-1441-151','부산광역시 동래구 명륜동','166','60','29','여');
INSERT INTO 회원 VALUES('014','윤세찬','010-1001-1991','부산광역시 남구 대연동','178','68','24','남');
INSERT INTO 회원 VALUES('015','임일훈','010-1151-1341','부산광역시 남구 대연동','183','64','21','남');
INSERT INTO 회원 VALUES('016','한병찬','010-5441-6611','부산광역시 해운대구 우제동','165','60','24','남');
INSERT INTO 회원 VALUES('017','조민광','010-8766-1341','부산광역시 해운대구 좌제동','180','64','25','남');
INSERT INTO 회원 VALUES('018','정웅천','010-1453-1331','부산광역시 사하구 부곡동','187','88','27','남');
INSERT INTO 회원 VALUES('019','김연우','010-1453-1531','부산광역시 사하구 부곡동','185','80','47','남');
INSERT INTO 회원 VALUES('020','이민히','010-1453-4531','부산광역시 사하구 부곡동','155','78','17','남');
INSERT INTO 회원 VALUES('021','김민후','010-115-1331','부산광역시 사하구 부곡동','126','78','27','남');
INSERT INTO 회원 VALUES('022','정조차','010-1153-1331','부산광역시 사하구 부곡동','178','50','37','남');
INSERT INTO 회원 VALUES('023','고정혁','010-1513-1331','부산광역시 사하구 부곡동','165','60','27','남');
INSERT INTO 회원 VALUES('024','정옹치','010-1113-1331','부산광역시 사하구 부곡동','111','85','25','여');
INSERT INTO 회원 VALUES('025','한상의','010-1222-1331','부산광역시 사하구 부곡동','123','50','24','여');

INSERT INTO 회원 VALUES('026','한ㄹ의','010-1222-1331','부산광역시 하구 부곡동','123','50','24','여');
SELECT * FROM 회원;

DELETE FROM 회원 WHERE 이름='강세빈';

-- 운동기구 추가
INSERT INTO 운동기구 VALUES('고무밴드','001','Y','토마토휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','Y','토마토휘트니스');
INSERT INTO 운동기구 VALUES('중량벨트','003','Y','토마토휘트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','Y','멋짐휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','N','멋짐휘트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','Y','위드피트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','N','위드피트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','N','우리동네헬스장');
INSERT INTO 운동기구 VALUES('스트랩','002','Y','우리동네헬스장');
INSERT INTO 운동기구 VALUES('고무밴드','001','Y','린바디휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','N','린바디휘트니스');
INSERT INTO 운동기구 VALUES('중량벨트','003','N','린바디휘트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','Y','림휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','N','림휘트니스');
INSERT INTO 운동기구 VALUES('중량벨트','003','N','림휘트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','N','굿모닝휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','Y','굿모닝휘트니스');
INSERT INTO 운동기구 VALUES('중량벨트','003','N','굿모닝휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','N','굿바디휘트니스');
INSERT INTO 운동기구 VALUES('중량벨트','003','N','굿바디휘트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','N','리본휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','N','리본휘트니스');
INSERT INTO 운동기구 VALUES('중량벨트','003','Y','리본휘트니스');
INSERT INTO 운동기구 VALUES('고무밴드','001','Y','내셔널팀휘트니스');
INSERT INTO 운동기구 VALUES('스트랩','002','Y','내셔널팀휘트니스');

DELETE FROM 운동기구 WHERE 운동기구."가게명"='리본휘트니스' AND 운동기구."기구번호"='003'

select * from 운동기구;
select * from 대여;

-- 상품 추가
INSERT INTO 상품 VALUES('001','단백질보충제','5','50000','토마토휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','3','10000','토마토휘트니스');
INSERT INTO 상품 VALUES('003','헬스부스터','4','30000','토마토휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','7','60000','멋짐휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','2','15000','멋짐휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','8','70000','위드피트니스');
INSERT INTO 상품 VALUES('002','손목보호대','5','20000','위드피트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','3','40000','우리동네헬스장');
INSERT INTO 상품 VALUES('002','손목보호대','7','10000','우리동네헬스장');
INSERT INTO 상품 VALUES('001','단백질보충제','9','80000','린바디휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','3','5000','린바디휘트니스');
INSERT INTO 상품 VALUES('003','헬스부스터','2','40000','린바디휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','5','50000','림휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','3','20000','림휘트니스');
INSERT INTO 상품 VALUES('003','헬스부스터','7','50000','림휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','6','40000','굿모닝휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','1','10000','굿모닝휘트니스');
INSERT INTO 상품 VALUES('003','헬스부스터','9','70000','굿모닝휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','4','45000','굿바디휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','3','23000','굿바디휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','4','60000','리본휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','5','10000','리본휘트니스');
INSERT INTO 상품 VALUES('003','헬스부스터','3','30000','리본휘트니스');
INSERT INTO 상품 VALUES('001','단백질보충제','8','40000','내셔널팀휘트니스');
INSERT INTO 상품 VALUES('002','손목보호대','5','15000','내셔널팀휘트니스');

INSERT INTO 상품 VALUES('005','손목보호대','5','15000','내셔널팀휘트니스');

SELECT 상품이름,가게명 FROM 상품 WHERE 상품.상품이름='손목보호대' AND '내셔널팀휘트니스'=상품.가게명;

DELETE FROM 상품 WHERE 상품."상품번호"='005' AND 상품.가게명='내셔널팀휘트니스';
select * from 상품;
select * from 구매;

--트레이너 추가
INSERT INTO 트레이너 VALUES('001','이민지','010-5211-5365','부산광역시 부산진구 가야동','30','5','여','토마토휘트니스','2021-03-01','3000');
INSERT INTO 트레이너 VALUES('002','김선호','010-4321-5355','부산광역시 부산진구 전포동','35','6','남','토마토휘트니스','2020-05-21','4000');
INSERT INTO 트레이너 VALUES('003','정동화','010-6734-1425','부산광역시 부산진구 가야동','37','10','남','멋짐휘트니스','2021-01-03','5000');
INSERT INTO 트레이너 VALUES('004','김민지','010-4343-5436','부산광역시 중구 초량동','35','4','여','위드피트니스','2020-07-11','4000');
INSERT INTO 트레이너 VALUES('005','송이한','010-2342-4536','부산광역시 중구 초량동','28','7','남','우리동네헬스장','2020-10-15','4500');
INSERT INTO 트레이너 VALUES('006','임도혁','010-1236-4675','부산광역시 중구 범일동','40','8','남','린바디휘트니스','2020-08-31','4500');
INSERT INTO 트레이너 VALUES('007','이승훈','010-5542-4878','부산광역시 사상구 삼락동','37','4','남','린바디휘트니스','2021-02-10','3000');
INSERT INTO 트레이너 VALUES('008','이은하','010-5435-7585','부산광역시 사상구 삼락동','38','3','여','림휘트니스','2020-08-24','3000');
INSERT INTO 트레이너 VALUES('009','윤도현','010-5661-7609','부산광역시 사상구 덕포동','31','4','여','림휘트니스','2020-12-05','3500');
INSERT INTO 트레이너 VALUES('010','김나영','010-5143-5367','부산광역시 연제구 산제동','34','8','남','굿모닝휘트니스','2020-11-21','4000');
INSERT INTO 트레이너 VALUES('011','유희열','010-5345-8986','부산광역시 연제구 연산동','37','10','남','굿바디휘트니스','2020-10-11','4500');
INSERT INTO 트레이너 VALUES('012','정승환','010-1235-6544','부산광역시 강서구 대저동','34','12','남','리본휘트니스','2020-09-10','5500');
INSERT INTO 트레이너 VALUES('013','이준희','010-2211-5435','부산광역시 강서구 대저동','45','9','남','리본휘트니스','2021-05-03','5000');
INSERT INTO 트레이너 VALUES('014','강동규','010-5346-5333','부산광역시 강서구 명지동','43','7','남','내셔널팀휘트니스','2021-07-21','4800');

DELETE FROM 트레이너 WHERE 트레이너번호=12;
select * from 트레이너;
select * from PT;
select * from 순위;

--PT 추가
INSERT INTO PT VALUES('3','벌크업식단','11월 28일 수업 예정','001',001);
INSERT INTO PT VALUES('5','벌크업식단','11월 24일 수업 예정','002',002);
INSERT INTO PT VALUES('7','다이어트식단','11월 25일 수업 예정','006',004);
INSERT INTO PT VALUES('10','다이어트식단','12월 03일 수업 예정','009',005);
INSERT INTO PT VALUES('13','벌크업식단','12월 13일 수업 예정','013',008);
INSERT INTO PT VALUES('5','다이어트식단','12월 10일일 수업 예정','016',010);
INSERT INTO PT VALUES('4','벌크업식단','11월 15일 수업 예정','011',007);
INSERT INTO PT VALUES('9','다이어트식단','12월 23일 수업 예정','012',007);
INSERT INTO PT VALUES('8','벌크업식단','11월 14일 수업 예정','007',012);
INSERT INTO PT VALUES('11','다이어트식단','11월 03일 수업 예정','005',003);

INSERT INTO PT VALUES('11','다이어트식단','11월 03일 수업 예정','002',001);
INSERT INTO PT VALUES('11','다이어트식단','11월 03일 수업 예정','003',001);

DELETE FROM PT WHERE PT."트레이너번호"=001 AND PT."회원번호"='002';

SELECT * FROM PT;
SELECT COUNT(*)  FROM PT WHERE 001=PT.트레이너번호;
SELECT * FROM 트레이너;
-- 순위 추가
INSERT INTO 순위 VALUES('SILVER','30000','001');
INSERT INTO 순위 VALUES('GOLD','5000','002');
INSERT INTO 순위 VALUES('GOLD','50000','003');
INSERT INTO 순위 VALUES('SILVER','30000','004');
INSERT INTO 순위 VALUES('GOLD','50000','005');
INSERT INTO 순위 VALUES('GOLD','50000','006');
INSERT INTO 순위 VALUES('SILVER','30000','007');
INSERT INTO 순위 VALUES('SILVER','30000','008');
INSERT INTO 순위 VALUES('SILVER','30000','009');
INSERT INTO 순위 VALUES('GOLD','50000','010');
INSERT INTO 순위 VALUES('GOLD','50000','011');
INSERT INTO 순위 VALUES('GOLD','50000','012');
INSERT INTO 순위 VALUES('GOLD','50000','013');
INSERT INTO 순위 VALUES('GOLD','50000','014');

-- 우수회원 추가
INSERT INTO 우수회원 VALUES('SILVER','300000','3000','001');
INSERT INTO 우수회원 VALUES('GOLD','800000','8000','002');
INSERT INTO 우수회원 VALUES('SILVER','400000','4000','003');
INSERT INTO 우수회원 VALUES('SILVER','300000','3000','004');
INSERT INTO 우수회원 VALUES('SILVER','100000','1000','005');
INSERT INTO 우수회원 VALUES('SILVER','400000','4000','006');
INSERT INTO 우수회원 VALUES('SILVER','500000','5000','007');
INSERT INTO 우수회원 VALUES('SILVER','700000','7000','008');
INSERT INTO 우수회원 VALUES('SILVER','700000','7000','009');
INSERT INTO 우수회원 VALUES('SILVER','500000','5000','010');
INSERT INTO 우수회원 VALUES('SILVER','600000','6000','011');
INSERT INTO 우수회원 VALUES('SILVER','100000','1000','012');
INSERT INTO 우수회원 VALUES('SILVER','200000','2000','013');
INSERT INTO 우수회원 VALUES('SILVER','900000','9000','014');
INSERT INTO 우수회원 VALUES('SILVER','700000','7000','015');
INSERT INTO 우수회원 VALUES('SILVER','800000','8000','016');
INSERT INTO 우수회원 VALUES('SILVER','400000','4000','017');
INSERT INTO 우수회원 VALUES('SILVER','300000','3000','018');
INSERT INTO 우수회원 VALUES('SILVER','900000','9000','019');
INSERT INTO 우수회원 VALUES('SILVER','700000','7000','020');
INSERT INTO 우수회원 VALUES('SILVER','800000','8000','021');
INSERT INTO 우수회원 VALUES('SILVER','400000','4000','022');
INSERT INTO 우수회원 VALUES('SILVER','300000','3000','023');
INSERT INTO 우수회원 VALUES('SILVER','400000','4000','024');
INSERT INTO 우수회원 VALUES('SILVER','300000','3000','025');

-- 가입 추가
INSERT INTO 가입 VALUES('2021-10-08','3','001','토마토휘트니스');
INSERT INTO 가입 VALUES('2021-01-08','10','002','토마토휘트니스');
INSERT INTO 가입 VALUES('2021-10-28','4','003','토마토휘트니스');
INSERT INTO 가입 VALUES('2021-05-07','6','004','멋짐휘트니스');
INSERT INTO 가입 VALUES('2021-04-28','1','005','멋짐휘트니스');
INSERT INTO 가입 VALUES('2021-03-10','4','006','위드피트니스');
INSERT INTO 가입 VALUES('2021-02-08','5','007','위드피트니스');
INSERT INTO 가입 VALUES('2021-11-07','7','008','우리동네헬스장');
INSERT INTO 가입 VALUES('2021-05-07','7','009','우리동네헬스장');
INSERT INTO 가입 VALUES('2021-05-03','5','010','린바디휘트니스');
INSERT INTO 가입 VALUES('2021-04-28','6','011','린바디휘트니스');
INSERT INTO 가입 VALUES('2021-05-26','1','012','린바디휘트니스');
INSERT INTO 가입 VALUES('2021-07-08','2','013','림휘트니스');
INSERT INTO 가입 VALUES('2021-11-11','9','014','림휘트니스');
INSERT INTO 가입 VALUES('2021-10-10','7','015','림휘트니스');
INSERT INTO 가입 VALUES('2021-08-07','8','016','굿모닝휘트니스');
INSERT INTO 가입 VALUES('2021-10-03','4','017','굿모닝휘트니스');
INSERT INTO 가입 VALUES('2021-05-18','3','018','굿모닝휘트니스');
INSERT INTO 가입 VALUES('2021-03-03','3','019','굿바디휘트니스');
INSERT INTO 가입 VALUES('2021-01-25','6','020','굿바디휘트니스');
INSERT INTO 가입 VALUES('2021-12-01','1','021','리본휘트니스');
INSERT INTO 가입 VALUES('2021-10-28','2','022','리본휘트니스');
INSERT INTO 가입 VALUES('2021-11-14','2','023','리본휘트니스');
INSERT INTO 가입 VALUES('2021-12-25','5','024','내셔널팀휘트니스');
INSERT INTO 가입 VALUES('2021-09-30','6','025','내셔널팀휘트니스');

delete from 헬스장 where 가게명='내셔널팀휘트니스';
commit;
select * from 우수회원;


-- 대여 추가
INSERT INTO 대여 VALUES('2021-10-18','001','토마토휘트니스','001');
INSERT INTO 대여 VALUES('2021-10-18','001','토마토휘트니스','003');
INSERT INTO 대여 VALUES('2021-01-28','002','토마토휘트니스','002');
INSERT INTO 대여 VALUES('2021-05-27','004','멋짐휘트니스','001');
INSERT INTO 대여 VALUES('2021-02-20','007','위드피트니스','001');
INSERT INTO 대여 VALUES('2021-11-15','008','우리동네헬스장','002');
INSERT INTO 대여 VALUES('2021-02-23','010','린바디휘트니스','001');
INSERT INTO 대여 VALUES('2021-07-18','013','림휘트니스','001');
INSERT INTO 대여 VALUES('2021-08-18','016','굿모닝휘트니스','002');
INSERT INTO 대여 VALUES('2021-10-11','021','리본휘트니스','003');
INSERT INTO 대여 VALUES('2021-07-31','024','내셔널팀휘트니스','001');
INSERT INTO 대여 VALUES('2021-07-31','025','내셔널팀휘트니스','002');

select * from 구매;

select * from PT;

DELETE FROM 대여 WHERE 회원번호 = '012' AND 기구번호='002';

-- 구매 추가
INSERT INTO 구매 VALUES('2021-10-05','1','001','001','토마토휘트니스');
INSERT INTO 구매 VALUES('2021-01-15','2','001','002','토마토휘트니스');
INSERT INTO 구매 VALUES('2021-11-05','2','002','003','토마토휘트니스');
INSERT INTO 구매 VALUES('2021-05-10','3','001','005','멋짐휘트니스');
INSERT INTO 구매 VALUES('2021-03-30','1','002','006','위드피트니스');
INSERT INTO 구매 VALUES('2021-11-19','1','001','008','우리동네헬스장');
INSERT INTO 구매 VALUES('2021-03-01','2','003','010','린바디휘트니스');
INSERT INTO 구매 VALUES('2021-05-11','2','001','011','린바디휘트니스');
INSERT INTO 구매 VALUES('2021-07-31','1','002','013','림휘트니스');
INSERT INTO 구매 VALUES('2021-08-20','3','001','016','굿모닝휘트니스');
INSERT INTO 구매 VALUES('2021-06-25','1','003','017','굿모닝휘트니스');
INSERT INTO 구매 VALUES('2021-03-23','2','001','001','굿바디휘트니스');
INSERT INTO 구매 VALUES('2021-10-15','1','002','006','리본휘트니스');
INSERT INTO 구매 VALUES('2021-04-02','2','002','007','리본휘트니스');
INSERT INTO 구매 VALUES('2021-09-10','1','001','011','내셔널팀휘트니스');
INSERT INTO 구매 VALUES('2021-10-06','1','001','001','토마토휘트니스');

select * from 우수회원;
select * from 운동기구;
select * from 트레이너;
select * from 헬스장;
select * from 회원;



commit;


