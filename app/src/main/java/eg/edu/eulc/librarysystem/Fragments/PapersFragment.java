package eg.edu.eulc.librarysystem.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import eg.edu.eulc.librarysystem.R;

/**
 * Created by Eslam El-Meniawy on 01-Nov-15.
 */
public class PapersFragment extends Fragment {
    private EditText paperTitleET, authorsET, keywordsET, paperAbstractET, authorNationalIDET, authorIDET;
    private Button searchButton;
    private LinearLayout searchLayout, resultsLayout;

    public PapersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_papers, container, false);

        paperTitleET = (EditText) rootView.findViewById(R.id.PaperTitle);
        authorsET = (EditText) rootView.findViewById(R.id.Authors);
        keywordsET = (EditText) rootView.findViewById(R.id.Keywords);
        paperAbstractET = (EditText) rootView.findViewById(R.id.Abstract);
        authorNationalIDET = (EditText) rootView.findViewById(R.id.AuthorNationalID);
        authorIDET = (EditText) rootView.findViewById(R.id.AuthorID);
        searchButton = (Button) rootView.findViewById(R.id.searchButton);
        searchLayout = (LinearLayout) rootView.findViewById(R.id.searchLayout);
        resultsLayout = (LinearLayout) rootView.findViewById(R.id.resultsLayout);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paperTitle = paperTitleET.getText().toString();
                String authors = authorsET.getText().toString();
                String keywords = keywordsET.getText().toString();
                String paperAbstract = paperAbstractET.getText().toString();
                String authorNationalID = authorNationalIDET.getText().toString();
                String authorID = authorIDET.getText().toString();
                if ((paperTitle.equals("") || paperTitle == null) && (authors.equals("") || authors == null) && (keywords.equals("") || keywords == null) && (paperAbstract.equals("") || paperAbstract == null) && (authorNationalID.equals("") || authorNationalID == null) && (authorID.equals("") || authorID == null)) {
                    Snackbar.make(v, getResources().getText(R.string.enter_text), Snackbar.LENGTH_LONG).show();
                } else {
                    searchLayout.setVisibility(View.GONE);
                    resultsLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        return rootView;
    }

    public boolean getLayoutVisibility() {
        if (resultsLayout.getVisibility() == View.VISIBLE) {
            return true;
        }
        return false;
    }

    public void showSearch() {
        resultsLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.VISIBLE);
    }
}
