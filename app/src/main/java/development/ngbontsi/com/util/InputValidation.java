package development.ngbontsi.com.util;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class InputValidation {
	private final Context context;

	/**
	 * constructor
	 *
	 * @param context
	 */
	public InputValidation(Context context) {
		this.context = context;
	}

	/**
	 * method to Hide keyboard
	 *
	 * @param view
	 */
	private void hideKeyboardFrom(View view) {
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}


	/**
	 * method to check InputEditText has valid email .
	 *
	 * @param textInputEditText
	 * @param textInputLayout
	 * @param message
	 * @return
	 */
	public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message) {
		String value = textInputEditText.getText().toString().trim();
		if (value.equals("") || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
			textInputLayout.setError(message);
			hideKeyboardFrom(textInputEditText);
			return false;
		} else
			textInputLayout.setErrorEnabled(false);
		return true;
	}

	/**
	 * method to check InputEditText filled .
	 *
	 * @param textInputEditText
	 * @param textInputLayout
	 * @param message
	 * @return
	 */
	public boolean isInputEditTextFilled( TextInputEditText textInputEditText,TextInputLayout textInputLayout, String message) {

		if (textInputEditText.getText().toString().trim().equals("")) {
			textInputLayout.setError(message);
			hideKeyboardFrom(textInputEditText);
			return false;
		} else
			textInputLayout.setErrorEnabled(false);

		return true;
	}

	/**
	 * method to check InputEditText filled .
	 *
	 * @param textInputEditText
	 * @param textInputLayout
	 * @param message
	 * @return
	 */
	public boolean displayError( TextInputEditText textInputEditText,TextInputLayout textInputLayout, String message) {


			textInputLayout.setError(message);
			hideKeyboardFrom(textInputEditText);
			return false;

	}

	public boolean isInputEditTextMatches(TextInputEditText textInputEditText1,TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message) {

		if (!textInputEditText1.getText().toString().trim().contentEquals(textInputEditText2.getText().toString().trim())) {
			textInputLayout.setError(message);
			hideKeyboardFrom(textInputEditText2);
			return false;
		} else
			textInputLayout.setErrorEnabled(false);
		return true;
	}
}
