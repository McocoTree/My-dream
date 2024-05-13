create table subject(
    no number not null,
    s_num varchar2(2) not null,
    s_name varchar2(24) not null,
    primary key(no),
    unique(s_num)
);
--ALTER TABLE subject ADD CONSTRAINT subject_pk PRIMARY KEY (no);
--ALTER TABLE subject ADD CONSTRAINT subject_uk UNIQUE KEY (s_num);

create sequence subject_seq
    start with 1 
    increment by 1;
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'01','컴퓨터공학과');
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'02','교육학과');
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'03','신문방송학과');
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'04','인터넷비즈니스과');
insert into subject(no, s_num, s_name) values(SUBJECT_SEQ.NEXTVAL,'05','기술경영과');
COMMIT;
SELECT*FROM subject order by no;



create table student(
    no number not null,
    sd_num varchar2(8) not null,     --학번
    sd_name varchar2(12) not null,   --이름
    sd_id varchar2(12) not null,     --아이디
    sd_passwd varchar2(12) not null, --비밀번호
    s_num varchar2(2) not null,      --학과번호
    sd_birthday varchar2(8) not null,--생년월일
    sd_phone varchar2(15) not null,  --핸드폰번호
    sd_address varchar2(80) not null,--주소
    sd_email varchar2(40) not null,  --이메일
    sd_date date default sysdate     --등록일자
    --primary key(no),
    --unique(sd_num),
    --unique(sd_id),
    --foreign key(s_num) references subject(s_num)
);
ALTER TABLE student ADD CONSTRAINT student_pk PRIMARY KEY (no);
ALTER TABLE student ADD CONSTRAINT student_uk UNIQUE KEY (sd_num);
ALTER TABLE student ADD CONSTRAINT student_uk UNIQUE KEY (sd_id);
ALTER TABLE student ADD CONSTRAINT student_fk FOREIGN KEY (s_num) REFERENCES subject(s_num);
ALTER TRIGGER UNIVERSITY.GENERATE_STUDENT_NUM ENABLE;

create sequence student_seq
    start with 1
    increment by 1;
insert into student values(STUDENT_SEQ.NEXTVAL,'21010001 ','김정수','Javajsp1111','1111','05','010101''010-1111-1111','서울시 서대문구 창전동','11@11.com');
insert into student values(STUDENT_SEQ.NEXTVAL,'21020001 ','김수현','Javajsp2222','2222','01','020202''010-2222-2222','서울시 서초구 양재동','22@22.com');
insert into student values(STUDENT_SEQ.NEXTVAL,'21030001 ','공화춘','Javajsp3333','3333','02','030303''010-3333-3333','부산시 해운대구 반송동','33@33.com');
insert into student values(STUDENT_SEQ.NEXTVAL,'21040001 ','조류독감','Javajsp4444','4444','03','040404''010-4444-4444','대전시 중구 은행동','44@44.com');
insert into student values(STUDENT_SEQ.NEXTVAL,'21050001 ','유정란','Javajsp5555','5555','04','050505''010-5555-5555','경기도 수원시 장안구 이목동','55@55.com');
insert into student values(STUDENT_SEQ.NEXTVAL,'21060001 ','안중근','Javajsp6666','6666','05','060606''010-6666-6666','서울시 성동구 왕십리로','66@66.com');
COMMIT;
update student set sd_passwd='1234', sd_phone='0102', sd_address='st.heaven',sd_email='77@77.com' where sd_num='21070001';

create table lesson(
no number not null,
l_abbre varchar2(2) not null,
l_name varchar2(20) not null
--primary key(no),
--unique(l_abbre)
);
ALTER TABLE lesson ADD CONSTRAINT lesson_pk PRIMARY KEY (no);
ALTER TABLE lesson ADD CONSTRAINT lesson_uk UNIQUE KEY (l_abbre);

create sequence lesson_seq
start with 1 
increment by 1;

insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'K','국어' );
insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'M','수학' );
insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'E','영어' );
insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'H','역사' );
insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'P','프로그래밍' );
insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'D','데이터베이스' );
insert into lesson ' + "(no, l_abbre, l_name)" + " values" + "(lesson_seq.nextval,'ED','교육학이론' );
select * from lesson order by no;

create table trainee(
no number not null,
sd_num varchar2(8) not null,
l_abbre varchar2(2) not null,
t_section varchar2(20) not null,
t_date date default sysdate,
primary key(no),
foreign key(sd_num) references student(sd_num),
foreign key(l_abbre) references lesson(l_abbre)
);
ALTER TABLE trainee ADD CONSTRAINT trainee_pk PRIMARY KEY (no);
ALTER TABLE trainee ADD CONSTRAINT trainee_fk FOREIGN KEY (sd_num) REFERENCES student(sd_num);
ALTER TABLE trainee ADD CONSTRAINT trainee_fk FOREIGN KEY (l_abbre) REFERENCES lesson(l_abbre);



create sequence trainee_seq
start with 1 
increment by 1;

select tr.no as no, tr.sd_num as sd_num, tr.l_abbre as l_abbre, le.l_name as l_name, st.sd_name as sd_name, t_section, t_date "
				+ " from trainee tr, lesson le , student st "
				+ " where tr.sd_num = '21010001' and tr.l_abbre = le.l_abbre and tr.sd_num = st.sd_num order by t_date;



delete from trainee where no = ?
insert into trainee " + "(no, sd_num, l_abbre, t_section, t_date)" + " values "
				+ "(trainee_seq.nextval, ?, ?, ?, sysdate);
select l_abbre from lesson where l_name = ?