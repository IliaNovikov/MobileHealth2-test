package repositories;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import models.PFCData;
import models.ProfileData;

public class PFCRepository {
    private final String FILE_PATH = "pfc.json";
    private Context context;

    public PFCRepository(Context context) {
        this.context = context;
    }

    public void SavePFCData(PFCData data){
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
    public PFCData LoadPFCData(){
        try(FileInputStream input = context.openFileInput(FILE_PATH);
            InputStreamReader reader = new InputStreamReader(input))
        {
            Gson gson = new Gson();
            PFCData data = gson.fromJson(reader, PFCData.class);
            return data;

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return null;
    }

}
