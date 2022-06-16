CREATE TABLE MEMBER
(
	id number NOT NULL PRIMARY key,
	name varchar(255)
);

CREATE SEQUENCE vibes.member_seq INCREMENT BY 1 START  WITH 1;

;
SELECT * FROM MEMBER
;

INSERT INTO MEMBER (id, name) VALUES (member_seq.nextval,'test1');