package cab.uber.dto;

public class PriceEstimate {

    private String localized_display_name;
    private double distance;
    private String display_name;
    private String product_id;
    private int high_estimate;
    private int low_estimate;
    private int duration;
    private String estimate;
    private String currency_code;

    public String getLocalized_display_name() {
        return localized_display_name;
    }

    public void setLocalized_display_name(String localized_display_name) {
        this.localized_display_name = localized_display_name;
    }

    // more getters and setters for the rest of the fields
    // ...
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getHigh_estimate() {
        return high_estimate;
    }

    public void setHigh_estimate(int high_estimate) {
        this.high_estimate = high_estimate;
    }

    public int getLow_estimate() {
        return low_estimate;
    }

    public void setLow_estimate(int low_estimate) {
        this.low_estimate = low_estimate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

}