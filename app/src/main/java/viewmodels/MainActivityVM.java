package viewmodels;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.mobilehealth.R;

public class MainActivityVM extends ViewModel {
    private int frameLayout;
    private Context context;

    public MainActivityVM(int frameLayout, Context context) {
        this.frameLayout = frameLayout;
        this.context = context;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
