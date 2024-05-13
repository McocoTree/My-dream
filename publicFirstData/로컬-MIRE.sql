create table subject(
    no number not null,     --순차번호
    s_num varchar2(2) not null,  --학과번호
    s_name varchar2(24) not null  --
--primary key(no),
--unique(s_num)
);
ALTER TABLE subject ADD CONSTRAINT subject_pk PRIMARY KEY (no);
ALTER TABLE subject ADD CONSTRAINT subject_uk UNIQUE KEY (s_num);

create sequence subject_seq
    start with 1 
    increment by 1;
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'01','컴퓨터학과');
COMMIT;
SELECT*FROM subject order by no asc;