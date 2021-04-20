import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestOhTest {

    @Test
    public void test1() {
        PointWork pointWork = new PointWork();
        Map<String, String> pointData = new HashMap<>();
        pointData.put("x", "0");
        pointData.put("y", "0");
        pointData.put("r", "0");

        Point point = pointWork.getPoint(pointData);

        Assertions.assertTrue(point.isInArea());

        Assertions.assertEquals(0, point.getR());
    }
}
