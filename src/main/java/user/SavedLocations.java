package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import location.Location;

public class SavedLocations {
    private Map<String, List<Location>> locations;

    public SavedLocations(Map<String, List<Location>> locations) {
        this.locations = new HashMap<>();
    }

    public void saveNewLocation(Location location, String saveType) {
        if (locations.containsKey(saveType)) {
            List<Location> currList = locations.get(saveType);
            // TODO: To check if tests pass here as data is added to value returned
            currList.add(location);
        } else {
            List<Location> newList = new ArrayList<Location>();
            newList.add(location);
            locations.put(saveType, newList);
        }
    }

    public Map<String, List<Location>> getLocations() {
        return locations;
    }

    public void setLocations(Map<String, List<Location>> locations) {
        this.locations = locations;
    }

    
    
    
}