package viewmodels;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collection;

import models.StepData;
import repositories.StepRepository;

public class StepsFragmentVM extends ViewModel implements SensorEventListener {

    public MutableLiveData<Integer> stepCount = new MutableLiveData<Integer>(17);
    public MutableLiveData<Integer> stepsToday = new MutableLiveData<Integer>(0);
    private int previousSteps = 0;
    private Activity context;

    private StepRepository repository;
    private StepData stepData;
    private SensorManager sensorManager;
    private Sensor stepSensor;

    public StepsFragmentVM(Activity context) {
        this.context = context;
        repository = new StepRepository(context);
        if (repository.LoadStepsData() != null) {
            stepData = repository.LoadStepsData();
            stepCount.setValue(stepData.getTotalSteps());
        }
        else
            stepData = new StepData();
        Log.e("steps", String.valueOf(stepData.getTotalSteps()));
        Toast.makeText(context, "stepsData:" + String.valueOf(stepData.getTotalSteps()), Toast.LENGTH_SHORT).show();
        if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(context, new String[] {Manifest.permission.ACTIVITY_RECOGNITION}, 1);
        }
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(stepSensor == null){
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0] == 0)
            sensorEvent.values[0] = stepData.getTotalSteps();
        Toast.makeText(context, "sensorEvent: " + String.valueOf(sensorEvent.values[0]), Toast.LENGTH_SHORT).show();
        stepCount.setValue((int) sensorEvent.values[0] + stepData.getTotalSteps());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void saveData(){
        stepData.setTotalSteps(stepCount.getValue());
        repository.SaveStepsData(stepData);
        Log.e("data", "saved");
        Log.e("stepCount", String.valueOf(stepCount.getValue()));
    }

    @Override
    public void onCleared() {
        Log.e("step viewmodel", "cleared");
        super.onCleared();
    }
}