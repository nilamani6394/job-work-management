package com.nilmani.jobworkmanagement.validation

import java.util.regex.Matcher
import java.util.regex.Pattern


/**Name contain only letter not number */
fun String.validateLetters(): Boolean {

    val regx = "^[a-zA-Z\\s]+$"
    val pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE)
    val matcher: Matcher = pattern.matcher(this)
    return matcher.find()
}

/**Email validation*/

fun String.isValid(): Boolean {
    val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$"
    val pat = Pattern.compile(emailRegex)
    return pat.matcher(this).matches()
}

/**password validation */
fun String.isValidPassword(): Boolean {

    //check
    val regex = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")
    // Compile
    val p = Pattern.compile(regex)
    if (this == null) {
        return false
    }
    val m = p.matcher(this)

    return m.matches()
}


