package ir.frh.persiandatepicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;


import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Date;

import ir.frh.persiandatepicker.util.PersianCalendar;
import ir.frh.persiandatepicker.util.PersianHelper;

public class PersianDatePickerDialog {

    public static final int THIS_YEAR = -1;
    public static final int NO_TITLE = 0;
    public static final int DAY_MONTH_YEAR = 1;
    public static final int WEEKDAY_DAY_MONTH_YEAR = 2;

    private Context context;
    private String positiveButtonString = "تایید";
    private String submitButtonString = "ضبت";
    private String negativeButtonString = "انصراف";
    private Listener listener;
    private Listener listener2;

    public boolean hideYear = false;
    public boolean hideMonth = false;
    public boolean hideDay = false;

    private int maxYear = 0;
    private int minYear = 0;
    private PersianCalendar initDate = new PersianCalendar();
    private PersianCalendar pCalendar;
    public static Typeface typeFace;
    private String todayButtonString = "امروز";
    private boolean todayButtonVisibility = false;
    private boolean buttonTodayDismissOk;
    private boolean buttonSubmit;

    private int actionColor = Color.GRAY;
    private int submitColor = Color.WHITE;
    private int backgroundColor = Color.WHITE;
    private int titleColor = Color.parseColor("#111111");
    private boolean cancelable = true;
    private boolean forceMode;
    private int pickerBackgroundColor;
    private int pickerBackgroundDrawable;
    private int backgroundDrawable;


    private int pickerLeavesBackgroundDrawable;
    private int pickerButtonSubmitBackgroundDrawable;


    private int titleType = 0;
    private boolean showInBottomSheet;

    public PersianDatePickerDialog(Context context) {
        this.context = context;
    }

    public PersianDatePickerDialog setListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public PersianDatePickerDialog setbuttonSubmitListener(Listener listener) {
        this.listener2 = listener;
        return this;
    }


    public PersianDatePickerDialog setMaxYear(int maxYear) {
        this.maxYear = maxYear;
        return this;
    }

    public PersianDatePickerDialog setTypeFace(Typeface typeFace) {
        this.typeFace = typeFace;
        return this;
    }

    public PersianDatePickerDialog setMinYear(int minYear) {
        this.minYear = minYear;
        return this;
    }

    public PersianDatePickerDialog setInitDate(PersianCalendar initDate) {
        return setInitDate(initDate, false);
    }

    public PersianDatePickerDialog setInitDate(PersianCalendar initDate, boolean force) {
        this.forceMode = force;
        this.initDate = initDate;
        return this;
    }

    public PersianDatePickerDialog setPositiveButtonString(String positiveButtonString) {
        this.positiveButtonString = positiveButtonString;
        return this;
    }

    public PersianDatePickerDialog setPositiveButtonResource(@StringRes int positiveButton) {
        this.positiveButtonString = context.getString(positiveButton);
        return this;
    }

    public PersianDatePickerDialog setTodayButtonVisible(boolean todayButtonVisiblity) {
        this.todayButtonVisibility = todayButtonVisiblity;
        return this;
    }

    public PersianDatePickerDialog setTodayButton(String todayButton) {
        this.todayButtonString = todayButton;
        return this;
    }

    public PersianDatePickerDialog setButtonSubmitText(String todayButton) {
        this.submitButtonString = todayButton;
        return this;
    }

    public PersianDatePickerDialog setTodayButtonResource(@StringRes int todayButton) {
        this.todayButtonString = context.getString(todayButton);
        return this;
    }


    public PersianDatePickerDialog setNegativeButton(String negativeButton) {
        this.negativeButtonString = negativeButton;
        return this;
    }

    public PersianDatePickerDialog setNegativeButtonResource(@StringRes int negativeButton) {
        this.negativeButtonString = context.getString(negativeButton);
        return this;
    }

    public PersianDatePickerDialog setActionTextColor(@ColorInt int colorInt) {
        this.actionColor = colorInt;
        return this;
    }

    public PersianDatePickerDialog setButtonSubmitColor(@ColorInt int colorInt) {
        this.submitColor = colorInt;
        return this;
    }

    public PersianDatePickerDialog setActionTextColorResource(@ColorRes int colorInt) {
        this.actionColor = ContextCompat.getColor(context, colorInt);
        return this;
    }

