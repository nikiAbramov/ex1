import oop.ex3.searchengine.Hotel;
import oop.ex3.searchengine.HotelDataset;

public class Boopingsite {
    private Hotel[] hotels;
    public Boopingsite(String name){
        hotels = HotelDataset.getHotels(name);
    }

    public Hotel[] getHotelsInCityByRating(String city){
        for(int i = 0; i < hotels.length; i++){
            if (hotels[i].getCity().equals(city))
                return hotels;
        }
        return new Hotel[0];
    }

    public Hotel[] getHotelsByProximity(double latitude, double longitude){
        return null;
    }

    public Hotel[] getHotelInCityByProximity(String city, double latitude, double longitude){
        return null;
    }
}
