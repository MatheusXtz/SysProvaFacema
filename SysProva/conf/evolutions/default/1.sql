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

create table colecao_status (
  id_colecao_s              bigint auto_increment not null,
  constraint pk_colecao_status primary key (id_colecao_s))
;

create table curso (
  id_curso                  bigint auto_increment not null,
  nome                      varchar(255),
  matutino                  tinyint,
  vespertino                tinyint,
  noturno                   tinyint,
  constraint pk_curso primary key (id_curso))
;

create table disciplina (
  id_disciplina             bigint auto_increment not null,
  nome                      varchar(255),
  qtd_questao               integer,
  carga_horaria             integer,
  professor_id_prof         bigint,
  turma_id_turma            bigint,
  constraint pk_disciplina primary key (id_disciplina))
;

create table observacao (
  id_obs                    bigint auto_increment not null,
  descricao                 varchar(255),
  questao_id_questao        bigint,
  avaliador                 varchar(255),
  questao_ok                tinyint(1) default 0,
  constraint pk_observacao primary key (id_obs))
;

create table professor (
  id_prof                   bigint auto_increment not null,
  nome                      varchar(255),
  cpf                       integer not null,
  tipo_profe                varchar(255),
  email                     varchar(255),
  matricula                 integer not null,
  curso_id_curso            bigint,
  constraint pk_professor primary key (id_prof))
;

create table prova (
  id_prova                  bigint auto_increment not null,
  turma_id_turma            bigint,
  data_inicial              varchar(255),
  data_final                varchar(255),
  constraint pk_prova primary key (id_prova))
;

create table questao (
  id_questao                bigint auto_increment not null,
  enunciado                 varchar(255),
  disciplina_id_disciplina  bigint,
  prova_id_prova            bigint,
  periodo                   varchar(255),
  aval_coord                tinyint(1) default 0,
  aval_nucleo               tinyint(1) default 0,
  constraint pk_questao primary key (id_questao))
;

create table search_disc_prof (
  id_search                 bigint auto_increment not null,
  disciplina_id_disciplina  bigint,
  professor_id_prof         bigint,
  periodo                   varchar(255),
  constraint pk_search_disc_prof primary key (id_search))
;

create table status (
  id_status                 bigint auto_increment not null,
  descricao                 varchar(255),
  data                      varchar(255),
  usuario_id_usuario        bigint,
  questao_id_questao        bigint,
  constraint pk_status primary key (id_status))
;

create table turma (
  id_turma                  bigint auto_increment not null,
  nome                      varchar(255),
  qtd_questao               integer,
  curso_id_curso            bigint,
  constraint pk_turma primary key (id_turma))
;

create table usuario (
  id_usuario                bigint auto_increment not null,
  nome                      varchar(255),
  matricula                 integer not null,
  senha                     varchar(255) not null,
  constraint pk_usuario primary key (id_usuario))
;

alter table alternativa add constraint fk_alternativa_questao_1 foreign key (questao_id_questao) references questao (id_questao) on delete restrict on update restrict;
create index ix_alternativa_questao_1 on alternativa (questao_id_questao);
alter table disciplina add constraint fk_disciplina_professor_2 foreign key (professor_id_prof) references professor (id_prof) on delete restrict on update restrict;
create index ix_disciplina_professor_2 on disciplina (professor_id_prof);
alter table disciplina add constraint fk_disciplina_turma_3 foreign key (turma_id_turma) references turma (id_turma) on delete restrict on update restrict;
create index ix_disciplina_turma_3 on disciplina (turma_id_turma);
alter table observacao add constraint fk_observacao_questao_4 foreign key (questao_id_questao) references questao (id_questao) on delete restrict on update restrict;
create index ix_observacao_questao_4 on observacao (questao_id_questao);
alter table professor add constraint fk_professor_curso_5 foreign key (curso_id_curso) references curso (id_curso) on delete restrict on update restrict;
create index ix_professor_curso_5 on professor (curso_id_curso);
alter table prova add constraint fk_prova_turma_6 foreign key (turma_id_turma) references turma (id_turma) on delete restrict on update restrict;
create index ix_prova_turma_6 on prova (turma_id_turma);
alter table questao add constraint fk_questao_disciplina_7 foreign key (disciplina_id_disciplina) references disciplina (id_disciplina) on delete restrict on update restrict;
create index ix_questao_disciplina_7 on questao (disciplina_id_disciplina);
alter table questao add constraint fk_questao_prova_8 foreign key (prova_id_prova) references prova (id_prova) on delete restrict on update restrict;
create index ix_questao_prova_8 on questao (prova_id_prova);
alter table search_disc_prof add constraint fk_search_disc_prof_disciplina_9 foreign key (disciplina_id_disciplina) references disciplina (id_disciplina) on delete restrict on update restrict;
create index ix_search_disc_prof_disciplina_9 on search_disc_prof (disciplina_id_disciplina);
alter table search_disc_prof add constraint fk_search_disc_prof_professor_10 foreign key (professor_id_prof) references professor (id_prof) on delete restrict on update restrict;
create index ix_search_disc_prof_professor_10 on search_disc_prof (professor_id_prof);
alter table status add constraint fk_status_usuario_11 foreign key (usuario_id_usuario) references usuario (id_usuario) on delete restrict on update restrict;
create index ix_status_usuario_11 on status (usuario_id_usuario);
alter table status add constraint fk_status_questao_12 foreign key (questao_id_questao) references questao (id_questao) on delete restrict on update restrict;
create index ix_status_questao_12 on status (questao_id_questao);
alter table turma add constraint fk_turma_curso_13 foreign key (curso_id_curso) references curso (id_curso) on delete restrict on update restrict;
create index ix_turma_curso_13 on turma (curso_id_curso);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table alternativa;

drop table colecao_status;

drop table curso;

drop table disciplina;

drop table observacao;

drop table professor;

drop table prova;

drop table questao;

drop table search_disc_prof;

drop table status;

drop table turma;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

