package info.androidhive.actionbar.model;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

import info.androidhive.actionbar.R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

/**
 * Card Examples
 *
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class MiscCardFragment extends BaseFragment {

    protected ScrollView mScrollView;

    @Override
    public int getTitleResourceId() {
        return R.string.carddemo_title_misc_card;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.demo_fragment_misc_card, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // mScrollView = (ScrollView) getActivity().findViewById(R.id.card_scrollview);
       // initCard();
       // initCardSuggested();
        initCards();
    }

/*
    private void initCard() {


        //Create a Card
        MayKnowCard card= new MayKnowCard(getActivity(),"","Sensor1","Sensor1");
        card.setShadow(false);
        //Set card in the cardView
        CardView cardView = (CardView) getActivity().findViewById(R.id.carddemo_MayKnow);
        cardView.setCard(card);

        MayKnowCard card2 = new MayKnowCard(getActivity(),"","Sensor2","Sensor2");
        card2.addCardHeader(null);
        CardView mayView2 = (CardView) getActivity().findViewById(R.id.carddemo_MayKnow2);
        mayView2.setCard(card2);


        LinearLayout detailListView;
        detailListView = (LinearLayout)  getActivity().findViewById(R.id.my_card_layout); // Find the layout where you want to add button
        MayKnowCard card3 = new MayKnowCard(getActivity(),"","Sensor3","Sensor2");
        card3.addCardHeader(null);
        card3.setShadow(true);
        CardView mayView3 = new CardView(getActivity());
        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        Resources r = getResources();
        float pxLeftMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, r.getDisplayMetrics());
        float pxTopMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());
        float pxRightMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, r.getDisplayMetrics());
        float pxBottomMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, r.getDisplayMetrics());

        rightGravityParams.setMargins(Math.round(pxLeftMargin), Math.round(pxTopMargin), Math.round(pxRightMargin), Math.round(pxBottomMargin));
        mayView3.setLayoutParams(mayView2.getLayoutParams());
       // mayView3.setLayoutParams(rightGravityParams);


        detailListView.addView(mayView3);
        mayView3.setCard(card3);//add view to add

    }

    /**
     * This method builds a suggested card example
     */
   /* private void initCardSuggested() {

        SuggestedCard card = new SuggestedCard(getActivity());
        CardView cardView = (CardView) getActivity().findViewById(R.id.carddemo_suggested);
        cardView.setCard(card);
    }*/
    private void initCards() {

        ArrayList<Card> cards = new ArrayList<Card>();
       for (int i=0;i<10;i++){



           SuggestedCard card2 = new SuggestedCard(getActivity());
            card2.setSwipeable(true);
            cards.add(card2);

        }
        Log.d("DDD", ""+cards.size());
        // Provide a custom adapter.
        // It is imphtortant to set the viewTypeCount
        // You have to provide in your card the type value with {@link Card#setType(int)} method.
        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(),cards);


        // An alternative is to write a own CardArrayAdapter
        // MyCardArrayAdapter mCardArrayAdapter = new MyCardArrayAdapter(getActivity(),cards);


        CardListView listView = (CardListView) getActivity().findViewById(R.id.listId);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);

        }
    }










}
