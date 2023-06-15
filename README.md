Demo hello world app that builds a container image using Red Hat build of OpenJDK (registry.access.redhat.com/ubi9/openjdk-17:1.14).

To build an image, run `./mvnw clean package k8s:build -DskipTests`.

To run the image locally, run `docker run --rm -it -p 8080:8080 example/hello-world-spring-openjdk:latest`

You can then hit the following endpoints:
- `/hello`
- `/hello/{name}`, where `{name}` can be anything you want.