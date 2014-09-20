# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table alternativa (
  id_alternativa            bigint auto_increment not null,
  alternativa               varchar(255),
  alter_correta             tinyint(1) default 0,
  questao_id_questao        bigint,
  constraint pk_alternativa primary key (id_alternativa))
;

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
  professor_id_prof         bigint,
  prova_id_prova            bigint,
  constraint pk_disciplina primary key (id_disciplina))
;

create table professor (
  id_prof                   bigint auto_increment not null,
  nome                      varchar(255),
  cpf                       bigint,
  email                     varchar(255),
  constraint pk_professor primary key (id_prof))
;

create table prova (
  id_prova                  bigint auto_increment not null,
  turma_id_turma            bigint,
  constraint pk_prova primary key (id_prova))
;

create table questao (
  id_questao                bigint auto_increment not null,
  enunciado                 varchar(255),
  disciplina_id_disciplina  bigint,
  constraint pk_questao primary key (id_questao))
;

create table turma (
  id_turma                  bigint auto_increment not null,
  descricao_turma           varchar(255),
  qtd_questao_turma         integer,
  carga_horaria             integer,
  id_curso                  bigint,
  curso_id_curso            bigint,
  constraint pk_turma primary key (id_turma))
;

alter table alternativa add constraint fk_alternativa_questao_1 foreign key (questao_id_questao) references questao (id_questao) on delete restrict on update restrict;
create index ix_alternativa_questao_1 on alternativa (questao_id_questao);
alter table disciplina add constraint fk_disciplina_professor_2 foreign key (professor_id_prof) references professor (id_prof) on delete restrict on update restrict;
create index ix_disciplina_professor_2 on disciplina (professor_id_prof);
alter table disciplina add constraint fk_disciplina_prova_3 foreign key (prova_id_prova) references prova (id_prova) on delete restrict on update restrict;
create index ix_disciplina_prova_3 on disciplina (prova_id_prova);
alter table prova add constraint fk_prova_turma_4 foreign key (turma_id_turma) references turma (id_turma) on delete restrict on update restrict;
create index ix_prova_turma_4 on prova (turma_id_turma);
alter table questao add constraint fk_questao_disciplina_5 foreign key (disciplina_id_disciplina) references disciplina (id_disciplina) on delete restrict on update restrict;
create index ix_questao_disciplina_5 on questao (disciplina_id_disciplina);
alter table turma add constraint fk_turma_curso_6 foreign key (curso_id_curso) references curso (id_curso) on delete restrict on update restrict;
create index ix_turma_curso_6 on turma (curso_id_curso);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table alternativa;

drop table curso;

drop table disciplina;

drop table professor;

drop table prova;

drop table questao;

drop table turma;

SET FOREIGN_KEY_CHECKS=1;

