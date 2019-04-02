create table LoginGroup (id bigint not null, groupname varchar(64) not null, primary key (id)) engine=InnoDB;
create table LoginUser (id bigint not null, password varchar(255) not null, username varchar(64) not null, primary key (id)) engine=InnoDB;
create table LoginUserGroup (userid bigint not null, groupid bigint not null) engine=InnoDB;
alter table LoginGroup add constraint UK_b5xt7ls806mdksklqe93pk0h unique (groupname);
alter table LoginUser add constraint UK_lqn8xkd86ctyv2rbtr8inoul3 unique (username);
alter table LoginUserGroup add constraint FKnherul6o3mqawy2s21e5jn2uf foreign key (groupid) references LoginGroup (id);
alter table LoginUserGroup add constraint FK1yx1e7rd0iptfqosrb3qpuqao foreign key (userid) references LoginUser (id);
