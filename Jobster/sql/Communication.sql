create table user(
  Id int primary key   not null,
  Username varchar(30)  not null,
  Password varchar(30)  not null 
 )
;

create table Message(
  Id int  primary key  not null,
  Fk_User_From int  not null,
  Subject  varchar(256) not null,
  Content   text  not null,
  constraint  Fk_Message_User_From,
    foreign key (Fk_User_From )
    references   User (Id )
    on delete cascade
    )
;

create table Junc_Message_To(
Fk_Message int not null,
  Fk_User int not null,
  Sent   datetime not null,
  Read   datetime not null,
  Deleted  datetime not null,
  PRIMARY KEY (Fk_Message, Fk_User),
  constraint  Fk_Junc_Message_To__Message
    foreign key (Fk_Message )
    references Message (Id )
    on delete cascade,
  constraint  Fk_Junc_Message_To__User
    foreign key (Fk_User )
    references  User (Id )
    on delete cascade
    )
;