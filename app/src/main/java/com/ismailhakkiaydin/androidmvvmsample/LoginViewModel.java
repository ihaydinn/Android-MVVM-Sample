package com.ismailhakkiaydin.androidmvvmsample;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class LoginViewModel extends BaseObservable {

    private User user;

    private String successMessage = "Giriş Başarılı";
    private String errorMessage = "Giriş Yapılamadı";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    public void setUserEmail(String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserPassword(){
        return user.getPassword();
    }

    public void setUserPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel(){
        user = new User("","");
    }

    public void onLoginClicked(){
        if(isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }

}
