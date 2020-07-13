package br.com.soap.service.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.soap.students.GetStudentDetailsRequest;
import com.demo.soap.students.GetStudentDetailsResponse;
import com.demo.soap.students.StudentDetails;

@Endpoint
public class StudentEndpoint {

	@PayloadRoot(namespace = "http://soap_demo.com/students", localPart = "GetStudentDetailsRequest")
	@ResponsePayload
	public GetStudentDetailsResponse processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {
		GetStudentDetailsResponse response = new GetStudentDetailsResponse();
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setId(request.getId());
		studentDetails.setName("Adam");
		studentDetails.setPassportNumber("E1234567");
		response.setStudentDetails(studentDetails);
		return response;
	}
}
