## Documentation

Basically, two artifacts are available.
This is on the one hand the Spring-Boot-Starter `vdigiwf-okverkehr-integration-starter`
and on the other hand the service `digiwf-okverkehr-integration-service` which is provided as an
[Image](https://hub.docker.com/repository/docker/itatm/digiwf-okverkehr-integration-service).

### Spring-Boot-Starter

The usage of the starter is documented
in [quickstart.md](https://github.com/it-at-m/digiwf-ok.verkehr-integration#getting-started).

#### Error handling

The errors occurring during the rest request are divided into three error categories.
These are client-side errors, server-side errors and errors that cannot be assigned to either the client or the server.
Each of these three error categories is assigned its own exception, which is then thrown when the methods in the
repository class `OkVerkehrHalterRepository` are called.

### Service provided as an image

The service is provided via Dockerhub as
an [Image](https://hub.docker.com/repository/docker/itatm/digiwf-okverkehr-integration-service).
The source code for the service can be found in
submodule [digiwf-okverkehr-integration-service](https://github.com/it-at-m/digiwf-ok.verkehr-integration/tree/dev/digiwf-okverkehr-integration-service)
.

The requests to OK.VERKEHR are expected by the service over kafka event bus messages.
To provide the event bus functionality via kafka,
the [DigiWF Spring Cloudstream Utils](https://github.com/it-at-m/digiwf-spring-cloudstream-utils) are used.

#### Service Configuration

An example configuration can be found within the properties files.

* `application.yml`: `digiwf-okverkehr-integration-service/src/main/resources/application.yml`
* `application-local.yml`: `digiwf-okverkehr-integration-service/src/main/resources/application.yml`

The file `application.yml` contains the configuration according graceful shutdown, metrics, ports, ...

The file `application-local.yml` provides the event bus and OK.VERKEHR relevant configuration.
The event bus configuration is implemented
according [DigiWF Spring Cloudstream Utils](https://github.com/it-at-m/digiwf-spring-cloudstream-utils#getting-started).

