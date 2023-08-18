FROM registry.access.redhat.com/ubi8/openjdk-11-runtime:latest
USER 185

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY target/quarkus-app/lib/ /deployments/lib/
COPY target/quarkus-app/*.jar /deployments/.
COPY target/quarkus-app/app/ /deployments/app/
COPY target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 9090
ENTRYPOINT [ "java", "-jar","/deployments/quarkus-run.jar" ]
