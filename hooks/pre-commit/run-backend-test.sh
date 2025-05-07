#!/bin/env bash

###
# RUN BACKEND TEST PRE COMMIT HOOK SCRIPT
###

###
# CDS INTO CHILD DIRECTORY
###
cd arcana-stash-api

###
# RUNS GRADLE TEST TASK
###
./gradlew test

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
