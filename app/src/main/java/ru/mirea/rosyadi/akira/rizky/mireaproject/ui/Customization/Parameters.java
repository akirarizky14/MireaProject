package ru.mirea.rosyadi.akira.rizky.mireaproject.ui.Customization;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import ru.mirea.rosyadi.akira.rizky.mireaproject.R;

import static android.content.Context.MODE_PRIVATE;

public class Parameters extends Fragment {
    private TextView textGreeting;
    private RadioButton radioButtonDark;
    private RadioButton radioButtonLight;
    private RadioButton radioButtonNight;
    private EditText editNewGreeting;
    private Button buttonChange;
    private String greeting;
    private SharedPreferences preferences;
    private final String SAVED_GREETING = "saved_greeting";
    private final String SAVED_COLOR = "saved_color";
    private String color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_parameters, container, false);

        textGreeting = root.findViewById(R.id.text_greeting);
        radioButtonDark = root.findViewById(R.id.button_dark_theme);
        radioButtonLight = root.findViewById(R.id.button_light_theme);
        radioButtonNight = root.findViewById(R.id.button_night_theme);
        editNewGreeting = root.findViewById(R.id.edit_new_greeting);
        buttonChange = root.findViewById(R.id.button_change);
        preferences = getActivity().getPreferences(MODE_PRIVATE);

        radioButtonDark.setOnClickListener(radioButtonListener);
        radioButtonLight.setOnClickListener(radioButtonListener);
        radioButtonNight.setOnClickListener(radioButtonListener);
        buttonChange.setOnClickListener(changeClickListener);

        if (!preferences.getString(SAVED_GREETING, "Empty").equals("Empty"))
            textGreeting.setText(preferences.getString(SAVED_GREETING, "Empty"));

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        color = preferences.getString(SAVED_COLOR, "Empty");
        if (color != null) {

            switch (color) {
                case "dark":
                    getView().setBackgroundColor(getResources().getColor(R.color.black));
                    break;
                case "light":
                    getView().setBackgroundColor(getResources().getColor(R.color.design_default_color_background));
                    break;
                case "yellow":
                    getView().setBackgroundColor(getResources().getColor(R.color.white));
                    break;
            }
        }
    }

    View.OnClickListener radioButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton clickedButton = (RadioButton) v;
            switch (clickedButton.getId()) {
                case R.id.button_dark_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.black));
                    color = "dark";
                    break;
                case R.id.button_light_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.design_default_color_background));
                    color = "light";
                    break;
                case R.id.button_night_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.white));
                    color = "yellow";
                    break;
            }
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SAVED_COLOR, color);
            editor.apply();
        }
    };

    View.OnClickListener changeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!editNewGreeting.getText().toString().equals("")) {
                greeting = editNewGreeting.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(SAVED_GREETING, greeting);
                editor.apply();
                textGreeting.setText(greeting);
            }
        }
    };
}