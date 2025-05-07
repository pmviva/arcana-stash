#!/bin/env bash

###
# RUN BACKEND FORMAT PRE COMMIT HOOK SCRIPT
###

###
# CDS INTO CHILD DIRECTORY
###
cd arcana-stash-api

###
# DEFINES THE STASH BEFORE VARIABLE
###
STASH_BEFORE=$(git stash list | wc -l)

###
# RUNS GIT STASH
###
git stash -q --keep-index

###
# RUNS GRADLE SPOTLESS APPLY TASK
###
./gradlew spotlessApply

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
# RUNS GIT ADD
###
git add .

###
# DEFINES THE STASH AFTER VARIABLE
###
STASH_AFTER=$(git stash list | wc -l)

###
# RUNS GIT STASH POP
###
if [ "$STASH_AFTER" -gt "$STASH_BEFORE" ]; then
    git stash pop -q;
fi

###
# CDS INTO PARENT DIRECTORY
###
cd ..
