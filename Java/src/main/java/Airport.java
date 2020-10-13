import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport{
    private List<? extends Plane> planes;

    public <C extends Plane> List<C> getPlanesByType(Class<C> clazz) {
        List<C> planes = new ArrayList<>();
        for (Plane p: planes) {
            if (p.getClass().equals(clazz)) {
                planes.add((C) p);
            }
        }
        return planes;
    }
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPlanesByType(PassengerPlane.class);
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlaneByType(MilitaryType militaryType){
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getPlanesByType(MilitaryPlane.class);
        for (int i = 0; i < militaryPlanes.size(); i++) {
            if (militaryPlanes.get(i).getMilitaryType() == militaryType) {
                transportMilitaryPlanes.add(militaryPlanes.get(i));
            }
        }
        return transportMilitaryPlanes;
    }


    public Airport sortByMaxDistance() {
        Collections.sort(planes, Plane.getAttributeMaxFlightDistance());
        return this;
    }


    public Airport sortByMaxSpeed() {
        Collections.sort(planes, Plane.getAttributeMaxSpeed());
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, Plane.getAttributeMaxLoadCapacity());
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
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
