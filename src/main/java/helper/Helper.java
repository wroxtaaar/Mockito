package helper;

public interface Helper {
    // supported platform keywords - "android", "ios"
    // returns false if call wasn't made
    // returns false for unsupported platform type
    public boolean call(String number, String platformType);

    // Lat -> -90 to +90 Long -> -180 to +180
    public boolean isValidLocation(String startLatitude, String startLongitude, String endLatitude, String endLongitude);
    
}