package viewmodels.factories;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import viewmodels.ProfileFragmentVM;

public class ProfileFragmentVMFactory implements ViewModelProvider.Factory {
    private Activity contextActivity;

    public ProfileFragmentVMFactory(Activity contextActivity) {
        this.contextActivity = contextActivity;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProfileFragmentVM(contextActivity);
    }
}
