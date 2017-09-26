package development.ngbontsi.com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import development.ngbontsi.com.util.DatabaseCreation;

public class DatabaseHelper extends SQLiteOpenHelper {


	private static final int DATABASE_VERSION =1;
	private static final String DATABASE_NAME="UserManager.db";
	public static final String TABLE_USER="user";
	public static final String TABLE_ADDRESS="address";
	public static final String TABLE_COMMERCIAL="commercial";
	public static final String TABLE_CONTACT="contact";
	public static final String TABLE_EVENT="event";
	public static final String TABLE_EVENT_STATUS="eventStatus";
	public static final String TABLE_EVENT_TYPE="eventType";
	public static final String TABLE_ORGANIZER="organizer";
	public static final String TABLE_VENUE_FACILITY="venueFacility";
	public static final String TABLE_VENUE="venue";

	//	User table Columns
	public static final String USER_ID ="user_id";
	public static final String USER_NAME ="user_name";
	public static final String USER_EMAIL ="user_email";
	public static final String USER_PASSWORD ="user_password";
	public static final String USER ="user";
	public static final String organiser ="organiser";
	//	Address table Columns
	public static final String ADDRESS_ID="address_id";
	public static final String CITY="city";
	public static final String STREET ="street";
	public static final String LINE_1 ="line_1";
	public static final String LINE_2="line_2";
	public static final String LINE_3="line_3";
	public static final String LINE_4="line_4";
	public static final String POSTAL_CODE="postal_code";

	//	Commercial table Columns
	public static final String COM_EVENT_COMMERCIAL_ID="event_commercial_id";
	public static final String EVENT_COMMERCIAL_DESCRIPTION="event_commercial_description";


	//	Contact table Columns
	public static final String CONTACT_ID="contact_id";
	public static final String C_ORGANIZER_ID="organizer_id";
	public static final String CONTACT_NUMBER="contact_number";
	public static final String C_ADDRESS_ID="address_id";
	public static final String WEB_SITE_ADDRESS="web_site_address";
	public static final String OTHER_DETAILS="other_details";

	//	Event table Columns
	public static final String EVENT_ID="event_id";
	public static final String E_EVENT_STATUS_ID="event_status_id";
	public static final String E_EVENT_TYPE_ID="event_type_id";
	public static final String EVENT_COMMERCIAL_ID="event_commercial_id";
	public static final String E_ORGANIZER_ID="organizer_id";
	public static final String E_VANUE_ID="venue_id";
	public static final String EVENT_NAME="event_name";
	public static final String EVENT_STARTDATE="event_startDate";
	public static final String EVENT_ENDDATE="event_endDate" ;

	//	Event Status table Columns
	public static final String EVENT_STATUS_ID="event_status_id";
	public static final String EVENT_DESCRIPTION ="event_description";

	//	Event Type table Columns
	public static final String EVENT_TYPE_ID="event_type_id";
	public static final String EVENT_TYPE_DESCRIPTION="event_type_description";

	//	Organizer table Columns
	public static final String ORGANIZER_ID="organizer_id";
	public static final String ORGANIZER_NAME="organizer_name";
	public static final String ORGANIZER_EMAIL="organizer_email";
	public static final String ORG_USER_ID="user_id";

	//	Venue table Columns
	public static final String VENUE_ID ="venue_id";
	public static final String VENUE_NAME ="venue_name";
	public static final String V_ADDRESS_ID="address_id";


	//	Venue Facility table Columns
	public static final String F_VANUE_ID="venue_id";
	public static final String FACILITY_CODE="facility_code";
	public static final String FACILITY_DESC="facility_description";

	// create table sql query
	private final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
			+ USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME + " TEXT,"
			+ USER_EMAIL + " TEXT," + USER_PASSWORD + " TEXT,"+ USER+" INTEGER DEFAULT 0)" ;

	private final String CREATE_ADDRESS_TABLE = "CREATE TABLE " + TABLE_ADDRESS + "("
			+ ADDRESS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CITY + " TEXT,"
			+ STREET + " TEXT," + LINE_1 +" TEXT," + LINE_2 +" TEXT," + LINE_3 +" TEXT," + LINE_4 +" TEXT," + POSTAL_CODE + " TEXT" + ")";

	private final String CREATE_COMMERCIAL_TABLE = "CREATE TABLE " + TABLE_COMMERCIAL + "("
			+ COM_EVENT_COMMERCIAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + EVENT_COMMERCIAL_DESCRIPTION+ " TEXT"+ ")";


