package com.example.mac.magiclock;

import android.app.Activity;
import android.content.ContentResolver;
<<<<<<< HEAD
=======
import android.content.ContentValues;
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
<<<<<<< HEAD
=======
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.EditText;
=======
import android.os.Build;
import android.widget.Button;
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
<<<<<<< HEAD
import java.net.Socket;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;

import android.widget.Toast;
import android.view.View.OnClickListener;


public class MyClock extends Activity implements LocationListener  {

    //================== button get postion
    Socket MyClient;

    static Button btn;
    static TextView tv1,tv2,tv_srvr,tv_port;
    static String str1="0", str2="0";

    String msg_from_server;
    //==================
    TextView place_txt;
=======

public class MyClock extends Activity {
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
    TextView textView, textView2;
    //宣告
    private ImageView mImg;
    private DisplayMetrics mPhone;
    //private final static int CAMERA = 66 ;
    private final static int PHOTO = 99 ;

<<<<<<< HEAD
    //location
    private boolean getService = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clock);

=======

    private ImageView secondImage;

    private void findViews() {
        secondImage = (ImageView) findViewById(R.id.img);
    }
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clock);

        findViews();
        secondImage.setImageResource(R.drawable.profile);

>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
        Button btnPrefs = (Button) findViewById(R.id.btnPrefs);
        //Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);
        textView = (TextView) findViewById(R.id.txtPrefs);
        textView2 = (TextView) findViewById(R.id.fmtext);
<<<<<<< HEAD
        place_txt = (TextView) findViewById(R.id.place_txt);

        //========get postion botton
        tv_srvr = (TextView) findViewById(R.id.server);
        tv_port = (TextView) findViewById(R.id.port);
        btn = (Button)findViewById(R.id.get2);
        tv1 = (TextView)findViewById(R.id.position);
        tv2 = (TextView)findViewById(R.id.position2);

        btn.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                str1 = "click";
                Thread t = new thread2();
                t.start();
                try {
                    t.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tv1.setText(str1);
                tv2.setText(str2);
            }

        });
        //========
=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07

        //讀取手機解析度
        mPhone = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mPhone);

        mImg = (ImageView) findViewById(R.id.img);
        //Button camera = (Button) findViewById(R.id.camera);
        ImageView img = (ImageView) findViewById(R.id.img);

<<<<<<< HEAD
        //location
        testLocationProvider();

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnPrefs:
                        Intent intent = new Intent(MyClock.this, PrefsActivity.class);
                        startActivity(intent);
                        break;
                    //              case R.id.btnGetPreferences:
                    //                  displaySharedPreferences();
                    //                  break;
                    //                case R.id.camera:
                    //                    //開啟相機功能，並將拍照後的圖片存入SD卡相片集內，須由startActivityForResult且
                    //                    //帶入
                    //                    //requestCode進行呼叫，原因為拍照完畢後返回程式後則呼叫onActivityResult
                    //                    ContentValues value = new ContentValues();
                    //                    value.put(MediaStore.Video.Media.MIME_TYPE, "image/jpeg");
                    //                    Uri uri= getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,value);
                    //                    Intent intent1 = new Intent("android.media.action.IMAGE_CAPTURE");
                    //                    intent1.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());
                    //                    startActivityForResult(intent1, CAMERA);
                    case R.id.img:
                        //開啟相簿相片集，須由startActivityForResult且帶入requestCode進行呼叫，原因
                        //為點選相片後返回程式呼叫onActivityResult
                        Intent intent2 = new Intent();
                        intent2.setType("image/*");
                        intent2.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent2, PHOTO);
                    default:
                        break;
                }
            }
        };






        btnPrefs.setOnClickListener(listener);
        //camera.setOnClickListener(listener);
        img.setOnClickListener(listener);
        //btnGetPrefs.setOnClickListener(listener);
=======
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.btnPrefs:
                    Intent intent = new Intent(MyClock.this,PrefsActivity.class);
                    startActivity(intent);
                    break;
