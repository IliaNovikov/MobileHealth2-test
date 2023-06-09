package repositories;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import models.ProfileData;
import models.StepData;

public class ProfileInfoRepository {
    private final String FILE_PATH = "profile.json";
    private Context context;

    public ProfileInfoRepository(Context context) {
        this.context = context;
    }
    public void SaveProfileData(ProfileData data){
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
    public ProfileData LoadProfileData(){
        try(FileInputStream input = context.openFileInput(FILE_PATH);
            InputStreamReader reader = new InputStreamReader(input))
        {
            Gson gson = new Gson();
            ProfileData data = gson.fromJson(reader, ProfileData.class);
            return data;

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return null;
    }
}
