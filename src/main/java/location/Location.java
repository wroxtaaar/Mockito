package location;

import java.time.LocalTime;

import helper.Helper;

public class Location {
    // this value is used to create locationId value
    private static int count = 0;

    private int locationId;
    private String address;
    private LocalTime closesAt;
    private String phone;
    private String website;
    
    private Helper helper;
    
    public Location(String address, LocalTime closesAt, String phone, String website) {
        this.locationId = count++;
        this.address = address;
        this.closesAt = closesAt;
        this.phone = phone;
        this.website = website;
    }

    public boolean call(String platformType, LocalTime currTime) {
        if (this.closesAt.isBefore(currTime)) {
            boolean callResult = helper.call(this.phone, platformType);
            return callResult;
        } else {
            return false;
        }
    }

    // check if the location is open
    public boolean isOpen(LocalTime time) {
        if (this.closesAt == null) {
            return false;
        }

        return time.isBefore(this.closesAt);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getClosesAt() {
        return closesAt;
    }

    public void setClosesAt(LocalTime closesAt) {
        this.closesAt = closesAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }






    
}