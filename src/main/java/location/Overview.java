package location;

import java.time.LocalTime;

public class Overview {
    private String address;
    private LocalTime closesAt;
    private String phone;
    private String website;
    
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