	private final String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENT + "("
			+ EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + E_EVENT_STATUS_ID+ " INTEGER ,"
			+ E_EVENT_TYPE_ID + " INTEGER,"+EVENT_COMMERCIAL_ID+" INTEGER,"+E_ORGANIZER_ID+" INTEGER,"+E_VANUE_ID+" INTEGER,"+EVENT_NAME+" TEXT,"+EVENT_STARTDATE+" TEXT,"+EVENT_ENDDATE+" TEXT"+ ")";

	private final String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_CONTACT + "("
			+ CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + C_ORGANIZER_ID + " INTEGER,"
			+ C_ADDRESS_ID + " INTEGER," + CONTACT_NUMBER+ " TEXT,"+WEB_SITE_ADDRESS+" TEXT,"+OTHER_DETAILS+" TEXT" + ")";

	private final String CREATE_EVENT_STATUS_TABLE = "CREATE TABLE " + TABLE_EVENT_STATUS + "("
			+ EVENT_STATUS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + EVENT_DESCRIPTION+ " TEXT"+ ")";

	private final String CREATE_ORGANIZER_TABLE = "CREATE TABLE " + TABLE_ORGANIZER + "("
			+ ORGANIZER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + ORGANIZER_NAME+ " TEXT,"
			+ ORGANIZER_EMAIL + " TEXT," + ORG_USER_ID+ " INTEGER" + ")";

	private final String CREATE_EVENT_TYPE_TABLE = "CREATE TABLE " + TABLE_EVENT_TYPE + "("
			+ EVENT_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + EVENT_TYPE_DESCRIPTION + " TEXT"+ ")";

	private final String CREATE_VENUE_FACILITY_TABLE = "CREATE TABLE " + TABLE_VENUE_FACILITY + "("
			+ FACILITY_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT," + FACILITY_DESC + " TEXT,"
			+ E_VANUE_ID + " INTEGER" +")";
	private final String CREATE_VENUE_TABLE = "CREATE TABLE " + TABLE_VENUE + "("
			+ VENUE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + VENUE_NAME + " TEXT,"
			+ V_ADDRESS_ID + " INTEGER" +")";
	// drop table sql query
	private final String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
	private final String DROP_ADDRESS_TABLE = "DROP TABLE IF EXISTS " + TABLE_ADDRESS;
	private final String DROP_COMMERCIAL_TABLE = "DROP TABLE IF EXISTS " + TABLE_COMMERCIAL;
	private final String DROP_CONTACT_TABLE = "DROP TABLE IF EXISTS " + TABLE_CONTACT;
	private final String DROP_EVENT_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENT;
	private final String DROP_EVENT__STATUS_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENT_STATUS;
	private final String DROP_EVENT__TYPE_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENT_TYPE;
	private final String DROP_ORGANIZER_TABLE = "DROP TABLE IF EXISTS " + TABLE_ORGANIZER;
	private final String DROP_VENUE_FACILITY_TABLE = "DROP TABLE IF EXISTS " + TABLE_VENUE_FACILITY;
	private final String DROP_VENUE_TABLE = "DROP TABLE IF EXISTS " + TABLE_VENUE;
	private  DatabaseCreation databaseCreation;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null,DATABASE_VERSION);
		databaseCreation = new DatabaseCreation(context);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(CREATE_USER_TABLE);
		arg0.execSQL(CREATE_ADDRESS_TABLE);
		arg0.execSQL(CREATE_COMMERCIAL_TABLE);
		arg0.execSQL(CREATE_EVENT_TABLE);
		arg0.execSQL(CREATE_CONTACT_TABLE);
		arg0.execSQL(CREATE_EVENT_STATUS_TABLE);
		arg0.execSQL(CREATE_ORGANIZER_TABLE);
		arg0.execSQL(CREATE_EVENT_TYPE_TABLE);
		arg0.execSQL(CREATE_VENUE_FACILITY_TABLE);
		arg0.execSQL(CREATE_VENUE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL(DROP_USER_TABLE);
		arg0.execSQL(DROP_ADDRESS_TABLE);
		arg0.execSQL(DROP_ADDRESS_TABLE);
		arg0.execSQL(DROP_COMMERCIAL_TABLE);
		arg0.execSQL(DROP_CONTACT_TABLE);
		arg0.execSQL(DROP_EVENT_TABLE);
		arg0.execSQL(DROP_EVENT__STATUS_TABLE);
		arg0.execSQL(DROP_EVENT__TYPE_TABLE);
		arg0.execSQL(DROP_ORGANIZER_TABLE);
		arg0.execSQL(DROP_VENUE_FACILITY_TABLE);
		arg0.execSQL(DROP_VENUE_TABLE);
		onCreate(arg0);

	}



}
