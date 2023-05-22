package viewmodels;

import android.app.Activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import models.Medical;
import repositories.MedicineRepository;

public class MedsFragmentVM extends ViewModel {

    private Activity contextActivity;
    public MutableLiveData<ArrayList<Medical>> medicals = new MutableLiveData<>();
    MedicineRepository repository = new MedicineRepository(contextActivity);

    public MedsFragmentVM(Activity contextActivity) {
        this.contextActivity = contextActivity;

    }
    public void saveData(){
        repository.SaveMedicalData(medicals.getValue());
    }
    public void loadData(){

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
