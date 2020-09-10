package internal.helper;

public interface GoogleMapsHelper {

  // supported platform keywords - "android", "ios"
  // returns false if call wasn't made
  // returns false for unsupported platform type
  public boolean callBusiness(String latitude, String longitude);

  // Lat -> -90 to +90 Long -> -180 to +180
  public boolean isValidLocation(Double startLatitude, Double startLongitude,
      Double endLatitude, Double endLongitude);

}