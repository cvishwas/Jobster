Create Table Users( 
user_id number primary key,
username varchar(30),
password varchar(30),
f_name varchar(30),
l_name varchar(30),
acc_type number, -- 1 for job seekers or 0 for employer
email varchar(30),
address varchar(50)
);

Create Sequence users_seq
    Start with 1
    Increment by 1;

---Trigger for adding a primary key for a user
Create Or Replace Trigger T_Users_Insert
Before Insert On Users
For Each Row
Begin
  Select users_seq.nextval
  Into :new.user_id
  From dual;
End;
/


--Drop Table Location;
Create Table Location(
location_id number primary key,
city varchar(30),
state_province varchar(20),
postal_code varchar(10)
);

Create Sequence location_seq;

---Trigger for adding a primary key for a job category
Create Or Replace Trigger T_Location_Insert
Before Insert On Location
For Each Row
Begin
  Select location_seq.nextval
  Into :new.location_id
  From dual;
End;
/
  




--Each Job Post can have 1 Employer
Create Table Job_Post( 
job_id number primary key,
job_description varchar(400),
created_date date,
employer_id number,
Constraint fk_emp_user
    foreign key (employer_id)
    references Users(user_id)
);

Create Sequence job_post_seq;

---Trigger for adding a primary key for a job post
Create Or Replace Trigger T_Job_Post_Insert
Before Insert On Job_Post
For Each Row
Begin
  Select job_post_seq.nextval
  Into :new.job_id
  From dual;
End;
/


--Junction Table for location_id and users/job_post
--a location can be used by multiple users/job_post
Create Table User_Job_Location(
location_id number,
user_id number,
job_id number,
constraint fk_ujl_loc_user
    foreign key (user_id)
    references Users(user_id),
constraint fk_ujl_loc_post
    foreign key (job_id)
    references Job_Post(job_id),
constraint fk_ujl_loc
    foreign key (location_id)
    references Location(location_id),    
--checks if location is a job location xor an user location upon insertion
--BUT NOT BOTH (ie only one of the fields can have value the other MUST be NULL)
constraint chk_isUserXorJobCheck
    check ((user_id is not null and job_id is null) 
        or (user_id is null and job_id is not null))
);



--checks if location is a job location or an user location
--BUT NOT BOTH (ie only one of the fields can have value the other MUST be NULL) 
---in Oracle
Create Or Replace Trigger t_before_insert_location
Before Insert On User_Job_Location
For each row 
Begin 
    if (:new.user_id is null and :new.job_id is null) or (:new.user_id is not null and :new.job_id is not null) then 
        Raise_Application_Error (-20100, 'Must be inserted just one field or job_id or user_id');
    end if;
end;  
/


-- ie Full Time, Part Time, Internship
Create Table Job_Type( 
type_id number primary key,
type_name varchar(20)
);

Create Sequence job_type_seq;

---Trigger for adding a primary key for a job type
Create Or Replace Trigger T_Job_Type_Insert
Before Insert On Job_Type
For Each Row
Begin
  Select job_type_seq.nextval
  Into :new.type_id
  From dual;
End;
/


-- ie Tech, Business, Food
Create Table Job_Category( 
categ_id number primary key,
categ_name varchar(30)
);

Create Sequence job_category_seq;

---Trigger for adding a primary key for a job category
Create Or Replace Trigger T_Job_Category_Insert
Before Insert On Job_Category
For Each Row
Begin
  Select job_category_seq.nextval
  Into :new.categ_id
  From dual;
End;
/



--Junction Table for Job_Post and Job_Type
--since a job_post can have many types and a type can have many posts
Create Table Job_Post_Type(
post_id number,
type_id number,
constraint fk_jpt_post
    foreign key (post_id)
    references Job_Post(job_id),
constraint fk_jpt_type
    foreign key (type_id)
    references Job_Type(type_id)
);


--Junction Table for Job_Post and Job_Category
--since a job_post can have many categories and a category can have many posts
Create Table Job_Post_Categ(
post_id number,
category_id number,
constraint fk_jpc_post
    foreign key (post_id)
    references Job_Post(job_id),
constraint fk_jpc_type
    foreign key (category_id)
    references Job_Category(categ_id)
);

--Junction Table for job_post and applicants from Users
--a job can have multiple applicants
--an applicant can have multiple jobs applied for
Create Table Job_Applicants(
applicant_id number,
job_id number,
constraint fk_ja_applicant
    foreign key (applicant_id)
    references Users(user_id),
constraint fk_ja_post
    foreign key (job_id)
    references Job_Post(job_id)
);




---Junction Table for users favorite job_posts
--- user can have multiple favorite job_posts
-- job_post - can be favorites for a lot of users
Create Table Job_User_Favorites (
    user_id number,
    job_id number,
    constraint fk_juf_user
        foreign key (user_id)
        references Users(user_id),
    constraint fk_juf_job
        foreign key (job_id)
        references Job_Post(job_id)
);

--User Preference Table
--Skippable if User is employer(ie acc_type is 0)
Create Table User_Preferences(
    user_id number,
    job_type number,
    job_categ number,
    salary  number,
    pref_loc number,
    Constraint fk_up_user
        foreign key (user_id)
        references Users(user_id),
    Constraint fk_up_type
        foreign key (job_type)
        references Job_Type(type_id),
    Constraint fk_up_categ
        foreign key (job_categ)
        references Job_Category(categ_id),
    Constraint fk_up_loc
        foreign key (pref_loc)
        references Location(location_id)
);

