PostageApp for Java
===============
[![Build Status](https://travis-ci.org/sleroux/postageapp_java.png)](https://travis-ci.org/sleroux/postageapp_java)

###Installation

####Maven

To get started with PostageApp using maven, you can add the following to your pom.xml file:

	<dependencies>
		...
	    <dependency>
	      <groupId>com.github.postageapp</groupId>
	      <artifactId>postageapp</artifactId>
	      <version>1.1.0</version>
	    </dependency>
	    ...
	</dependencies>
	
#### Manually

You ahead and download the latest release tag and you can build the uber jar for requiring into your project as well as a
thin jar if you wish to include the other dependencies yourself. Once you download the tag, go into the project directory and run:

	mvn clean package
	
Inside the target/ folder you will have uber jar as well as the thin jar.

### Usage

To get started, grab a copy of PostageApp client and set your API key:

		PostageAppClient postageClient = PostageAppFactory.getSingleton();
		postageClient.setAPIKey("Your API Key Here!");
	
#### Sending a Message

Setting up a message to send is easy! Using the `MessageParams` class you can build your message before sending it to the API:

	MessageParams params = new MessageParams()
	
Once you have configured your `MessageParams` you can ship it off to the API using the `sendMessage` call:

	try {
		postageClient.sendMessage(params);
	} catch (PostageAppException exception) {
		// Handle API Exception
	}
	
##### Adding Recipients

To add a list of recipients to your message:

	List<String> recipients = new ArrayList<String>();
	recipients.add("someone@someemail.com");
	
	params.setRecipients(recipients);

##### Adding Attachments

To add attachments to your message parameters:

	String pdfName = "filename.pdf";
	String contentType = "application/octet-stream";
	String encodedData = "BASE64_ENCODED_DATA";
	
	params.addAttachment(pdfName, contentType, encodedDate);

##### Adding Content

Adding content to message paramters:

	String contentType = "text/plain";
	String content = "This is a test!";
	
	params.addContentType(contentType, content);
	
##### Method Chaining

For convenience, you can also change the building of parameters using the builder pattern:

    List<String> recipients = new ArrayList<String>();
       recipients.add("fakeemail@test.com");
       
       MessageParams params = new MessageParams()
       	.setRecipients(recipients)
       	.addContentType("text/plain", "This is a test!");

Besides sending messages you have access to all the other API endpoints as well:

* getMessageReceipt
* getMethodList
* getAccountInfo
* getProjectInfo
* getMessages
* getMessageTranmissions
* getMetrics
* getMessageStatus
* getMessageDeliveryStatus
* getRecipientsList

Refer to the online documation / javadocs for usage for these endpoints.

	
### Documentation

API Documentation: [PostageApp API Documentation](http://dev.postageapp.com/pages/api)

### Contributors

	* [Stephan Leroux](https://github.com/sleroux)
	* [Derek Watson](https://github.com/derek-watson)
	* [Scott Tadman](https://github.com/tadman)
