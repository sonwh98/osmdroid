package org.osmdroid.google.sample;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assume;
import org.osmdroid.google.wrapper.v2.MapFactory;

/**
 * Created by alex on 1/27/16.
 */
public class BingSourceTest   extends ActivityInstrumentationTestCase2<OsmMapActivity> {

    public BingSourceTest() {
        super(OsmMapActivity.class);
    }

    public void testActivity() {

        OsmMapActivity activity = getActivity();
        assertNotNull(activity);
        //it would be nice to have some verification that the tiles loaded...
    }
}

