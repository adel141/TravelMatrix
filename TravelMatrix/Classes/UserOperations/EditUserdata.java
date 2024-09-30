package Classes.UserOperations;

import Classes.AdminOperations.UserManagement.EditUser;

public class EditUserdata extends EditUser
{
    public EditUserdata(String User)
    {
        searchUsernameT.setText(User);
        searchUsernameT.setVisible(false);
        searchUsernameL.setVisible(false);
        searchB.doClick();
        searchB.setVisible(false);

    }
}
