package development.ngbontsi.com.model;

/**
 * Created by nbontsi on 2017/06/07.
 */

public class Event {
    private int event_id;
    private int event_status_id;
    private int event_type_id;
    private int event_commercial_id;
    private int organizer_id;
    private int venue_id;
    private  String name;
    private  String startDate;
    private  String endDate;



    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getEvent_status_id() {
        return event_status_id;
    }

    public void setEvent_status_id(int event_status_id) {
        this.event_status_id = event_status_id;
    }

    public int getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(int event_type_id) {
        this.event_type_id = event_type_id;
    }

    public int getEvent_commercial_id() {
        return event_commercial_id;
    }

    public void setEvent_commercial_id(int event_commercial_id) {
        this.event_commercial_id = event_commercial_id;
    }

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
