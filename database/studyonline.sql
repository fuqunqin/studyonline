
/*==============================================================*/


alter table s_accreditation
   drop constraint FK_S_ACCRED_REF_18_S_QUALIF;

alter table s_admin
   drop constraint FK_S_ADMIN_REF_5_S_CERTIF;

alter table s_admin
   drop constraint FK_S_ADMIN_REF_6_S_SECURI;

alter table s_admin
   drop constraint FK_S_ADMIN_REF_7_S_STATUS;

alter table s_admin_menu
   drop constraint FK_S_ADMIN__REF_8_S_MENU;

alter table s_admin_menu
   drop constraint FK_S_ADMIN__REF_9_S_ADMIN;

alter table s_certificate_exam
   drop constraint FK_S_CERTIF_REF_19_S_QUALIF;

alter table s_frontier
   drop constraint FK_S_FRONTI_REF_15_S_SUBJEC;

alter table s_frontier
   drop constraint FK_S_FRONTI_REF_24_S_FRONTI;

alter table s_group_users
   drop constraint FK_S_GROUP__REF_23_S_INTERE;

alter table s_group_users
   drop constraint FK_S_GROUP__REF_24_S_USER;

alter table s_interest_group
   drop constraint FK_S_INTERE_REF_21_S_USER;

alter table s_interest_group
   drop constraint FK_S_INTERE_REF_22_S_STATUS;

alter table s_pubmed_tribe
   drop constraint FK_S_PUBMED_REF_15_S_PUBMED;

alter table s_share
   drop constraint FK_S_SHARE_REF_12_S_SHARE_;

alter table s_share
   drop constraint FK_S_SHARE_REF_13_S_SUBJEC;

alter table s_share
   drop constraint FK_S_SHARE_REF_14_S_USER;

alter table s_sutra_book
   drop constraint FK_S_SUTRA__REF_11_S_SUBJEC;

alter table s_test
   drop constraint FK_S_TEST_REF_20_S_QUALIF;

alter table s_user
   drop constraint FK_S_USER_REF_2_S_CERTIF;

alter table s_user
   drop constraint FK_S_USER_REF_3_S_STATUS;

alter table s_user
   drop constraint FK_S_USER_REF_4_S_SECURI;

alter table s_user_message
   drop constraint FK_S_USER_M_REF_25_S_USER;

alter table s_user_message
   drop constraint FK_S_USER_M_REF_26_S_ADMIN;

alter table s_win
   drop constraint FK_S_WIN_REF_24_S_SUBJEC;

drop table s_accreditation cascade constraints;

drop table s_admin cascade constraints;

drop table s_admin_menu cascade constraints;

drop table s_certificate cascade constraints;

drop table s_certificate_exam cascade constraints;

drop table s_english_study cascade constraints;

drop table s_exam_appreciate cascade constraints;

drop table s_frontier cascade constraints;

drop table s_frontier_type cascade constraints;

drop table s_group_users cascade constraints;

drop table s_interest_group cascade constraints;

drop table s_menu cascade constraints;

drop table s_online_listening cascade constraints;

drop table s_pubmed_tribe cascade constraints;

drop table s_pubmed_type cascade constraints;

drop table s_qualification_type cascade constraints;

drop table s_security cascade constraints;

drop table s_share cascade constraints;

drop table s_share_type cascade constraints;

drop table s_status cascade constraints;

drop table s_subject cascade constraints;

drop table s_sutra_book cascade constraints;

drop table s_test cascade constraints;

drop table s_user cascade constraints;

drop table s_user_message cascade constraints;

drop table s_win cascade constraints;

drop sequence s_accreditation_seq;

drop sequence s_admin_seq;

drop sequence s_certificate_seq;

drop sequence s_certificateexam_seq;

drop sequence s_englishstudy_seq;

drop sequence s_examappreciate_seq;

drop sequence s_frontier_seq;

drop sequence s_frontiertype_seq;

drop sequence s_interestgroup_seq;

drop sequence s_menu_seq;

drop sequence s_onlinelistening_seq;

drop sequence s_pubmedtribe_seq;

drop sequence s_pubmedtype_seq;

drop sequence s_qualificationtype_seq;

drop sequence s_security_seq;

drop sequence s_share_seq;

drop sequence s_sharetype_seq;

drop sequence s_status_seq;

drop sequence s_subject_seq;

drop sequence s_sutrabook_seq;

drop sequence s_test_seq;

drop sequence s_user_message_seq;

drop sequence s_user_seq;

