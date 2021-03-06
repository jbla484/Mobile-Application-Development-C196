package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseDetailsActivity extends AppCompatActivity {

    private int courseId = 0;
    private GestureDetectorCompat mDetector;
    private static final String TAG = "DEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //REGULAR CODE
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        //View assessments and term details
        StudentDatabase sdb = new StudentDatabase(getApplicationContext());
        Cursor c = null;
        try {
            courseId = Integer.parseInt(getIntent().getStringExtra("courseId"));
            c = sdb.getAssessments2(courseId);
        } catch (Exception e) {
            Log.i(TAG, "onCreate: s == null");
        }

        FloatingActionButton fab = findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(view -> {

            Intent intent = new Intent(CourseDetailsActivity.this,AddAssessmentActivity.class);
            intent.putExtra("course_id", courseId);

            intent.putExtra("termMonthValue", getIntent().getStringExtra("termMonthValue"));
            intent.putExtra("termName", getIntent().getStringExtra("termName"));
            intent.putExtra("termStart", getIntent().getStringExtra("termStart"));
            intent.putExtra("termEnd", getIntent().getStringExtra("termEnd"));
            intent.putExtra("termNameAndDate", getIntent().getStringExtra("termNameAndDate"));
            intent.putExtra("termId", getIntent().getStringExtra("termId"));

            intent.putExtra("courseMonthValue", getIntent().getStringExtra("courseMonthValue"));
            intent.putExtra("courseNameAndDate", getIntent().getStringExtra("courseNameAndDate"));
            intent.putExtra("courseId", getIntent().getStringExtra("courseId"));
            intent.putExtra("courseOptionalNotes", getIntent().getStringExtra("courseOptionalNotes"));
            startActivity(intent);
        });

        //Populate remaining weeks
        String weeks = getIntent().getStringExtra("courseMonthValue");
        TextView textView = findViewById(R.id.remainingWeeksValue2);
        textView.setText(weeks);
        TextView textViewTitle = findViewById(R.id.termView2);
        textViewTitle.setText(getIntent().getStringExtra("courseNameAndDate"));
        TextView textViewNotes = findViewById(R.id.termViewNotes);
        textViewNotes.setText(getIntent().getStringExtra("courseOptionalNotes"));

        if (getIntent().getStringExtra("courseOptionalNotes").equals("")) {
            textViewNotes.setVisibility(View.GONE);
        }

        Button btn0 = findViewById(R.id.assessment_button_first);
        Button btn1 = findViewById(R.id.assessment_button_second);
        Button btn2 = findViewById(R.id.assessment_button_third);
        Button btn3 = findViewById(R.id.assessment_button_fourth);
        Button btn4 = findViewById(R.id.assessment_button_fifth);
        Button btn5 = findViewById(R.id.assessment_button_sixth);
        Button btn6 = findViewById(R.id.assessment_button_seventh);
        Button btn7 = findViewById(R.id.assessment_button_eighth);
        Button btn8 = findViewById(R.id.assessment_button_ninth);
        Button btn9 = findViewById(R.id.assessment_button_tenth);

        btn0.setOnClickListener(view -> {

            StudentDatabase sdb12 = new StudentDatabase(getApplicationContext());
            Cursor c12 = sdb12.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c12.moveToNext()) {
                if (btn0.getText().toString().equals(c12.getString(c12.getColumnIndexOrThrow("title")))) {

                    int assessment_id = Integer.parseInt(c12.getString(c12.getColumnIndexOrThrow("_id")));
                    String courseTitle = c12.getString(c12.getColumnIndexOrThrow("title"));
                    String startDate = c12.getString(c12.getColumnIndexOrThrow("start_date"));
                    String endDate = c12.getString(c12.getColumnIndexOrThrow("end_date"));
                    String type = c12.getString(c12.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, assessment_id, type);
                }
            }
        });

        btn1.setOnClickListener(view -> {

            StudentDatabase sdb1 = new StudentDatabase(getApplicationContext());
            Cursor c1 = sdb1.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c1.moveToNext()) {
                if (btn1.getText().toString().equals(c1.getString(c1.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c1.getString(c1.getColumnIndexOrThrow("_id")));
                    String courseTitle = c1.getString(c1.getColumnIndexOrThrow("title"));
                    String startDate = c1.getString(c1.getColumnIndexOrThrow("start_date"));
                    String endDate = c1.getString(c1.getColumnIndexOrThrow("end_date"));
                    String type = c1.getString(c1.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn2.setOnClickListener(view -> {

            StudentDatabase sdb13 = new StudentDatabase(getApplicationContext());
            Cursor c13 = sdb13.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c13.moveToNext()) {
                if (btn2.getText().toString().equals(c13.getString(c13.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c13.getString(c13.getColumnIndexOrThrow("_id")));
                    String courseTitle = c13.getString(c13.getColumnIndexOrThrow("title"));
                    String startDate = c13.getString(c13.getColumnIndexOrThrow("start_date"));
                    String endDate = c13.getString(c13.getColumnIndexOrThrow("end_date"));
                    String type = c13.getString(c13.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn3.setOnClickListener(view -> {

            StudentDatabase sdb14 = new StudentDatabase(getApplicationContext());
            Cursor c14 = sdb14.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c14.moveToNext()) {
                if (btn3.getText().toString().equals(c14.getString(c14.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c14.getString(c14.getColumnIndexOrThrow("_id")));
                    String courseTitle = c14.getString(c14.getColumnIndexOrThrow("title"));
                    String startDate = c14.getString(c14.getColumnIndexOrThrow("start_date"));
                    String endDate = c14.getString(c14.getColumnIndexOrThrow("end_date"));
                    String type = c14.getString(c14.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn4.setOnClickListener(view -> {

            StudentDatabase sdb15 = new StudentDatabase(getApplicationContext());
            Cursor c15 = sdb15.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c15.moveToNext()) {
                if (btn4.getText().toString().equals(c15.getString(c15.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c15.getString(c15.getColumnIndexOrThrow("_id")));
                    String courseTitle = c15.getString(c15.getColumnIndexOrThrow("title"));
                    String startDate = c15.getString(c15.getColumnIndexOrThrow("start_date"));
                    String endDate = c15.getString(c15.getColumnIndexOrThrow("end_date"));
                    String type = c15.getString(c15.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn5.setOnClickListener(view -> {

            StudentDatabase sdb16 = new StudentDatabase(getApplicationContext());
            Cursor c16 = sdb16.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c16.moveToNext()) {
                if (btn5.getText().toString().equals(c16.getString(c16.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c16.getString(c16.getColumnIndexOrThrow("_id")));
                    String courseTitle = c16.getString(c16.getColumnIndexOrThrow("title"));
                    String startDate = c16.getString(c16.getColumnIndexOrThrow("start_date"));
                    String endDate = c16.getString(c16.getColumnIndexOrThrow("end_date"));
                    String type = c16.getString(c16.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn6.setOnClickListener(view -> {

            StudentDatabase sdb16 = new StudentDatabase(getApplicationContext());
            Cursor c16 = sdb16.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c16.moveToNext()) {
                if (btn6.getText().toString().equals(c16.getString(c16.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c16.getString(c16.getColumnIndexOrThrow("_id")));
                    String courseTitle = c16.getString(c16.getColumnIndexOrThrow("title"));
                    String startDate = c16.getString(c16.getColumnIndexOrThrow("start_date"));
                    String endDate = c16.getString(c16.getColumnIndexOrThrow("end_date"));
                    String type = c16.getString(c16.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn7.setOnClickListener(view -> {

            StudentDatabase sdb16 = new StudentDatabase(getApplicationContext());
            Cursor c16 = sdb16.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c16.moveToNext()) {
                if (btn7.getText().toString().equals(c16.getString(c16.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c16.getString(c16.getColumnIndexOrThrow("_id")));
                    String courseTitle = c16.getString(c16.getColumnIndexOrThrow("title"));
                    String startDate = c16.getString(c16.getColumnIndexOrThrow("start_date"));
                    String endDate = c16.getString(c16.getColumnIndexOrThrow("end_date"));
                    String type = c16.getString(c16.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn8.setOnClickListener(view -> {

            StudentDatabase sdb16 = new StudentDatabase(getApplicationContext());
            Cursor c16 = sdb16.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c16.moveToNext()) {
                if (btn8.getText().toString().equals(c16.getString(c16.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c16.getString(c16.getColumnIndexOrThrow("_id")));
                    String courseTitle = c16.getString(c16.getColumnIndexOrThrow("title"));
                    String startDate = c16.getString(c16.getColumnIndexOrThrow("start_date"));
                    String endDate = c16.getString(c16.getColumnIndexOrThrow("end_date"));
                    String type = c16.getString(c16.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn9.setOnClickListener(view -> {

            StudentDatabase sdb16 = new StudentDatabase(getApplicationContext());
            Cursor c16 = sdb16.getAssessments();

            Intent intent = new Intent(CourseDetailsActivity.this, ViewAssessmentActivity.class);

            while (c16.moveToNext()) {
                if (btn9.getText().toString().equals(c16.getString(c16.getColumnIndexOrThrow("title")))) {

                    int course_id = Integer.parseInt(c16.getString(c16.getColumnIndexOrThrow("_id")));
                    String courseTitle = c16.getString(c16.getColumnIndexOrThrow("title"));
                    String startDate = c16.getString(c16.getColumnIndexOrThrow("start_date"));
                    String endDate = c16.getString(c16.getColumnIndexOrThrow("end_date"));
                    String type = c16.getString(c16.getColumnIndexOrThrow("type"));
                    findRemainingWeeks(courseTitle, startDate, endDate, intent, course_id, type);
                }
            }
        });

        btn0.setVisibility(View.INVISIBLE);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        btn4.setVisibility(View.INVISIBLE);
        btn5.setVisibility(View.INVISIBLE);
        btn6.setVisibility(View.INVISIBLE);
        btn7.setVisibility(View.INVISIBLE);
        btn8.setVisibility(View.INVISIBLE);
        btn9.setVisibility(View.INVISIBLE);

        assert c != null;
        Log.d(TAG, "onCreate: c count " + c.getCount());
        if (c.getCount() >= -1) {
            int i = 0;
            while (c.moveToNext()) {
                switch (i) {
                    case 0:
                        btn0.setText(c.getString(1));
                        btn0.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 1:
                        btn1.setText(c.getString(1));
                        btn1.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 2:
                        btn2.setText(c.getString(1));
                        btn2.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 3:
                        btn3.setText(c.getString(1));
                        btn3.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 4:
                        btn4.setText(c.getString(1));
                        btn4.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 5:
                        btn5.setText(c.getString(1));
                        btn5.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 6:
                        btn6.setText(c.getString(1));
                        btn6.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 7:
                        btn7.setText(c.getString(1));
                        btn7.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 8:
                        btn8.setText(c.getString(1));
                        btn8.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                    case 9:
                        btn9.setText(c.getString(1));
                        btn9.setVisibility(View.VISIBLE);
                        ++i;
                        break;
                }
            }
        }
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            Log.i(TAG, "onDown: ");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.i(TAG, "onFling: ");
            if (velocityX > 500) {
                startActivity(new Intent(CourseDetailsActivity.this, DashboardActivity.class));
            }
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_courses, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public class DeleteCourse extends AsyncTask<Integer, Object, Integer> {
        StudentDatabase dbConnector = new StudentDatabase(getApplicationContext());

        @Override
        protected Integer doInBackground(Integer... params) {
            dbConnector.removeCourse(params[0]);
            return 1;
        }
        protected void onPostExecute(Integer result) {
            Toast.makeText(getApplicationContext(), "Course Deleted!", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Determine which menu option was chosen
        switch (item.getItemId()) {
            case android.R.id.home:
                //BACK BUTTON
                StudentDatabase sdb2 = new StudentDatabase(getApplicationContext());
                Cursor c2 = sdb2.getCourses3(Integer.parseInt(getIntent().getStringExtra("courseId")));

                if (c2.moveToNext()) {
                    Intent intent = new Intent(CourseDetailsActivity.this, TermDetailsActivity.class);
                    intent.putExtra("termId", getIntent().getStringExtra("termId"));
                    intent.putExtra("termName", getIntent().getStringExtra("termName"));
                    intent.putExtra("termStart", getIntent().getStringExtra("termStart"));
                    intent.putExtra("termEnd", getIntent().getStringExtra("termEnd"));
                    intent.putExtra("termProgress", c2.getString(4));
                    intent.putExtra("termNameAndDate", getIntent().getStringExtra("termNameAndDate"));
                    intent.putExtra("termMonthValue", getIntent().getStringExtra("termMonthValue"));
                    Log.i(TAG, "onOptionsItemSelected: " + getIntent().getStringExtra("termId"));
                    startActivity(intent);
                }
                return true;

            case R.id.action_zero_courses:
                // SET ALERTS
                Log.i(TAG, "onOptionsItemSelected: ");
                Toast.makeText(getApplicationContext(), "Course Alerts Set", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(CourseDetailsActivity.this, MyReceiverCourses.class);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // TERM VALUES
                i.putExtra("termMonthValue", getIntent().getStringExtra("termMonthValue"));
                i.putExtra("termName", getIntent().getStringExtra("termName"));
                i.putExtra("termStart", getIntent().getStringExtra("termStart"));
                i.putExtra("termEnd", getIntent().getStringExtra("termEnd"));
                i.putExtra("termNameAndDate", getIntent().getStringExtra("termNameAndDate"));
                i.putExtra("termId", getIntent().getStringExtra("termId"));

                // COURSE VALUES
                i.putExtra("courseMonthValue", getIntent().getStringExtra("courseMonthValue"));
                i.putExtra("courseNameAndDate", getIntent().getStringExtra("courseNameAndDate"));
                i.putExtra("courseId", getIntent().getStringExtra("courseId"));
                i.putExtra("courseOptionalNotes", getIntent().getStringExtra("courseOptionalNotes"));

                // TEST
                i.putExtra("courseTitleCopy", getIntent().getStringExtra("courseTitleCopy"));
                Log.i(TAG, "onOptionsItemSelected: " + getIntent().getStringExtra("courseTitleCopy"));
                i.putExtra("courseStartCopy", getIntent().getStringExtra("courseStartCopy"));
                Log.i(TAG, "onOptionsItemSelected: " + getIntent().getStringExtra("courseStartCopy"));
                i.putExtra("courseEndCopy", getIntent().getStringExtra("courseEndCopy"));
                Log.i(TAG, "onOptionsItemSelected: " + getIntent().getStringExtra("courseEndCopy"));

                PendingIntent sender = null;
                sender = PendingIntent.getBroadcast(CourseDetailsActivity.this, MainActivity.numAlert++, i, PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                // INTERVAL IS 24 HOURS.
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_HALF_DAY, sender);

                return true;

            case R.id.action_one_courses:
                //EDIT COURSE ACTIVITY
                Log.i(TAG, "onOptionsItemSelected:");
                StudentDatabase sdb1 = new StudentDatabase(getApplicationContext());
                Cursor c1 = sdb1.getCourses3(Integer.parseInt(getIntent().getStringExtra("courseId")));

                if (c1.moveToNext()) {
                    Intent intent = new Intent(CourseDetailsActivity.this, EditCourseActivity.class);
                    intent.putExtra("courseId", getIntent().getStringExtra("courseId"));
                    intent.putExtra("termName", c1.getString(1));
                    intent.putExtra("termStart", c1.getString(2));
                    intent.putExtra("termEnd", c1.getString(3));
                    intent.putExtra("termProgress", c1.getString(4));
                    intent.putExtra("termInstructorName", c1.getString(5));
                    intent.putExtra("termInstructorPhone", c1.getString(6));
                    intent.putExtra("termInstructorEmail", c1.getString(7));
                    intent.putExtra("optionalNotes", c1.getString(9));
                    Log.i(TAG, "onOptionsItemSelected:" + getIntent().getStringExtra("termId"));
                    startActivity(intent);
                }

                return true;

            case R.id.action_two_courses:
                //DELETE COURSE ACTIVITY
                Log.i(TAG, "onOptionsItemSelected: ");
                StudentDatabase sdb = new StudentDatabase(getApplicationContext());
                Cursor c = sdb.getAssessments2(courseId);

                if (c.moveToNext()) {
                    FragmentManager manager = getSupportFragmentManager();
                    DeleteError2DialogFragment dialog = new DeleteError2DialogFragment();
                    dialog.show(manager, "deleteErrorDialog");
                } else {
                    new DeleteCourse().execute(courseId);
                    Intent intent = new Intent(CourseDetailsActivity.this, TermDetailsActivity.class);
                    intent.putExtra("termMonthValue", getIntent().getStringExtra("termMonthValue"));
                    intent.putExtra("termName", getIntent().getStringExtra("termName"));
                    intent.putExtra("termStart", getIntent().getStringExtra("termStart"));
                    intent.putExtra("termEnd", getIntent().getStringExtra("termEnd"));
                    intent.putExtra("termNameAndDate", getIntent().getStringExtra("termNameAndDate"));
                    intent.putExtra("termId", getIntent().getStringExtra("termId"));
                    startActivity(intent);
                }

                return true;

            case R.id.action_three_courses:
                //SHARE COURSE NOTES
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("courseOptionalNotes"));
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void findRemainingWeeks(String termTitle, String startDate, String endDate, Intent intent, int term_id, String type) {
        String[] parseStart = startDate.split(" ");
        int monthIndexStart = 0;

        if (parseStart[0].equals("JAN")) {
            monthIndexStart = 1;
        }
        if (parseStart[0].equals("FEB")) {
            monthIndexStart = 2;
        }
        if (parseStart[0].equals("MAR")) {
            monthIndexStart = 3;
        }
        if (parseStart[0].equals("APR")) {
            monthIndexStart = 4;
        }
        if (parseStart[0].equals("MAY")) {
            monthIndexStart = 5;
        }
        if (parseStart[0].equals("JUN")) {
            monthIndexStart = 6;
        }
        if (parseStart[0].equals("JUL")) {
            monthIndexStart = 7;
        }
        if (parseStart[0].equals("AUG")) {
            monthIndexStart = 8;
        }
        if (parseStart[0].equals("SEP")) {
            monthIndexStart = 9;
        }
        if (parseStart[0].equals("OCT")) {
            monthIndexStart = 10;
        }
        if (parseStart[0].equals("NOV")) {
            monthIndexStart = 11;
        }
        if (parseStart[0].equals("DEC")) {
            monthIndexStart = 12;
        }

        String[] parseEnd = endDate.split(" ");
        int monthIndexEnd = 0;

        if (parseEnd[0].equals("JAN")) {
            monthIndexEnd = 1;
        }
        if (parseEnd[0].equals("FEB")) {
            monthIndexEnd = 2;
        }
        if (parseEnd[0].equals("MAR")) {
            monthIndexEnd = 3;
        }
        if (parseEnd[0].equals("APR")) {
            monthIndexEnd = 4;
        }
        if (parseEnd[0].equals("MAY")) {
            monthIndexEnd = 5;
        }
        if (parseEnd[0].equals("JUN")) {
            monthIndexEnd = 6;
        }
        if (parseEnd[0].equals("JUL")) {
            monthIndexEnd = 7;
        }
        if (parseEnd[0].equals("AUG")) {
            monthIndexEnd = 8;
        }
        if (parseEnd[0].equals("SEP")) {
            monthIndexEnd = 9;
        }
        if (parseEnd[0].equals("OCT")) {
            monthIndexEnd = 10;
        }
        if (parseEnd[0].equals("NOV")) {
            monthIndexEnd = 11;
        }
        if (parseEnd[0].equals("DEC")) {
            monthIndexEnd = 12;
        }

        int numOfWeeks = 0;
        try {
            @SuppressLint("SimpleDateFormat") Date userStart = new SimpleDateFormat("yyyy MM dd").parse(parseStart[2] + " " + monthIndexStart + " " + parseStart[1]);
            @SuppressLint("SimpleDateFormat") Date userEnd = new SimpleDateFormat("yyyy MM dd").parse(parseEnd[2] + " " + monthIndexEnd + " " + parseEnd[1]);
            assert userStart != null;
            assert userEnd != null;
            long diff =  userEnd.getTime() - userStart.getTime();
            int numOfDays = (int) (diff / (1000 * 60 * 60 * 24));
            numOfWeeks = (numOfDays / 7);

            Log.i(TAG, "onClick: NUMBER OF WEEKS: " + numOfWeeks);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        intent.putExtra("termMonthValue", getIntent().getStringExtra("termMonthValue"));
        intent.putExtra("termName", getIntent().getStringExtra("termName"));
        intent.putExtra("termStart", getIntent().getStringExtra("termStart"));
        intent.putExtra("termEnd", getIntent().getStringExtra("termEnd"));
        intent.putExtra("termNameAndDate", getIntent().getStringExtra("termNameAndDate"));
        intent.putExtra("termId", getIntent().getStringExtra("termId"));

        intent.putExtra("courseMonthValue", getIntent().getStringExtra("courseMonthValue"));
        intent.putExtra("courseNameAndDate", getIntent().getStringExtra("courseNameAndDate"));
        intent.putExtra("courseId", getIntent().getStringExtra("courseId"));
        intent.putExtra("courseOptionalNotes", getIntent().getStringExtra("courseOptionalNotes"));

        intent.putExtra("assessmentMonthValue", String.valueOf(numOfWeeks));
        intent.putExtra("assessmentId", term_id);
        intent.putExtra("assessmentTitle", termTitle);
        intent.putExtra("assessmentStart", startDate);
        intent.putExtra("assessmentEnd", endDate);
        intent.putExtra("assessmentType", type);
        startActivity(intent);
    }
}
