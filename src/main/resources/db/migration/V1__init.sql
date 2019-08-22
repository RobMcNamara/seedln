drop view if exists activities;
drop view if exists tags;
drop view if exists tags_activities;

create table if not exists tags (
id bigserial primary key,
tag varchar(250) not null
--created_on date not null
);

create table if not exists activities (
id bigserial primary key,
title varchar(250) not null,
type varchar(250) not null,
estimated_time_in_minutes integer

--created_on date not null
);

create table if not exists tags_activities (
activities_id integer references activities(id),
tags_id integer references tags(id),
constraint id primary key (activities_id, tags_id)
);
