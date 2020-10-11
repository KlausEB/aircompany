import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    public List<Plane> getPlanesByType(String planeType){
        List<Plane> arrayPlane = new ArrayList<>();
        for (Plane p : planes) {
            if (p.getClass().getSimpleName().equals(planeType)) {
                arrayPlane.add(p);
            }
        }
        return arrayPlane;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<Plane> passengerPlanes = getPlanesByType("PassengerPlane");
        PassengerPlane planeWithMaxCapacity = (PassengerPlane) passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (((PassengerPlane) passengerPlanes.get(i)).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = (PassengerPlane) passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlaneByType(MilitaryType militaryType){
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<Plane> militaryPlanes = getPlanesByType("MilitaryPlane");
        for (int i = 0; i < militaryPlanes.size(); i++) {
            if (((MilitaryPlane)militaryPlanes.get(i)).getMilitaryType() == militaryType) {
                transportMilitaryPlanes.add((MilitaryPlane)militaryPlanes.get(i));
            }
        }
        return transportMilitaryPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }


    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMS() - o2.getMS();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
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
