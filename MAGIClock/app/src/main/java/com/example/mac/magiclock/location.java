package com.example.mac.magiclock;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Debug;
import android.provider.Settings;

import android.widget.TextView;
import android.widget.Toast;

public class location extends Activity implements LocationListener {
    /** Called when the activity is first created. */
    private boolean getService = false;		//¨Oß_§w∂}±“©w¶Ï™A∞»
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        testLocationProvider();		//¿À¨d©w¶Ï™A∞»
    }

    private void testLocationProvider() {
        //®˙±o®t≤Œ©w¶Ï™A∞»
        LocationManager status = (LocationManager) (this.getSystemService(Context.LOCATION_SERVICE));
        if (status.isProviderEnabled(LocationManager.GPS_PROVIDER) || status.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            getService = true;	//ΩTª{∂}±“©w¶Ï™A∞»
            locationServiceInitial();
        } else {
            Toast.makeText(this, "testLocationProvider fail", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));	//∂}±“≥]©w≠∂≠±
        }
    }

    private LocationManager lms;
    private String bestProvider = LocationManager.GPS_PROVIDER;	//≥Ã®Œ∏Í∞T¥£®—™Ã
    private void locationServiceInitial() {
        lms = (LocationManager) getSystemService(LOCATION_SERVICE);	//®˙±o®t≤Œ©w¶Ï™A∞»
        Criteria criteria = new Criteria();	//∏Í∞T¥£®—™ÃøÔ®˙º–∑«
        bestProvider = lms.getBestProvider(criteria, true);	//øÔæ‹∫Î∑«´◊≥Ã∞™™∫¥£®—™Ã
        Location location = lms.getLastKnownLocation(bestProvider);
        getLocation(location);
    }

    private void getLocation(Location location) {	//±N©w¶Ï∏Í∞T≈„•‹¶bµe≠±§§
        if(location != null) {
            Toast.makeText(this, "Hello!", Toast.LENGTH_LONG).show();
//            TextView longitude_txt = (TextView) findViewById(R.id.longitude);
//            TextView latitude_txt = (TextView) findViewById(R.id.latitude);
//            TextView place_txt = (TextView) findViewById(R.id.place_text);

//            Double longitude = location.getLongitude();	//®˙±o∏g´◊
//            Double latitude = location.getLatitude();	//®˙±oΩn´◊
//
//            longitude_txt.setText(String.valueOf(longitude));
//            latitude_txt.setText(String.valueOf(latitude));
//            place_txt.setText(getAddressByLocation(location));
        }
        else {
            Toast.makeText(this, "can't define", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if(getService) {
            lms.requestLocationUpdates(bestProvider, 1000, 1, this);
            //™A∞»¥£®—™Ã°BßÛ∑s¿W≤v60000≤@¨Ì=1§¿ƒ¡°B≥Ãµu∂Z¬˜°B¶a¬IßÔ≈‹Æ…©I•s™´•Û
        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        if(getService) {
            lms.removeUpdates(this);	//¬˜∂}≠∂≠±Æ…∞±§ÓßÛ∑s
        }
    }

    @Override
    protected void onRestart() {	//±q®‰•¶≠∂≠±∏ı¶^Æ…
        // TODO Auto-generated method stub
        super.onRestart();
        testLocationProvider();
    }

    @Override
    public void onLocationChanged(Location location) {	//∑Ì¶a¬IßÔ≈‹Æ…
        // TODO Auto-generated method stub
        getLocation(location);
    }

    @Override
    public void onProviderDisabled(String arg0) {	//∑ÌGPS©Œ∫Ù∏Ù©w¶Ï•\Ø‡√ˆ≥¨Æ…
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String arg0) {	//∑ÌGPS©Œ∫Ù∏Ù©w¶Ï•\Ø‡∂}±“
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {	//©w¶Ï™¨∫AßÔ≈‹
        // TODO Auto-generated method stub
    }
    public String getAddressByLocation(Location location) {
        String returnAddress = "";
        try {
            if (location != null) {
                Double longitude = location.getLongitude();	//®˙±o∏g´◊
                Double latitude = location.getLatitude();	//®˙±oΩn´◊

                Double lo1 = 121.54159248;
                Double la1 = 25.01943363;
                Double d_lo1 = 0.00069201;
                Double d_la1 = 0.00057116999;

                if( Math.abs(lo1-longitude) < d_lo1 &&  Math.abs(la1-latitude) < d_la1)
                    returnAddress = "德田";
                else if(Math.abs(25.04189446-latitude) < 0.00030619 && Math.abs(121.52355731 - longitude) < 0.00078857)
                    returnAddress = "男四/女四";
                else if(Math.abs(25.02011903-latitude) < 0.00085554 && Math.abs(121.53766036 - longitude) < 0.00067592)
                    returnAddress = "醉月湖";
                else if(Math.abs(25.01764961-latitude) <0.00092362 && Math.abs(121.5409863 - longitude) <0.00049353)
                    returnAddress = "圖書館";
                else
                    returnAddress = "somewhere";

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return returnAddress;
    }
}