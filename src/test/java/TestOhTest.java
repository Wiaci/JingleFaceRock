import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestOhTest {

    @Test
    public void test1() {
        PointWork pointWork = new PointWork(false);
        Map<String, String> pointData = new HashMap<>();
        pointData.put("x", "0");
        pointData.put("y", "0");
        pointData.put("r", "0");

        Point point = pointWork.getPoint(pointData);

        Assert.assertTrue(point.isInArea());
    }

    @Test
    public void test2() {
        PointWork pointWork = new PointWork(false);
        Map<String, String> pointData = new HashMap<>();
        pointData.put("x", "0");
        pointData.put("y", "0");
        pointData.put("r", "0");

        Point point = pointWork.getPoint(pointData);

        Assert.assertEquals(0, point.getR(), 0.0001);
    }

    @Test
    public void testFailure() {
        Assert.fail("Вы облажались");
    }
}
