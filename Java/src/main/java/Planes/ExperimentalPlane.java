package Planes;

import models.ClassificationSecrecyLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private final ExperimentalTypes experimentalTypes;
    private ClassificationSecrecyLevel classificationSecrecyLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalTypes, ClassificationSecrecyLevel classificationSecrecyLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalTypes = experimentalTypes;
        this.classificationSecrecyLevel = classificationSecrecyLevel;
    }

    public ClassificationSecrecyLevel getClassificationLevel(){
        return classificationSecrecyLevel;
    }

    public void setClassificationLevel(ClassificationSecrecyLevel classificationSecrecyLevel){
        this.classificationSecrecyLevel = classificationSecrecyLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
