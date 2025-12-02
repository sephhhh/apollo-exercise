package apollo.exercise.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(HttpMessageNotReadableException ex) {
		var error = new ErrorResponse("BAD_REQUEST", "Invalid JSON");
		return ResponseEntity.badRequest().body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
		return ResponseEntity.status(422).body("Unprocessable Entity");
	}

	record ErrorResponse(String error, String message) {
	}

}