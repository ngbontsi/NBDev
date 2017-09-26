package development.ngbontsi.com.constants;

/**
 * Created by nbontsi on 2017/06/29.
 */

public enum ModelConstants {
    Address("ADDRESS"),
    Commercial("COMMERCIAL"),
    Contacts("CONTACTS"),
    Event("EVENT"),
    EventStatus("EVENTSTATUS"),
    EventType("EVENTTYPE"),
    Organiser("ORGANISER"),
    User("USER"),
    Venue("VENUE"),
    VenueFacility("VENUEFACILITY"),
    Screen("SCREEN_NAME");

    private String model;
    private ModelConstants(String model){
        this.model = model;
    }
}
