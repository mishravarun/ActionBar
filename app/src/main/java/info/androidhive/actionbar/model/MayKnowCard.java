/*
 * ******************************************************************************
 *   Copyright (c) 2013-2014 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */

package info.androidhive.actionbar.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import info.androidhive.actionbar.R;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardView;
import it.gmariotti.cardslib.library.view.component.CardThumbnailView;

/**
 * This class provides a simple example of May Know Card
 *
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class MayKnowCard extends Card {
    TextView title;
    TextView subtitle;
    TextView add ;
    String innerTitle="",innerSubtitle="";

    public MayKnowCard(Context context,String headerTitle, String innerTitle, String innerSubtitle) {
        this(context, R.layout.carddemo_mayknow_inner_content, headerTitle, innerTitle, innerSubtitle);
    }

    public MayKnowCard(Context context, int innerLayout,String headerTitle, String innerTitle, String innerSubtitle) {
        super(context, innerLayout);
        init(headerTitle, innerTitle, innerSubtitle);
    }

    private void init(String headerTitle1, final String innerTitle1, String innerSubtitle1) {
        //Add Header
        CardHeader header = new MayKnowCardHeader(getContext(), R.layout.carddemo_mayknow_inner_header);
        header.setTitle(getContext().getString(R.string.may_know_card_title));
        addCardHeader(header);
        setShadow(false);
        innerTitle=innerTitle1;
        innerSubtitle=innerSubtitle1;
        //Add Thumbnail
        CardThumbnail thumbnail = new CardThumbnail(getContext());
        thumbnail.setUrlResource("https://lh5.googleusercontent.com/-N8bz9q4Kz0I/AAAAAAAAAAI/AAAAAAAAAAs/Icl2bQMyK7c/s265-c-k-no/photo.jpg");
        thumbnail.setErrorResource(R.drawable.ic_error_loadingsmall);
        addCardThumbnail(thumbnail);

        OnCardClickListener clickListener = new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                Toast.makeText(getContext(), "Click Listener card=" + innerTitle, Toast.LENGTH_SHORT).show();
            }
        };

        addPartialOnClickListener(Card.CLICK_LISTENER_CONTENT_VIEW,clickListener);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        title = (TextView) view.findViewById(R.id.carddemo_mayknow_main_inner_title);
       subtitle = (TextView) view.findViewById(R.id.carddemo_mayknow_main_inner_subtitle);
        add = (TextView) view.findViewById(R.id.carddemo_mayknow_main_inner_button);

        title.setText(innerTitle);
        subtitle.setText(innerSubtitle);
        add.setClickable(true);

        CardView cardView = getCardView();
        CardThumbnailView thumb = cardView.getInternalThumbnailLayout();
        if (thumb != null) {
            ViewGroup.LayoutParams lp = thumb.getLayoutParams();
            if (lp instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) lp).setMargins(25, 0, 0, 5);
            }
        }


    }

    class MayKnowCardHeader extends CardHeader {

        public MayKnowCardHeader(Context context, int innerLayout) {
            super(context, innerLayout);
        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {
            super.setupInnerViewElements(parent, view);

            TextView t1 = (TextView) view.findViewById(R.id.carddemo_mayknow_main_inner_subtitle);
                t1.setText(getContext().getString(R.string.may_know_card_subtitle));
        }
    }
}
