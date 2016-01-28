package org.osmdroid.google.sample;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assume;
import org.osmdroid.google.wrapper.v2.MapFactory;

/**
 * Created by alex on 1/27/16.
 */
public class Googlev2WrapperTest  extends ActivityInstrumentationTestCase2<Googlev2WrapperSample> {

    public Googlev2WrapperTest() {
        super(Googlev2WrapperSample.class);
    }

    public void testActivity() {
        boolean isSupported = MapFactory.isGoogleMapsV2Supported(getActivity());
        if(isSupported) {

            Googlev2WrapperSample activity = getActivity();
            assertNotNull(activity);
        }
    }
}

