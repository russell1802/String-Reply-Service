package com.beta.replyservice;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.http.HttpStatus;


public class ReplyMessageV2 {
  
  private final HttpStatus statusCode;
	private final String message;
 

	public ReplyMessageV2(String message) {
        HttpStatus status = HttpStatus.OK; //http code return
        String string = message.substring(message.lastIndexOf("-") + 1);// get string from message
        String code = message.substring( 0, message.indexOf("-")); //get rules from rules
        char[] rules = code.toCharArray();// get each code from rules, dynamic for future use


        loop: for (int i = 0; i < rules.length; i++) {    //loop for all codes, dynamic for future use

              switch(rules[i]) {
                case '1':{
                  string = new StringBuilder(string).reverse().toString(); //reserve the string
                  break;}
                case '2':  {
                try{
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    md.update(string.getBytes(), 0, string.length());
                    string = new BigInteger(1, md.digest()).toString(32);

                } catch (NoSuchAlgorithmException e){// Exception handling

                  status = HttpStatus.BAD_REQUEST;
                  string = "Exception";
                  
                }         
                 break;}
                // add more code if needed
                default:
                  string = "Invalid input";
                  status = HttpStatus.BAD_REQUEST; //error handling if code is not available
                  break loop;                   
              }

        }

    
    this.statusCode = status;
		this.message = string;
  }

	public HttpStatus getStatus() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	}

