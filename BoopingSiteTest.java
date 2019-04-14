import oop.ex3.searchengine.Hotel;
import oop.ex3.searchengine.HotelDataset;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoopingSiteTest {
    private Boopingsite testSite;

    @Before
    public void init(){
        testSite = new Boopingsite("hotels_dataset.txt");
    }

    @Test
    public void testGetHotelsByCity(){
        Hotel[] expectedHotels = new Hotel[2];
        expectedHotels[0] = HotelDataset.getHotels()[0];
        expectedHotels[1] = HotelDataset.getHotels()[1];
        Assert.assertEquals(new Hotel[0], testSite.getHotelsInCityByRating("Gotham City"));
        Assert.assertEquals(expectedHotels, testSite.getHotelsInCityByRating("gurgaon"));
    }
}
