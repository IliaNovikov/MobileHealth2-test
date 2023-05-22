package viewmodels;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;

import models.ProfileData;
import repositories.ProfileInfoRepository;

public class ProfileFragmentVM extends ViewModel {

    private Activity contextActivity;
    private ProfileInfoRepository repository;

    private ProfileData data;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<Integer> height = new MutableLiveData<>(0);
    public MutableLiveData<Integer> weight = new MutableLiveData<>(0);
    public MutableLiveData<Long> birthDate = new MutableLiveData<>();


    public ProfileFragmentVM(Activity contextActivity) {
        this.contextActivity = contextActivity;
        repository = new ProfileInfoRepository(contextActivity);
        loadData();
    }

    public void saveData(){
        data = new ProfileData(name.getValue(), height.getValue(), weight.getValue(), birthDate.getValue());
        repository.SaveProfileData(data);
    }
    public void loadData(){
        if(repository.LoadProfileData() != null) {
            data = repository.LoadProfileData();
            name.setValue(data.getName());
            height.setValue(data.getHeight());
            weight.setValue(data.getWeight());
            birthDate.setValue(data.getBirthDate());
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
