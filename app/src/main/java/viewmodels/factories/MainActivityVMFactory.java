package viewmodels.factories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import viewmodels.MainActivityVM;

public class MainActivityVMFactory implements ViewModelProvider.Factory {
    private Context context;
    private int frameLayoutID;

    public MainActivityVMFactory(Context context, int frameLayoutID) {
        this.context = context;
        this.frameLayoutID = frameLayoutID;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new MainActivityVM(frameLayoutID, context);
    }
}
