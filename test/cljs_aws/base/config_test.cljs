(ns cljs-aws.base.config-test
  (:require [clojure.test :refer [deftest is]]
            [cljs-aws.base.config :as config]))

(def expected-aws-keys
  #{"Config"
    "ElasticTranscoder"
    "DeviceFarm"
    "ELBv2"
    "KMS"
    "ElastiCache"
    "RDS"
    "Request"
    "CognitoIdentityCredentials"
    "CodePipeline"
    "AutoScaling"
    "CloudWatchEvents"
    "config"
    "StorageGateway"
    "CloudTrail"
    "WAF"
    "Firehose"
    "MTurk"
    "SSM"
    "WorkDocs"
    "util"
    "Signers"
    "LexRuntime"
    "STS"
    "ApplicationAutoScaling"
    "ParamValidator"
    "CloudHSM"
    "Iot"
    "ElasticBeanstalk"
    "CredentialProviderChain"
    "APIGateway"
    "XML"
    "Response"
    "EC2"
    "VERSION"
    "MobileAnalytics"
    "Route53"
    "Redshift"
    "ECS"
    "Rekognition"
    "HttpRequest"
    "Model"
    "Credentials"
    "OpsWorks"
    "ECR"
    "ELB"
    "Protocol"
    "CognitoIdentityServiceProvider"
    "Polly"
    "CloudWatch"
    "JSON"
    "CloudFront"
    "CUR"
    "DirectConnect"
    "SNS"
    "events"
    "GameLift"
    "Lambda"
    "ConfigService"
    "CloudWatchLogs"
    "CognitoSync"
    "EventListeners"
    "WebIdentityCredentials"
    "Inspector"
    "DynamoDBStreams"
    "MarketplaceCommerceAnalytics"
    "Kinesis"
    "Endpoint"
    "SequentialExecutor"
    "IotData"
    "MachineLearning"
    "Route53Domains"
    "DynamoDB"
    "EFS"
    "CodeDeploy"
    "SQS"
    "S3"
    "CloudFormation"
    "Service"
    "CognitoIdentity"
    "ACM"
    "CodeCommit"
    "SES"
    "HttpResponse"
    "ServiceCatalog"
    "EMR"
    "HttpClient"})

(deftest require--aws-valid
  (is (some? config/aws))
  (is (empty? (clojure.set/difference                       ; Note not all of the services are available in the default
                expected-aws-keys                           ; browser build
                (set (goog.object/getKeys config/aws))))))

(deftest require--memoized-service--ok
  (is (some? (config/service "S3"))))

(deftest valid--set-region--ok
  (is (nil? (config/set-region! "us-east-1"))))

(deftest valid--load-credentials--ok
  (is (nil? (config/load-credentials! :web-identity-credentials {:identity-pool-id "foo"})))
  (is (nil? (config/load-credentials! :cognito-identity-credentials {:role-arn            "bar"
                                                                      :web-identity-token "baz"}))))