//              case R.id.btnGetPreferences:
//                  displaySharedPreferences();
//                  break;
//                case R.id.camera:
//                    //開啟相機功能，並將拍照後的圖片存入SD卡相片集內，須由startActivityForResult且
//                    //帶入
//                    //requestCode進行呼叫，原因為拍照完畢後返回程式後則呼叫onActivityResult
//                    ContentValues value = new ContentValues();
//                    value.put(MediaStore.Video.Media.MIME_TYPE, "image/jpeg");
//                    Uri uri= getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,value);
//                    Intent intent1 = new Intent("android.media.action.IMAGE_CAPTURE");
//                    intent1.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());
//                    startActivityForResult(intent1, CAMERA);
                case R.id.img:
                    //開啟相簿相片集，須由startActivityForResult且帶入requestCode進行呼叫，原因
                    //為點選相片後返回程式呼叫onActivityResult
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent2, PHOTO);
                default:
                    break;
            }
        }
    };

    btnPrefs.setOnClickListener(listener);
    //camera.setOnClickListener(listener);
    img.setOnClickListener(listener);
    //btnGetPrefs.setOnClickListener(listener);
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07



       /* mCamera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //開啟相機功能，並將拍照後的圖片存入SD卡相片集內，須由startActivityForResult且
                //帶入
                //requestCode進行呼叫，原因為拍照完畢後返回程式後則呼叫onActivityResult
                ContentValues value = new ContentValues();
                value.put(MediaStore.Video.Media.MIME_TYPE, "image/jpeg");
                Uri uri= getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                        value);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());
                startActivityForResult(intent, CAMERA);
            }
        });

        mPhoto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //開啟相簿相片集，須由startActivityForResult且帶入requestCode進行呼叫，原因
                //為點選相片後返回程式呼叫onActivityResult
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO);
            }
        });*/
}
<<<<<<< HEAD
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

    class thread extends Thread{
        public void run() {
            Log.d("happy run", "2");
            str1="run";
            try{
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyClock.this);
                String server=prefs.getString("host", "Default name");
                String port=prefs.getString("port", "Default name");
//                int servPort=8033;
//                String addr = "140.112.30.38";
                Log.d("server happy:",server);
                SocketClient client = new SocketClient();
                StringBuilder msg = new StringBuilder();
                msg.append("1 "+textView.getText().toString()+" "+place_txt.getText().toString());
                str2 = client.cnnct(server, Integer.parseInt(port),msg.toString(),1);
                str1 = "Connected!!";
            }catch(Exception e)
            {
                str1 = "fuch u !!!";
//                str2 = "fuch u, too !!!";
            }
        }
    }
    class thread2 extends Thread{
        public void run() {
            Log.d("happy run", "2");
            str1="run";
            try{
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyClock.this);
                String server=prefs.getString("host", "Default name");
                String port=prefs.getString("port", "Default name");
//                int servPort=8033;
//                String addr = "140.112.30.38";
                Log.d("server happy:",server);
                SocketClient client = new SocketClient();
                StringBuilder msg = new StringBuilder();
                msg.append("0 ");
                msg_from_server = client.cnnct(server, Integer.parseInt(port),msg.toString(),0);
                str2 = msg_from_server;
                str1 = "Connected!!";
            }catch(Exception e)
            {
                str1 = "fuch u !!!";
//                str2 = "fuch u, too !!!";
            }
        }
    }

    private void getLocation(Location location) {	//±N©w¶Ï∏Í∞T≈„•‹¶bµe≠±§§
        if(location != null) {
            //Toast.makeText(this, "Hello!", Toast.LENGTH_LONG).show();
//            TextView longitude_txt = (TextView) findViewById(R.id.longitude);
//            TextView latitude_txt = (TextView) findViewById(R.id.latitude);


//            Double longitude = location.getLongitude();	//®˙±o∏g´◊
//            Double latitude = location.getLatitude();	//®˙±oΩn´◊
//
//            longitude_txt.setText(String.valueOf(longitude));
//            latitude_txt.setText(String.valueOf(latitude));
            place_txt.setText(getAddressByLocation(location));

            Thread t = new thread();
            t.start();
            try {
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tv1.setText(str1);
            tv2.setText(str2);


        }
        else {
            Toast.makeText(this, "can't define", Toast.LENGTH_LONG).show();
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
                    returnAddress = "csie_department";
                else if(Math.abs(25.04189446-latitude) < 0.00030619 && Math.abs(121.52355731 - longitude) < 0.00078857)
                    returnAddress = "dorm";
                else if(Math.abs(25.02011903-latitude) < 0.00085554 && Math.abs(121.53766036 - longitude) < 0.00067592)
                    returnAddress = "drunk_moon_lake";
                else if(Math.abs(25.01764961-latitude) <0.00092362 && Math.abs(121.5409863 - longitude) <0.00049353)
                    returnAddress = "library";
                else
                    returnAddress = "somewhere";

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return returnAddress;
    }

=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
    @Override
    public void onResume(){
        super.onResume();
        displaySharedPreferences();
<<<<<<< HEAD
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
=======

>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_clock, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

<<<<<<< HEAD
    @Override
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
        getLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my_clock, container, false);
            return rootView;
        }
    }
    private void displaySharedPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyClock.this);

        String username = prefs.getString("your name", "Default NickName");
        String group = prefs.getString("Group name", "Default name");
