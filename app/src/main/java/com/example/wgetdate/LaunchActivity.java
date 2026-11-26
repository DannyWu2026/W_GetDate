package com.example.wgetdate;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class LaunchActivity extends Activity {
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy/M/d", Locale.ROOT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            ClipboardManager clipboard = getSystemService(ClipboardManager.class);
            if (clipboard == null) {
                Log.e("W_GetDate", "Clipboard service is unavailable");
                Toast.makeText(this, R.string.copy_failed, Toast.LENGTH_SHORT).show();
            } else {
                String date = LocalDate.now().format(DATE_FORMAT);
                clipboard.setPrimaryClip(ClipData.newPlainText("date", date));
            }
        } catch (SecurityException error) {
            Log.e("W_GetDate", "Could not copy date", error);
            Toast.makeText(this, R.string.copy_failed, Toast.LENGTH_SHORT).show();
        } finally {
            finish();
        }
    }
}
