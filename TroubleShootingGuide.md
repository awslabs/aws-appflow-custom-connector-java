### TroubleShooting Guide

##### 1. OOM from the lambda: 
Since your lambda connector will perform memory/CPU bound operation you might experience OOM exception (java.lang.OutOfMemoryError). Please go to your lambda log group and check for the java.lang.OutOfMemoryError exception. Below is the Sample Stack Trace: 

````
Metaspace: java.lang.OutOfMemoryError
java.lang.OutOfMemoryError: Metaspace
at java.lang.ClassLoader.defineClass1(Native Method)
at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
at java.net.URLClassLoader.defineClass(URLClassLoader.java:473)
at java.net.URLClassLoader.access$100(URLClassLoader.java:74)
at java.net.URLClassLoader$1.run(URLClassLoader.java:369)
at java.net.URLClassLoader$1.run(URLClassLoader.java:363)
at java.security.AccessController.doPrivileged(Native Method)
at java.net.URLClassLoader.findClass(URLClassLoader.java:362)
at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
````

To resolve this issue , Please increase the  Memory allocation of your lambda. To know more please read


- https://docs.aws.amazon.com/lambda/latest/operatorguide/configurations.html#memory-config

##### 2. Exception while processing the request due to AccessDeniedException
````
java.lang.RuntimeException: Unable to get secrets from SecretsManager. SecretArn [……..]  ….
because no identity-based policy allows the secretsmanager:GetSecretValue action (Service: AWSSecretsManager; Status Code: 400; Error Code: AccessDeniedException; Request ID: 3a2e678c-cfb0-4076-81d1-ac396649817e; Proxy: null)
at com.amazonaws.http.AmazonHttpClient$RequestExecutor.handleErrorResponse(AmazonHttpClient.java:1819)
at com.amazonaws.http.AmazonHttpClient$RequestExecutor.handleServiceErrorResponse(AmazonHttpClient.java:1403)
````

Your lambda fetches the credentials from the secret created in the secret manager in your AWS account.To fetch the credentials it uses getSecrets function on the secret. This type of error indicates that 
your lambda do not have permission on getSecret on your secrets. Please add the required permissions to your lambda.

##### 3. AccessDeniedException from Secrets even after providing the correct permissions to my connector lambda.

This happens when you try to access your secret right after making the changes in the permissions. AWS Secrets Manager uses a distributed computing model called eventual consistency. Any change that you make in Secrets Manager (or other AWS services) takes time to become visible from all possible endpoints. Some of the delay results from the time it takes to send the data from server to server, from replication zone to replication zone, and from region to region around the world.

Please read  https://docs.aws.amazon.com/secretsmanager/latest/userguide/troubleshoot_general.html#troubleshoot_general_eventual-consistency for more details.


##### 4. ResourceNotFoundException from Secret Manager.
Below is the Sample Stack Trace: 

````
Exception while processing the request due to java.lang.RuntimeException: Unable to get secrets from SecretsManager. SecretArn [arn:aws:secretsmanager:eu-west-3:.....]: Secrets Manager can't find the specified secret. (Service: AWSSecretsManager; Status Code:
 400; Error Code: ResourceNotFoundException; Request ID: 2741f26a-4bd1-42ac-a1e6-fab49f2e3ea7; Proxy: null)
 \n\tat com.amazonaws.appflow.custom.connector.util.CredentialsProvider.getCredentials(CredentialsProvider.java:71)
````

Amazon AppFlow creates the secret in AppFlow user account and then pass the secret arn to the connector. AWS Secrets Manager uses a distributed computing model called eventual consistency. Any change that you make in Secrets Manager (or other AWS services) takes time to become visible from all possible endpoints. Some of the delay results from the time it takes to send the data from server to server, from replication zone to replication zone, and from region to region around the world.

Please read  https://docs.aws.amazon.com/secretsmanager/latest/userguide/troubleshoot_general.html#troubleshoot_general_eventual-consistency for more details.

#### 5. How do I put logs or find logs
AppFlow provides `flowName/connectorProfileLabel/executionId` to the `ConnectorContext`. Please use these string to query the log group for your lambda in the cloudwatch. Please Read more here : https://docs.aws.amazon.com/AmazonCloudWatch/latest/logs/CWL_QuerySyntax.html for more advanced cloudwatch queries.

#### 6. Resolving issues becuase of connector lambda cold start.
This can happen when connector lambda is being invoked after a long period of inactivity. This cold start can result in timeout issues. Please follow the below links to know more on how to avoid such issues: 
https://aws.amazon.com/blogs/compute/operating-lambda-performance-optimization-part-1/
https://aws.amazon.com/blogs/compute/new-for-aws-lambda-predictable-start-up-times-with-provisioned-concurrency/



