FROM public.ecr.aws/lambda/java:11

# Copy function code and runtime dependencies from Maven layout
COPY target/classes ${LAMBDA_TASK_ROOT}
COPY target/dependency/* ${LAMBDA_TASK_ROOT}/lib/

# Set the CMD to your handler
CMD [ "com.amazonaws.appflow.custom.connector.example.handler.SalesforceLambdaHandler::handleRequest" ]