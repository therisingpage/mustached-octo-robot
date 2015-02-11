package com.nitushoma.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.nitushoma.model.ImageAdapter;
import com.nitushoma.model.R;

/**
 * description, the purpose of this class is to show the books that are in written form.
 * @author lkirabo
 * @date 28th April 2014
 */

public class ShowReadBooks extends Fragment
{

    private View rootView;
    private GridView gridview;

    public final static String THE_TITLE = "com.nitusoma.view.TITLE";
    public final static String THE_AUTHOR = "com.nitusoma.view.AUTHOR";
    public final static String THE_DESCRI = "com.nitushoma.view.DESCRI";
    public final static String AUTHOR_URL = "com.nitushoma.view.AUTHORURL";
    public final static String BOOK_COVER = "com.nitushoma.view.BOOKCOVER";
    public final static String BOOK_ID = "com.nitushoma.view.BOOKID";

    String title ;
    String author ;
    String descri;
    String authorUrl = "http://jalada.org/";
    int bookcover;
    int bookID;

    Intent openBookIntent;




    public ShowReadBooks()
    {   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        rootView = inflater.inflate(R.layout.fragment_show_read_books, container, false);

        //The code below displays the book covers in a grid view
        //It also assigns each book cover an intent that will open it.
        gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(ShowReadBooks.this.getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                switch(position)
                {
                    case 0:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), OpenBook.class);
                        title = "Book Title: Big Pieces Little Pieces";
                        author = "Book Author: Tshuma";
                        descri  = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_big_pieces_little_pieces_tshuma;
                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        startActivity(openBookIntent);
                        break;

                    case 1:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Cover at the End of Death";
                        author = "Book Author: Ndinda";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_death_at_the_end_ndinda;
                        bookID = R.raw.death_at_the_end_ndinda;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 2:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Haggia";
                        author = "Book Author: Sofia Warui";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_hagia_sophia_wairua;
                        bookID = R.raw.hagia_sophia_wairua;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 3:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Just because you did not win";
                        author = "Book Author: Kakoma";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_just_because_you_didnt_win_kakoma;
                        bookID = R.raw.just_because_you_didnt_win_kakoma;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 4:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Over Population dynamics";
                        author = "Book Author: Gabonewe";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_overpopulation_dynamics_gabonewe;
                        bookID = R.raw.overpopulation_dynamics_gabonewe;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 5:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Picket Fences";
                        author = "Book Author: Musita";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_picket_fences_musita;
                        bookID = R.raw.picket_fences_musita;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;
                    case 6:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Please do not kill the baby";
                        author = "Book Author: Ochiel";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_please_dont_kill_the_baby_ochiel;
                        bookID = R.raw.please_dont_kill_the_baby_ochiel;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 7:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Rabies";
                        author = "Book Author: Luhumyo";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_rabies_luhumyo;
                        bookID = R.raw.rabies_luhumyo;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 8:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Sketch of a bald woman in the semi nude";
                        author = "Book Author: Gachagua";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_sketch_of_a_bald_woman_in_the_semi_nude_gachagua;
                        bookID = R.raw.sketch_of_a_bald_woman_in_the_semi_nude_gachagua;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 9:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: The Ease with which one dies";
                        author = "Book Author: Moraa";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_the_ease_with_which_one_dies_moraa;
                        bookID = R.raw.the_ease_with_which_one_dies_moraa;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 10:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: Visiting Angel Gabriel";
                        author = "Book Author: Kilolo";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_visiting_angel_gabriel_kilolo;
                        bookID = R.raw.visiting_angel_gabriel_kilolo;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 11:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: The god with twelve hands";
                        author = "Book Author: Ikawah";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly.";
                        bookcover = R.drawable.cover_the_god_with_twelve_hands_ikawah;
                        bookID = R.raw.the_god_with_twelve_hands_ikawah;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;

                    case 12:
                        openBookIntent = new Intent(ShowReadBooks.this.getActivity(), DownloadABook.class);
                        title = "Book Title: The Gentle man from iten";
                        author = "Book Author: Kimutai";
                        descri = "Book Description \nFather was very particular about his belongings. Take the time when Mama burnt his Che Guevara shirt, the frayed one with a black and white man who looked liked somebody called Bob Marley but without his dreadlocks. You had always thought that shirt was a sweaty-smelly thing because Father wore it only when he went to some place called Jim which made him sweaty-smelly. But the way he smashed Mama’s Philips iron against the wall and screamed What kind of nincompoop destroyed something so revolutionary? made that shirt as good as new. Ever since then Mama had always tried the iron on a cloth first, then carefully pressed his clothes, " +
                                "hesitantly, as though she expected, at any moment, the smell of roasted fabric to waft to her nostrils.";
                        bookcover = R.drawable.cover_the_gentle_man_from_iten_kimutai;
                        bookID = R.raw.the_gentle_man_from_iten_kimutai;

                        openBookIntent.putExtra(THE_TITLE, title);
                        openBookIntent.putExtra(THE_AUTHOR, author);
                        openBookIntent.putExtra(THE_DESCRI, descri);
                        openBookIntent.putExtra(AUTHOR_URL, authorUrl);
                        openBookIntent.putExtra(BOOK_COVER, bookcover);
                        openBookIntent.putExtra(BOOK_ID, bookID);
                        startActivity(openBookIntent);
                        break;
                    default:
                        break;
                }
            }
        });

        return rootView;
    }


}
