package mapper;


import entity.Location;
import java.util.ArrayList;
import java.util.List;
 
/**
 *
 * @author felesiah
 */
public class LocationMapper {
    public List<LocationMapper> locations = new ArrayList();
   
    public LocationMapper(List<Location> location, boolean addLocation){
        for (Location l: location) {
            this.locations.add(new LocationMapper((List<Location>) l, addLocation));
        }
       
    }
}