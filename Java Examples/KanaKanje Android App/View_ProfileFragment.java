package com.cmu.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cmu.controller.DatabaseConnector;
import com.cmu.model.MainActivity;
import com.cmu.model.R;
import com.cmu.view.AddBaby;
/**
 * Created by: lkirabo
 *
 */

public class View_ProfileFragment extends Fragment
{
    private long rowID; // selected baby's name

    private TextView babyName; // displays baby's name
    private TextView babyAge; // displays baby's age
    private TextView babyLocation; // displays baby's location


    private Button editProfileButton;
    private Button deleteProfileButton;

    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_view_profile, container, false);


        babyName = (TextView) rootView.findViewById(R.id.bNameTV);
        babyAge = (TextView) rootView.findViewById(R.id.bAgeTV);
        babyLocation = (TextView) rootView.findViewById(R.id.bLocationTV);



        //Buttons

        editProfileButton = (Button) rootView.findViewById(R.id.edit_profile_button);
        deleteProfileButton = (Button) rootView.findViewById(R.id.delete_profile_button);

        // get the selected contact's row ID
        Bundle extras = View_ProfileFragment.this.getActivity().getIntent().getExtras();
        rowID = extras.getLong(MainActivity.ROW_ID);

        //The onClick Listeners
        editProfileButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Intent addRecord = new Intent(View_ProfileFragment.this.getActivity(), AddBaby.class);

                        // pass the selected contact's data as extras with the Intent
                        addRecord.putExtra(MainActivity.ROW_ID, rowID);
                        addRecord.putExtra("BabyName", babyName.getText());
                        addRecord.putExtra("BabyAge", babyAge.getText());
                        addRecord.putExtra("BabyLocation", babyLocation.getText());

                        startActivity(addRecord);
                    }
                }
        );



        deleteProfileButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        deleteRecord();
                    }
                }
        );

        return rootView;
    }

    private void deleteRecord()
    {
        // create a new AlertDialog Builder
        AlertDialog.Builder builder =
                new AlertDialog.Builder(View_ProfileFragment.this.getActivity());

        builder.setTitle(R.string.confirmTitle); // title bar string
        builder.setMessage(R.string.confirmMessage); // message to display

        // provide an OK button that simply dismisses the dialog
        builder.setPositiveButton(R.string.button_delete,
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int button)
                    {
                        final DatabaseConnector databaseConnector =
                                new DatabaseConnector(View_ProfileFragment.this.getActivity());

                        // create an AsyncTask that deletes the profile in another
                        // thread, then calls finish after the deletion
                        AsyncTask<Long, Object, Object> deleteTask =
                                new AsyncTask<Long, Object, Object>()
                                {
                                    @Override
                                    protected Object doInBackground(Long... params)
                                    {
                                        databaseConnector.deleteBabyProfile(params[0]);
                                        return null;
                                    } // end method doInBackground

                                    @Override
                                    protected void onPostExecute(Object result)
                                    {
                                        View_ProfileFragment.this.getActivity().finish(); // return to the View Profile Activity
                                    } // end method onPostExecute
                                }; // end new AsyncTask

                        // execute the AsyncTask to delete profile at rowID
                        deleteTask.execute(new Long[] { rowID });
                    } // end method onClick
                } // end anonymous inner class
        ); // end call to method setPositiveButton

        builder.setNegativeButton(R.string.button_cancel, null);
        builder.show(); // display the Dialog
    } // end method deleteBabyProfile

    // set the physician information visible

    @Override
    public void onResume()
    {
        super.onResume();

        // create new LoadRecordTask and execute it
        new LoadRecordTask().execute(rowID);
    } // end method onResume

    // performs database query outside GUI thread
    private class LoadRecordTask extends AsyncTask<Long, Object, Cursor>
    {
        DatabaseConnector databaseConnector =
                new DatabaseConnector(View_ProfileFragment.this.getActivity());

        // perform the database access
        @Override
        protected Cursor doInBackground(Long... params)
        {
            databaseConnector.open();

            // get a cursor containing all data on given entry
            return databaseConnector.getOneBaby(params[0]);
        } // end method doInBackground

        // use the Cursor returned from the doInBackground method
        @Override
        protected void onPostExecute(Cursor result)
        {
            super.onPostExecute(result);

            result.moveToFirst(); // move to the first item

            // get the column index for each data item
            int bbNum = result.getColumnIndex("_id");
            int studentIndex = result.getColumnIndex("BabyName");
            int qz1Index = result.getColumnIndex("BabyAge");
            int qz2Index = result.getColumnIndex("BabyLocation");


            // fill TextViews with the retrieved data
            babyName.setText(result.getString(studentIndex));
            babyAge.setText(result.getString(qz1Index));
            babyLocation.setText(result.getString(qz2Index));


            result.close(); // close the result cursor
            databaseConnector.close(); // close database connection
        } // end method onPostExecute
    } // end class LoadRecordTask


}
