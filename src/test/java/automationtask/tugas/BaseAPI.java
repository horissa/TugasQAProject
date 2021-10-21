package automationtask.tugas;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPI {
	RequestSpecification commonJsonSpec = new RequestSpecBuilder().
			setBaseUri("https://api-staging-builder.engineer.ai").
			setContentType(ContentType.JSON).build().log().all();
}
