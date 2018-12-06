Drop Table EMPLOYER_FAVORITES;
Drop Table User_Preferences;
Drop Table Job_User_Favorites;
Drop Table Job_Applicants;
Drop Table Job_Post_Categ;
Drop Table Job_Post_Type;
Drop Table Job_Category;
Drop Table Job_Type;
Drop Table User_Job_Location;
Drop Table Job_Post;
Drop Table Location;
Drop Table Users;
Drop Table Account_Identifier;

--Drop Sequences
Drop sequence acc_id_seq;
Drop Sequence users_seq;
Drop Sequence location_seq;
Drop Sequence job_post_seq;
Drop Sequence job_type_seq;
Drop Sequence job_category_seq;

--Drop Triggers 
--NOTE: this doesnt work
--Drop Trigger T_Users_Insert;
--Drop Trigger T_Location_Insert;
--Drop Trigger T_Job_Post_Insert;
--Drop Trigger t_before_insert_location;
--Drop Trigger T_Job_Type_Insert;
--Drop Trigger T_Job_Category_Insert;