CREATE TABLE User_Favorites_Employee(
	user_id number,
	employer_id number,
	CONSTRAINT fav_emp_user
    	FOREIGN KEY (user_id)
    	REFERENCES Users(user_id),
	CONSTRAINT fav_emp_employer
    	FOREIGN KEY (employer_id)
    	REFERENCES Users(user_id)    
);
