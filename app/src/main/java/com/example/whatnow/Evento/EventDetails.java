package com.example.whatnow.Evento;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.TextView;

        import com.example.whatnow.R;
        import com.google.android.material.appbar.CollapsingToolbarLayout;

public class EventDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        getSupportActionBar().hide();
        //receive data
        String name = getIntent().getExtras().getString("Name");
        String description = getIntent().getExtras().getString("Description");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapse);
        collapsingToolbarLayout.setTitle(name);


        TextView event_description = findViewById(R.id.Description);

        event_description.setText(description);



    }
}
