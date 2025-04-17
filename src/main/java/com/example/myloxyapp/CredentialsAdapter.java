package com.example.myloxyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class CredentialsAdapter extends BaseAdapter {

    private Context context;
    private List<Credential> credentials;
    private OnDeleteClickListener onDeleteClickListener;

    public CredentialsAdapter(Context context) {
        this.context = context;
    }

    // Method to update the list of credentials
    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
        notifyDataSetChanged();  // Notify the adapter that the data set has changed
    }

    @Override
    public int getCount() {
        return credentials != null ? credentials.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return credentials != null ? credentials.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setOnDeleteClickListener(OnDeleteClickListener listener) {
        this.onDeleteClickListener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_credential, parent, false);
        }

        Credential credential = credentials.get(position);

        TextView appNameTextView = convertView.findViewById(R.id.appNameTextView);
        TextView aliasTextView = convertView.findViewById(R.id.aliasTextView);
        TextView passwordTextView = convertView.findViewById(R.id.passwordTextView);
        ImageButton unmaskPasswordButton = convertView.findViewById(R.id.unmaskPasswordButton);
        ImageButton deleteButton = convertView.findViewById(R.id.deleteButton);

        appNameTextView.setText(credential.appName);
        aliasTextView.setText(credential.alias);
        passwordTextView.setText("****");

        // Handle password visibility toggle
        unmaskPasswordButton.setOnClickListener(v -> {
            if (passwordTextView.getText().toString().equals("****")) {
                passwordTextView.setText(credential.password); // Unmask
                unmaskPasswordButton.setImageResource(R.drawable.ic_visibility_off);
            } else {
                passwordTextView.setText("****"); // Mask
                unmaskPasswordButton.setImageResource(R.drawable.ic_visibility);
            }
        });

        // Handle delete button click
        deleteButton.setOnClickListener(v -> {
            if (onDeleteClickListener != null) {
                onDeleteClickListener.onDeleteClick(credential);
            }
        });

        return convertView;
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(Credential credential);
    }
}
