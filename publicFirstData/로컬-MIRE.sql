create table subject(
    no number not null,     --������ȣ
    s_num varchar2(2) not null,  --�а���ȣ
    s_name varchar2(24) not null  --
--primary key(no),
--unique(s_num)
);
ALTER TABLE subject ADD CONSTRAINT subject_pk PRIMARY KEY (no);
ALTER TABLE subject ADD CONSTRAINT subject_uk UNIQUE KEY (s_num);

create sequence subject_seq
    start with 1 
    increment by 1;
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'01','��ǻ���а�');
COMMIT;
SELECT*FROM subject order by no asc;