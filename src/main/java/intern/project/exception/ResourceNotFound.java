package intern.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFound(String e) {
		// TODO Auto-generated constructor stub
		super(e);
	}
}
