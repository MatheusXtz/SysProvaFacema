# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table alternativa (
  id_alternativa            bigint auto_increment not null,
  alter01                   varchar(255) not null,
  alter02                   varchar(255) not null,
  alter03                   varchar(255) not null,
  alter04                   varchar(255) not null,
  alter05                   varchar(255) not null,
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
  descricao_disciplina      varchar(255),
  qtd_questao_disciplina    integer,
  carga_horaria             integer,
  professor_id_prof         bigint,
  constraint pk_disciplina primary key (id_disciplina))
;

create table professor (
  id_prof                   bigint auto_increment not null,
  nome                      varchar(255),
  cpf                       integer not null,
  email                     varchar(255),
  matricula                 integer not null,
  senha                     varchar(255) not null,
  constraint pk_professor primary key (id_prof))
;

create table prova (
  id_prova                  bigint auto_increment not null,
  turma_id_turma            bigint,
  data_prova                datetime,
  constraint pk_prova primary key (id_prova))
;

create table questao (
  id_questao                bigint auto_increment not null,
  enunciado                 varchar(255),
  alter_correta             varchar(255),
  disciplina_id_disciplina  bigint,
  constraint pk_questao primary key (id_questao))
;

create table questoes_prova (
  provas_id_prova           bigint,
  questoes_id_questao       bigint)
;

create table status_prova (
  id_status_prova           bigint auto_increment not null,
  descricao                 varchar(255),
  local                     varchar(255),
  data                      datetime,
  prova_id_prova            bigint,
  constraint pk_status_prova primary key (id_status_prova))
;

create table turma (
  id_turma                  bigint auto_increment not null,
  descricao_turma           varchar(255),
  qtd_questao_turma         integer,
  curso_id_curso            bigint,
  constraint pk_turma primary key (id_turma))
;

create table usuario (
  id_usuario                bigint auto_increment not null,
  matricula                 integer not null,
  senha                     varchar(255) not null,
  constraint pk_usuario primary key (id_usuario))
;

alter table alternativa add constraint fk_alternativa_questao_1 foreign key (questao_id_questao) references questao (id_questao) on delete restrict on update restrict;
create index ix_alternativa_questao_1 on alternativa (questao_id_questao);
alter table disciplina add constraint fk_disciplina_professor_2 foreign key (professor_id_prof) references professor (id_prof) on delete restrict on update restrict;
create index ix_disciplina_professor_2 on disciplina (professor_id_prof);
alter table prova add constraint fk_prova_turma_3 foreign key (turma_id_turma) references turma (id_turma) on delete restrict on update restrict;
create index ix_prova_turma_3 on prova (turma_id_turma);
alter table questao add constraint fk_questao_disciplina_4 foreign key (disciplina_id_disciplina) references disciplina (id_disciplina) on delete restrict on update restrict;
create index ix_questao_disciplina_4 on questao (disciplina_id_disciplina);
alter table questoes_prova add constraint fk_questoes_prova_provas_5 foreign key (provas_id_prova) references prova (id_prova) on delete restrict on update restrict;
create index ix_questoes_prova_provas_5 on questoes_prova (provas_id_prova);
alter table questoes_prova add constraint fk_questoes_prova_questoes_6 foreign key (questoes_id_questao) references questao (id_questao) on delete restrict on update restrict;
create index ix_questoes_prova_questoes_6 on questoes_prova (questoes_id_questao);
alter table status_prova add constraint fk_status_prova_prova_7 foreign key (prova_id_prova) references prova (id_prova) on delete restrict on update restrict;
create index ix_status_prova_prova_7 on status_prova (prova_id_prova);
alter table turma add constraint fk_turma_curso_8 foreign key (curso_id_curso) references curso (id_curso) on delete restrict on update restrict;
create index ix_turma_curso_8 on turma (curso_id_curso);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table alternativa;

drop table curso;

drop table disciplina;

drop table professor;

drop table prova;

drop table questao;

drop table questoes_prova;

drop table status_prova;

drop table turma;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

