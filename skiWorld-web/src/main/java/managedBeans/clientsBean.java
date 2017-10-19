package managedBeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.MessagingException;

import skiworld.services.MailServiceamin;


@Named
@RequestScoped
public class clientsBean {
	
	 private String recipient;
	    private String subject;
	    private String message;
	    private String statusMessage = "";

	public clientsBean() {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
     return message;
 }

 public void setMessage(String message) {
     this.message = message;
 }

 public String getRecipient() {
     return recipient;
 }

 public void setRecipient(String recipient) {
     this.recipient = recipient;
 }

 public String getSubject() {
     return subject;
 }

 public void setSubject(String subject) {
     this.subject = subject;
 }

 public String getStatusMessage() {
     return statusMessage;
 }
 
 public String send() {
   
     try {
         MailServiceamin.sendMessage(recipient, subject, message);
         statusMessage = "Message Sent";
     }
     catch(MessagingException ex) {
         statusMessage = ex.getMessage();
     }
     return "template";  // redisplay page with status message
 }
 


}
