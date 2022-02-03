/*-
 * #%L
 * custom-connector-tests
 * %%
 * Copyright (C) 2021 Amazon Web Services
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import com.amazonaws.appflow.custom.connector.lambda.handler.BaseLambdaConnectorHandler;
import com.amazonaws.appflow.custom.connector.tests.invokers.BaseConnectorTestInvoker;
import com.amazonaws.appflow.custom.connector.tests.model.TestConfig;
import com.amazonaws.appflow.custom.connector.util.CustomObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * This class describes a java program that should be used to validate the custom connector handlers.
 * It generates basic requests that exercise most paths of the connector handler and does basic verification
 * on the response (such as checking for success/failure depending on the test). More comprehensive tests
 * can be added by extending the base test class and verifying expected content.
 *
 * <p>
 * You can run this tool using the following commands:
 * 1. $mvn package
 * 2. java -cp target/custom-connector-tests-1.0.jar RunTests -h com.amazonaws.appflow.custom.connector.example.handler.SalesforceLambdaHandler -t ~/TestConfig.json
 * <p>
 */
public class RunTests {
    protected RunTests() {
        // Intentionally left blank
    }

    public static void main(final String[] args) {
        CommandLine commandLine;
        CommandLineParser parser = new DefaultParser();

        Option optionHandlerName = Option.builder("h").argName("handlerName").hasArg().desc("Name of the connector handler to test").build();
        Option optionTestConfig = Option.builder("t").argName("testConfigFile").hasArg().desc("Location of the Test Configuration file").build();
        Options options = new Options();

        options.addOption(optionHandlerName);
        options.addOption(optionTestConfig);

        try {
            commandLine = parser.parse(options, args);
            if (!commandLine.hasOption("h")) {
                System.out.println("Name of the class under test must be provided via the -h option.");
                System.exit(1);
            }
            if (!commandLine.hasOption("t")) {
                System.out.println("Location of the test configuration file must be provided via the -t option.");
                System.exit(1);
            }

            File configJson = new File(commandLine.getOptionValue("t"));
            ObjectMapper mapper = CustomObjectMapper.getObjectMapper();
            TestConfig testConfig = mapper.readValue(configJson, TestConfig.class);

            String className = commandLine.getOptionValue("h");
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();

            Object handler = constructor.newInstance();
            BaseConnectorTestInvoker testInvoker = new BaseConnectorTestInvoker((BaseLambdaConnectorHandler) handler, testConfig);

            System.out.println("Starting connector verification tests for " + className);

            testInvoker.invokeConfigurationHandlerTests();
            testInvoker.invokeMetadataHandlerTests();
            testInvoker.invokeRecordHandlerTests();

            System.out.println("Tests completed successfully, see above logs for results");
            System.exit(0);
        } catch (ParseException e) {
            System.out.println("Parse Error");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Could not resolve class definition");
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("Could not locate no-args constructor in the specified handler");
            System.out.println(e.getMessage());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            System.out.println("Mapping exception");
            System.out.println(e.getMessage());
        } catch (JsonParseException e) {
            System.out.println("Cannot parse JSON");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("File was not found");
            System.out.println(e.getMessage());
        }

        System.exit(1);
    }
}
