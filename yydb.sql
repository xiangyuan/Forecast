/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/5/17 23:17:19                           */
/*==============================================================*/


drop table if exists FactorSystem;

drop table if exists FactorWeight;

drop table if exists PrdctExpertData;

drop table if exists Product;

drop table if exists ProductFactor;

drop table if exists ProductResult;

drop table if exists ProductType;

drop table if exists Task;

drop table if exists TaskCEProduct;

drop table if exists TaskResult;

drop table if exists Users;

drop table if exists WeightExpertData;

drop table if exists FactorCharacter;

/*==============================================================*/
/* Table: FactorSystem                                          */
/*==============================================================*/
create table FactorSystem
(
   FactorCode           int not null comment '����',
   TaskCode             int comment '����',
   FactorName           varchar(1),
   BelongFactorCode     int comment '��Ϊ���ϲ㣬��ֵΪ0',
   BelongTaskCode       int comment '���',
   IsLeaf               int,
   primary key (FactorCode)
);

/*==============================================================*/
/* Table: FactorWeight                                          */
/*==============================================================*/
create table FactorWeight
(
   FactorCode           int not null,
   WeightVal            float,
   primary key (FactorCode)
);

/*==============================================================*/
/* Table: PrdctExpertData                                       */
/*==============================================================*/
create table PrdctExpertData
(
   ProductCode          int not null,
   FactorCode           int not null,
   ExpertCode           int not null,
   QualitativeRank      char(1) comment '�ţ������У���ܲ�',
   primary key (ProductCode, FactorCode, ExpertCode)
);

/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Product
(
   PrdctCode            int not null comment '����������Ӵ�����һ����',
   CpnCode              int comment '������������ҵ������Ϣ��',
   PrdctSequence        int comment '����ҵ�ڲ�Ʒ����',
   PrdctKindCode        int comment '������������Ʒ��ϸ��',
   PrdctName            varchar(1),
   PrdctModel           varchar(1),
   PrdctPara            varchar(1),
   PrdctPicturePath     varchar(1),
   PrdctIntro           varchar(1),
   SubmitTime           datetime,
   primary key (PrdctCode)
);

/*==============================================================*/
/* Table: ProductFactor                                         */
/*==============================================================*/
create table ProductFactor
(
   ProductCode          int not null,
   FactorCode           int not null,
   QuantitativeVal      float,
   QuanlitativeRank     char(1) comment '�ţ������У���ܲ�',
   StandardizedVal      float,
   NoDimensionVal       float,
   primary key (ProductCode, FactorCode)
);

/*==============================================================*/
/* Table: ProductResult                                         */
/*==============================================================*/
create table ProductResult
(
   TaskCode             int not null,
   PrdctCode            int not null,
   CEValue              float,
   primary key (TaskCode, PrdctCode)
);

/*==============================================================*/
/* Table: ProductType                                           */
/*==============================================================*/
create table ProductType
(
   PrdctTypeCode        int not null comment '����',
   PrdctTypeName        varchar(1),
   primary key (PrdctTypeCode)
);

/*==============================================================*/
/* Table: Task                                                  */
/*==============================================================*/
create table Task
(
   TaskCode             int not null comment '����',
   TaskName             varchar(1),
   TaskIntro            varchar(1),
   CEPrdctTypeCode      int,
   CreateWeightWay      int comment '1:AHP��
            2:DELPHI��
            3:ֱ�Ӹ�Ȩ
            4����ԱȽϷ�
            4:',
   ComposeWay           int comment '1:���Լ�Ȩ�ͷ�
            2:����㷨
            3:�˻��ϳɷ�
            4:ģ���ۺ����۷���',
   CreateDate           datetime,
   UserID               char(1) comment '�����û��˺�',
   primary key (TaskCode)
);

/*==============================================================*/
/* Table: TaskCEProduct                                         */
/*==============================================================*/
create table TaskCEProduct
(
   TaskCode             int not null comment '����',
   ProductCode          int not null comment '����',
   primary key (TaskCode, ProductCode)
);

/*==============================================================*/
/* Table: TaskResult                                            */
/*==============================================================*/
create table TaskResult
(
   TaskCode             int not null,
   ProductCode          int comment '����',
   ReportURL            varchar(1),
   primary key (TaskCode)
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
   UserID               char(1) not null comment '�������û�ע��ʱ��д��������Ψһ�Լ��',
   UserPassword         char(1) comment 'ע��ʱ��д',
   UserType             int comment '1:��������Ա,2:��ҵ',
   UserName             varchar(1),
   UserCompany          varchar(1),
   UserPhone            varchar(1),
   UserEmail            varchar(1),
   RegDate              datetime,
   IsPast               int,
   PassDate             datetime,
   NotPassResponse      varchar(1),
   primary key (UserID)
);

/*==============================================================*/
/* Table: WeightExpertData                                      */
/*==============================================================*/
create table WeightExpertData
(
   FactorCode           int not null,
   ExpertCoDE           int not null,
   WeightRank           float,
   primary key (FactorCode, ExpertCoDE)
);

/*==============================================================*/
/* Table: FactorCharacter                                        */
/*==============================================================*/
create table FactorCharacter
(
   FacorCode            int not null comment '����',
   PrdctTypeCode        int comment '����',
   FactorUnit           char(1),
   IsQualitative        int,
   FactorType           int comment '0:������
            1:��С��
            2:�̶���
            3:������',
   BestValue            float comment '�̶���ָ����ֵ',
   BestLowValue         float comment '������ָ����ֵ',
   BestUpValue          float comment '������ָ����ֵ',
   min                  float,
   max                  float,
   StandardizeWay       int,
   NoDimensionWay       int,
   primary key (FacorCode)
);

alter table FactorSystem add constraint FK_Reference_3 foreign key (TaskCode)
      references Task (TaskCode) on delete restrict on update restrict;

alter table TaskResult add constraint FK_Reference_1 foreign key (TaskCode, ProductCode)
      references TaskCEProduct (TaskCode, ProductCode) on delete restrict on update restrict;

alter table FactorCharacter add constraint FK_Reference_2 foreign key (PrdctTypeCode)
      references ProductType (PrdctTypeCode) on delete restrict on update restrict;

