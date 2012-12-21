PostageApp for Java
===============
[![Build Status](https://travis-ci.org/sleroux/postageapp_java.png)](https://travis-ci.org/sleroux/postageapp_java)

###Installation

You can get started by downloading the Postage App .jar from the Downloads page. Along with the main .jar you will need the following dependencies:

Along with the main package you will need the following dependencies:

* [Apache HTTP Components](http://hc.apache.org/)
	* httpcore 4.2.3
	* httpclient 4.2.2
	
* [Apache Commons](http://commons.apache.org/io/)
	* commons-io 2.4
	
* [Google GSON](http://code.google.com/p/google-gson/)
	* 2.2.2

If you are using maven you can also add use the maven dependency thanks to Sonatype/Nexus (Coming soon...):


Also make sure to add in the maven dependencies for HTTP Components, Commons and Google GSON
     
### Usage

To get started, grab a copy of postage app client and set your API key:

		PostageAppClient postageClient = PostageAppFactory.getSingleton();
		postageClient.setAPIKey("Your API Key Here!");
	
Try sending a message,

	    List<String> recipients = new ArrayList<String>();
        recipients.add("fakeemail@test.com");
        
        MessageParams params = new MessageParams()
        	.setRecipients(recipients)
        	.addContentType("text/plain", "This is a test!");
        	
        try {
			client.sendMessage(params);
		} catch (PostageAppException e) {
			e.printStackTrace();
		}

Besides sending messages you have access to all the other API endpoints as well:

* getMessageReceipt
* getMethodList
* getAccountInfo
* getProjectInfo
* getMessages
* getMessageTranmissions
* getMetrics
	
### Documentation

[PostageApp API Documentation](http://help.postageapp.com/kb/api/api-overview)


### Feedback / Props

* Thanks for the PostageApp guys for helpingout with the API
	
