#!/bin/bash
#  Author:          Luis Pérez Marín - https://github.com/LuisPzMarin
#  Email:           luispzmarin@gmail.com
#  FileName:        buildAndServe.sh
#  Description:     Script para compilar y servir proyectos en java, utilizando Docker


#Inicializa variables
build=false;
serve=false;

#Muestra ayuda
help() { echo "Ayuda: Script para compilar y servir proyectos en java, utilizando Docker
Opciones:
  -b       Compila el proyecto usando mvn clean package
  -s       Sirve el proyecto usando la configuración de los ficheros docker del prouyecto
  -noargs  Compila y sirve el proyecto" 1>&2; exit 1; }


#Revisa parametros y los parsea
if [ $# -eq 0 ]; then
  build=true;
  serve=true;
else

  while getopts "bs" o; do
      case "$o" in
          b)
              build=true;
              ;;
          s)
              serve=true;
              ;;
          *)
              help
              ;;
      esac
  done
  shift $((OPTIND-1))
fi

#Compila el proyecto
if $build ; then
  echo "Compila con Maven 3.6.0"
  docker run -it --rm \
         -v $HOME/.m2/repository:/root/.m2/repository \
         -v "$(pwd)":/opt/maven \
         -w /opt/maven \
         maven:3.6.0-jdk-11-slim\
         mvn clean package -DskipTests
fi

#Sirve el proyecto
if $serve ; then
  echo "Sirve"
  docker-compose up  --build
fi