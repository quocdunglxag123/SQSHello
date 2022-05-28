package sqs;

import java.awt.print.Printable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.json.JSONArray;
import org.json.JSONObject;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int check = 1;
		String fName = request.getParameter("fNameinput");
		String lName = request.getParameter("lNameinput");

		try {
			AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
			String queueUrl = "https://sqs.us-east-1.amazonaws.com/015207326210/TriggerHelloWord";
			SendMessageRequest send_msg_request = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody("{"

					+ '"' + "fName" + '"' + ":" + '"' + fName + '"' + "," + '"' + "lName" + '"' + ":" + '"' + lName
					+ '"' + "}").withDelaySeconds(3);
			// Return ID Of message
			SendMessageResult result = sqs.sendMessage(send_msg_request);
			System.out.print(result.getMessageId());
		} catch (Exception e) {
			check = 0;
			System.out.print("cannot insert");
		}


		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