drop sequence s_win_seq;

create sequence s_accreditation_seq;

create sequence s_admin_seq;

create sequence s_certificate_seq;

create sequence s_certificateexam_seq;

create sequence s_englishstudy_seq;

create sequence s_examappreciate_seq;

create sequence s_frontier_seq;

create sequence s_frontiertype_seq;

create sequence s_interestgroup_seq;

create sequence s_menu_seq;

create sequence s_onlinelistening_seq;

create sequence s_pubmedtribe_seq;

create sequence s_pubmedtype_seq;

create sequence s_qualificationtype_seq;

create sequence s_security_seq;

create sequence s_share_seq;

create sequence s_sharetype_seq;

create sequence s_status_seq;

create sequence s_subject_seq;

create sequence s_sutrabook_seq;

create sequence s_test_seq;

create sequence s_user_message_seq;

create sequence s_user_seq;

create sequence s_win_seq;

/*==============================================================*/
/* Table: s_accreditation                                       */
/*==============================================================*/
create table s_accreditation  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   content              CLOB,
   publish_date         DATE,
   qualification_id     INTEGER,
   constraint PK_S_ACCREDITATION primary key (id)
);

/*==============================================================*/
/* Table: s_admin                                               */
/*==============================================================*/
create table s_admin  (
   id                   INTEGER                         not null,
   login_name           VARCHAR2(200)                   not null,
   login_password       VARCHAR2(200)                   not null,
   certificate_id       INTEGER,
   certificate_number   VARCHAR2(200),
   security_id          INTEGER,
   security_answer      VARCHAR2(200),
   status_id            INTEGER,
   email                VARCHAR2(200),
   telephone            VARCHAR2(200),
   address              VARCHAR2(200),
   constraint PK_S_ADMIN primary key (id),
   constraint AK_KEY_2_S_ADMIN unique (login_name)
);

/*==============================================================*/
/* Table: s_admin_menu                                          */
/*==============================================================*/
create table s_admin_menu  (
   admin_id             INTEGER                         not null,
   menu_id              INTEGER                         not null,
   constraint PK_S_ADMIN_MENU primary key (admin_id, menu_id)
);

/*==============================================================*/
/* Table: s_certificate                                         */
/*==============================================================*/
create table s_certificate  (
   id                   INTEGER                         not null,
   description          VARCHAR2(200)                   not null,
   constraint PK_S_CERTIFICATE primary key (id),
   constraint AK_KEY_2_S_CERTIF unique (description)
);

/*==============================================================*/
/* Table: s_certificate_exam                                    */
/*==============================================================*/
create table s_certificate_exam  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   exam_date            DATE,
   user_book            VARCHAR2(1000),
   publish_date         DATE,
   qualification_id     INTEGER,
   constraint PK_S_CERTIFICATE_EXAM primary key (id)
);

/*==============================================================*/
/* Table: s_english_study                                       */
/*==============================================================*/
create table s_english_study  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   content              CLOB,
   publish_date         DATE,
   constraint PK_S_ENGLISH_STUDY primary key (id)
);

/*==============================================================*/
/* Table: s_exam_appreciate                                     */
/*==============================================================*/
create table s_exam_appreciate  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   content              CLOB,
   publish_date         DATE,
   constraint PK_S_EXAM_APPRECIATE primary key (id)
);

/*==============================================================*/
/* Table: s_frontier                                            */
/*==============================================================*/
create table s_frontier  (
   id                   INTEGER                         not null,
   subject_id           INTEGER,
   publish_date         DATE,
   title                VARCHAR2(200),
   content              CLOB,
   frontier_type_id     INTEGER,
   constraint PK_S_FRONTIER primary key (id)
);

/*==============================================================*/
/* Table: s_frontier_type                                       */
/*==============================================================*/
create table s_frontier_type  (
   id                   INTEGER                         not null,
   frontier_type        VARCHAR2(100),
   constraint PK_S_FRONTIER_TYPE primary key (id)
);

/*==============================================================*/
/* Table: s_group_users                                         */
/*==============================================================*/
create table s_group_users  (
   group_id             INTEGER                         not null,
   user_id              INTEGER                         not null,
   constraint PK_S_GROUP_USERS primary key (group_id, user_id)
);

/*==============================================================*/
/* Table: s_interest_group                                      */
/*==============================================================*/
create table s_interest_group  (
   id                   INTEGER                         not null,
   group_name           VARCHAR2(100),
   group_notice         VARCHAR2(500),
   user_id              INTEGER,
   status_id            INTEGER,
   group_date           TIMESTAMP,
   constraint PK_S_INTEREST_GROUP primary key (id)
);

