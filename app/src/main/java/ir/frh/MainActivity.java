package ir.frh;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ir.frh.persiandatepicker.Listener;
import ir.frh.persiandatepicker.PersianDatePickerDialog;
import ir.frh.persiandatepicker.util.PersianCalendar;


public class MainActivity extends AppCompatActivity {

    private PersianDatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showCalendar(View v) {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Shabnam-Light-FD.ttf");

        PersianCalendar initDate = new PersianCalendar();
        initDate.setPersianDate(1370, 3, 13);

        picker = new PersianDatePickerDialog(this)
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .showTodayDismissOk(false)
                .showLinearSubmit(false)
                .setMinYear(1300)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setInitDate(initDate)
                .setButtonSubmitText("ثبت")
                .setButtonSubmitBackgroundDrawable(R.drawable.background_button_submit)
                .setBackgroundDrawable(R.drawable.background_bottomsheet)
                .setLeavesBackgroundDrawable(R.drawable.ic_group_1290)
                .setActionTextColor(Color.GRAY)
                .setButtonSubmitColor(Color.WHITE)
                .setTypeFace(typeface)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        Toast.makeText(MainActivity.this, persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        picker.show();
    }

    public void showCalendarInDarkMode(View v) {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Shabnam-Light-FD.ttf");

        PersianCalendar initDate = new PersianCalendar();
        initDate.setPersianDate(1370, 3, 13);

        picker = new PersianDatePickerDialog(this)
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1300)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setInitDate(initDate)
                .setActionTextColor(Color.GRAY)
                .setTypeFace(typeface)
                .setBackgroundColor(Color.BLACK)
                .setTitleColor(Color.WHITE)
                .setActionTextColor(Color.WHITE)
                .setPickerBackgroundDrawable(R.drawable.darkmode_bg)
                .setTitleType(PersianDatePickerDialog.DAY_MONTH_YEAR)
                .setCancelable(false)
                .setbuttonSubmitListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        Toast.makeText(MainActivity.this, persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onDismissed() {

                    }
                })
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        Toast.makeText(MainActivity.this, persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed() {

                    }

                });
        picker.show();
    }

}
