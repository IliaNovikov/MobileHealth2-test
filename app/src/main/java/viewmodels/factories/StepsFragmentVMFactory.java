package viewmodels.factories;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import viewmodels.StepsFragmentVM;

public class StepsFragmentVMFactory implements ViewModelProvider.Factory {

    private Activity context;

    public StepsFragmentVMFactory(Activity context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new StepsFragmentVM(context);
    }
}
