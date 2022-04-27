# Project Title

Choose and leave only one of the following badge

![REPO-TYPE](https://img.shields.io/badge/repo--type-backend-critical?style=for-the-badge&logo=github)


One Paragraph of project description goes here.

More detailed infos here.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
On a local machine, just get the jar file and execute it
For example java -jar pluginmng-0.0.1-SNAPSHOT.jar

If you want to use a specific profile, enter it in the command line
For example to use the test profile, just use the command
java -Dspring.profiles.active=test -jar pluginmng-0.0.1-SNAPSHOT.jar

To build the docker image, follow the steps:
1. Copy docker/Dockerfile in the root folder of the system.
2. Be sure that under the root there is target/pluginmng-0.0.1-SNAPSHOT.jar
3. Run the command docker build -t pluginmng . (be carefull to use dot at the end)
4. Wait the image to be created.

To run the docker image
1. Run the docker command: docker run -d pluginmng
2.


### Prerequisites

The project is developed as a microservice.
It is developed on Java 11.
The only thinh necessary to run application is the JVM 11 or newer
You can run the application by calling:
java <app.name.jar>
The application is by default using port 6084
There is also a docker file, which can be used to create a docker image.

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running
To install on a standalone system (no docker) just copy the jar file in the choosend working directory.
For example copy pluginmng-0.0.1-SNAPSHOT.jar in /tmp/ folder

To build the docker image, follow the steps:
1. Copy docker/Dockerfile in the root folder of the system.
2. Be sure that under the root there is target/pluginmng-0.0.1-SNAPSHOT.jar
3. Run the command docker build -t pluginmng . (be carefull to use dot at the end)
4. Wait the image to be created.
5. 
## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [SpringBoot](http://springboot.io) - The Java framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](tags). 

## Authors

* **Name Surname** - *Role* - [githubnickname](github_profile_url)

See also the list of [contributors](contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
