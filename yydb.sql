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
   FactorCode           int not null comment '主键',
   TaskCode             int comment '主键',
   FactorName           varchar(50),
   BelongFactorCode     int comment '若为最上层，该值为0',
   BelongTaskCode       int comment '外键',
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
   QualitativeRank      varchar(4) comment '优，良，中，差，很差',
   primary key (ProductCode, FactorCode, ExpertCode)
);

/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Product
(
   PrdctCode            int not null comment '主键，按添加次序逐一递增',
   CpnCode              int comment '外键，定义见企业基本信息表',
   PrdctSequence        int comment '本企业内产品排名',
   PrdctKindCode        int comment '外键，定义见产品明细类',
   PrdctName            varchar(50),
   PrdctModel           varchar(50),
   PrdctPara            varchar(50),
   PrdctPicturePath     varchar(50),
   PrdctIntro           varchar(50),
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
   QuanlitativeRank     varchar(5) comment '优，良，中，差，很差',
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
   PrdctTypeCode        int not null comment '主键',
   PrdctTypeName        varchar(60),
   primary key (PrdctTypeCode)
);

/*==============================================================*/
/* Table: Task                                                  */
/*==============================================================*/
create table Task
(
   TaskCode             int not null comment '主键',
   TaskName             varchar(30),
   TaskIntro            varchar(100),
   CEPrdctTypeCode      int,
   CreateWeightWay      int comment '1:AHP法
            2:DELPHI法
            3:直接赋权
            4：逐对比较法
            4:',
   ComposeWay           int comment '1:线性加权和法
            2:理想点法
            3:乘积合成法
            4:模糊综合评价方法',
   CreateDate           datetime,
   UserID               int comment '创建用户账号',
   primary key (TaskCode)
);

/*==============================================================*/
/* Table: TaskCEProduct                                         */
/*==============================================================*/
create table TaskCEProduct
(
   TaskCode             int not null comment '主键',
   ProductCode          int not null comment '主键',
   primary key (TaskCode, ProductCode)
);

/*==============================================================*/
/* Table: TaskResult                                            */
/*==============================================================*/
create table TaskResult
(
   TaskCode             int not null,
   ProductCode          int comment '主键',
   ReportURL            varchar(80),
   primary key (TaskCode)
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
   UserID               int not null comment '主键，用户注册时填写，并进行唯一性检查',
   UserPassword         varchar(20) comment '注册时填写',
   UserType             int comment '1:超级管理员,2:企业',
   UserName             varchar(25),
   UserCompany          varchar(25),
   UserPhone            varchar(30),
   UserEmail            varchar(25),
   RegDate              datetime,
   IsPast               int,
   PassDate             datetime,
   NotPassResponse      varchar(20),
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
   FacorCode            int not null comment '主键',
   PrdctTypeCode        int comment '主键',
   FactorUnit           varchar(4),
   IsQualitative        int,
   FactorType           int comment '0:极大型
            1:极小型
            2:固定型
            3:区间型',
   BestValue            float comment '固定型指标需值',
   BestLowValue         float comment '区间型指标需值',
   BestUpValue          float comment '区间型指标需值',
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

