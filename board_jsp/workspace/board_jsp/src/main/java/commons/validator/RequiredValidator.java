package commons.validator;

import models.member.Member;

public interface RequiredValidator {

	default void checkedrequired(String data, RuntimeException e) {
		if (data == null || data.isBlank()) {
			throw e;
		}
	}
}
