package com.johnabele.function;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpTrigger-Java". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpTrigger-Java&code={your function key}
     * 2. curl "{your host}/api/HttpTrigger-Java?name=HTTP%20Query&code={your function key}"
     * Function Key is not needed when running locally, it is used to invoke function deployed to Azure.
     * More details: https://aka.ms/functions_authorization_keys
     */
    @FunctionName("cosmosDBMonitor")
    public void cosmosDbProcessor(
            @CosmosDBTrigger(name = "document", databaseName = "CosmosDatabaseName",
            collectionName = "SourceCollection",
            connectionStringSetting = "CosmosDbConnString", /*from appsettings*/
            leaseCollectionName = "LeaseCollection", createLeaseCollectionIfNotExists = true)
            String document,
            final ExecutionContext context ) {

                //do some work
                
                context.getLogger().info("CosmosDB trigger processed a request ");
            }
}
