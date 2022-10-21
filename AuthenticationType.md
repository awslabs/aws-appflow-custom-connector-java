# Authentication Type

SDK supports the below Authentication types that can be used by the connector:

1. BasicAuth
2. APIKey 
3. OAuth2.0
4. CustomAuth

## BasicAuth

Standard Username and Password based authentication. AppFlow will ask the user to provide the username and password and stores in Customer's account secret manager. AppFlow will provide SecretManagerARN to the connector where the `username` and `password` values are stored provided as key-value pairs.

## APIKey

API Key and Secret Key based Authentication. AppFlow will ask the user to provide the ApiKey and SecretKey and stores in Customer's secret manager. AppFlow will provide SecretManagerARN to the connector where the `apiKey` and `apiSecretKey` values are stored provided as key-value pairs.

## OAuth2.0

OAuth 2.0, which stands for `Open Authorization`, is a standard designed to allow a website or application to access resources hosted by other web apps on behalf of a user. 

OAuth 2.0 provides consented access and restricts actions of what the client app can perform on resources on behalf of the user, without ever sharing the user's credentials.

AppFlow provides the inbuilt support for the 3 legged and 2 legged OAuth2 and responsible for generating the AuthorizationCode/AccessToken and also handles the access token refresh when its expired/invalid.

AppFlow will provide SecretManagerARN to the connector where the `accessToken` and `refreshToken` are stored as key-value pairs.

`SDK provides the support for below OAuth2 grant types flows:`

1. Authorization Code
2. Client Credentials

#### Authorization Code

The Authorization Code grant type is used by confidential and public clients to exchange an authorization code for an access token.

After the user returns to the client via the redirect URL, the application will get the authorization code from the URL and use it to request an access token.

#### Client Credentials

The Client Credentials grant type is used by clients to obtain an access token outside of the context of a user.

This is typically used by clients to access resources about themselves rather than to access a user's resources.


**SDK provides the support for below customizable OAuth2 properties which can be defined as per the Application OAuth2 specification. And AppFlow will use this configuration while performing the OAuth2.0 to generate the AuthorizationCode/AccessToken/RefreshToken.**

1. **OAuth2GrantType** - OAuth2 GrantType supported by the Application.
2. **Scopes** - Scopes needs to be provided to Application as parameter while getting AuthorizationCode/getting the access token in case of client credentials.
3. **TokenUrls** - URLs which are required to get the accessToken/RefreshToken. This URL can be in two format - Static and Template based where we need the input from the Customer to build the complete URL.
    For Static URLs you can add the URL directly to this list like - https://login.salesforce.com/services/oauth2/token
    And for template based URLs, you can use this format - https://{{SALESFORCE_SUBDOMAIN}}.auth.marketingcloudapis.com/v2/token where the SALESFORCE_SUBDOMAIN will be the user input and AppFlow will ask the customers to provide its value while configuring the connector profile. 
4. **AuthUrls** - URLs which are required to get the Authorization code. This URL can be in two format - Static and Template based.
5. **OAuth2ContentType** - OAuth2 Content type to use in the request header while making request to the Application. Default: "application/x-www-form-urlencoded"
6. **OAuth2MethodType** - OAuth2 Http method(POST/GET) to get the token from the Application . Default: "POST"
7. **OAuth2CustomProperties**  - Custom parameters needs to be provided while making the request to the Application. AppFlow will ask the user to provide these inputs and will add these as key value pairs while making the request to the Application.
   In case of 3 legged OAuth2 AppFlow have clientId and scope defined as the default parameter for AUTH_URL to generate the Authorization code. Connector developer doesn't have to define clientId and scope as OAuth2Custom Parameter for AUTH_URL.
8. **AddBasicAuthHeader** - Specifies if clientId and clientSecret should be added to basic auth header as base64 encoded string.

## CustomAuth

CustomAuth can be used when the application doesn't support the above 3 authentication types. It supports defining the keys for which the connector requires the user input to perform Authorization.
AppFlow will ask the user to provide the input and stores in Customer's secret manager. AppFlow will provide SecretManagerARN to the connector where the connector specified keys and its values are stored as key-value pairs.
