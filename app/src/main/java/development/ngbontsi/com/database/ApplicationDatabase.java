package development.ngbontsi.com.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import development.ngbontsi.com.interfaces.AddressDAO;
import development.ngbontsi.com.interfaces.CommercialDAO;
import development.ngbontsi.com.interfaces.ContactDAO;
import development.ngbontsi.com.interfaces.EventDAO;
import development.ngbontsi.com.interfaces.EventStatusDAO;
import development.ngbontsi.com.interfaces.EventTypeDAO;
import development.ngbontsi.com.interfaces.LoginDAO;
import development.ngbontsi.com.interfaces.OrganizerDAO;
import development.ngbontsi.com.interfaces.UserDAO;
import development.ngbontsi.com.interfaces.VenueDAO;
import development.ngbontsi.com.interfaces.VenueFacilityDAO;
import development.ngbontsi.com.model.Address;
import development.ngbontsi.com.model.Commercial;
import development.ngbontsi.com.model.Contact;
import development.ngbontsi.com.model.Event;
import development.ngbontsi.com.model.EventStatus;
import development.ngbontsi.com.model.EventType;
import development.ngbontsi.com.model.Login;
import development.ngbontsi.com.model.Organizer;
import development.ngbontsi.com.model.User;
import development.ngbontsi.com.model.Venue;
import development.ngbontsi.com.model.VenueFacility;

@Database(entities = {User.class, Address.class, Commercial.class, Contact.class, Event.class, EventType.class, Organizer.class, Venue.class, EventStatus.class, VenueFacility.class, Login.class},
version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

	private  static ApplicationDatabase INSTANCE;

	public abstract  UserDAO userDAO();
	public abstract AddressDAO addressDAO();
	public abstract CommercialDAO commercialDAO();
	public abstract ContactDAO contactDAO();
	public abstract EventDAO eventDAO();
	public abstract EventStatusDAO eventStatusDAO();
	public abstract EventTypeDAO eventTypeDAO();
	public abstract OrganizerDAO organizerDAO();
	public abstract VenueDAO venueDAO();
	public abstract VenueFacilityDAO venueFacilityDAO();
	public abstract LoginDAO loginDAO();

	public static ApplicationDatabase getAppDatabase(Context context){
		if (INSTANCE == null) {
			INSTANCE =
					Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, "event-database")
							// allow queries on the main thread.
							// Don't do this on a real app! See PersistenceBasicSample for an example.
							.allowMainThreadQueries()
							.build();
		}
		return INSTANCE;
	}

	public static void destroyInstance(){
		INSTANCE=null;
	}
}
