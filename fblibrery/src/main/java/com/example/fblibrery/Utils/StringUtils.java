package com.example.fblibrery.Utils;

import android.content.Context;

import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by munchado on 13-08-2018.
 */
public abstract class StringUtils {
    public static final String EMAIL_REGEX = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    public static String toTitleCase(String str) {

        if (str == null) {
            return null;
        }

        boolean space = true;
        StringBuilder builder = new StringBuilder (str);
        final int len = builder.length();

        for (int i = 0; i < len; ++i) {
            char c = builder.charAt(i);
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c));
                    space = false;
                }
            } else if (Character.isWhitespace(c)) {
                space = true;
            } else {
                builder.setCharAt(i, c);
            }
        }

        return builder.toString();
    }

    /**
     * @param pStr String object to be tested.
     * @returns true if the given string is null or empty or contains spaces
     * only.
     */
    public static boolean isNullOrEmpty(final String pStr) {
        return pStr == null || pStr.trim().length() == 0 || pStr.trim().equalsIgnoreCase("null");
    }

    /**
     * @param pEmail
     * @param pAllowBlank
     * @return true if pEmail matches with {@link StringUtils#EMAIL_REGEX},
     * false otherwise
     */
    public static boolean isValidEmail(String pEmail,boolean pAllowBlank) {
        if (pAllowBlank && isNullOrEmpty(pEmail)) {
            return true;
        }
        Pattern validRegexPattern = Pattern.compile(EMAIL_REGEX);
        return validRegexPattern.matcher(pEmail).matches();
    }

    /**
     * @returns
     */
    public static String firstLetterToUpperCase(String pWord) {
        pWord = pWord == null ? "" : pWord;
        String output = "";
        for (int i = 0; i < pWord.length(); i++) {
            if (i == 0) {
                output += Character.toUpperCase(pWord.charAt(i));
            } else {
                output += Character.toLowerCase(pWord.charAt(i));
            }
        }
        return output;
    }

    /**
     * @return
     * @note maxDigit validation can be implemented by XML
     */
    public static boolean isValidMobileNumber(String pMobileNumber,boolean pPlusSignNeeded,int pMinLength) {
        if (StringUtils.isNullOrEmpty(pMobileNumber)) {
            return false;
        }
        pMobileNumber = pMobileNumber.trim();
        if (pPlusSignNeeded && !pMobileNumber.startsWith("+")) {
            return false;
        }
        return pMobileNumber.length() >= pMinLength;
    }


    /**
     * @param pEncodedString
     * @param pIsUrlEncoding
     * @return
     */
    public static String decode(String pEncodedString,String pCharsetName,boolean pIsUrlEncoding) {
        try {
            if (pIsUrlEncoding) {
                return URLDecoder.decode(pEncodedString, pCharsetName);
            } else {
                return new String (pEncodedString.getBytes(), pCharsetName);
            }
        } catch (Exception e) {
            return "";
        }
    }


    public static int getResourceId(Context context,String name,String resourceType) {
        return context.getResources().getIdentifier(name, resourceType, context.getPackageName());
    }

    public static boolean isNullOrEmpty(List<?> arrayList) {
        return ( null == arrayList || arrayList.size() == 0);
    }

    public static String formatSingleDigit(int a) {
        if (a > 9)
            return a + "";
        else
            return "0" + a;
    }
}

