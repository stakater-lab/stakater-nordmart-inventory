# stakater-nordmart-inventory

## Overview

A Spring boot inventory application that exposes product's inventory status on REST API endpoints.

## Dependencies

It requires following things to be installed:

* Java: ^8.0
* Maven
* Postgres


### Deployment strategy

### Local deployment

To run the application locally use the command given below:

```bash
mvn spring-boot:run
```

### Docker

To deploy app inside a docker container

* Create a network if it doesn't already exist by executing

  ```bash
  docker network create --driver bridge nordmart-apps
  ```

* Build jar file of the app by executing

  ```bash
  mvn clean package
  ```

* Next build the image using

  ```bash
  docker build -t inventory .
  ```

* Finally run the image by executing

  ```bash
  docker run -d --name inventory --network nordmart-apps -p 8081:8080 inventory
  ```

### Helm Charts

#### Pre-requisites

 
1. Apply dependencies from deployment/dependencies `kubectl apply -f deployment/dependencies`
2. With helm `helm install stakater/application -f deployment/values.yaml`. Without helm, `kubectl apply -f deployment/manifests`

