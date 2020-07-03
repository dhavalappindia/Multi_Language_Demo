package utils;

import android.content.Context;
import android.content.SharedPreferences;


public class MyPreference {
    SharedPreferences myPrefs;
    SharedPreferences.Editor prefEditor;
    Context context;


    @SuppressWarnings("static-access")
    public MyPreference(Context context) {
        this.context = context;
        myPrefs = context.getSharedPreferences("language_data", context.MODE_PRIVATE);
    }

    public void clearPrefs() {
        prefEditor = myPrefs.edit();
        prefEditor.clear();
        prefEditor.commit();
    }


    public int getSelectedLanmguagePosition() {
        return myPrefs.getInt("language_position", 0);
    }

    /*----------------------------------------restaurant_id-----------------------------------------*/
    public void setSelectedLanmguagePosition(int language_position) {
        prefEditor = myPrefs.edit();
        prefEditor.putInt("language_position", language_position);
        prefEditor.commit();

    }


}
