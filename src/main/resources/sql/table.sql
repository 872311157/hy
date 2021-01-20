CREATE TABLE hyuser(
	id serial PRIMARY KEY not null,
	username VARCHAR,
	passwords VARCHAR,
	sex VARCHAR,
	age INTEGER,
	workno VARCHAR,
	email VARCHAR
);
select * from hyuser;
insert into hyuser(id, username, passwords, sex, age, workno) values(0, 'system', 'system', '男', 23, '');

CREATE TABLE hycalendar(
	id serial PRIMARY KEY not null,
	workyear INTEGER,
	workmonth INTEGER,
	workday INTEGER,
	workweek INTEGER,--星期几
	workdate TIMESTAMP,
	holiday VARCHAR,--节假日
	workstatus INTEGER--0工作日，1节假日，2周末
);
select * from hycalendar where workyear=2020 and workmonth=10 order by workdate asc
delete from hycalendar;
insert into calendar(workyear, workmonth, workday, workweek, workdate, holiday, workstatus) values()

--数据类型代码表
drop table hycodetable
CREATE TABLE hycodetable(
  id serial PRIMARY KEY not null,
  ctype character varying(64), -- 类型
  ccode integer, -- 数据
  cvalue character varying(64), -- 值
);
select * from hycodetable;
insert into hycodetable(ctype, ccode, cvalue) values('iswhether', 0, '是');
insert into hycodetable(ctype, ccode, cvalue) values('iswhether', 1, '否');
insert into hycodetable(ctype, ccode, cvalue) values('roletype', 0, '超级系统管理员');
insert into hycodetable(ctype, ccode, cvalue) values('moduletype', 0, '分类');
insert into hycodetable(ctype, ccode, cvalue) values('moduletype', 1, '引用');

--默认数据代码表
drop table hysystem;
CREATE TABLE hysystem(
    id serial PRIMARY KEY not null,
    systype VARCHAR(128) UNIQUE, -- 默认数据名称
    sysvalue VARCHAR(256) -- 默认数据值
);
select * from hysystem;
insert into hysystem(systype, sysvalue) values('server', 'http://127.0.0.1:8090/hy/');

--角色表
drop table hyrole;
CREATE TABLE hyrole(
    id serial PRIMARY KEY not null,
    rolename VARCHAR(128), -- 角色名称
    roletype INTEGER -- 角色类型
);
select * from hyrole;
insert into hyrole(id, rolename, roletype) values(0, '系统管理员', 0);

--模型表
drop table hymodule;
CREATE TABLE hymodule(
    id serial PRIMARY KEY not null,
    mname VARCHAR(128), --模型名称
    maddress VARCHAR(512), --模型地址
    parentid INTEGER, --父模型id
    mtype INTEGER --模型类型0分类，1引用
);
--ALTER TABLE bootmodule ADD mtype INTEGER; --模型类型0分类，1引用
select * from hymodule;
--delete from hymodule
insert into hymodule(id, mname, maddress, parentid, mtype) values(1, '系统管理', '', 0, 0);
INSERT INTO hymodule(id, mname, maddress, parentid, mtype) VALUES(2, '模块管理', 'hymodule', 1, 1);
INSERT INTO hymodule(id, mname, maddress, parentid, mtype) VALUES(3, '角色管理', 'hyrole', 1, 1);
INSERT INTO hymodule(id, mname, maddress, parentid, mtype) VALUES(4, '系统管理', 'hysystem', 1, 1);
INSERT INTO hymodule(id, mname, maddress, parentid, mtype) VALUES(5, '用户管理', 'hyuser', 1, 1);

--用户角色关联表
CREATE TABLE hy_roleuser(
    id serial PRIMARY KEY not null,
    roleid INTEGER, -- 角色id
    userid INTEGER -- 用户id
);
insert into hy_roleuser(roleid, userid) values(0, 0);
select * from hy_roleuser;

--角色模型关联表
CREATE TABLE hy_rolemodule(
    id serial PRIMARY KEY not null,
    roleid INTEGER, -- 角色id
    moduleid INTEGER -- 模型id
);
insert into hy_rolemodule(roleid, moduleid) values(0, 1)


--创建用户模型关联视图
--drop view view_rolemodules;

create or replace VIEW view_rolemodules AS
select rm.roleid, rm.moduleid, m.mname, m.parentid, m.mtype from hyrole r
left join hy_rolemodule rm on r.id = rm.roleid
left join hymodule m on rm.moduleid = m.id where m.mtype=0 and parentid=0;

select * from view_rolemodules;



--postgresql递归查询
WITH RECURSIVE r AS (
   SELECT * FROM bootmodule WHERE id = 1
   union ALL
   SELECT bootmodule.* FROM bootmodule, r WHERE bootmodule.parentid = r.id
)
SELECT * FROM r ORDER BY id asc;