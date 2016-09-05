package selfshaper.com.realtimerailtimes.stations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import selfshaper.com.realtimerailtimes.api.OpenDataTranslinkAPIService;
import selfshaper.com.realtimerailtimes.model.stations.Station;

import static org.mockito.Mockito.verify;
import static selfshaper.com.realtimerailtimes.stations.RestServiceTestHelper.convertStreamToString;
import static selfshaper.com.realtimerailtimes.stations.RestServiceTestHelper.returnResponseFromServer;

/**
 * Created by Paul.Allan on 14/08/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StationsPresenterTest {

    @Mock
    private StationsView stationsView;
    private OpenDataTranslinkAPIService apiService;
    private StationsPresenter stationsPresenter;

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @Test
    public void testOnCreateView() throws Exception {

        CountDownLatch lock = new CountDownLatch(1);

        String json = convertStreamToString(this.getClass().getClassLoader().getResourceAsStream("response.json"));

        apiService =  new Retrofit.Builder()
                        .baseUrl(server.url("/"))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                .create(OpenDataTranslinkAPIService.class);

        CountDownLatch latch = returnResponseFromServer(server, new MockResponse().setBody(json));

        stationsPresenter = new StationsPresenter(stationsView, apiService);
        stationsPresenter.onCreateView();

        latch.await();

        verify(stationsView).populateStations(new ArrayList<Station>()
        {{
            add(new Station("3042A0", "Adelaide"));
            add(new Station("3042A1", "Antrim"));
            add(new Station("3042A3", "Ballycarry"));
            add(new Station("3042A2", "Ballymena"));
            add(new Station("3042AA", "Ballymoney"));
            add(new Station("3042A5", "Balmoral"));
            add(new Station("3042A7", "Bangor"));
            add(new Station("3042A9", "Bangor West"));
            add(new Station("3043AF", "Belfast Central"));
            add(new Station("3042A6", "Bellarena"));
            add(new Station("3042A8", "Botanic"));
            add(new Station("3042AB", "Carnalea"));
            add(new Station("3043B1", "Carrickfergus"));
            add(new Station("3042AE", "Castlerock"));
            add(new Station("3042AD", "City Hospital"));
            add(new Station("3043B0", "Clipperstown"));
            add(new Station("3042AC", "Coleraine"));
            add(new Station("3043B3", "Cullybackey"));
            add(new Station("3043B2", "Cultra"));
            add(new Station("3043B5", "Derriaghy"));
            add(new Station("3043BA", "Dhu Varren"));
            add(new Station("3043B9", "Downshire"));
            add(new Station("3043B4", "Drogheda"));
            add(new Station("3043B8", "Dublin Connolly"));
            add(new Station("3043B6", "Dundalk"));
            add(new Station("3043B7", "Dunmurry"));
            add(new Station("3043BB", "Finaghy"));
            add(new Station("3044BD", "Glynn"));
            add(new Station("3044BE", "Great Victoria St"));
            add(new Station("3043BC", "Greenisland"));
            add(new Station("3044BF", "Helen's Bay"));
            add(new Station("3044C0", "Hilden"));
            add(new Station("3044C1", "Holywood"));
            add(new Station("3044C2", "Jordanstown"));
            add(new Station("3044C4", "Lambeg"));
            add(new Station("3044C6", "Larne Harbour"));
            add(new Station("3044C5", "Larne Town"));
            add(new Station("3044C3", "Lisburn"));
            add(new Station("3044C8", "Londonderry"));
            add(new Station("3044C7", "Lurgan"));
            add(new Station("3044C9", "Magheramorne"));
            add(new Station("3044CA", "Marino"));
            add(new Station("3045CB", "Moira"));
            add(new Station("3045CC", "Mossley West"));
            add(new Station("3045CD", "Newry"));
            add(new Station("3045CE", "Portadown"));
            add(new Station("3045CF", "Portrush"));
            add(new Station("3045D0", "Poyntzpass"));
            add(new Station("3045D1", "Scarva"));
            add(new Station("3045D2", "Seahill"));
            add(new Station("3045D3", "Sydenham"));
            add(new Station("3042A4", "Titanic Quarter"));
            add(new Station("3045D4", "Trooperslane"));
            add(new Station("3045D5", "University"));
            add(new Station("3045D7", "Whiteabbey"));
            add(new Station("3045D6", "Whitehead"));
            add(new Station("3045D8", "Yorkgate"));
        }});

        lock.countDown();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}