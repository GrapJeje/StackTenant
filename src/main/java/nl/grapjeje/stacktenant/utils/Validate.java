package nl.grapjeje.stacktenant.utils;

import java.util.regex.Pattern;

public class Validate {
    private static final Pattern STRICT_EMAIL_PATTERN = Pattern.compile(
            "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$"
    );

    public static boolean email(String email) {
        if (email == null || email.trim().isEmpty())
            return false;

        if (email.length() > 254 ||
                email.startsWith(".") ||
                email.contains("..") ||
                email.contains("@.")) {
            return false;
        }

        int atIndex = email.lastIndexOf('@');
        if (atIndex < 1 || atIndex > email.length() - 3)
            return false;

        String localPart = email.substring(0, atIndex);

        return localPart.length() > 64 || !STRICT_EMAIL_PATTERN.matcher(localPart).matches();
    }
}