/*==============================================================*/
/* Table: s_menu                                                */
/*==============================================================*/
create table s_menu  (
   id                   INTEGER                         not null,
   menu_name            VARCHAR2(200),
   url                  VARCHAR2(200),
   parent_id            INTEGER,
   constraint PK_S_MENU primary key (id)
);

/*==============================================================*/
/* Table: s_online_listening                                    */
/*==============================================================*/
create table s_online_listening  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   listen_url           VARCHAR2(100),
   publish_date         DATE,
   constraint PK_S_ONLINE_LISTENING primary key (id)
);

/*==============================================================*/
/* Table: s_pubmed_tribe                                        */
/*==============================================================*/
create table s_pubmed_tribe  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   content              CLOB,
   pubmed_type_id       INTEGER,
   publish_date         DATE,
   constraint PK_S_PUBMED_TRIBE primary key (id)
);

/*==============================================================*/
/* Table: s_pubmed_type                                         */
/*==============================================================*/
create table s_pubmed_type  (
   id                   INTEGER                         not null,
   type_name            VARCHAR2(100),
   constraint PK_S_PUBMED_TYPE primary key (id)
);

/*==============================================================*/
/* Table: s_qualification_type                                  */
/*==============================================================*/
create table s_qualification_type  (
   id                   INTEGER                         not null,
   type_name            VARCHAR2(100),
   constraint PK_S_QUALIFICATION_TYPE primary key (id)
);

/*==============================================================*/
/* Table: s_security                                            */
/*==============================================================*/
create table s_security  (
   id                   INTEGER                         not null,
   description          VARCHAR2(200)                   not null,
   constraint PK_S_SECURITY primary key (id),
   constraint AK_KEY_2_S_SECURI unique (description)
);

/*==============================================================*/
/* Table: s_share                                               */
/*==============================================================*/
create table s_share  (
   id                   INTEGER                         not null,
   share_url            VARCHAR2(1000),
   share_user_id        INTEGER,
   share_date           DATE,
   share_type_id        INTEGER,
   subject_id           INTEGER,
   share_name           VARCHAR2(100),
   constraint PK_S_SHARE primary key (id)
);

/*==============================================================*/
/* Table: s_share_type                                          */
/*==============================================================*/
create table s_share_type  (
   id                   INTEGER                         not null,
   type_name            VARCHAR2(100),
   constraint PK_S_SHARE_TYPE primary key (id)
);

/*==============================================================*/
/* Table: s_status                                              */
/*==============================================================*/
create table s_status  (
   id                   INTEGER                         not null,
   description          VARCHAR2(200)                   not null,
   constraint PK_S_STATUS primary key (id),
   constraint AK_KEY_2_S_STATUS unique (description)
);

/*==============================================================*/
/* Table: s_subject                                             */
/*==============================================================*/
create table s_subject  (
   id                   INTEGER                         not null,
   subject_name         VARCHAR2(100),
   constraint PK_S_SUBJECT primary key (id)
);

/*==============================================================*/
/* Table: s_sutra_book                                          */
/*==============================================================*/
create table s_sutra_book  (
   id                   INTEGER                         not null,
   book_name            VARCHAR2(100)                   not null,
   public_company       VARCHAR2(100),
   book_user_name       VARCHAR2(100),
   public_date          DATE,
   book_synopsis        VARCHAR2(4000),
   publish_date         DATE,
   subject_id           INTEGER,
   constraint PK_S_SUTRA_BOOK primary key (id)
);

/*==============================================================*/
/* Table: s_test                                                */
/*==============================================================*/
create table s_test  (
   id                   INTEGER                         not null,
   title                VARCHAR2(100),
   qualification_id     INTEGER,
   uploade_date         DATE,
   uploade_url          VARCHAR2(100),
   constraint PK_S_TEST primary key (id)
);

/*==============================================================*/
/* Table: s_user                                                */
/*==============================================================*/
create table s_user  (
   id                   INTEGER                         not null,
   login_name           VARCHAR2(200)                   not null,
   login_password       VARCHAR2(200)                   not null,
   status_id            INTEGER,
   email                VARCHAR2(200),
   certificate_id       INTEGER,
   certificate_number   VARCHAR2(200),
   security_id          INTEGER,
   security_answer      VARCHAR2(200),
   register_date        TIMESTAMP,
   constraint PK_S_USER primary key (id),
   constraint AK_KEY_2_S_USER unique (login_name)
);

