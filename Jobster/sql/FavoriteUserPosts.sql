-------1-insert, 2 - delete into(from) table Job_User_Favorites---
create or replace Procedure inst_dlt_usr_favorite_post(p_user_id In Integer, p_job_id In Integer, p_result Out Integer)
As
    v_post_is_favorite Integer :=0;
    v_user_acc_type Integer :=-1;
Begin 

    Select acc_type Into v_user_acc_type 
    From Users 
    Where user_id =p_user_id;
    If v_user_acc_type = 0 Then 
        p_result := 0;
        Return;
    End If;
    
    Delete From Job_User_Favorites Where user_id = p_user_id And job_id = p_job_id;
    If SQL%ROWCOUNT = 0 
    Then
        Insert Into Job_User_Favorites (user_id, job_id) Values (p_user_id, p_job_id); 
        p_result := 1;
    Else 
        p_result :=2;
    End If;
End;
 
