# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table curso (
  id_curso                  bigint auto_increment not null,
  nome                      varchar(255),
  constraint pk_curso primary key (id_curso))
;

create table disciplina (
  id_disciplina             bigint auto_increment not null,
  descicao_disciplina       varchar(255),
  qtd_questao_disciplina    integer,
  carga_horaria             integer,
  constraint pk_disciplina primary key (id_disciplina))
;

create table professor (
  id_prof                   bigint auto_increment not null,
  nome                      varchar(255),
  cpf                       integer,
  email                     varchar(255),
  constraint pk_professor primary key (id_prof))
;

create table questao (
  id_questao                bigint auto_increment not null,
  enunciado                 varchar(255),
  alternativa_correta       varchar(255),
  constraint pk_questao primary key (id_questao))
;

create table turma (
  id_turma                  bigint auto_increment not null,
  descricao_turma           varchar(255),
  qtd_questao_turma         integer,
  constraint pk_turma primary key (id_turma))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table curso;

drop table disciplina;

drop table professor;

drop table questao;

drop table turma;

SET FOREIGN_KEY_CHECKS=1;

