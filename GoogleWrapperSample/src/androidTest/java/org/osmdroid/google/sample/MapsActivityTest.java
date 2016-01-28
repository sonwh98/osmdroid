package org.osmdroid.google.sample;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assume;
import org.osmdroid.google.wrapper.v2.MapFactory;

/**
 * Created by alex on 1/27/16.
 */
public class MapsActivityTest  extends ActivityInstrumentationTestCase2<MapsActivity> {

    public MapsActivityTest() {
        super(MapsActivity.class);
    }

    public void testActivity() {
        boolean isSupported = MapFactory.isGoogleMapsV2Supported(getActivity());
        if(isSupported) {

            MapsActivity activity = getActivity();
            assertNotNull(activity);
        }
    }
}

