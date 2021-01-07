package com.qualidade.qapp.login;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import java.util.List;

public class LoginRepository {

    private final LoginDao loginDao;
    private final LiveData<List<Login>> allUsers;

    public LoginRepository(Application application) {
        LoginDatabase loginDataBase = LoginDatabase.getInstance(application);
        loginDao = loginDataBase.loginDao();
        allUsers = loginDao.getAllUsers();
    }

    public void insert(Login login) { new LoginRepository.InsertUserAsyncTask(loginDao).execute(login); }

    public void delete(Login login) { new LoginRepository.DeleteUserAsyncTask(loginDao).execute(login); }

    public void update(Login login) { new LoginRepository.UpdateUserAsyncTask(loginDao).execute(login); }

    public void deleteAllUsers() { new LoginRepository.DeleteAllUsersAsyncTask(loginDao).execute(); }

    public LiveData<Integer> getUser(String user, String senha) { return loginDao.getUser(user, senha); }

    public LiveData<List<Login>> getAllUsers() { return allUsers; }

    private static class InsertUserAsyncTask extends AsyncTask<Login, Void, Void> {
        private final LoginDao loginDao;

        private InsertUserAsyncTask(LoginDao loginDao) { this.loginDao = loginDao; }

        @Override
        protected Void doInBackground(Login... logins) {
            loginDao.insert(logins[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<Login, Void, Void> {
        private final LoginDao loginDao;

        private UpdateUserAsyncTask(LoginDao loginDao) { this.loginDao = loginDao; }

        @Override
        protected Void doInBackground(Login... logins) {
            loginDao.update(logins[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<Login, Void, Void> {
        private final LoginDao loginDao;

        private DeleteUserAsyncTask(LoginDao loginDao) { this.loginDao = loginDao; }

        @Override
        protected Void doInBackground(Login... logins) {
            loginDao.delete(logins[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAsyncTask extends AsyncTask<Login, Void, Void> {
        private final LoginDao loginDao;

        private DeleteAllUsersAsyncTask(LoginDao loginDao) { this.loginDao = loginDao; }

        @Override
        protected Void doInBackground(Login... logins) {
            loginDao.deleteAllUsers();
            return null;
        }
    }
}
