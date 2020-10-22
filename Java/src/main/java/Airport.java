import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

/**
 * @author
 */

public class Airport{
    private final List<? extends Plane> planes;

    public <C extends Plane> List<C> getPlanesByType(Class<C> clazz) {
        List<C> planesByType = new ArrayList<>();
        for (Plane p: planes) {
            if (p.getClass().equals(clazz)) {
                planesByType.add((C) p);
            }
        }
        return planesByType;
    }
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPlanesByType(PassengerPlane.class);
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlaneByType(MilitaryType militaryType){
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getPlanesByType(MilitaryPlane.class);
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getMilitaryType() == militaryType) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }


    public void sortByMaxDistance() {
        Collections.sort(planes, Plane.getAttributeMaxFlightDistance());
    }


    public void sortByMaxSpeed() {
        Collections.sort(planes, Plane.getAttributeMaxSpeed());
    }

    public void sortByMaxLoadCapacity() {
        Collections.sort(planes, Plane.getAttributeMaxLoadCapacity());
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
