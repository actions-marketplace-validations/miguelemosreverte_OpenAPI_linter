
# OpenApi Validator
# Dev
sbt "run apischema.json"

# Prod
sbt docker 
docker run -v ${PWD}:/data customer/openapi:latest apischema.json
