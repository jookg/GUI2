insert into Board(article_seq,id,title,content,hitcount,regdate)values(article_seq.nextval,'joo','헬로','망난아',0,SYSDATE);
select DISTINCT id from board where content like '%피어나는%';
--****************
-- 2017.08.02
-- [1]MAJOR_TAB
-- [2]SUBJECT_TAB
-- [3]MEMBER_TAB
-- [4]PROF_TAB
-- [5]STUDENT_TAB
-- [6]GRADE_TAB
-- [7]BOARD_TAB
--****************

--****************
-- [1]MAJOR_TAB
-- 2017.08.02
-- major_id,title
--****************
--DDL
create table major(
major_id varchar2(10),
title varchar2(10),

primary key(major_id)
)
alter table major add subj_id varchar2(10);

--DML
select * from MAJOR;
insert into major(major_id,title)values('','미술');
--****************
-- [2]SUBJECT_TAB
-- 2017.08.02
-- subj_id,title,major_id
--****************
--DDL
create table subject(
subj_id varchar2(10),
title varchar2(10),
major_id varchar2(10),
primary key(subj_id),foreign key (major_id) references major(major_id) on delete cascade
)
--DML
insert into subject(subj_id,title)values('html','html');
update subject set subj_id='sql', title='sql' where subj_id='mysql'
--****************
-- [3]MEMBER_TAB
-- 2017.08.02
-- id,pw,name,ssn,regdate,phone,email,major_id,profile,
--****************
--DDL
create table Member(
	id varchar2(10),
	pw varchar2(10),
	name varchar2(20),
	ssn varchar2(15),
	regdate date,
	primary key(id),foreign key (major_id) references major(major_id) on delete cascade
);
alter table member add major_id varchar2(10);
alter table member add constraint member_fk_major
foreign key(major_id) references major(major_id);
--DML
update member set profile='js.jpg' where id='joo';
select * from member;
delete from member where id='xvcvcvx';
--****************
-- [4]PROF_TAB
-- 2017.08.02
-- id, salary
--****************
--DDL
create table Prof(
id varchar2(10),
salary varchar2(10),
primary key(id),foreign key(id) references member(id) on delete cascade
);
--****************
-- [5]STUDENT_TAB
-- 2017.08.02
-- id,stu_no
--****************
--DDL
create table Student(
id varchar2(10),
stu_no varchar2(8),
primary key(id),foreign key(id) references member(id)
);
--****************
-- [6]GRADE_TAB
-- 2017.08.02
-- grade_seq_score_exam_date,subj_id
--****************
--DDL
create table grade(
grade_seq varchar2(10),
score varchar2(10),
exam_date varchar2(10),
subj_id varchar2(10),
primary key(grade_seq),foreign key(subj_id) references subject(subj_id) on delete cascade
)
alter table grade add id varchar2(10);
alter table grade add constraint grade_fk_member
foreign key(id) references member(id);
--DML
--member_id를 입력하면 평균점수를 반환하는 sql
--****************
-- [7]BOARD_TAB
-- 2017.08.02
-- article_seq,id,title,content,hitcount,regdate
--****************
--DDL
create table Board(
article_seq NUMBER,
id varchar2(10),
title varchar2(20),
content varchar2(100),
hitcount NUMBER,
regdate date,
primary key(article_seq),foreign key (id) REFERENCES member(id) on delete cascade
);
--DML
insert into Board(article_seq,id,title,content,hitcount,regdate)values(seq.nextval,'joo','헬로','망난아',0,SYSDATE);

--*******************

create SEQUENCE seq
START with 2000
INCREMENT BY 1
NOCACHE
NOCYCLE;
--*******************
select * from tab;

select DISTINCT ssn,name from member m, board b
where m.id=b.id and rownum <=5
order by ssn,name;



select * from grade;
select * from student;
select * from MAJOR;
select * from MEMBER;
select * from prof;
select * from SUBJECT;
select * from student s, member m where s.ID = m.ID;
insert into prof(id,salary)values('ccc','5000');
insert into student(id,stu_no)values('ggg','20117123');

update prof set salary='4000' where id='aaa';

insert into grade(grade_seq,score,exam_date,subj_id,id)values(seq.nextval,'77','2017-06','C','abc');

--delete student where id='aka';
select avg(score) from(select distinct m.ID as id, m.NAME, mj.TITLE as major, g.SCORE,sj.TITLE as 과목명, g.EXAM_DATE as ed from member m,STUDENT s, grade g, subject sj,major mj
where m.ID = s.ID and m.ID = g.ID and sj.MAJOR_ID = mj.MAJOR_ID and sj.SUBJ_ID = g.SUBJ_ID) t where t.id='aka'
order by id,ed;

select avg(score) from(select m.ID as id, m.NAME, g.SCORE, g.EXAM_DATE as ed from grade g
join subject s on g.SUBJ_ID = s.SUBJ_ID
join member m on m.ID = g.ID) t
where t.id='aka';

select * from member m
join board b on m.ID = b.ID
where m.name='aa';

select ename from emp e1 where e1.sal > (select avg(e2.sal) from emp e2 where e1.deptno=e2.deptno);
commit;


insert all
when grade like 4 then
into grade_four values(stuno, grade)
when grade like 3 then
into grade_thr values(stuno, grade)
when grade like 2 then
into grade_two values(stuno, grade)
when grade like 1 then
into grade_one values(stuno, grade)
select stuno,grade
from stud
where grade <5;

update professor set (sal,comm)=(select sal,comm from professor where name like '엘리자베스') where name like '김유신';

create view student (no,id,pw,name,ssn,regdate,phone,email,title)
as
select rownum no,s.* from(
select m.id, pw,name,rpad(substr(ssn,1,6),14,'*') ssn,to_char(regdate,'YYYY-MM-DD') 
regdate,phone,email,nvl(listagg(s.title,',')within group(order by s.title),'미정') title from member m left join major j on m.ID = j.ID left join subject s on s.SUBJ_ID = j.SUBJ_ID
group by m.id, pw, name, ssn ,regdate, phone, email order by regdate) s;

select listagg(SUBJ_ID,',')within group (order by subj_id) from major;
select * from student;

select * from
(select * from student where no <= greatest(((select count(*) from student)-5),0))
where rownum <6;

select * from(select rownum rnum, s.* from student s ) where rnum between 6 and 10;
