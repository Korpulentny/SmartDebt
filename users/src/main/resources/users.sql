create table user (id bigint generated by default as identity, password_hash varchar(255), username varchar(255), primary key (id))
create table user_debtors (user_entity_id bigint not null, debtors_id bigint not null)
alter table user_debtors add constraint UK_l1ts69k1fusrtvrvuub1fflnr unique (debtors_id)
alter table user_debtors add constraint FKex3u7qvg01qe99phfgial2ep8 foreign key (debtors_id) references user
alter table user_debtors add constraint FKhuie9cxni3bfjt6pv7vy4r1ea foreign key (user_entity_id) references user
create table user (id bigint generated by default as identity, password_hash varchar(255), username varchar(255), primary key (id))
create table user_debtors (user_entity_id bigint not null, debtors_id bigint not null)
alter table user_debtors add constraint UK_l1ts69k1fusrtvrvuub1fflnr unique (debtors_id)
alter table user_debtors add constraint FKex3u7qvg01qe99phfgial2ep8 foreign key (debtors_id) references user
alter table user_debtors add constraint FKhuie9cxni3bfjt6pv7vy4r1ea foreign key (user_entity_id) references user
create table user (id bigint generated by default as identity, password_hash varchar(255), username varchar(255), primary key (id))
create table user_debtors (user_entity_id bigint not null, debtors_id bigint not null)
alter table user_debtors add constraint UK_l1ts69k1fusrtvrvuub1fflnr unique (debtors_id)
alter table user_debtors add constraint FKex3u7qvg01qe99phfgial2ep8 foreign key (debtors_id) references user
alter table user_debtors add constraint FKhuie9cxni3bfjt6pv7vy4r1ea foreign key (user_entity_id) references user
create table user (id bigint generated by default as identity, password_hash varchar(255), username varchar(255), primary key (id))
create table user_debtors (user_entity_id bigint not null, debtors_id bigint not null)
alter table user_debtors add constraint UK_l1ts69k1fusrtvrvuub1fflnr unique (debtors_id)
alter table user_debtors add constraint FKex3u7qvg01qe99phfgial2ep8 foreign key (debtors_id) references user
alter table user_debtors add constraint FKhuie9cxni3bfjt6pv7vy4r1ea foreign key (user_entity_id) references user
create table user (id bigint generated by default as identity, password_hash varchar(255), username varchar(255), primary key (id))
create table user_debtors (user_entity_id bigint not null, debtors_id bigint not null)
alter table user_debtors add constraint UK_l1ts69k1fusrtvrvuub1fflnr unique (debtors_id)
alter table user_debtors add constraint FKex3u7qvg01qe99phfgial2ep8 foreign key (debtors_id) references user
alter table user_debtors add constraint FKhuie9cxni3bfjt6pv7vy4r1ea foreign key (user_entity_id) references user