package external.uber;

import external.uber.model.PriceEstimate;
import internal.helper.GoogleMapsHelper;
import org.springframework.web.client.RestTemplate;

public class ExternalUberService {

  private static final String BASE_URL = "https://api.uber.com";
  private static final String PRICE_ESTIMATE_ENDPOINT = "/v1.2/estimates/price";

  private String startLatitude;
  private String startLongitude;
  private String endLatitude;
  private String endLongitude;

  private PriceEstimate[] priceEstimates;

  private RestTemplate restTemplate;
  private GoogleMapsHelper googleMapsHelper;

  /**
   * Gets the price estimate of various Uber cabs given the start and end coordinates.
   *
   * @param startLatitude of type Double.
   * @param startLongitude of type Double.
   * @param endLatitude of type Double.
   * @param endLongitude of type Double.
   * @return Price estimate of various Uber cab types like UberGo, UberXL.
   * - If the latitude/longitude are invalid, returns an empty array.
   * - Handles any UberAPI related issues gracefully.
   */
  public PriceEstimate[] getPriceEstimates(Double startLatitude, Double startLongitude,
      Double endLatitude, Double endLongitude) {
    // Validate location coordinates
    if (!googleMapsHelper.isValidLocation(startLatitude, startLongitude,
        endLatitude, endLongitude)) {
      // If the location is invalid, return an empty array.
      return new PriceEstimate[0];
    }
    // Construct the UberAPI url based on the source/destination coordinates.
    String priceEstimateBaseUrl = buildPriceEstimateBaseUrl(startLatitude, startLongitude,
        endLatitude, endLongitude);

    // TODO: If you uncomment the following line, your restTemplate mock won't work.
    // restTemplate = new RestTemplate();

    // Get data by making Uber API call.
    // RestTemplate in Java helps you call an API.
    PriceEstimate[] priceEstimates = restTemplate.getForObject(
        priceEstimateBaseUrl, PriceEstimate[].class);
    return priceEstimates;
  }

  public String buildPriceEstimateBaseUrl(Double startLatitude, Double startLongitude,
      Double endLatitude, Double endLongitude) {
    String urlParameters =
        String.format("?start_latitude=%f&start_longitude=%f&end_latitude=%f&end_longitude=%f",
            startLatitude, startLongitude, endLatitude, endLongitude);
    String apiUrl = new StringBuilder().append(BASE_URL)
        .append(PRICE_ESTIMATE_ENDPOINT)
        .append(urlParameters)
        .toString();

    return apiUrl;
  }

  public String getStartLatitude() {
    return startLatitude;
  }

  public void setStartLatitude(String startLatitude) {
    this.startLatitude = startLatitude;
  }

  public String getStartLongitude() {
    return startLongitude;
  }

  public void setStartLongitude(String startLongitude) {
    this.startLongitude = startLongitude;
  }

  public String getEndLatitude() {
    return endLatitude;
  }

  public void setEndLatitude(String endLatitude) {
    this.endLatitude = endLatitude;
  }

  public String getEndLongitude() {
    return endLongitude;
  }

  public void setEndLongitude(String endLongitude) {
    this.endLongitude = endLongitude;
  }

  public PriceEstimate[] getPriceEstimates() {
    return priceEstimates;
  }

  public void setPriceEstimates(PriceEstimate[] priceEstimates) {
    this.priceEstimates = priceEstimates;
  }

  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void setHelper(GoogleMapsHelper googleMapsHelper) {
    this.googleMapsHelper = googleMapsHelper;
  }

}