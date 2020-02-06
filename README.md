# ������ ��Ʈ ��α� �����

## 1. ���� ȯ��
* Springboot
* MyBatis
* MySQL
* JSP
* Spring Security
* Lombok

## 2. �䱸����(���)
* ȸ������
* �α���
* ����� ��������(����) ���ε�
* �Խñ� ���
* �Խñ� ����
* �Խñ� ����
* �Խñ� ���
* �Խñ� �󼼺���
* �Խñ� ����¡
* �Խñ� �˻�
* �Խñ� ���� ����
* ��� ���
* ��� ����

## 3. ���̺�
```sql
create user 'spring'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
create database spring;
use spring;
```

```sql
CREATE TABLE user(
	id int auto_increment primary key,
    username varchar(100) not null,
    password varchar(100) not null,
    email varchar(100),
    profile varchar(200),
    createDate timestamp
) engine=InnoDB default charset=utf8;
```

```sql
CREATE TABLE post(
	id int auto_increment primary key,
    title varchar(100) not null,
    content longtext,
    userId int,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null
) engine=InnoDB default charset=utf8;
```

```sql
CREATE TABLE comment(
	id int auto_increment primary key,
    userId int,
    postId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null,
    foreign key (postId) references post (id) on delete cascade
) engine=InnoDB default charset=utf8;
```