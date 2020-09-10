package external.uber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import external.uber.model.PriceEstimate;
import internal.helper.GoogleMapsHelper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class ExternalUberServiceTest {

  @Mock
  private GoogleMapsHelper googleMapsHelperMock;
  @Mock
  private RestTemplate restTemplateMock;
  @InjectMocks
  private ExternalUberService externalUberService;

  @Test
  public void getPriceEstimateBaseUrlTest() {
    // Pure Junit test
    Double startLatitude = 37.7752315;
    Double startLongitude = -122.418075;
    Double endLatitude = 37.7752415;
    Double endLongitude = -122.518075;
    ExternalUberService externalUberService = new ExternalUberService();
    String expectedUrl = "https://api.uber.com/v1.2/estimates/price?start_latitude=37.7752315&start_longitude=-122.418075&end_latitude=37.7752415&end_longitude=-122.518075";

    String actualUrl = externalUberService
        .buildPriceEstimateBaseUrl(startLatitude, startLongitude, endLatitude, endLongitude);

    assertEquals(expectedUrl, actualUrl);
  }

  @Test
  public void getPriceEstimatesReturnsEmptyArrayOnInvalidStartLatitudeTest() {
    /*
     * Code Under Test: GetUber.getPriceEstimates()
     * Test case: Check if GetUber.getPriceEstimates() returns empty array on invalid latitude for start location
     * Dependency Layer/Function:
     *      1. helperMock.isValidLocation(String startLatitude, String startLongitude, String endLatitude, String endLongitude);
     * Mock Setup:
     *      - Function to mock: helperMock.isValidLocation()
     *          - Input to mock: (some invalid start latitude, any start longitude, any end latitude, any end longitude)
     *          - Pre-set output from mock: false
     * Test Input:   getUber.getPriceEstimates(parameters should be inline with your mock setup)
     * Expected Test Output: Empty price estimate array
     */

    // Setup
    Double startLatitude = 137.7752315;
    Double startLongitude = -122.418075;
    Double endLatitude = 37.7752415;
    Double endLongitude = -122.518075;
    // GetUber getUber = new GetUber();

    // Setup mocks to return preset value of false
    // when startLatitude parameter is 137.7752315
    externalUberService.setHelper(googleMapsHelperMock);
    when(googleMapsHelperMock
        .isValidLocation(eq(137.7752315), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(false);

    // get output of the method under test
    PriceEstimate[] actualPriceEstimates = externalUberService
        .getPriceEstimates(startLatitude, startLongitude, endLatitude,
            endLongitude);

    // check if the returned value matches expected value
    int expectedLength = 0;
    assertEquals(expectedLength, actualPriceEstimates.length);

  }

  @Test
  public void getPriceEstimatesValidLocationReturnsPriceEstimatesTest()
      throws JsonParseException, RestClientException, JsonMappingException, IOException {
    /*
     * Code Under Test: GetUber.getPriceEstimates()
     * Test case: Check if GetUber.getPriceEstimates() returns data on valid location coordinates
     * Dependency Layer/Function:
     *      1. helperMock.isValidLocation(String startLatitude, String startLongitude, String endLatitude, String endLongitude);
     * Mock Setup:
     *      - Function to mock: helperMock.isValidLocation()
     *          - Input to mock: (any start latitude, any start longitude, any end latitude, any end longitude)
     *          - Pre-set output from mock: true
     * Test Input:   getUber.getPriceEstimates(parameters should be inline with your mock setup)
     * Expected Test Output: Non-empty array matching contents of file data is read from
     */
    Double startLatitude = 37.7752315;
    Double startLongitude = -122.418075;
    Double endLatitude = 37.7752415;
    Double endLongitude = -122.518075;
    // GetUber getUber = new GetUber();
    PriceEstimate[] expectedPriceEstimates = loadPriceEstimateList();
    String url = "https://api.uber.com/v1.2/estimates/price?start_latitude=37.7752315&start_longitude=-122.418075&end_latitude=37.7752415&end_longitude=-122.518075";

    when(googleMapsHelperMock.isValidLocation(anyDouble(), anyDouble(), anyDouble(), anyDouble()))
        .thenReturn(true);
    when(restTemplateMock.getForObject(eq(url), eq(PriceEstimate[].class)))
        .thenReturn(expectedPriceEstimates);

    PriceEstimate[] actualPriceEstimates = externalUberService
        .getPriceEstimates(startLatitude, startLongitude, endLatitude,
            endLongitude);

    assertEquals(3, actualPriceEstimates.length);
    assertEquals("₹110-140", actualPriceEstimates[0].getEstimate());
    assertEquals("₹110-130", actualPriceEstimates[1].getEstimate());
    assertEquals("₹210", actualPriceEstimates[2].getEstimate());

  }

  private PriceEstimate[] loadPriceEstimateList()
      throws JsonParseException, JsonMappingException, IOException {
    File file = new File("src/test/resources/price_estimate.json");
    ObjectMapper objectMapper = new ObjectMapper();

    PriceEstimate[] priceEstimates = objectMapper.readValue(file, PriceEstimate[].class);
    return priceEstimates;

  }
}