/*==============================================================*/
/* Table: s_user_message                                        */
/*==============================================================*/
create table s_user_message  (
   id                   INTEGER                         not null,
   user_id              INTEGER,
   admin_id             INTEGER,
   publish_date         TIMESTAMP,
   delete_flag          VARCHAR2(4),
   message              VARCHAR2(2000),
   read_flag            VARCHAR2(4),
   constraint PK_S_USER_MESSAGE primary key (id)
);

/*==============================================================*/
/* Table: s_win                                                 */
/*==============================================================*/
create table s_win  (
   id                   INTEGER                         not null,
   win_name             VARCHAR2(50)                    not null,
   win_user_name        VARCHAR2(50),
   win_date             DATE,
   win_description      VARCHAR2(4000),
   publish_date         DATE,
   subject_id           INTEGER,
   constraint PK_S_WIN primary key (id)
);

alter table s_accreditation
   add constraint FK_S_ACCRED_REF_18_S_QUALIF foreign key (qualification_id)
      references s_qualification_type (id);

alter table s_admin
   add constraint FK_S_ADMIN_REF_5_S_CERTIF foreign key (certificate_id)
      references s_certificate (id);

alter table s_admin
   add constraint FK_S_ADMIN_REF_6_S_SECURI foreign key (security_id)
      references s_security (id);

alter table s_admin
   add constraint FK_S_ADMIN_REF_7_S_STATUS foreign key (status_id)
      references s_status (id);

alter table s_admin_menu
   add constraint FK_S_ADMIN__REF_8_S_MENU foreign key (menu_id)
      references s_menu (id);

alter table s_admin_menu
   add constraint FK_S_ADMIN__REF_9_S_ADMIN foreign key (admin_id)
      references s_admin (id);

alter table s_certificate_exam
   add constraint FK_S_CERTIF_REF_19_S_QUALIF foreign key (qualification_id)
      references s_qualification_type (id);

alter table s_frontier
   add constraint FK_S_FRONTI_REF_15_S_SUBJEC foreign key (subject_id)
      references s_subject (id);

alter table s_frontier
   add constraint FK_S_FRONTI_REF_24_S_FRONTI foreign key (frontier_type_id)
      references s_frontier_type (id);

alter table s_group_users
   add constraint FK_S_GROUP__REF_23_S_INTERE foreign key (group_id)
      references s_interest_group (id);

alter table s_group_users
   add constraint FK_S_GROUP__REF_24_S_USER foreign key (user_id)
      references s_user (id);

alter table s_interest_group
   add constraint FK_S_INTERE_REF_21_S_USER foreign key (user_id)
      references s_user (id);

alter table s_interest_group
   add constraint FK_S_INTERE_REF_22_S_STATUS foreign key (status_id)
      references s_status (id);

alter table s_pubmed_tribe
   add constraint FK_S_PUBMED_REF_15_S_PUBMED foreign key (pubmed_type_id)
      references s_pubmed_type (id);

alter table s_share
   add constraint FK_S_SHARE_REF_12_S_SHARE_ foreign key (share_type_id)
      references s_share_type (id);

alter table s_share
   add constraint FK_S_SHARE_REF_13_S_SUBJEC foreign key (subject_id)
      references s_subject (id);

alter table s_share
   add constraint FK_S_SHARE_REF_14_S_USER foreign key (share_user_id)
      references s_user (id);

alter table s_sutra_book
   add constraint FK_S_SUTRA__REF_11_S_SUBJEC foreign key (subject_id)
      references s_subject (id);

alter table s_test
   add constraint FK_S_TEST_REF_20_S_QUALIF foreign key (qualification_id)
      references s_qualification_type (id);

alter table s_user
   add constraint FK_S_USER_REF_2_S_CERTIF foreign key (certificate_id)
      references s_certificate (id);

alter table s_user
   add constraint FK_S_USER_REF_3_S_STATUS foreign key (status_id)
      references s_status (id);

alter table s_user
   add constraint FK_S_USER_REF_4_S_SECURI foreign key (security_id)
      references s_security (id);

alter table s_user_message
   add constraint FK_S_USER_M_REF_25_S_USER foreign key (user_id)
      references s_user (id);

alter table s_user_message
   add constraint FK_S_USER_M_REF_26_S_ADMIN foreign key (admin_id)
      references s_admin (id);

alter table s_win
   add constraint FK_S_WIN_REF_24_S_SUBJEC foreign key (subject_id)
      references s_subject (id);

