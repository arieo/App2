package app2.example.com.app2;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.BroadcastReceiver;
import android.widget.Toast;

public class Action extends Fragment {

    Cursor mCursor;

    public static Action newInstance() {
        Action fragment = new Action();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       // launchReceiver();
        Uri mUri = Uri.parse("content://com.example.loginapplication.Model.BackEnd.BusinessAndActionProvider/business");
        try{
            mCursor = getActivity().getApplicationContext().getContentResolver().query(mUri, null, null, null, null);
        }catch (Exception e) {
            Log.d("EXCEPTION", e.toString());
        }
        int a = mCursor.getColumnCount();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_action, container, false);
    }


    //IntentFilter filter = new IntentFilter("com.example.loginapplication.UPDATE");

   // MyReceiver receiver = new MyReceiver();
   // registerReceiver(receiver, filter);

    /*private void launchReceiver()
    {
         final BroadcastReceiver actionReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //Intent in = getIntent();
                //finish();
                Log.d("actionReceiver", "onReceive: BROADCAST RECIBIDO!!!");
                Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();
            }
        };
    }*/
}