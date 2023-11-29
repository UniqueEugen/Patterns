import com.example.patterns1.data.main.GetTrains;
import com.example.patterns1.data.main.GetTrainsImpl;
import com.example.patterns1.data.main.animalsXML.Train;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrainsCallTest {
    private List<Train> trains;

    @Order(2)
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void checkTime(){
        try {
            trains = GetTrainsImpl.getInstance().getTrains();
            trains.forEach(animal-> animal.toString());
        }catch (Exception e){
            fail(e);
        }
    }

    @Test
    @Order(3)
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void checkInternational(){
        try {
            trains = GetTrainsImpl.getInstance().getTrains();
            trains.forEach(train -> {
                String num = train.getTrainNumber();
                var type = String.valueOf(num.charAt(num.length()-1));
                if (type.equals("C")){
                    if(!train.announcement().equals("Поезд международных линий"))
                        throw new RuntimeException("Wrong answer!");
                }
            });
        }catch (Exception e){
            fail(e);
        }
    }
    @Test
    @Order(1)
    @Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
    public void checkSingleton(){
        try{
            GetTrains getTrains = GetTrainsImpl.getInstance();
            assertNotNull(getTrains);
        }catch (Exception e){
            fail(e);
        }
    }
    @Test
    @Order(4)
    @Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
    public void checkUniqueId(){
        try{
;
            AtomicReference<String> checkTrainNum = new AtomicReference<>("0");
            GetTrainsImpl.getInstance().getTrains().stream().forEach(train -> {
                if(train.getTrainNumber().equals(checkTrainNum.get())){ fail("Non unique num");}
                else checkTrainNum.set(train.getTrainNumber());
            });
        }catch (Exception e){
            fail(e);
        }
    }
}
