# README #

The SQS Modular Framework Test Module.

### What is this repository for? ###

* This repository houses the standard test module using the SQS Modular Framework.
* This repository can be copied or forked to produce client-specific tests modules.
* Current version is 1.0.2-SNAPSHOT

### How do I get set up? ###

* The entire repository can be cloned from Bitbucket if you have access.
* Configuration is taken care of in the test module POM file and TestNGExecuteTests.xml file.
  There are several variables that can be changed. See the **properties** section in the 
  **profiles** section for some examples. 
* Dependencies are handled by Maven. See the module POM files for more details.
  To add a specific module use a block similar to:
  
```xml
<dependency>
    <groupId>com.sqs</groupId>
    <artifactId>sqsfw_core</artifactId>
    <version>1.0.2-SNAPSHOT</version>
</dependency>
```
* Running tests can either be accomplished via a correctly configured IDE or by the command line via
  the maven command:
~~~  
mvn clean test
~~~
* The allure report can be generated by running the site lifecycle phase once the test run has
  completed:
~~~
mvn site
~~~

  
### Contribution guidelines ###

* Code review is performed via pull requests from a feature branch.

### Who do I talk to? ###

* For any issues please contact: <IREAutomationFramework@sqs.com>.