    public PersianDatePickerDialog setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public PersianDatePickerDialog setBackgroundColor(@ColorInt int bgColor) {
        this.backgroundColor = bgColor;
        return this;
    }

    public PersianDatePickerDialog setTitleColor(@ColorInt int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    public PersianDatePickerDialog setPickerBackgroundColor(@ColorInt int color) {
        this.pickerBackgroundColor = color;
        return this;
    }


    public PersianDatePickerDialog setPickerBackgroundDrawable(@DrawableRes int drawableBg) {
        this.pickerBackgroundDrawable = drawableBg;
        return this;
    }

    public PersianDatePickerDialog setBackgroundDrawable(@DrawableRes int drawableBg) {
        this.backgroundDrawable = drawableBg;
        return this;
    }

    public PersianDatePickerDialog setLeavesBackgroundDrawable(@DrawableRes int drawableBg) {
        this.pickerLeavesBackgroundDrawable = drawableBg;
        return this;
    }

    public PersianDatePickerDialog setButtonSubmitBackgroundDrawable(@DrawableRes int drawableBg) {
        this.pickerButtonSubmitBackgroundDrawable = drawableBg;
        return this;
    }

    public PersianDatePickerDialog setTitleType(int titleType) {
        this.titleType = titleType;
        return this;
    }

    public PersianDatePickerDialog setShowInBottomSheet(boolean b) {
        this.showInBottomSheet = b;
        return this;
    }

    public PersianDatePickerDialog showTodayDismissOk(boolean b) {
        this.buttonTodayDismissOk = b;
        return this;
    }

    public PersianDatePickerDialog showLinearSubmit(boolean b) {
        this.buttonSubmit = b;
        return this;
    }

    public PersianDatePickerDialog hideYear(boolean hideYear) {
        this.hideYear = hideYear;
        return this;
    }

    public PersianDatePickerDialog hideMonth(boolean hideMonth) {
        this.hideMonth = hideMonth;
        return this;
    }

    public PersianDatePickerDialog hideDay(boolean hideDay) {
        this.hideDay = hideDay;
        return this;
    }


    public void show() {

        pCalendar = new PersianCalendar();

        View v = View.inflate(context, R.layout.dialog_picker, null);
        final PersianDatePicker datePicker = v.findViewById(R.id.datePicker);
        final TextView dateText = v.findViewById(R.id.dateText);
        final AppCompatButton positiveButton = v.findViewById(R.id.positive_button);
        final AppCompatButton negativeButton = v.findViewById(R.id.negative_button);
        final AppCompatButton todayButton = v.findViewById(R.id.today_button);
        final RelativeLayout container = v.findViewById(R.id.container);
        final ImageView imageViewBackgroundLeaves = v.findViewById(R.id.imageView_background_leaves);
        final LinearLayout linearTodayDismissOk = v.findViewById(R.id.linear_today_dismiss_ok);
        final LinearLayout linearSubmit = v.findViewById(R.id.linear_submit);
        final AppCompatButton ButtonSubmit = v.findViewById(R.id.button_submit);
        final RelativeLayout backgroundDatePicker = v.findViewById(R.id.relativelayout_background_date_picker);


        imageViewBackgroundLeaves.setBackgroundResource(pickerLeavesBackgroundDrawable);
        ButtonSubmit.setBackgroundResource(pickerButtonSubmitBackgroundDrawable);

        container.setBackgroundColor(backgroundColor);
        dateText.setTextColor(titleColor);

        if (hideYear) {
            v.findViewById(R.id.yearNumberPicker).setVisibility(View.GONE);
        }
        if (hideMonth) {
            v.findViewById(R.id.monthNumberPicker).setVisibility(View.GONE);
        }
        if (hideDay) {
            v.findViewById(R.id.dayNumberPicker).setVisibility(View.GONE);
        }


        if (buttonTodayDismissOk) {
            linearTodayDismissOk.setVisibility(View.VISIBLE);
        }
        if (buttonSubmit) {
            linearSubmit.setVisibility(View.VISIBLE);
        }

        if (pickerBackgroundColor != 0) {
            datePicker.setBackgroundColor(pickerBackgroundColor);
        } else if (pickerBackgroundDrawable != 0) {
            datePicker.setBackgroundDrawable(pickerBackgroundDrawable);
        }

        if (backgroundDrawable != 0) {
            backgroundDatePicker.setBackgroundResource(backgroundDrawable);
        }


        if (maxYear > 0) {
            datePicker.setMaxYear(maxYear);
        } else if (maxYear == THIS_YEAR) {
            maxYear = pCalendar.getPersianYear();
            datePicker.setMaxYear(pCalendar.getPersianYear());
        }

        if (minYear > 0) {
            datePicker.setMinYear(minYear);
        } else if (minYear == THIS_YEAR) {
            minYear = pCalendar.getPersianYear();
            datePicker.setMinYear(pCalendar.getPersianYear());
        }

        if (initDate != null) {
            int initYear = initDate.getPersianYear();
            if (initYear > maxYear || initYear < minYear) {
                Log.e("PERSIAN CALENDAR", "init year is more/less than minYear/maxYear");
                if (forceMode) {
                    datePicker.setDisplayPersianDate(initDate);
                }
            } else {
                datePicker.setDisplayPersianDate(initDate);
            }

        }

        if (typeFace != null) {
            dateText.setTypeface(typeFace);
            positiveButton.setTypeface(typeFace);
            ButtonSubmit.setTypeface(typeFace);
            negativeButton.setTypeface(typeFace);
            todayButton.setTypeface(typeFace);
            datePicker.setTypeFace(typeFace);

        }

        positiveButton.setTextColor(actionColor);
        negativeButton.setTextColor(actionColor);
        todayButton.setTextColor(actionColor);
        ButtonSubmit.setTextColor(submitColor);
        positiveButton.setText(positiveButtonString);
        negativeButton.setText(negativeButtonString);
        todayButton.setText(todayButtonString);
        ButtonSubmit.setText(submitButtonString);

        if (todayButtonVisibility) {
            todayButton.setVisibility(View.VISIBLE);
        }


        pCalendar = datePicker.getDisplayPersianDate();
        updateView(dateText);

        datePicker.setOnDateChangedListener(new PersianDatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(int newYear, int newMonth, int newDay) {
                pCalendar.setPersianDate(newYear, newMonth, newDay);
                updateView(dateText);
            }
        });


        final AppCompatDialog dialog;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && showInBottomSheet) {
            dialog = new BottomSheetDialog(context, R.style.AppTheme_fff);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            dialog.getWindow().setStatusBarColor(Color.TRANSPARENT);
            dialog.setContentView(v);
            container.setBackgroundColor(Color.TRANSPARENT);
            dialog.setCancelable(cancelable);

            ((View) v.getParent()).setBackgroundColor(Color.TRANSPARENT);

            dialog.create();
        } else {
            dialog = new AlertDialog.Builder(context)
                    .setView(v)
                    .setCancelable(cancelable)
                    .create();
        }

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onDismissed();
                }
                dialog.dismiss();
            }
        });

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onDateSelected(datePicker.getDisplayPersianDate());
                }
                dialog.dismiss();
            }
        });

        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDateSelected(datePicker.getDisplayPersianDate());
                }
                dialog.dismiss();
            }
        });

        todayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePicker.setDisplayDate(new Date());

                if (maxYear > 0) {
                    datePicker.setMaxYear(maxYear);
                }

                if (minYear > 0) {
                    datePicker.setMinYear(minYear);
                }

                pCalendar = datePicker.getDisplayPersianDate();
                dateText.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateView(dateText);
                    }
                }, 100);
            }
        });

        dialog.show();
    }


    private void updateView(TextView dateText) {
        String date;
        switch (titleType) {
            case NO_TITLE:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dateText.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 30);
                dateText.setLayoutParams(layoutParams);
                break;
            case DAY_MONTH_YEAR:
                date = pCalendar.getPersianDay() + " " +
                        pCalendar.getPersianMonthName() + " " +
                        pCalendar.getPersianYear();

                dateText.setText(PersianHelper.toPersianNumber(date));
                break;
            case WEEKDAY_DAY_MONTH_YEAR:
                date = pCalendar.getPersianWeekDayName() + " " +
                        pCalendar.getPersianDay() + " " +
                        pCalendar.getPersianMonthName() + " " +
                        pCalendar.getPersianYear();

                dateText.setText(PersianHelper.toPersianNumber(date));
                break;
            default:
                Log.d("PersianDatePickerDialog", "never should be here");
                break;
        }

    }

}
