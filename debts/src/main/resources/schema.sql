create sequence hibernate_sequence start with 1 increment by 1
create table DEBTS (id bigint not null, AMOUNT decimal(19,2), creationTimestamp timestamp, FIRST_USER_ID bigint, IS_FIRST_OWED boolean, SECOND_USER_ID bigint, primary key (id))
