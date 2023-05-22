package repositories;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import models.Medical;
import models.ProfileData;

public class MedicineRepository{
    private final String FILE_PATH = "medicine.json";
    private Context context;

    public MedicineRepository(Context context) {
        this.context = context;
    }
    public void SaveMedicalData(ArrayList<Medical> data){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonFormat = gson.toJson(data);
        Log.e("json", gsonFormat);
        try {
            FileOutputStream outputStream = context.openFileOutput(FILE_PATH, Context.MODE_PRIVATE);
            outputStream.write(gsonFormat.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //извлечение данных из json
    public ArrayList<Medical> LoadMedicalData(){
        try(FileInputStream input = context.openFileInput(FILE_PATH);
            InputStreamReader reader = new InputStreamReader(input))
        {
            Gson gson = new Gson();
            ArrayList<Medical> data = gson.fromJson(reader, new TypeToken<ArrayList<Medical>>(){}.getType());
            return data;
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return null;
    }
}