<<<<<<< HEAD
        String server = prefs.getString("host", "Default name");
        String port = prefs.getString("port", "Default name");
=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
        //String passw = prefs.getString("password", "Default Password");
        //boolean checkBox = prefs.getBoolean("checkBox", false);
        //String listPrefs = prefs.getString("listpref", "Default list prefs");
        StringBuilder builder = new StringBuilder();
        StringBuilder build = new StringBuilder();
<<<<<<< HEAD
        builder.append(username);
        build.append(group);
=======
        builder.append(username + "\n");
        build.append(group + "\n");
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
        //builder.append(listPrefs + "\n");

        //builder.append("Password: " + passw + "\n");
        //builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        //builder.append("List preference: " + listPrefs);
        //TextView textView;
        textView.setText(builder.toString());
        textView2.setText(build.toString());
<<<<<<< HEAD

        StringBuilder bld = new StringBuilder();
        bld.append("server IP: " + server + "\n");
        tv_srvr.setText(bld.toString());
        bld = new StringBuilder();
        bld.append("port: " + port + "\n");
        tv_port.setText(bld.toString());
=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
    }

    //拍照完畢或選取圖片後呼叫此函式
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        //藉由requestCode判斷是否為開啟相機或開啟相簿而呼叫的，且data不為null
        if ((requestCode == PHOTO) && data != null)
        {
            //取得照片路徑uri
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try
            {
                //讀取照片，型態為Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));

                //判斷照片為橫向或者為直向，並進入ScalePic判斷圖片是否要進行縮放
                if(bitmap.getWidth()>bitmap.getHeight())ScalePic(bitmap,mPhone.heightPixels);
                else ScalePic(bitmap,mPhone.widthPixels);
            }
            catch (FileNotFoundException e)
            {
            }
        }

<<<<<<< HEAD

=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void ScalePic(Bitmap bitmap,int phone)
    {
        //縮放比例預設為1
        float mScale = 1 ;

        //如果圖片寬度大於手機寬度則進行縮放，否則直接將圖片放入ImageView內
        if(bitmap.getWidth() > phone )
        {
            //判斷縮放比例
            mScale = (float)phone/(float)bitmap.getWidth();

            Matrix mMat = new Matrix() ;
            mMat.setScale(mScale, mScale);

            Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),mMat,false);
            mImg.setImageBitmap(mScaleBitmap);
        }
        else mImg.setImageBitmap(bitmap);
    }

    public static class RoundedImageView extends ImageView {

        public RoundedImageView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        public RoundedImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            Drawable drawable = getDrawable();

            if (drawable == null) {
                return;
            }

            if (getWidth() == 0 || getHeight() == 0) {
                return;
            }
            Bitmap b =  ((BitmapDrawable)drawable).getBitmap() ;
            Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

            int w = getWidth(), h = getHeight();


            Bitmap roundBitmap =  getCroppedBitmap(bitmap, w);
            canvas.drawBitmap(roundBitmap, 0,0, null);

        }

        public static Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
            Bitmap sbmp;
            if(bmp.getWidth() != radius || bmp.getHeight() != radius)
                sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
            else
                sbmp = bmp;
            Bitmap output = Bitmap.createBitmap(sbmp.getWidth(),
                    sbmp.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final int color = 0xffa19774;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());

            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(Color.parseColor("#BAB399"));
            canvas.drawCircle(sbmp.getWidth() / 2+0.7f, sbmp.getHeight() / 2+0.7f,
                    sbmp.getWidth() / 2+0.1f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(sbmp, rect, rect, paint);


            return output;
        }

    }
<<<<<<< HEAD

=======
>>>>>>> 57b4dc53d69f564b4977a12625cfa6c036408c07
}
