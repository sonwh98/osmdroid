package org.osmdroid.debug.model;

import android.database.Cursor;
import android.util.Log;

import org.osmdroid.api.IMapView;
import org.osmdroid.tileprovider.modules.SqlTileWriter;

import java.util.ArrayList;
import java.util.List;

import static org.osmdroid.tileprovider.modules.DatabaseFileArchive.COLUMN_KEY;
import static org.osmdroid.tileprovider.modules.DatabaseFileArchive.COLUMN_PROVIDER;
import static org.osmdroid.tileprovider.modules.DatabaseFileArchive.TABLE;

/**
 * created on 12/21/2016.
 *
 * @author Alex O'Ree
 */

public class SqlTileWriterExt extends SqlTileWriter {

    public Cursor select(int rows, int offset){
        if (db!=null)
            return db.rawQuery("select " + COLUMN_KEY +","+ COLUMN_EXPIRES + "," + COLUMN_PROVIDER + " from " + TABLE + " limit ? offset ?",new String[]{rows+"", offset+""});
        return null;
    }

    /**
     * gets all the tiles sources that we have tiles for in the cache database and their counts
     * @return
     */
    public List<SourceCount> getSources(){
        List<SourceCount> ret = new ArrayList<>();
        if (db!=null) {
            Cursor cur = db.rawQuery("select distinct (" + COLUMN_PROVIDER + ") from " + TABLE, null);
            while (cur.moveToNext()){
                String prov=cur.getString(cur.getColumnIndex(COLUMN_PROVIDER));
                SourceCount c = new SourceCount();
                c.source=prov;
                c.rowCount = getRowCount(prov);
                ret.add(c);
            }
        }
        return ret;

    }

    public long getRowCountExpired() {
        long count=0;
        try {
            Cursor mCount = null;

            mCount = db.rawQuery("select count(*) from " + TABLE + " where " + COLUMN_EXPIRES + " < '" + System.currentTimeMillis()+ "'", null);
            if (mCount.moveToFirst()) {
                count = mCount.getLong(0);
            }
            mCount.close();
        } catch (Throwable ex) {
            Log.e(IMapView.LOGTAG, "Unable to query for expired tiles" , ex);
        }
        return count;
    }

    public static class SourceCount{
        public long rowCount=0;
        public String source=null;
    }

}
