package repositories;

import android.content.Context;

public class MedicineRepository{
    private final String FILE_PATH = "medicine.json";
    private Context context;

    public MedicineRepository(Context context) {
        this.context = context;
    }

}
