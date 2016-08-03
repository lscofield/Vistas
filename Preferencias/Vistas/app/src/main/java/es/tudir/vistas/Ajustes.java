package es.tudir.vistas;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;

public class Ajustes extends AppCompatPreferenceActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            carga(2);
                getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            carga(1);
        }

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.configuracion);
        }
    }

    private void carga(int cod){

        if (cod == 1) {
            addPreferencesFromResource(R.xml.configuracion);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}
