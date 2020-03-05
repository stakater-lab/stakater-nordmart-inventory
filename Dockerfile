FROM gcr.io/distroless/java:8

LABEL name="Inventory Service" \
      maintainer="asdaasdasdasd@stakater.com" \
      vendor="Stakater" \
      release="1" \
      summary="Project containing inventory service with springboot for Nordmart Microservices"

USER 1001
a
ENV HOME=/opt/app
WORKDIR $HOME

# Pass environment variables for jaeger opentracing
ENV JAEGER_SERVICE_NAME=nordmart-opentracing-inventory\
  JAEGER_PROPAGATION=b3\
  JAEGER_ENDPOINT="http://jaeger-collector.istio-system:14268/api/traces"\
  JAEGER_TRACEID_128BIT=true\
  JAEGER_REPORTER_LOG_SPANS=true\
  JAEGER_SAMPLER_TYPE=const\
  JAEGER_SAMPLER_PARAM=1

# Expose the port on which your service will run
EXPOSE 8080

# NOTE we assume there's only 1 jar in the target dir
COPY target/*.jar $HOME/artifacts/app.jar

CMD ["artifacts/app.jar"]