import java.sql.ResultSet;
import java.sql.SQLException;

public class roompojo {
	
	private int room_id;
	private String room_name;
	private String location;
	private int capacity;
	private String projector;
	private String monitor;
	private String whiteboard;
	
	
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getProjector() {
		return projector;
	}
	public void setProjector(String projector) {
		this.projector = projector;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getWhiteboard() {
		return whiteboard;
	}
	public void setWhiteboard(String whiteboard) {
		this.whiteboard = whiteboard;
	}
	
	public roompojo (ResultSet resultSet) throws SQLException
    {
       // this.room_id = resultSet.getInt("room_id");
        this.room_name = resultSet.getString("room_name");
        this.location = resultSet.getString("location");
    	this.capacity = resultSet.getInt("capacity");
    	this.projector= resultSet.getString("projector");
    	this.monitor = resultSet.getString("monitor");
    	this.whiteboard = resultSet.getString("whiteboard");
    }

}
