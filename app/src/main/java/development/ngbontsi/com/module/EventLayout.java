package development.ngbontsi.com.module;

import android.content.Context;

import java.io.Serializable;
import java.util.List;

import development.ngbontsi.com.database.CommercialDatabase;
import development.ngbontsi.com.database.ApplicationDatabase;
import development.ngbontsi.com.database.EventDatabase;
import development.ngbontsi.com.database.EventStatusDatabase;
import development.ngbontsi.com.database.EventTypeDatabase;
import development.ngbontsi.com.database.OrganizerDatabase;
import development.ngbontsi.com.database.VenueDatabase;
import development.ngbontsi.com.model.Event;



/**
 * Created by nbontsi on 2017/06/13.
 */

public class EventLayout implements Serializable{

    private int id;
    private String name;
    private String status;
    private String type;
    private String commercial;
    private String organizer;
    private String venue;

    public EventLayout(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
