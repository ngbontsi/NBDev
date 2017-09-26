package development.ngbontsi.com.model;

import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nbontsi on 2017/06/07.
 */

public class Address {
    @PrimaryKey
    private int address_id;
    private String city;
    private String street;
    private String line_1;
    private String line_2;
    private String line_3;
    private String line_4;
    private int postal_code;


    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLine_1() {
        return line_1;
    }

    public void setLine_1(String line_1) {
        this.line_1 = line_1;
    }

    public String getLine_2() {
        return line_2;
    }

    public void setLine_2(String line_2) {
        this.line_2 = line_2;
    }

    public String getLine_3() {
        return line_3;
    }

    public void setLine_3(String line_3) {
        this.line_3 = line_3;
    }

    public String getLine_4() {
        return line_4;
    }

    public void setLine_4(String line_4) {
        this.line_4 = line_4;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
}
