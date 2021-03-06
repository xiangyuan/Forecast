/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/5/17 23:17:19                           */
/*==============================================================*/

drop table if exists Company;

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

drop table if exists ComposeWay;

drop table if exists CreateWeightWay;

/*==============================================================*/
/* Table: Company                                          */
/*==============================================================*/
create table Company 
( cid int auto_increment comment '主健',
  cpnName 	varchar(100),
  primary key (cid)
);
/*==============================================================*/
/* Table: ComposeWay                                          */
/*==============================================================*/
create table ComposeWay
( composeId int auto_increment,
  wayName  varchar(100),
   primary key (composeId)

);
/*==============================================================*/
/* Table: CreateWeightWay                                          */
/*==============================================================*/
create table CreateWeightWay 
( weightId int auto_increment,
 weightName varchar(100),
  primary key (weightId)
);

/*==============================================================*/
/* Table: FactorSystem                                          */
/*==============================================================*/
create table FactorSystem
(
   FactorCode           int auto_increment comment '主键',
   TaskCode             int comment '主键',
   FactorName           varchar(100),
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
   FactorCode           int auto_increment,
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
   QualitativeRank      varchar(100) comment '优，良，中，差，很差',
   primary key (ProductCode, FactorCode, ExpertCode)
);

/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Product
(
   PrdctCode            int auto_increment comment '主键，按添加次序逐一递增',
   CpnCode              int comment '外键，定义见企业基本信息表',
   PrdctSequence        int comment '本企业内产品排名',
   PrdctKindCode        int comment '外键，定义见产品明细类',
   PrdctName            varchar(100),
   PrdctModel           varchar(100),
   PrdctPara            varchar(100),
   PrdctPicturePath     varchar(100),
   PrdctIntro           varchar(100),
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
   QuanlitativeRank     varchar(80) comment '优，良，中，差，很差',
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
   PrdctTypeCode        int auto_increment comment '主键',
   PrdctTypeName        varchar(80),
   primary key (PrdctTypeCode) 
);

/*==============================================================*/
/* Table: Task                                                  */
/*==============================================================*/
create table Task
(
   TaskCode             int auto_increment comment '主键',
   TaskName             varchar(80),
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
   TaskCode             int auto_increment,
   ProductCode          int comment '主键',
   ReportURL            varchar(80),
   primary key (TaskCode) 
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
   UserID               int auto_increment comment '主键，用户注册时填写，并进行唯一性检查',
   UserPassword         varchar(80) comment '注册时填写',
   UserType             int comment '1:超级管理员,2:企业',
   UserName             varchar(80),
   UserCompany          varchar(80),
   UserPhone            varchar(80),
   UserEmail            varchar(80),
   RegDate              datetime,
   IsPast               int,
   PassDate             datetime,
   NotPassResponse      varchar(80),
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
   FacorCode            int auto_increment comment '主键',
   PrdctTypeCode        int comment '主键',
   FactorUnit           varchar(80),
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
      
      
insert into ProductType(PrdctTypeName) values('多媒体');
insert into ProductType(PrdctTypeName) values('文档类');
insert into ProductType(PrdctTypeName) values('消费类软件');
insert into ProductType(PrdctTypeName) values('企业软件');
insert into ProductType(PrdctTypeName) values('个人软件');
insert into ProductType(PrdctTypeName) values('社交软件');


insert into Company(cpnName) values('google');
insert into Company(cpnName) values('facebook');
insert into Company(cpnName) values('apple');
insert into Company(cpnName) values('twitter');
insert into Company(cpnName) values('wumii');
insert into Company(cpnName) values('wondershare');
