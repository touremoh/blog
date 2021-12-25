create schema if not exists tourem;

set schema 'tourem';

create table if not exists author
(
  id         varchar(36) not null,
  first_name varchar(50) not null,
  last_name  varchar(50) not null,
  login      varchar(50) not null,
  password   varchar(50) not null,
  created_at timestamp,
  updated_at timestamp,
  deleted_at timestamp,
  constraint pk_author
    primary key (id)
);
create index if not exists idx_author on author (id, first_name, last_name);

create table if not exists user_role
(
  id         varchar(36) not null,
  name       varchar(50) not null,
  created_at timestamp,
  updated_at timestamp,
  deleted_at timestamp,
  constraint pk_user_role
    primary key (id)
);
create index if not exists idx_user_role on user_role (id, name);

create table if not exists author_user_role
(
  user_role_id varchar(36) not null,
  author_id    varchar(36) not null,
  constraint pk_author_user_role
    primary key (user_role_id, author_id)
);

create table if not exists user_operation
(
  id             varchar(36) not null,
  operation_name varchar(50) not null,
  user_role_id   varchar(36),
  created_at     timestamp,
  updated_at     timestamp,
  deleted_at     timestamp,
  constraint pk_user_operation
    primary key (id)
);
create index if not exists idx_user_operation on user_operation (id, operation_name, user_role_id);


create table if not exists article
(
  id         varchar(36)  not null,
  title      varchar(250) not null,
  payload    text         not null,
  author_id  varchar(35),
  created_at timestamp,
  updated_at timestamp,
  deleted_at timestamp,
  constraint pk_article
    primary key (id)
);
create index if not exists idx_article on article (id, title, payload, author_id);

create table if not exists image_url
(
  id         varchar(36)   not null,
  url        varchar(1000) not null,
  created_at timestamp,
  updated_at timestamp,
  deleted_at timestamp,
  constraint pk_image_url
    primary key (id)
);
create index if not exists idx_image_url on image_url (id, url);

alter table author_user_role
  add foreign key (author_id)
    references author;
alter table author_user_role
  add foreign key (user_role_id)
    references user_role;
alter table author_user_role
  add foreign key (author_id)
    references author;
alter table user_operation
  add foreign key (user_role_id)
    references user_role;
alter table article
  add foreign key (author_id)
    references author;
alter table author
  add constraint unique_author_login unique (login);
alter table author
  add constraint unique_author_passwd unique (password);