package selfshaper.com.realtimerailtimes.stations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import selfshaper.com.realtimerailtimes.api.OpenDataClient;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.model.stations.Station;

import static org.mockito.Mockito.verify;

/**
 * Created by Paul.Allan on 14/08/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StationsPresenterTest {

    @Mock
    private StationsView stationsView;
    //@Mock
    private OpenDataTranslinkAPIService apiService;
    private StationsPresenter stationsPresenter;

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
        //OpenDataClient.BASE_URL = server.url("/").toString();
    }

    @Test
    public void testOnCreateView() throws Exception {

        CountDownLatch lock = new CountDownLatch(1);

        server.enqueue(new MockResponse().setResponseCode(200)
                .setBody("{\n" +
                        "  \"stations\": [\n" +
                        "    {\n" +
                        "      \"code\": \"3042A0\",\n" +
                        "      \"name\": \"Adelaide\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A1\",\n" +
                        "      \"name\": \"Antrim\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A3\",\n" +
                        "      \"name\": \"Ballycarry\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A2\",\n" +
                        "      \"name\": \"Ballymena\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042AA\",\n" +
                        "      \"name\": \"Ballymoney\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A5\",\n" +
                        "      \"name\": \"Balmoral\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A7\",\n" +
                        "      \"name\": \"Bangor\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A9\",\n" +
                        "      \"name\": \"Bangor West\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043AF\",\n" +
                        "      \"name\": \"Belfast Central\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A6\",\n" +
                        "      \"name\": \"Bellarena\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A8\",\n" +
                        "      \"name\": \"Botanic\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042AB\",\n" +
                        "      \"name\": \"Carnalea\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B1\",\n" +
                        "      \"name\": \"Carrickfergus\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042AE\",\n" +
                        "      \"name\": \"Castlerock\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042AD\",\n" +
                        "      \"name\": \"City Hospital\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B0\",\n" +
                        "      \"name\": \"Clipperstown\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042AC\",\n" +
                        "      \"name\": \"Coleraine\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B3\",\n" +
                        "      \"name\": \"Cullybackey\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B2\",\n" +
                        "      \"name\": \"Cultra\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B5\",\n" +
                        "      \"name\": \"Derriaghy\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043BA\",\n" +
                        "      \"name\": \"Dhu Varren\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B9\",\n" +
                        "      \"name\": \"Downshire\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B4\",\n" +
                        "      \"name\": \"Drogheda\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B8\",\n" +
                        "      \"name\": \"Dublin Connolly\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B6\",\n" +
                        "      \"name\": \"Dundalk\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043B7\",\n" +
                        "      \"name\": \"Dunmurry\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043BB\",\n" +
                        "      \"name\": \"Finaghy\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044BD\",\n" +
                        "      \"name\": \"Glynn\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044BE\",\n" +
                        "      \"name\": \"Great Victoria St\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3043BC\",\n" +
                        "      \"name\": \"Greenisland\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044BF\",\n" +
                        "      \"name\": \"Helen's Bay\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C0\",\n" +
                        "      \"name\": \"Hilden\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C1\",\n" +
                        "      \"name\": \"Holywood\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C2\",\n" +
                        "      \"name\": \"Jordanstown\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C4\",\n" +
                        "      \"name\": \"Lambeg\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C6\",\n" +
                        "      \"name\": \"Larne Harbour\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C5\",\n" +
                        "      \"name\": \"Larne Town\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C3\",\n" +
                        "      \"name\": \"Lisburn\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C8\",\n" +
                        "      \"name\": \"Londonderry\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C7\",\n" +
                        "      \"name\": \"Lurgan\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044C9\",\n" +
                        "      \"name\": \"Magheramorne\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3044CA\",\n" +
                        "      \"name\": \"Marino\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045CB\",\n" +
                        "      \"name\": \"Moira\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045CC\",\n" +
                        "      \"name\": \"Mossley West\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045CD\",\n" +
                        "      \"name\": \"Newry\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045CE\",\n" +
                        "      \"name\": \"Portadown\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045CF\",\n" +
                        "      \"name\": \"Portrush\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D0\",\n" +
                        "      \"name\": \"Poyntzpass\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D1\",\n" +
                        "      \"name\": \"Scarva\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D2\",\n" +
                        "      \"name\": \"Seahill\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D3\",\n" +
                        "      \"name\": \"Sydenham\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3042A4\",\n" +
                        "      \"name\": \"Titanic Quarter\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D4\",\n" +
                        "      \"name\": \"Trooperslane\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D5\",\n" +
                        "      \"name\": \"University\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D7\",\n" +
                        "      \"name\": \"Whiteabbey\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D6\",\n" +
                        "      \"name\": \"Whitehead\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"code\": \"3045D8\",\n" +
                        "      \"name\": \"Yorkgate\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"));

        apiService =  new Retrofit.Builder()
                        .baseUrl(server.url("/"))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(OpenDataTranslinkAPIService.class);

        stationsPresenter = new StationsPresenter(stationsView, apiService);
        stationsPresenter.onCreateView();

        lock.await(5, TimeUnit.SECONDS);

        verify(stationsView).populateStations(new ArrayList<Station>()
            {{
                add(new Station("3042A0", "Adelaide"));
                add(new Station("3042A1", "Antrim"));
                add(new Station("3042A3", "Ballycarry"));

                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));
                add(new Station("3042A3", "Ballycarry"));

            }});
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}