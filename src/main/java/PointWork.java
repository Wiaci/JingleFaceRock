import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "point")
@SessionScoped
public class PointWork implements Serializable {

    DatabaseManager db;
    private double x, y, r;

    public PointWork() {
        db = new DatabaseManager();
    }

    public PointWork(boolean needToConnectToBase) {}

    public List<Point> getPoints() {
        return db.getAll();
    }

    public void clear() {
        db.clear();
    }

    private Map<String, String> getPointParams() {
        return FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
    }

    private boolean isPointInArea(double x, double y, double r) {
        return (x <= 0 && y >= 0 && x*x + y*y <= r*r) || (x >= 0 && y >= 0 && x <= r && y <= r) ||
                (x <= 0 && y <= 0 && y >= -2*x - r);
    }

    public Point getPoint(Map<String, String> params) {
        double x = params.get("x") != null ? Double.parseDouble(params.get("x")) : this.x;
        double y = params.get("y") != null ? Double.parseDouble(params.get("y")) : this.y;
        double r = params.get("r") != null ? Double.parseDouble(params.get("r")) : this.r;
        boolean inArea = isPointInArea(x, y, r);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

        return new Point(Math.round(x*100)/100d, Math.round(y*100)/100d, r, inArea, format.format(date));
    }

    public void addPoint() {
        Map<String, String> params = getPointParams();
        Point point = getPoint(params);
        db.add(point);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
