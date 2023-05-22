package viewmodels;

import android.app.Activity;
import android.os.Build;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobilehealth.R;

import java.time.LocalDate;
import java.time.LocalTime;

import models.PFCData;
import models.ProfileData;
import repositories.PFCRepository;
import repositories.ProfileInfoRepository;

public class PFCFragmentVM extends ViewModel {
    private Activity contextActivity;
    private PFCRepository repository;
    private ProfileInfoRepository profileRepository;
    private PFCData data;
    private ProfileData profileData;

    public MutableLiveData<Integer> proteinTotal = new MutableLiveData<>(0);
    public MutableLiveData<Integer> fatTotal = new MutableLiveData<>(0);
    public MutableLiveData<Integer> carbTotal = new MutableLiveData<>(0);

    public MutableLiveData<Integer> proteinCurrent = new MutableLiveData<>(0);
    public MutableLiveData<Integer> fatCurrent = new MutableLiveData<>(0);
    public MutableLiveData<Integer> carbCurrent = new MutableLiveData<>(0);

    public MutableLiveData<String> protein = new MutableLiveData<>();
    public MutableLiveData<String> fat = new MutableLiveData<>();
    public MutableLiveData<String> carb = new MutableLiveData<>();

    public PFCFragmentVM(Activity contextActivity) {
        this.contextActivity = contextActivity;
        repository = new PFCRepository(contextActivity);
        profileRepository = new ProfileInfoRepository(contextActivity);
    }
    public void saveData(){
        data = new PFCData(proteinTotal.getValue(), fatTotal.getValue(), carbTotal.getValue(),
                proteinCurrent.getValue(), fatCurrent.getValue(), carbCurrent.getValue());
        repository.SavePFCData(data);
    }
    public void loadData(){
        if(repository.LoadPFCData() != null) {
            data = repository.LoadPFCData();
            if (profileRepository.LoadProfileData() != null) {
                profileData = profileRepository.LoadProfileData();
                proteinTotal.setValue((int) Math.round(profileData.getWeight() * 1.5));
                fatTotal.setValue((int) Math.round(profileData.getWeight() * 1.2));
                carbTotal.setValue((int) Math.round(profileData.getWeight() * 2));
                if (proteinCurrent.getValue() == 0 && fatCurrent.getValue() == 0 && carbCurrent.getValue() == 0) {
                    proteinCurrent.setValue(data.getProteinCurrent());
                    fatCurrent.setValue(data.getFatCurrent());
                    carbCurrent.setValue(data.getCarbCurrent());
                }
                protein.setValue(String.valueOf(proteinCurrent.getValue()) + "/" + String.valueOf(proteinTotal.getValue()));
                fat.setValue(String.valueOf(fatCurrent.getValue()) + "/" + String.valueOf(fatTotal.getValue()));
                carb.setValue(String.valueOf(carbCurrent.getValue()) + "/" + String.valueOf(carbTotal.getValue()));
            } else {
                Toast.makeText(contextActivity, R.string.enter_data, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
