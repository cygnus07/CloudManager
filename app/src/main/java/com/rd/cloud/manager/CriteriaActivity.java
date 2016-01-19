package com.rd.cloud.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CriteriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void autoRefreshToggle(View view) {
        CheckBox criteriaAutoRefresh = (CheckBox) view;
        System.out.println("CheckBox [Id: " + criteriaAutoRefresh.getId() + " Checked: " + criteriaAutoRefresh.isChecked() + "]");

        EditText criteriaAutoRefreshDuration = (EditText) findViewById(R.id.criteriaAutoRefreshDurationEditText);
        if (criteriaAutoRefresh.isChecked()) {
            System.out.println("Enabling criteriaAutoRefreshDurationEditText");
            criteriaAutoRefreshDuration.setVisibility(View.VISIBLE);
        } else {
            System.out.println("Disabling criteriaAutoRefreshDurationEditText");
            criteriaAutoRefreshDuration.setVisibility(View.GONE);
        }
    }

    public void helpText(View view) {

        if (view.getId() == R.id.criteriaNameImageButton) {
            Snackbar.make(view, "Easy to remember name for this criteria", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else if (view.getId() == R.id.criteriaContainsImageButton) {
            Snackbar.make(view, "comma-separated white-list of keywords to match in autoscaling", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else if (view.getId() == R.id.criteriaExcludesImageButton) {
            Snackbar.make(view, "comma-separated black-list of keywords to match in autoscaling", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else if (view.getId() == R.id.criteriaAutoRefreshImageButton) {
            Snackbar.make(view, "Refresh matching autoscalings every <duration> seconds", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void submitCriteria(View view) {
        EditText criteriaName = (EditText) findViewById(R.id.criteriaNameEditText);
        EditText criteriaContains = (EditText) findViewById(R.id.criteriaContainsEditText);
        EditText criteriaExcludes = (EditText) findViewById(R.id.criteriaExcludesEditText);
        CheckBox criteriaAutoRefresh = (CheckBox) findViewById(R.id.criteriaAutoRefreshCheckBox);
        EditText criteriaAutoRefreshDuration = (EditText) findViewById(R.id.criteriaAutoRefreshDurationEditText);

        System.out.println("Submitted Criteria: [Name: " + criteriaName.getText() + ", Contains: " + criteriaContains.getText() + ", Excludes: " + criteriaExcludes.getText() + ", AutoRefresh: " + criteriaAutoRefresh.getText() + "Duration: " + criteriaAutoRefreshDuration.getText() + "]");

        Toast.makeText(this, "Created Criteria: "+criteriaName.getText(), Toast.LENGTH_LONG).show();
    }
}
