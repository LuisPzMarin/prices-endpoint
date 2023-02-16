#!/bin/bash
#  Author:          Luis Pérez Marín - https://github.com/LuisPzMarin
#  Email:           luispzmarin@gmail.com
#  FileName:        buildAndServe.sh
#  Description:     Script para compilar y servir proyectos en java, utilizando Docker


#Inicializa variables
build=false;
serve=false;
test="-DskipTests";

#Muestra ayuda
help() { echo "Ayuda: Script para compilar y servir proyectos en java, utilizando Docker
Opciones:
  -b       Compila el proyecto usando mvn clean package --skipTest
  -s       Sirve el proyecto usando la configuración de los ficheros docker del proyecto
  -t       Se ejecutan los test junto a la compilación
  -noargs  Compila y sirve el proyecto, sin ejecutar los test" 1>&2; exit 1; }


#Revisa parametros y los parsea
if [ $# -eq 0 ]; then
  build=true;
  serve=true;
  test="-DskipTests";
else

  while getopts "bst" o; do
      case "$o" in
          b)
              build=true;
              ;;
          s)
              serve=true;
              ;;
          t)
              test="";
              build=true;
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
  echo "Compila con Maven 3.8.7 con OpenJDK 18"
  docker run -it --rm \
         -v $HOME/.m2/repository:/root/.m2/repository \
         -v "$(pwd)":/opt/maven \
         -w /opt/maven \
         maven:3.8.7-openjdk-18\
         mvn clean package $test
fi

#Sirve el proyecto
if $serve ; then
  echo "Sirve"
  sudo docker image rm prices-api --force
  docker-compose up  --build
fi
