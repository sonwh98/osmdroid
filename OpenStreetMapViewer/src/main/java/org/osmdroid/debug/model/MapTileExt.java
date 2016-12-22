package org.osmdroid.debug.model;

import org.osmdroid.tileprovider.MapTile;

/**
 * created on 12/20/2016.
 *
 * @author Alex O'Ree
 */

public class MapTileExt extends MapTile{
    public MapTileExt(int zoomLevel, int tileX, int tileY) {
        super(zoomLevel, tileX, tileY);
    }
    public String source;
    public long key=0;

}
