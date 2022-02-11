package com.example.intlistsorter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Presenter {

    public Presenter() {
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<String> filteredList(String arrayInput, String filterInput) {

        List<String> result = convertIntsToStringList(arrayInput);
        result.removeIf(string -> string.equals(filterInput));
        return result;
    }

    private static @NotNull
    List<String> convertIntsToStringList(@NotNull String text) {
        List<String> result = new ArrayList<>();

        int length = text.length();
        char[] charArray = new char[length];

        for (int i = 0; i < length; i++) {
            charArray[i] = text.charAt(i);
        }

        for (char ch : charArray) {
            result.add(String.valueOf(ch));
        }

        return result;
    }

}
