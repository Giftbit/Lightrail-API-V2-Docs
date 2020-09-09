#!/usr/bin/env bash

set -eu

STACK_NAME=$(aws cloudformation list-stacks --query 'StackSummaries[?contains(@.StackName,`-LightrailApiDocs-`)].StackName' --output text)
echo "found cloudformation stack name $STACK_NAME"

BUCKET_NAME=$(aws cloudformation describe-stack-resources --stack-name $STACK_NAME --query 'StackResources[?LogicalResourceId==`Bucket`].PhysicalResourceId' --output text)
echo "found s3 bucket name $BUCKET_NAME"

echo "aws s3 sync ./dist s3://$BUCKET_NAME"
aws s3 sync ./dist s3://$BUCKET_NAME
