package interfaces;

import models.Exercise;
import models.Section;
import models.Workout;

public interface OnWorkoutClickInterface {
    void onClick(Workout exercise, int position);
}
