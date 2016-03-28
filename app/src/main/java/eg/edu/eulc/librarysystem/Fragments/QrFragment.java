package eg.edu.eulc.librarysystem.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import eg.edu.eulc.librarysystem.Activities.MainActivity;
import eg.edu.eulc.librarysystem.R;

/**
 * Created by Eslam El-Meniawy on 21-Mar-16.
 */
@SuppressWarnings("DefaultFileTemplate")
public class QrFragment extends Fragment {
    private View rootView;

    public QrFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_qr, container, false);
        Button scan = (Button) rootView.findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanBarcode();
            }
        });
        scanBarcode();
        return rootView;
    }

    private void scanBarcode() {
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ((MainActivity) getActivity()).setConfig();
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Snackbar.make(rootView, getResources().getText(R.string.scan_canceled), Snackbar.LENGTH_LONG).show();
            } else {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(result.getContents())));
            }
        }
    }
}
