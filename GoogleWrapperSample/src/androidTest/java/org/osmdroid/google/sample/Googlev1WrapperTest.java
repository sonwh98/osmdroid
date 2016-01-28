package org.osmdroid.google.sample;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assume;
import org.osmdroid.google.wrapper.v2.MapFactory;

/**
 * Created by alex on 1/27/16.
 */
public class Googlev1WrapperTest extends ActivityInstrumentationTestCase2<Googlev1WrapperSample> {

    public Googlev1WrapperTest() {
        super(Googlev1WrapperSample.class);
    }

    public void testActivity() {
        boolean isSupported = MapFactory.isGoogleMapsV1Supported();
        if (isSupported) {

            Googlev1WrapperSample activity = getActivity();
            assertNotNull(activity);
        }
    }
}

