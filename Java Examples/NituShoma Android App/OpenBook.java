package com.nitushoma.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;
import com.google.android.gms.plus.PlusShare;
import com.nitushoma.model.R;

/***
 * The purpose of this class to populate the activity that will present
 * details about the written book a user has picked, rating.
 * @author lkirabo
 * date 28 April 2014
 */

public class OpenBook extends ActionBarActivity
{

    private TextView titleView;
    private TextView authorView;
    private TextView descriView;

    private ImageButton buyTheBook;
    private ImageButton plusTheBook;
    private ImageButton shareTheBook;

    private PlusOneButton mPlusOneButton;

    private static final int PLUS_ONE_REQUEST_CODE = 0;
    private String authorWebLink;

    String shareBody;
    String shareSubject;

    private RatingBar ratingBar;
    private SeekBar seekBar;
    private TextView chapterView;
    private TextView priceView;
    private ImageView theBookCover;
    private int totalPrice;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_book);

        theBookCover = (ImageView) findViewById(R.id.theBookCover);
        titleView = (TextView) findViewById(R.id.bookTitle);
        authorView = (TextView) findViewById(R.id.bookAuthor);
        descriView = (TextView) findViewById(R.id.bookDescri);

        Context context = OpenBook.this;
        sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        mPlusOneButton = (PlusOneButton) findViewById(R.id.plus_one_button);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            titleView.setText(extras.getString(ShowReadBooks.THE_TITLE));
            authorView.setText(extras.getString(ShowReadBooks.THE_AUTHOR));
            descriView.setText(extras.getString(ShowReadBooks.THE_DESCRI));
            authorWebLink = extras.getString(ShowReadBooks.AUTHOR_URL);

            int coverID = extras.getInt(ShowReadBooks.BOOK_COVER);
            theBookCover.setImageResource(coverID);

            shareBody = descriView.getText().toString();
            shareSubject = titleView.getText().toString() + " - " + authorView.getText().toString();
        }

        buyTheBook = (ImageButton) findViewById(R.id.buythisButton);
        plusTheBook = (ImageButton) findViewById(R.id.plusthisButton);
        shareTheBook = (ImageButton) findViewById(R.id.sharethisButton);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        chapterView = (TextView) findViewById(R.id.numberOfChapters);
        chapterView.setText("Number of Chapters: " + seekBar.getProgress() + "of" + seekBar.getMax());
        priceView = (TextView) findViewById(R.id.priceOfChapters);
        priceView.setText(" Price:  RwF 0");


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            int progress = 0;
            int price = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser)
            {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {   }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                chapterView.setText("Number of Chapters: " + progress + " of " + seekBar.getMax());

                if (progress == 0)
                {
                    price = 0;
                    priceView.setText(" Price:  RwF " + price);
                }
                else if ((progress == 1) || (progress < 10))
                {
                    price = 2500;
                    priceView.setText(" Price: RwF " + price);
                }
                else if ((progress == 10) || (progress < 30))
                {
                    price = 5000;
                    priceView.setText(" Price: RwF " + price);
                }
                else if ((progress == 30) || (progress < 70))
                {
                    price = 8000;
                    priceView.setText(" Price: RwF " + price);
                }
                else if ((progress == 70) || (progress < 100))
                {
                    price = 10000;
                    priceView.setText(" Price: RwF " + price);
                }
                else if ((progress == 100))
                {
                    price = 8500;
                    priceView.setText(" Price: RwF " + price);
                }
            }

        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            public void onRatingChanged(RatingBar ratingBar, float rating,boolean fromUser)
            {
                String rated = String.valueOf(rating);

                editor.putString(getString(R.string.preference_file_key), rated);
                editor.commit();

            }
        });

        shareTheBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareThisBook();
            }
        });
        plusTheBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusThisBook();
            }
        });

    }

    private void plusThisBook()
    {
        Intent plusShareIntent = new PlusShare.Builder(OpenBook.this)

                .setType("text/plain")
                .setText(shareSubject + "\n" + shareBody)
                .setContentUrl(Uri.parse(authorWebLink))
                .getIntent();

        startActivityForResult(plusShareIntent, 0);

    }

    private void shareThisBook()
    {
        Intent shareThisIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareThisIntent.setType("text/plain");
        shareThisIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSubject);
        shareThisIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareThisIntent, "Share via"));

    }


    protected void onResume()
    {
        super.onResume();

        String defaultValue = getResources().getString(R.string.default_saved_rating);
        String returnedText = sharedPref.getString(getString(R.string.preference_file_key), defaultValue);
        ratingBar.setRating(Float.parseFloat(returnedText));
        //text.setText(returnedText);

        // Refresh the state of the +1 button each time the activity receives focus.
        mPlusOneButton.initialize(authorWebLink, PLUS_ONE_REQUEST_CODE);
    }

}
