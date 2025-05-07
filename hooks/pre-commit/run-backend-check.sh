#!/bin/env bash

###
# RUN BACKEND CHECK PRE COMMIT HOOK SCRIPT
###

###
# CDS INTO CHILD DIRECTORY
###
cd arcana-stash-api

###
# RUNS GRADLE CHECK TASK
###
./gradlew check

###
# DEFINES THE STATUS VARIABLE
###
STATUS=$?

###
# CHECKS THE STATUS VARIABLE
###
if [ $STATUS -ne 0 ]; then
    exit $STATUS
fi

###
# CDS INTO PARENT DIRECTORY
###
cd ..
